package map;

import citizens.Visitor;
import items.Material;

/**
 * A warehouse mezot megvalositó osztaly.
 *
 * @author Kovacs Aron
 * @since 2022-03-26
 */
public class Warehouse extends Field {

    private Material material;

    /**
     * Az warehouse mezot letrehozo konstruktor
     *
     * @param material a warehouseban levo materialt adja meg
     */
    public Warehouse(Material material) {
        this.material = material;
    }

    /**
     * Az warehouse mezot letrehozo parameter nelkuli konstruktor
     */
    public Warehouse() {
        this.material = null;
    }

    /**
     * A warehouse mezo gettere
     *
     * @return material visszaadja a mezon levo anyagot
     */
    public Material getMaterial() {
        System.out.println("Warehouse: getter fuggvenye meghivodott");
        return material;
    }

    /**
     * A warehouse mezo settere
     *
     * @param material a warehouseban levo anyagot allitja be
     */
    public void setMaterial(Material material) {
        System.out.println("Warehouse: setter fuggvenye meghivodott");
        this.material = material;
    }

    /**
     * Az warehouse mezon levo material felvetelet vegzo fuggveny
     *
     * @return collected a felvett anyagot adja vissza
     */
    public Material collectMaterial() {
        System.out.println("Warehouse: anyag felvetele");
        Material collected = this.material;
        setMaterial(null);
        return collected;
    }

    /**
     * Az warehouse mezore lepo visitor fogadasat vegzo fuggveny
     *
     * @param v a mezore lepo visitor
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
