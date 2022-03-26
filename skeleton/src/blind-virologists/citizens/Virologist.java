package citizens;

import effects.Effect;
import effects.Reflect;
import items.*;
import map.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Virologist extends Citizen {
    /**
     * Visitor pattern resze, ha a myField laboratory
     *
     * @param lab sajat mezo
     */
    @Override
    public void visit(Laboratory lab) {
        System.out.println("Virologist: Meghivja a Laboratory readCode fuggvenyet");
        //Code code = lab.readCode();
        System.out.println("Virologist: A readCode-bol visszakapott kodot megkapja a virologus es megtanulja");
    }

    /**
     * Visitor pattern resze, ha a myField warehouse
     *
     * @param warehouse sajat mezo
     */
    @Override
    public void visit(Warehouse warehouse) {
        System.out.println("Virologist: meghivja a Warehouse collectMaterial fuggvenyet");
        //warehouse.collectMaterial
        System.out.println("Virologist: A collectMaterial-bol visszakapott anyagokat elteszi a virologus");
    }

    /**
     * Visitor pattern resze, ha a myField Empty
     *
     * @param empty sajat mezo
     */
    @Override
    public void visit(Empty empty) {
        System.out.println("Virologist: meghivja az Empty pickUpEquipment fuggvenyet");
        //empty.pickUpEquipment
        System.out.println("Virologist: A pickUpEquipment-bol visszakapott felszereleseket elteszi a virologus ha van nala hely");
    }

    /**
     * Visitor pattern resze, ha a myField Shelter
     *
     * @param shelter sajat mezo
     */
    @Override
    public void visit(Shelter shelter) {
        System.out.println("Felvenni kivant felszereles tipusa?");
        Scanner scanner = new Scanner(System.in);
        String newEquipment = scanner.next();

        System.out.println("Virologist: meghivja az Shelter Equip fuggvenyet a kivalasztott Equipment-el " + newEquipment);
        Equipment equipment;
        if (newEquipment.toLowerCase().equals("cape")) {
            equipment = new Cape();
        } else if (newEquipment.toLowerCase().equals("gloves")) {
            equipment = new Gloves();
        } else {//vagy ha bag-et irt vagy valami mast
            equipment = new Bag();
        }
        //empty.pickUpEquipment(equipment)
        System.out.println("Virologist: A pickUpEquipment-bol visszakapott felszereleseket elteszi a virologus ha van nala hely");
    }

    /**
     * Letrehoz a virologus anyagkeszletebol egy uj agnest
     */
    public void craft() {
        Code code = new Code();
        List<Material> materials = new ArrayList<>();

        System.out.println("Virologist: Lekeri a kod anyag koltseget.");
        //int aminocost = code.getAminoCost();
        //int nucleocost = code.getNucleoCost();

        System.out.println("A virologus rendelkezik elegendo anyag keszelttel? (igen/nem)");
        Scanner scanner = new Scanner(System.in);
        String material = scanner.next();
        if (material.toLowerCase().equals("igen")) {
            System.out.println("Virologist: A virologus rendelkezik megfelelo Material keszlettel, letrejon az uj Agent amit eltarol. A felhasznalt anyagok eltunnek a virologustol.");
            //Agent agent = code.getAgent()
        } else {
            System.out.println("Virologist: Nincs megfelelo anyagkeszlet");
        }

    }

    /**
     * Kivulrol meghivhato fuggveny ami eldobat egy felszerelest
     */
    public void dropEquipment() {
        System.out.println("Virologist: kilistazza a felhasznalonak a felszereleseket, es valaszt ker hogy mit dobjon el.");
        System.out.println("Virologist: Meghivja a drop-fuggvenyt egy felhasznalo altal kivalasztott felszerelessel.");
        Equipment equipmentToDrop = new Cape();
        drop(equipmentToDrop);
    }

    /**
     * A felhasznalo agnst ken egy masik virologusra
     */
    public void useAgent() {
        System.out.println("Virologist: A felhasznalo kivalaszt egy tamadni kivant szomszedos virologust es egy agenst");
        Agent a = new Vaccine();
        //a.use();
        System.out.println("Virologist: Az agensbol visszakapott effektet rakeni a virologusra");
        Virologist enemy = new Virologist();
    }

    /**
     * @param effect kenni kivant effekt
     */
    public void addEffect(Effect effect) {
        System.out.println("A virologuson van reflect immunitasa? (igen/nem)");
        Scanner scanner = new Scanner(System.in);
        String reflect = scanner.next();
        if (reflect.toLowerCase().equals("igen")) {
            System.out.println("Virologist: A virologustra nem ervenyes a kenes, mert immunis");
        } else {
            System.out.println("A virologuson van reflect kepessege? (igen/nem)");
            reflect = scanner.next();
            if (reflect.toLowerCase().equals("igen")) {
                System.out.println("Virologist: A virologustra nem ervenyes a kenes");
                System.out.println("Virologist: A reflect effektet elvesziti");
            } else {
                System.out.println("Virologist: A kenes sikeres volt a virologusnak uj effektel rendelkezik");
            }
        }

    }

    /**
     * Anyagkeszlet lopasa
     *
     * @return az ellophato anyagkeszlet
     */
    public List<Material> stealMaterial() {
        System.out.println("Virologist: Lopast kezdemenyeztek ellene");

        System.out.println("A virologuson van stun? (igen/nem)");
        Scanner scanner = new Scanner(System.in);
        String steal = scanner.next();
        if (steal.toLowerCase().equals("igen")) {
            System.out.println("Virologist: Visszaadja az anyagkeszletet mert nincs magnal a virologus");
            return new ArrayList<Material>();
        } else {
            System.out.println("Virologist: Nem ad vissza semmit mert nincs stun effect rajta");
        }
        return null;
    }

    /**
     * Felszereles lopas kezdemenyezese
     *
     * @return az ellophato felszerelesek
     */
    public List<Equipment> stealEquipment() {
        System.out.println("Virologist: Lopast kezdemenyeztek ellene");

        System.out.println("A virologuson van stun? (igen/nem)");
        Scanner scanner = new Scanner(System.in);
        String steal = scanner.next();
        if (steal.toLowerCase().equals("igen")) {
            System.out.println("Virologist: Visszaadja az felszereleseit mert nincs magnal a virologus");
            return new ArrayList<Equipment>();
        } else {
            System.out.println("Virologist: Nem ad vissza semmit mert nincs stun effect rajta");
        }
        return null;
    }

    /**
     * Torli a parametere kent kapott felszerelest es leteszi a mezore
     *
     * @param equipment a torolni kivant felszereles
     */
    public void drop(Equipment equipment) {
        System.out.println("Virologsit: Meghivja az aktualis mezo dropEquipment fuggvenyet.");
        Field myField = new Empty();
        //myField.dropEquipment(equipment);
        System.out.println("Virologist: Torli az eltarolt felszerelesek kozul az eldobottat.");
    }

    /**
     * Az aktiv felszerelesek kozul kivalaszt egyet a felhasznalo es azt atteszi a bag-be
     */
    public void unequip() {
        System.out.println("Virologist: Kilistazza az aktiv felszereleseket, ezekbol a felhasznalo valazt");
        System.out.println("Virologist: A kivalasztott felszereles lekerul az aktivak kozul");
    }

    /**
     * A virologus lopast indit egy masik virologus ellen
     */
    public void Steal() {
        System.out.println("Virologist (Thief): A felhasznaloval valasztat egy masik virologst akitol lophat");
        Virologist enemy = new Virologist();
        enemy.stealEquipment();
        enemy.stealMaterial();
        System.out.println("Virologist (Thief): Az ellopott anyagokat es felszereleseket elteszi magahoz.");
    }

}






