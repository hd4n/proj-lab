package citizens;

import map.Empty;
import map.Field;

import java.util.Scanner;

public abstract class Citizen implements Visitor {
    /**
     * fuggveny
     */
    public void move() {
        Field myField = new Empty();
        System.out.println("Cel mezo tipusa?");
        Scanner scanner = new Scanner(System.in);
        String nextTile = scanner.next();
        System.out.println("Citizen: aktualis myField player attributum torlese");
        //myField.SetPlayer(null);
        System.out.println("Citizen: myField beallitasa az uj " + nextTile + " mezore");
        System.out.println("Citizen: az uj myFiekd player attributumanak atirasa");
        //myField.SetPlayer(this);
    }
}
