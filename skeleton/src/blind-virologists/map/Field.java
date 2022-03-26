package map;

import citizens.Citizen;
import citizens.Virologist;
import citizens.Visitor;
import items.Equipment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A palya mezoit reprezentalo absztrakt osztaly
 *
 * @author Hajos Daniel
 * @since 2022-03-26
 */
public abstract class Field implements Visitable {

    /**
     * Elfogadja a Visitort, az leszarmazottak implementaljak
     *
     * @param v az elfogadando Visitor
     */
    public abstract void accept(Visitor v);

    /**
     * Visszaadja a szomszedos mezoket
     *
     * @return a szomszedos mezoket tartalmazo lista
     */
    public ArrayList<Field> getNeighbors() {
        System.out.println("Field: szomszedos mezok visszaadasa");
        return null;
    }

    /**
     * Elvesz a virologustol egy equipmentet, ami eltunik
     *
     * @param e az eldobott Equipment
     */
    public void dropEquipment(Equipment e) {
        System.out.println("Field: Equipment eldobva");
    }

    /**
     * Visszaadja a mezon allo Citizen
     *
     * @return a mezon allo Citizen, vagy null
     */
    public Citizen getCitizen() {
        System.out.println("Field: Van mar citizen a mezon? (igen/nem)");
        Scanner sc = new Scanner(System.in);
        String res = sc.next();
        if (res.equalsIgnoreCase("igen")) {
            return new Virologist();
        } else {
            return null;
        }
    }
}
