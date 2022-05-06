package items;

import citizens.Citizen;
import effects.*;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-04-22
 */
public abstract class Equipment {

    private String ID;
    /**
     * A fuggveny létrehozza a megfelelő effect-et és visszaadja azt.
     */
    protected Effect e;
    public abstract Effect use(Citizen target);
    public String getID(){
        return ID;
    }
    public void setID(String _ID){
        ID = _ID;
    }
    public String toString(){
        String out= "\tef_";
        if(e == null){
            out += "null";
        }
        else {
            out += e.getID();
        }
        return out;
    }
}
