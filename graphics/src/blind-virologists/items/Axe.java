package items;

import citizens.Citizen;
import citizens.Virologist;
import effects.Effect;
import map.Empty;
import map.Laboratory;
import map.Shelter;
import map.Warehouse;

import java.security.spec.RSAOtherPrimeInfo;

/**
 * A baltát megvalósító osztály.
 *
 * @author Feher Norbert
 * @since 2022-04-22
 */

public class Axe extends Equipment{

    private boolean used = false;

    public Axe(){
        e = null;
    }
    public Axe(String _ID){
        e = null;
        setID(_ID);
    }
    public boolean getUsed(){
        return used;
    }

    public Effect use(Citizen target) {

        used = true;
        return null;
    }

    @Override
    public String toString(){
        return "Axe";
    }
}
