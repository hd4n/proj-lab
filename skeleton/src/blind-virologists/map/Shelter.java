package map;

import citizens.Virologist;
import citizens.Visitor;
import items.Cape;

/**
 * Az ovohelyet megvalosito osztaly
 *
 * @author Hajos Daniel
 * @since 2022-03-26
 */
public class Shelter extends Field{
    /**
     * Elfogadja a Visitort
     * @param v az elfogadando Visitor
     */
    @Override
    public void accept(Visitor v) {
        //v.visit(this);
    }

    /**
     * A mezon allo virologushoz hozzaadja az ittlevo equipmentet
     */
    public void pickupEquipment(){
        System.out.println("Shelter: Equipment felvetele");
        Virologist currentVir=new Virologist();
        //currentVir.addEquipment(new Cape());
    }
}
