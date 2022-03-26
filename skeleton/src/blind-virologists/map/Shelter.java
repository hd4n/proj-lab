package map;

import citizens.Virologist;
import citizens.Visitor;
import items.Cape;
import items.Equipment;

import java.util.Scanner;

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
    public Equipment pickUpEquipment(){
        System.out.println("Shelter: Equipment felvetele");
        System.out.println("Shelter: Van Equipment a shelterben? (igen/nem)");
        Scanner sc=new Scanner(System.in);
        String res=sc.next();
        if(res.equalsIgnoreCase("igen")){
            System.out.println("Shelter: Equipment eltavolitva");
            return new Cape();
        } else{
            return null;
        }
    }
}
