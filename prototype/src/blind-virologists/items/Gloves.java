package items;

import citizens.Citizen;
import effects.*;

/**
 * A kesztyűt megvalósító osztály.
 *
 * @author Feher Norbert
 * @since 2022-04-22
 */
public class Gloves extends Equipment {
    /**
     * A fuggveny létrehoz egy Reflect effect-et és visszaadja azt.
     */
    public Gloves(){
        e = new Reflect(10);
    }
    public Effect use(Citizen target) {
        return e;
    }
}
