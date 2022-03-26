package map;

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

    private ArrayList<Virologist> players = new ArrayList<>();
    private ArrayList<Field> map = new ArrayList<>();

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

        //v1.setMyField(e1);
        //v2.setMyField(e2);
        //v3.setMyField(e3);

        System.out.println("City: Shelter letrehozasa");
        Shelter s = new Shelter();
        //s.setEquipment(new Cape());

        System.out.println("City: Warehouse letrehozasa");
        Warehouse w = new Warehouse();
        //w.setMaterial(new Aminoacid());

        System.out.println("City: Laboratory letrehozasa");
        Laboratory l = new Laboratory();
        //l.setCode(new Code());

        //???
        map.add(e1);
        map.add(e2);
        map.add(e3);
        map.add(s);
        map.add(w);
        map.add(l);

        players.add(v1);
        players.add(v2);
        players.add(v3);
    }

    /**
     * Elinditja a jatekot
     */
    public void startGame() {
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
        if (res.equals("i")) {
            endGame();
            return;
        }

        System.out.println("City: Uj kor");
        for (Virologist v : players) {
            //v.update();
            //v.move();
        }
    }
}
