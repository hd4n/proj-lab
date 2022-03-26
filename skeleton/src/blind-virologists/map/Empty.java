package map;

import citizens.Virologist;
import citizens.Visitor;
import items.Equipment;

/**
 * Az üres mezőt megvalosito osztaly.
 *
 * @author Kovacs Aron
 * @since 2022-03-26
 */
public class Empty extends Field{

    private Equipment equipment;

    /**
     * Az üres mezőt létrehozó konstruktor
     *@param equipment ha esetleg equipmenttel hoznánk létre üres mezőt
     */

    public Empty(Equipment equipment) {
        this.equipment = equipment;
    }

    /**
     * Az üres mezőt létrehozó paraméter nélküli konstruktor
     */
    public Empty() {
        this.equipment=null;
    }

    /**
     * Az üres mező gettere
     * @return a mezőn lévő felszerlést adja vissza
     */
    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * Az üres mező settere
     * @param equipment beállítja az üres mezőn lévő felszerelést
     */
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    /**
     * Az üres mezőn lévő equipment felvételét végző függvény
     * @return a felvett felszerelést adja vissza
     */
    public Equipment pickUpEquipment(){
        Equipment collected = equipment;
        setEquipment(null);
        return collected;
    }

    /**
     * Az üres mezőre lépő visitor fogadását végző függvény
     * @param v a mezőre lépő visitor
     */
    @Override
    public void accept(Visitor v) {
        //v.visit(this);
    }
}
