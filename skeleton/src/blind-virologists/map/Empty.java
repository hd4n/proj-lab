package map;

import citizens.Virologist;
import citizens.Visitor;
import items.Equipment;

/**
 * Az ures mezot megvalosito osztaly.
 *
 * @author Kovacs Aron
 * @since 2022-03-26
 */
public class Empty extends Field {

    private Equipment equipment;

    /**
     * Az ures mezot letrehozo konstruktor
     *
     * @param equipment ha esetleg equipmenttel hoznank letre ures mezot
     */

    public Empty(Equipment equipment) {
        this.equipment = equipment;
    }

    /**
     * Az ures mezot letrehozo parameter nelkuli konstruktor
     */
    public Empty() {
        this.equipment = null;
    }

    /**
     * Az ures mezo gettere
     *
     * @return a mezon levo felszerelest adja vissza
     */
    public Equipment getEquipment() {
        System.out.println("Empty: getter fuggvenye meghivodott");
        return equipment;
    }

    /**
     * Az ures mezo settere
     *
     * @param equipment beallitja az ures mezon levo felszerelest
     */
    public void setEquipment(Equipment equipment) {
        System.out.println("Empty: setter fuggvenye meghivodott");
        this.equipment = equipment;
    }

    /**
     * Az ures mezon levo equipment felvetelet vegzo fuggveny
     *
     * @return a felvett felszerelest adja vissza
     */
    public Equipment pickUpEquipment() {
        System.out.println("Empty: Equipment felvetele");
        Equipment collected = equipment;
        setEquipment(null);
        return collected;
    }

    /**
     * Az ures mezore lepo visitor fogadasat vegzo fuggveny
     *
     * @param v a mezore lepo visitor
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
