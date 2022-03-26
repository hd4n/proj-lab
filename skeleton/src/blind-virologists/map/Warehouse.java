package map;

import citizens.Visitor;
import items.Material;

/**
 * A warehouse mezőt megvalósító osztály.
 *
 * @author Kovacs Aron
 * @since 2022-03-26
 */
public class Warehouse extends Field {

    private Material material;

    /**
     * Az warehouse mezőt létrehozó konstruktor
     *
     * @param material a warehouseban lévő materialt adja meg
     */
    public Warehouse(Material material) {
        this.material = material;
    }

    /**
     * Az warehouse mezőt létrehozó paraméter nélküli konstruktor
     */
    public Warehouse() {
        this.material = null;
    }

    /**
     * A warehouse mező gettere
     *
     * @return material visszaadja a mezőn lévő anyagot
     */
    public Material getMaterial() {
        System.out.println("Warehouse mező: getter függvénye meghívódott");
        return material;
    }

    /**
     * A warehouse mező settere
     *
     * @param material a warehouseban lévő anyagot állítja be
     */
    public void setMaterial(Material material) {
        System.out.println("Warehouse mező: setter függvénye meghívódott");
        this.material = material;
    }

    /**
     * Az warehouse mezőn lévő material felvételét végző függvény
     *
     * @return collected a felvett anyagot adja vissza
     */
    public Material collectMaterial() {
        System.out.println("Warehouse mező: anyag felvétele");
        Material collected = this.material;
        setMaterial(null);
        return collected;
    }

    /**
     * Az warehouse mezőre lépő visitor fogadását végző függvény
     *
     * @param v a mezőre lépő visitor
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
