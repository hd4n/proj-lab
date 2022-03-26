package citizens;

import effects.*;
import map.Empty;
import map.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A varosban lako player altal iranyitott karakter absztarkt osztalya
 *
 * @author Barta Daniel
 * @since 2022-03-26
 */
public abstract class Citizen implements Visitor {
    /**
     * Kivalasztott mezore lep
     */
    public void move() {
        Field myField = new Empty();
        System.out.println("Cel mezo tipusa?");
        Scanner scanner = new Scanner(System.in);
        String nextTile = scanner.next();
        System.out.println("Citizen: Aktualis myField player atributumanak torlese.");
        //myField.setPlayer(null);
        System.out.println("Citizen: A myField beallitasa az uj " + nextTile + " mezore.");
        System.out.println("Citizen: Az uj myField player attributumanak atirasa.");
        //myField.setPlayer(this);
    }

    /**
     * Torli az osszes hatast, torli a lejart effecteket, majd beallitja az uj ertekeket
     */
    public void nextRound() {
        List<Effect> effects = new ArrayList<>();
        //altiv effektek a teszteleshez
        //stun
        System.out.println("Legyen aktiv stun effekt? (igen/nem)");
        Scanner scanner = new Scanner(System.in);
        String activeStun = scanner.next();
        if (activeStun.toLowerCase().equals("igen")) {
            effects.add(new Stun());
        }
        //dance
        System.out.println("Legyen aktiv dance effekt? (igen/nem)");
        String activeDance = scanner.next();
        if (activeDance.toLowerCase().equals("igen")) {
            effects.add(new Dance());
        }
        //forget
        System.out.println("Legyen aktiv forget effekt? (igen/nem)");
        String activeForget = scanner.next();
        if (activeForget.toLowerCase().equals("igen")) {
            effects.add(new Forget());
        }
        //immunuty
        System.out.println("Legyen aktiv immunuty effekt? (igen/nem)");
        String activeimmunuty = scanner.next();
        if (activeimmunuty.toLowerCase().equals("igen")) {
            effects.add(new Immunity());
        }

        //protection
        System.out.println("Legyen aktiv protection effekt? (igen/nem)");
        String protection = scanner.next();
        if (protection.toLowerCase().equals("igen")) {
            effects.add(new Protection());
        }

        //protection
        System.out.println("Legyen aktiv reflect effekt? (igen/nem)");
        String reflect = scanner.next();
        if (reflect.toLowerCase().equals("igen")) {
            effects.add(new Reflect());
        }

        //protection
        System.out.println("Legyen aktiv increase-bag effekt? (igen/nem)");
        String increaseBag = scanner.next();
        if (increaseBag.toLowerCase().equals("igen")) {
            effects.add(new IncreaseBag());
        }

        System.out.println("Citizen: Alapertelmezettre allitja az osszes tulajdonsagat.");
        System.out.println("Citizen: Meghivja az osszes effektjen az update fuggvenyt.");

        for (Effect item : effects) {
            //boolean letelt = item.update;
            boolean letelt = false;
            if (letelt) {
                System.out.println("Citizen: az adott effektet kiveszi a listajabol mert az letelt.");
            } else {
                System.out.println("Citizen: Meghivja az effekt appleEffect() fuggvenyet.");
                //item.applyEffect(this);
            }
        }
    }

    /**
     * A fuggveny a szabad szomszedos mezoket adja vissza, ahova lephet az adott Citizen. (nem all rajta senki)
     *
     * @return Field listat ad vissza
     */
    public List<Field> getMoves() {
        Field myField = new Empty();
        System.out.println("Citizen: Meghivja a myField GetNeighbors() fuggvenyt");
        List<Field> neighbors = new ArrayList<>();
        //List<Field> neighbors = myField.getNeighbors()
        System.out.println("Citizen: A szomszedos mezokbol kivalogatja azokat ahol nem all senki, (getCitizen()==null).");
        for (Field tile : neighbors) {
            //Citizen player = tile.getCitizen()
            Citizen player = null;
            if (player != null) {
                System.out.println("Citizen: Az adott mezo a jatekos szamara elerheto, visszaadja.");
            } else {
                System.out.println("Citizen: A adott mezo a jatekos szamara nem elerheto ezert nem adja vissza.");
                //neighbors.remove(tile);
            }
        }

        return neighbors;
    }

}
