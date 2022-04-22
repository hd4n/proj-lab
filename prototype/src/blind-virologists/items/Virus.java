package items;

import effects.*;

import java.util.Scanner;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Virus extends Agent {
    /**
     * Konstruktor. A fuggveny letrehoz egy vakcinat.
     */
    public Virus(){
    }
    /**
     * Konstruktor. A fuggveny letrehoz egy virust.
     * @param effect a kivant effect
     */
    public Virus(Effect effect) {
        super(effect);
    }

    /**
     * A fuggveny a megfelelo effect-et visszaadja.
     */
    @Override
    public Effect use() {
        return effect;
    }

}
