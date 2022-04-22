package items;

import citizens.Citizen;
import effects.*;

/**
 * A zsákot megvalósító osztály.
 *
 * @author Feher Norbert
 * @since 2022-04-22
 */
public class Bag extends Equipment {
    /**
     * A fuggveny létrehoz egy IncreaseBag effect-et és visszaadja azt.
     */
    public Bag(){
        e = new IncreaseBag(10);
    }
    public Effect use(Citizen target) {
        return e;
    }
}
