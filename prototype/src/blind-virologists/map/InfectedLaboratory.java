package map;

import citizens.Visitor;
import items.Code;

/**
 * A fertozott labort megvalosito osztaly
 *
 * @author Hajos Daniel
 * @since 2022-04-21
 */

public class InfectedLaboratory extends Laboratory {

    /**
     * Parameter nelkuli konstruktor
     */
    public InfectedLaboratory() {
    }

    /**
     * Parameteres konstruktor
     *
     * @param c az eltarolando kod
     */
    public InfectedLaboratory(Code c) {
        super(c);
    }

    /**
     * A mezovel interakcioba lepo visitor fogadasat vegzo fuggveny
     *
     * @param v az interakciot vegzo visitor
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
