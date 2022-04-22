package map;

import citizens.Citizen;
import citizens.Virologist;
import effects.Effect;
import items.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * A jatek vezerleset megvalosito osztaly
 *
 * @author Hajos Daniel
 * @since 2022-03-26
 */
public class City {
    private ArrayList<Citizen> players;
    private ArrayList<Field> fields;
    private int codes;

    public City() {
    }

    public City(ArrayList<Citizen> players, ArrayList<Field> fields, int codes) {
        this.players = players;
        this.fields = fields;
    }

    public ArrayList<Citizen> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Citizen> players) {
        this.players = players;
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }

    public void setCodes(int codes) {
        this.codes = codes;
    }

    public int getCodes() {
        return codes;
    }

    public void addPlayer(Citizen e) {
        players.add(e);
    }

    public void addField(Field f) {
        fields.add(f);
    }

    /**
     * Letrehozza palya mezoit, a rajtuk talalhato targyakat es a jatekosokat
     */
    public void generateMap() {

        System.out.println("Hany virologus legyen a palyan?\n");
        Scanner sc = new Scanner(System.in);
        int playerCount;
        playerCount = sc.nextInt();

        System.out.println("Mekkora legyen a palya?\n");
        Scanner sc2 = new Scanner(System.in);
        int fieldCount;
        fieldCount = sc2.nextInt();

        for (int i = 0; i < playerCount - 1; i++) {
            players.add(new Virologist());
        }

        for (int i = 0; i < fieldCount - 1; i++) {
            fields.add(new Empty());
        }

        Shelter s1 = new Shelter();
        fields.add(s1);
        s1.setEquipment(new Cape());

        Shelter s2 = new Shelter();
        fields.add(s2);
        s2.setEquipment(new Gloves());

        Warehouse w1 = new Warehouse();
        fields.add(w1);
        w1.setMaterial(new Aminoacid());

        Warehouse w2 = new Warehouse();
        fields.add(w2);
        w2.setMaterial(new Aminoacid());

        Laboratory l1 = new Laboratory();
        fields.add(l1);
        l1.setCode(new Code(new Vaccine(), 3, 3));

        Laboratory l2 = new Laboratory();
        fields.add(l2);
        l2.setCode(new Code(new Vaccine(), 3, 3));

        InfectedLaboratory il1 = new InfectedLaboratory();
        fields.add(il1);
        il1.setCode(new Code(new Virus(), 3, 2));

        InfectedLaboratory il2 = new InfectedLaboratory();
        fields.add(il2);
        il2.setCode(new Code(new Virus(), 3, 2));


        Random random = new Random();
        for (int i = 0; i < playerCount - 1; i++) {
            boolean found = false;
            while (!found) {
                Field temp = fields.get(random.nextInt(fieldCount - 1));
                if (temp.getCitizen() == null) {
                    players.get(i).setCurrentField(temp);
                    players.get(i).getCurrentField().setCitizen(players.get(i));
                    found = true;
                }
            }
        }


        Random random2 = new Random();
        for (int i = 0; i < fieldCount - 1; i++) {
            int temp = random2.nextInt(6 - 3 + 1) + 3;
            for (int x = 0; x < temp - 1; x++) {
                boolean foundN = false;
                while (!foundN) {
                    Field temp2 = fields.get(random.nextInt(fieldCount - 1));
                    if (fields.get(i).getNeighbors().contains(temp2) != true) {
                        fields.get(i).addNeighbor(temp2);
                        foundN = true;
                    }
                }
            }
        }
    }

    /**
     * Elinditja a jatekot
     */
    public void startGame() {
        generateMap();
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
        for (Citizen v : players) {
            v.nextRound();
            if (((Virologist)v).getCodes().size() == codes) {
                endGame();
            }
        }
    }


}
