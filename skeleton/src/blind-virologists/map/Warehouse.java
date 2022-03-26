package map;

import items.Material;

/**
 * A warehouse mezőt megvalósító osztály.
 *
 * @author Kovacs Aron
 * @since 2022-03-26
 */
public class Warehouse extends  Field{

    private Material material;

    /**
     * Az warehouse mezőt létrehozó konstruktor
     *@param material a warehouseban lévő materialt adja meg
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
     * @return material visszaadja a mezőn lévő anyagot
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * A warehouse mező gettere
     * @param material a warehouseban lévő anyagot állítja be
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Az warehouse mezőn lévő material felvételét végző függvény
     * @return collected a felvett anyagot adja vissza
     */
    public Material collectMaterial(){
        Material collected=this.material;
        setMaterial(null);
        return collected;
    }

    /**
     * Az warehouse mezőre lépő visitor fogadását végző függvény
     * @param v a mezőre lépő visitor
     */
    @Override
    public void accept(Visitor v) {
        //v.visit(this);
    }
}
