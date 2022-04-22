package map;

import citizens.Visitor;
import items.Equipment;

/**
 * Az ovohelyet megvalosito osztaly
 *
 * @author Hajos Daniel
 * @since 2022-04-21
 */
public class Shelter extends Field {

    /**
     * Az ovohelyen talalhato felszereles
     */
    private Equipment equipment;

    /**
     * Parameteres konstruktor
     *
     * @param e az eltarolando felszereles
     */
    public Shelter(Equipment e) {
        equipment = e;
    }

    /**
     * Parameter nelkuli konstruktor
     */
    public Shelter() {
        equipment=null;
    }

    /**
     * Elfogadja a Visitort
     *
     * @param v az elfogadando Visitor
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    /**
     * Eltavolitja es visszaadja a mezon levo equipmentet
     *
     * @return a mezon levo equipment
     */
    public Equipment pickUpEquipment() {
        Equipment tmp = equipment;
        equipment = null;
        return tmp;
    }

    /**
     * Beallitja a mezon levo Equipmentet
     *
     * @param e a beallitando Equipment
     */
    public void setEquipment(Equipment e) {
        equipment = e;
    }

    /**
     * Getter az equipmenthez
     *
     * @return a mezon levo equipment
     */
    public Equipment getEquipment() {
        return equipment;
    }
}
