package items;

import effects.*;

import java.util.Scanner;

/**
 * A virust megvalosito osztaly.
 *
 * @author Kovacs Aron
 * @since 2022-04-22
 */
public class Virus extends Agent {
    /**
     * Konstruktor. A fuggveny letrehoz egy vakcinat.
     */
    public Virus() {
    }

    /**
     * Konstruktor. A fuggveny letrehoz egy virust.
     *
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
