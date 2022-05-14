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
        e = new Reflect(10, this);
    }
    public Gloves(String _ID){
        e = new Reflect(10, this);
        setID(_ID);
    }
    public Effect use(Citizen target) {
        return e;
    }

    @Override
    public String toString(){
        return "Gloves";
    }
}
