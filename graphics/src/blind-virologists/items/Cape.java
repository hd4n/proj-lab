package items;

import citizens.Citizen;
import effects.*;

/**
 * A köpenyt megvalósító osztály.
 *
 * @author Feher Norbert
 * @since 2022-04-22
 */
public class Cape extends Equipment {
    /**
     * A fuggveny letrehoz egy Protection effect-et és visszaadja azt.
     */
    public Cape(){
        e = new Protection(10);
    }
    public Cape(String _ID){
        e = new Protection(10);
        setID(_ID);
    }
    public Effect use(Citizen target) {
        return e;
    }

    @Override
    public String toString(){
        return "Cape";
    }
}
