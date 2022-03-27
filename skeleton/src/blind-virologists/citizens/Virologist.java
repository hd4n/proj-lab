package citizens;

import effects.Effect;
import effects.Reflect;
import items.*;
import map.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Egy Citizen leszarmazott,
 * A virologus a jatekos vagy AI altal iranyitott
 *
 * @author Barta Daniel
 * @since 2022-03-26
 */
public class Virologist extends Citizen {
    /**
     * Visitor pattern resze, ha a myField laboratory
     *
     * @param lab sajat mezo
     */
    @Override
    public void visit(Laboratory lab) {
        System.out.println("Virologist: Meghivja a Laboratory readCode fuggvenyet");
        Code code = lab.readCode();
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
        warehouse.collectMaterial();
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
        Equipment equipment = empty.pickUpEquipment();
        System.out.println("Virologist: A pickUpEquipment-bol visszakapott felszereleseket elteszi a virologus ha van nala hely");
    }

    /**
     * Visitor pattern resze, ha a myField Shelter
     *
     * @param shelter sajat mezo
     */
    @Override
    public void visit(Shelter shelter) {
        System.out.println("Virologist: meghivja az Shelter pickUpEquipment fuggvenyet");
        Equipment equipment = shelter.pickUpEquipment();
        System.out.println("Virologist: A pickUpEquipment-bol visszakapott felszereleseket elteszi a virologus ha van nala hely");
    }

    public void equip() {
        System.out.println("Felvenni kivant felszereles tipusa?");
        Scanner scanner = new Scanner(System.in);
        String newEquipment = scanner.next();

        Equipment equipment;
        if (newEquipment.toLowerCase().equals("cape")) {
            equipment = new Cape();
        } else if (newEquipment.toLowerCase().equals("gloves")) {
            equipment = new Gloves();
        } else {//vagy ha bag-et irt vagy valami mast
            equipment = new Bag();
        }
        System.out.println("Virologist: Felveszi az aktiv felszerelesk koze a kivalasztottat");
    }


    /**
     * Letrehoz a virologus anyagkeszletebol egy uj agenst
     */
    public void craft() {
        Code code = new Code();
        List<Material> materials = new ArrayList<>();

        System.out.println("Virologist: Lekeri a kod anyag koltseget.");
        int aminocost = code.getAminoCost();
        int nucleocost = code.getNucleoCost();

        System.out.println("A virologus rendelkezik elegendo anyag keszelttel? (igen/nem)");
        Scanner scanner = new Scanner(System.in);
        String material = scanner.next();
        if (material.toLowerCase().equals("igen")) {
            System.out.println("Virologist: A virologus rendelkezik megfelelo Material keszlettel, letrejon az uj Agent amit eltarol. A felhasznalt anyagok eltunnek a virologustol.");
            Agent agent = code.getAgent();
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
     * A felhasznalo agenst ken egy masik virologusra
     */
    public void useAgent() {
        Field myField = new Shelter();
        myField.getNeighbors();
        Citizen citizen = myField.getCitizen();
        if (citizen == null){
            System.out.println("Virologist: nincs kire kenni");
            return;
        }

        System.out.println("Virologist: A felhasznalo kivalaszt egy tamadni kivant szomszedos virologust es egy agenst");
        Agent a;

        System.out.println("Virus legyen vagy vakcina? (virus/*)");
        Scanner scanner = new Scanner(System.in);
        String answ = scanner.next();

        if (answ.toLowerCase().equals("virus")) {
            a = new Virus();
        } else {
            a = new Vaccine();
        }

        Virologist enemy = new Virologist();
        Effect effect = a.use();
        System.out.println("Virologist: Az agensbol visszakapott effektet rakeni a virologusra, az agens torlodik" );
        enemy.addEffect(effect);
    }

    /**
     * @param effect kenni kivant effekt
     */
    public void addEffect(Effect effect) {
        System.out.println("A virologuson van immunitas? (igen/nem)");
        Scanner scanner = new Scanner(System.in);
        String answ = scanner.next();
        if (answ.toLowerCase().equals("igen")) {
            System.out.println("Virologist: A virologustra nem ervenyes a kenes, mert immunis");
        } else {
            System.out.println("A virologuson van reflect kepessege? (igen/nem)");
            answ = scanner.next();
            if (answ.toLowerCase().equals("igen")) {
                System.out.println("Virologist: A virologustra nem ervenyes a kenes");
                System.out.println("Virologist: Az effektet visszakeni a tamadora");
                System.out.println("Virologist: A reflect effektet elvesziti");
            } else {
                System.out.println("Virologist: A kenes sikeres volt a virologusnak uj effektel rendelkezik");
                effect.applyEffect(this);
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
            System.out.println("Virologist: Visszaadja az anyagkeszletet mert nincs maganal a virologus");
            return new ArrayList<Material>();
        } else {
            System.out.println("Virologist: Nem ad vissza anyag keszletet mert nincs stun effect rajta");
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
            System.out.println("Virologist: Visszaadja az felszereleseit mert nincs maganal a virologus");
            return new ArrayList<Equipment>();
        } else {
            System.out.println("Virologist: Nem ad vissza felszereleseket mert nincs stun effect rajta");
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
        myField.dropEquipment(equipment);
        System.out.println("Virologist: Torli az eltarolt felszerelesek kozul az eldobottat.");
    }

    /**
     * Az aktiv felszerelesek kozul kivalaszt egyet a felhasznalo es azt atteszi a bag-be
     */
    public void unequip() {
        System.out.println("Virologist: Kilistazza az aktiv felszereleseket, ezekbol a felhasznalo valaszt");
        System.out.println("Virologist: A kivalasztott felszereles lekerul az aktivak kozul");
    }

    /**
     * A virologus lopast indit egy masik virologus ellen
     */
    public void steal() {
        System.out.println("Virologist (Thief): A felhasznaloval valasztat egy masik virologst akitol lophat");
        Virologist enemy = new Virologist();
        enemy.stealEquipment();
        enemy.stealMaterial();
        System.out.println("Virologist (Thief): Az ellopott anyagokat es felszereleseket elteszi magahoz.");
    }

}






