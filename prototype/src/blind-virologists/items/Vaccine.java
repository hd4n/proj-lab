package items;

import effects.*;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Vaccine extends Agent {
    /**
     * Konstruktor. A fuggveny letrehoz egy vakcinat.
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
}
