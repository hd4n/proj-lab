package items;

import effects.*;

/**
 * A vakcinat megvalosito osztaly.
 *
 * @author Kovacs Aron
 * @since 2022-04-22
 */
public class Vaccine extends Agent {
    /**
     * Konstruktor. A fuggveny letrehoz egy vakcinat.
     *
     * @param effect a kivant effect
     */
    public Vaccine(Effect effect) {
        super(effect);
    }

    /**
     * Konstruktor. A fuggveny letrehoz egy vakcinat.
     */
    public Vaccine() {
    }

    /**
     * A fuggveny a megfelelo effect-et visszaadja.
     */
    @Override
    public Effect use() {
        return effect;
    }

    /**
     * A fuggveny segitsegevel tortenik az objektum azonositasa a tesztesetekhez
     *
     * @return out az objektum azonositoja
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
