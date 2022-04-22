package map;

import citizens.Citizen;
import citizens.Visitor;
import items.Equipment;

import java.util.ArrayList;

/**
 * A palya mezoit reprezentalo absztrakt osztaly
 *
 * @author Hajos Daniel
 * @since 2022-04-21
 */
public abstract class Field implements Visitable {

    /**
     * A mezon allo citizen
     */
    protected Citizen citizen;

    /**
     * Szomszedos mezok
     */
    protected ArrayList<Field> neighbors = new ArrayList<>();

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
        return neighbors;
    }

    /**
     * Elvesz a virologustol egy equipmentet, ami eltunik
     *
     * @param e az eldobott Equipment
     */
    public void dropEquipment(Equipment e) {
        //System.out.println("Equipment eldobva");
    }

    /**
     * Visszaadja a mezon allo Citizen
     *
     * @return a mezon allo Citizen, vagy null
     */
    public Citizen getCitizen() {
        return citizen;
    }

    /**
     * Beallitja a mezon levo Citizent
     *
     * @param c a beallitando Citizen
     */
    public void setCitizen(Citizen c) {
        citizen = c;
    }

    /**
     * Felvesz egy szomszedos mezot
     *
     * @param f a szomszedos mezo
     */
    public void addNeighbor(Field f) {
        neighbors.add(f);
    }
}
