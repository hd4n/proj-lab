package map;

import citizens.Citizen;
import citizens.Virologist;
import items.Aminoacid;
import items.Cape;
import items.Code;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A jatek vezerleset megvalosito osztaly
 *
 * @author Hajos Daniel
 * @since 2022-03-26
 */
public class City {
    /**
     * Letrehozza palya mezoit, a rajtuk talalhato targyakat es a jatekosokat
     */
    public void generateMap() {
        System.out.println("City: Palya letrehozasa...");

        System.out.println("City: Virologus1 leterhozasa");
        Virologist v1 = new Virologist();
        System.out.println("City: Virologus2 leterhozasa");
        Virologist v2 = new Virologist();
        System.out.println("City: Virologus3 leterhozasa");
        Virologist v3 = new Virologist();

        System.out.println("City: Empty1 letrehozasa");
        Empty e1 = new Empty();
        System.out.println("City: Empty2 letrehozasa");
        Empty e2 = new Empty();
        System.out.println("City: Empty3 letrehozasa");
        Empty e3 = new Empty();

        v1.setCurrentField(e1);
        v2.setCurrentField(e2);
        v3.setCurrentField(e3);

        e1.setCitizen(v1);
        e2.setCitizen(v2);
        e3.setCitizen(v3);

        System.out.println("City: Shelter letrehozasa");
        Shelter s = new Shelter();
        s.setEquipment(new Cape());

        System.out.println("City: Warehouse letrehozasa");
        Warehouse w = new Warehouse();
        w.setMaterial(new Aminoacid());

        System.out.println("City: Laboratory letrehozasa");
        Laboratory l = new Laboratory();
        l.setCode(new Code());

    }

    /**
     * Elinditja a jatekot
     */
    public void startGame() {
        generateMap();
        System.out.println("City: Elindult a jatek");
        nextRound();
    }

    /**
     * Befejezi a jatekot
     */
    public void endGame() {
        System.out.println("City: Veget ert a jatek");
    }

    /**
     * Uj kor kezdodik, veget er a jatek vagy frissulnek a virologusok allapotai
     */
    public void nextRound() {
        System.out.println("City: Megtanulta valaki az osszes kodot? (igen/nem)");
        Scanner scanner = new Scanner(System.in);
        String res = scanner.next();
        if (res.equalsIgnoreCase("igen")) {
            endGame();
            return;
        }

        //lista a teszteleshez
        ArrayList<Citizen> players = new ArrayList<>();
        players.add(new Virologist());

        System.out.println("City: Uj kor");
        for (Citizen v : players) {
            v.nextRound();
        }
    }
}
