package citizens;

import effects.Effect;
import items.*;
import map.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy Citizen leszarmazott,
 * A virologus a jatekos vagy AI altal iranyitott
 *
 * @author Barta Daniel
 * @since 2022-03-26
 */
public class Virologist extends Citizen {
    private ArrayList<Equipment> equipments = new ArrayList<>();
    private ArrayList<Equipment> activeEquipments = new ArrayList<>();
    private ArrayList<Material> materials = new ArrayList<>();
    private ArrayList<Code> codes = new ArrayList<>();
    private ArrayList<Agent> agents = new ArrayList<>();
    private int neededAmino = -1;
    private int neededNucleo = -1;

    /**
     * Visitor pattern resze, ha a myField laboratory
     *
     * @param lab sajat mezo
     */
    @Override
    public void visit(Laboratory lab) {
        Code code = lab.readCode();
        codes.add(code);
    }

    /**
     * Visitor pattern resze, ha a myField warehouse
     *
     * @param warehouse sajat mezo
     */
    @Override
    public void visit(Warehouse warehouse) {
        Material felvett = warehouse.collectMaterial();
        if (felvett != null) {
            materials.add(felvett);
        }
    }

    /**
     * Visitor pattern resze, ha a myField Empty
     *
     * @param empty sajat mezo
     */
    @Override
    public void visit(Empty empty) {
        Equipment equipment = empty.pickUpEquipment();
        if (equipment != null) {
            equipments.add(equipment);
        }

    }

    /**
     * Visitor pattern resze, ha a myField Shelter
     *
     * @param shelter sajat mezo
     */
    @Override
    public void visit(Shelter shelter) {
        Equipment equipment = shelter.pickUpEquipment();
        if (equipment != null) {
            equipments.add(equipment);
        }
    }

    public Virologist() {

    }

    /**
     * A Virologist konstruktora
     *
     * @param start kezdomezo
     */
    public Virologist(Field start) {
        super(start);
    }

    /**
     * A jatekos altal vezerlet bemenet hivja meg
     */
    public void equip() {

    }

    /**
     * Aktiv felszereleseket allitja be
     *
     * @param equipment az aktiv felszereles
     */
    public void equip(Equipment equipment) {
        if (equipment != null) {
            activeEquipments.add(equipment);
            equipments.remove(equipment);
        }
    }

    /**
     * A jatekos altal vezerlet bemenet hivja meg
     * Az aktiv felszerelesek kozul kivalaszt egyet a felhasznalo es azt atteszi a bag-be
     */
    public void unequip() {

    }

    /**
     * Az aktiv felszerelesekbol leveszi a parameterkent kapottat
     *
     * @param equipment a virologus aktiv felszerelese, amit le kell venni
     */
    public void unequip(Equipment equipment) {
        if (equipment != null) {
            equipments.add(equipment);
            activeEquipments.remove(equipment);
        }
    }

    /**
     * A jatekos altal vezerlet bemenet hivja meg
     * Kivalaszt egy felszerelest es azt eldobja
     */
    public void dropEquipment() {

    }

    /**
     * Torli a parametere kent kapott felszerelest es leteszi a mezore
     *
     * @param equipment a torolni kivant felszereles
     */
    public void drop(Equipment equipment) {
        equipments.remove(equipment);
        currentField.dropEquipment(equipment);
    }

    public void addEquipment(Equipment equipment) {
        if (equipment != null) {
            equipments.add(equipment);
        }
    }

    public void addEquipment(ArrayList<Equipment> equipmentList) {
        if (equipmentList != null) {
            for (Equipment item : equipmentList) {
                addEquipment(item);
            }
        }
    }

    /**
     * A jatekos altal vezerlet bemenet hivja meg
     */
    public void craft() {

    }

    /**
     * Letrehoz a virologus anyagkeszletebol egy uj agenst
     *
     * @param code az agans kodja
     */
    public void craft(Code code) {
        neededAmino = code.getAminoCost();
        neededNucleo = code.getNucleoCost();
        for (Material item : materials) {
            item.prepareForCraft();     //a material csokkenti a ket int-et
        }
        if ((neededAmino + neededNucleo) == 0) {
            Agent agent = code.getAgent();
            agents.add(agent);
        }
    }

    /**
     * A jatekos altal vezerlet bemenet hivja meg
     * A felhasznalo agenst ken egy masik virologusra
     */
    public void useAgent() {

    }

    /**
     * Agens kenese
     *
     * @param target az aldozat
     * @param agent  az agnes amit felhasznal
     */
    public void useAgnet(Citizen target, Agent agent) {
        Effect effect = agent.use();
        target.addEffect(effect);
        ///.....
        agents.remove(agent);
    }

    public void addMaterial(Material material){
        if (material != null){
            materials.add(material);
        }
    }

    /**
     * Anyagkeszlet lopasa
     *
     * @return az ellophato anyagkeszlet
     */
    public ArrayList<Material> stealMaterial() {
        if (stunned) {
            ArrayList<Material> toReturn = materials;
            materials = new ArrayList<>();
            return toReturn;
        }
        return null;
    }

    /**
     * Felszereles lopas kezdemenyezese
     *
     * @return az ellophato felszerelesek
     */
    public ArrayList<Equipment> stealEquipment() {
        if (stunned) {
            ArrayList<Equipment> toReturn = equipments;
            equipments = new ArrayList<>();
            //activeEquipments = new ArrayList<>();   //mert az aktivak is letunnek
            return toReturn;
        }
        return null;
    }

    /**
     * A jatekos altal vezerlet bemenet hivja meg
     * A virologus lopast indit egy masik virologus ellen, a megszerzett felszerelest es anyagkeszletet elrakja
     */
    public void steal() {

    }

    public int getNeededAmino() {
        return neededAmino;
    }

    public void setNeededAmino(int neededAmino) {
        this.neededAmino = neededAmino;
    }

    public int getNeededNucleo() {
        return neededNucleo;
    }

    public void setNeededNucleo(int neededNucleo) {
        this.neededNucleo = neededNucleo;
    }
}






