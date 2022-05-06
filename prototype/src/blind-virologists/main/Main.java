package main;

import citizens.Citizen;
import citizens.Virologist;
import effects.*;
import items.*;
import map.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 * @author Hajos Daniel
 * @since 2022-04-21
 */
public class Main {

    private City city = new City();

    private ArrayList<Equipment> equipments = new ArrayList<>();

    private ArrayList<Material> materials = new ArrayList<>();

    private ArrayList<Code> codes = new ArrayList<>();

    private ArrayList<Agent> agents = new ArrayList<>();

    private ArrayList<Effect> effects = new ArrayList<>();

    private static final String wdPath = new File(System.getProperty("user.dir")).getParent()/*+"\\proj-lab\\prototype"*/;

    public static void main(String[] args) {
        System.out.println("Vilagtalan virologusok vilaga - Proto");
        System.out.println("Csapat: alma");

        Scanner sc = null;
        PrintStream ps = null;
        var stdout = System.out;
        Main main = new Main();

        //System.out.println(wdPath);

        if (args.length == 3 && args[0].equals("-t")) {
            main.runTest(args[1], args[2]);
        } else if (args.length == 1 && args[0].equals("-at")) {
            File inputFolder = new File(wdPath + "/tests/input");
            File[] inputFiles = inputFolder.listFiles();
            for (File inputFile : inputFiles) {
                String input = inputFile.getName();
                if (input.equals("sample.test")) {
                    continue;
                }
                String expected = input.substring(0, input.length() - 5) + ".out";
                main.runTest(input, expected);
            }
        } else {
            System.out.println("-------------------------------");
            sc = new Scanner(System.in);
            sc.useDelimiter(System.getProperty("line.separator"));
            while (sc.hasNextLine()) {
                String command = sc.nextLine();
                main.execCommand(command);
            }
        }
    }

    private void runTest(String inputFile, String expectedFile) {
        System.out.println("-------------------------------");
        System.out.println("Teszt futtatasa: " + inputFile);

        PrintStream ps = null;
        Scanner sc = null;
        Main main = new Main();
        var stdout = System.out;

        File testFile = new File(wdPath + "/tests/input/" + inputFile);
        try {
            sc = new Scanner(testFile);
        } catch (FileNotFoundException e) {
            System.err.println("Nem talalhato a teszt file");
            return;
        }

        //stdout fileba
        File outFile = new File(wdPath + "/tests/output/" + inputFile);
        try {
            outFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            ps = new PrintStream(outFile);
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        //eID visszaallitasa, mert uj teszteset van
        Effect.resetEID();

        //feldolgozas
        while (sc.hasNextLine()) {
            String command = sc.nextLine();
            main.execCommand(command);
        }

        if (ps != null) {
            ps.close();
            System.setOut(stdout);
        }

        //kimenet ellenorzes
        if (compareResults(inputFile, expectedFile)) {
            System.out.println("A teszt futasa sikeres");
        } else {
            System.err.println("**A teszt futasa sikertelen**");
        }
    }

    private void execCommand(String command) {
        String[] commandArgs = command.split(" ");
        switch (commandArgs[0]) {
            case "load":
                loadFile(commandArgs);
                break;
            case "step":
                step(commandArgs);
                break;
            case "getstats":
                getStats(commandArgs);
                break;
            case "nextround":
                nextRound(commandArgs);
                break;
            case "interact":
                interact(commandArgs);
                break;
            case "drop":
                drop(commandArgs);
                break;
            case "equip":
                equip(commandArgs);
                break;
            case "useagent":
                useAgent(commandArgs);
                break;
            case "unequip":
                unequip(commandArgs);
                break;
            case "steal":
                steal(commandArgs);
                break;
            case "craft":
                craft(commandArgs);
                break;
            case "exit":
                System.exit(0);
        }
    }

    //region palyabetolto

    //load file.conf
    private void loadFile(String[] commandArgs) {
        File input = new File(wdPath + "/tests/config/" + commandArgs[1]);
        Scanner sc;
        try {
            sc = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.err.println("A teszt nem talalhato");
            return;
        }

        String section = "@items";
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] args = line.split(" ");

            if (line.length() == 0 || args[0].charAt(0) == '#') {
                continue;
            }

            if (args[0].charAt(0) == '@') {
                section = args[0];
                continue;
            }

            switch (section) {
                case "@items":
                    addItem(args);
                    break;
                case "@effects":
                    addEffect(args);
                    break;
                case "@agents":
                    addAgent(args);
                    break;
                case "@codes":
                    if (args.length == 2) {
                        codes.add(new Code(args[1]));
                    } else {
                        Agent a = (Agent) getByID(args[2]);
                        codes.add(new Code(a, Integer.parseInt(args[3]), Integer.parseInt(args[4]), args[1]));
                    }
                    city.increaseCodeCount();
                    break;
                case "@fields":
                    addField(args);
                    break;
                case "@neighbors":
                    ((Field) getByID(args[0])).addNeighbor((Field) getByID(args[1]));
                    ((Field) getByID(args[1])).addNeighbor((Field) getByID(args[0]));
                    break;
                case "@virologists":
                    addVirologist(args);
                    break;
            }
        }

        System.out.println("Load: sikeres");
    }

    private void addItem(String[] args) {
        switch (args[0]) {
            case "ax":
                equipments.add(new Axe(args[1]));
                break;
            case "ba":
                equipments.add(new Bag(args[1]));
                break;
            case "ca":
                equipments.add(new Cape(args[1]));
                break;
            case "gl":
                equipments.add(new Gloves(args[1]));
                break;
            case "am":
                materials.add(new Aminoacid(args[1]));
                break;
            case "nu":
                materials.add(new Nucleotide(args[1]));
                break;
        }
    }

    private void addEffect(String[] args) {
        switch (args[0]) {
            case "be":
                effects.add(new BearDance(Integer.parseInt(args[2]), args[1]));
                break;
            case "da":
                effects.add(new Dance(Integer.parseInt(args[2]), args[1]));
                break;
            case "fo":
                effects.add(new Forget(args[1]));
                break;
            case "im":
                effects.add(new Immunity(Integer.parseInt(args[2]), args[1]));
                break;
            case "in":
                effects.add(new IncreaseBag(Integer.parseInt(args[2]), args[1]));
                break;
            case "pr":
                effects.add(new Protection(Integer.parseInt(args[2]), args[1]));
                break;
            case "re":
                Gloves g = (Gloves) getByID(args[3]);
                effects.add(new Reflect(Integer.parseInt(args[2]), g, args[1]));
                break;
            case "st":
                effects.add(new Stun(Integer.parseInt(args[2]), args[1]));
                break;
        }
    }

    private void addAgent(String[] args) {
        switch (args[0]) {
            case "vi":
                agents.add(new Virus((Effect) getByID(args[2]), args[1]));
                break;
            case "va":
                agents.add(new Vaccine((Effect) getByID(args[2]), args[1]));
                break;
        }
    }

    private void addField(String[] args) {
        Field field = null;
        switch (args[0]) {
            case "em":
                field = args.length == 3 ? new Empty((Equipment) getByID(args[2]), args[1]) : new Empty(args[1]);
                break;
            case "in":
                field = args.length == 3 ? new InfectedLaboratory((Code) getByID(args[2]), args[1]) : new InfectedLaboratory(args[1]);
                break;
            case "la":
                field = args.length == 3 ? new Laboratory((Code) getByID(args[2]), args[1]) : new Laboratory(args[1]);
                break;
            case "sh":
                field = args.length == 3 ? new Shelter((Equipment) getByID(args[2]), args[1]) : new Shelter(args[1]);
                break;
            case "wa":
                field = args.length == 3 ? new Warehouse((Material) getByID(args[2]), args[1]) : new Warehouse(args[1]);
        }
        city.addField(field);
    }

    private void addVirologist(String[] args) {
        Virologist v = new Virologist(args[0]);
        v.setCurrentField((Field) getByID(args[1]));
        city.addPlayer(v);

        ((Field) getByID(args[1])).setCitizen(v);

        if (args.length >= 3) {
            if (!args[2].equals("null")) {
                String[] eq = args[2].split(";");
                for (int i = 0; i < eq.length; ++i) {
                    ((Virologist) getByID(args[0])).addEquipment((Equipment) getByID(eq[i]));
                }
            }
        }

        if (args.length >= 4) {
            if (!args[3].equals("null")) {
                String[] ma = args[3].split(";");
                for (int i = 0; i < ma.length; ++i) {
                    ((Virologist) getByID(args[0])).addMaterial((Material) getByID(ma[i]));
                }
            }
        }

        if (args.length >= 5) {
            if (!args[4].equals("null")) {
                String[] ef = args[4].split(";");
                for (int i = 0; i < ef.length; ++i) {
                    ((Virologist) getByID(args[0])).addEffect((Effect) getByID(ef[i]));
                }
            }
        }
    }
    //endregion

    //step virologus_id celmezo_id
    private void step(String[] commandArgs) {
        Virologist virologist = (Virologist) getByID(commandArgs[1]);
        Field target = (Field) getByID(commandArgs[2]);
        virologist.setDirection(target);
        System.out.println("step: " + commandArgs[1] + " " + commandArgs[2]);
    }

    //getstats id
    private void getStats(String[] commandArgs) {
        if (commandArgs[1].equals("map")) {
            System.out.println("stat map:");
            for (Field field : city.getFields()) {
                List<Field> neighbors = field.getNeighbors();
                for (Field f : neighbors) {
                    System.out.println("\t" + field.getID() + " - " + f.getID());
                }
            }
        } else {
            Object o = getByID(commandArgs[1]);
            if (o != null) {
                String out = "\nstats: " + commandArgs[1] + "\n" + o;
                System.out.println(out);
            }
        }
    }

    //nextround
    private void nextRound(String[] commandArgs) {
        city.nextRound();
        System.out.println("nextround: sikeres");
    }

    //interact virologus_id
    private void interact(String[] commandArgs) {
        Virologist virologist = (Virologist) getByID(commandArgs[1]);
        Field current = virologist.getCurrentField();
        current.accept(virologist);
        System.out.println("interact: " + commandArgs[1] + " " + current.getID());
    }

    //drop virologus_id equipment_id
    private void drop(String[] commandArgs) {
        Virologist virologist = (Virologist) getByID(commandArgs[1]);
        Equipment equipment = (Equipment) getByID(commandArgs[2]);
        virologist.drop(equipment);
        System.out.println("drop: " + commandArgs[1] + " " + commandArgs[2]);
    }

    //equip virologus_id equipment_id
    private void equip(String[] commandArgs) {
        Virologist virologist = (Virologist) getByID(commandArgs[1]);
        Equipment equipment = (Equipment) getByID(commandArgs[2]);
        virologist.equip(equipment);
        System.out.println("equip: " + commandArgs[1] + " " + commandArgs[2]);
    }

    //useagent virologus_id cel_id agent_id
    private void useAgent(String[] commandArgs) {
        Virologist virologist = (Virologist) getByID(commandArgs[1]);
        Virologist target = (Virologist) getByID(commandArgs[2]);
        Agent agent = (Agent) getByID(commandArgs[3]);
        virologist.useAgent(target, agent);
        System.out.println("useagent: " + commandArgs[1] + " " + commandArgs[2] + " " + commandArgs[3]);
    }

    //unequip virologus_id equipment_id
    private void unequip(String[] commandArgs) {
        Virologist virologist = (Virologist) getByID(commandArgs[1]);
        Equipment equipment = (Equipment) getByID(commandArgs[2]);
        virologist.unequip(equipment);
        System.out.println("unequip: " + commandArgs[1] + " " + commandArgs[2]);
    }

    //steal virologus_id target_id materials/equipments
    private void steal(String[] commandArgs) {
        Virologist virologist = (Virologist) getByID(commandArgs[1]);
        Virologist target = (Virologist) getByID(commandArgs[2]);
        switch (commandArgs[3]) {
            case "materials":
                ArrayList<Material> stolenM = target.stealMaterial();
                virologist.addMaterial(stolenM);
                System.out.println("steal: " + commandArgs[1] + " target: " + commandArgs[2] + ", materials");
                break;
            case "equipments":
                ArrayList<Equipment> stolenE = target.stealEquipment();
                virologist.addEquipment(stolenE);
                System.out.println("steal: " + commandArgs[1] + " target: " + commandArgs[2] + ", equipments");
                break;
        }
    }

    //craft virologus_id code_id
    private void craft(String[] commandArgs) {
        Virologist virologist = (Virologist) getByID(commandArgs[1]);
        Code code = (Code) getByID(commandArgs[2]);
        virologist.craft(code);
        System.out.println("craft: " + commandArgs[1] + " " + commandArgs[2]);
    }

    private Object getByID(String ID) {
        for (Equipment o : equipments) {
            if (o.getID().equals(ID)) {
                return o;
            }
        }

        for (Material o : materials) {
            if (o.getID().equals(ID)) {
                return o;
            }
        }

        for (Code o : codes) {
            if (o.getID().equals(ID)) {
                return o;
            }
        }

        for (Agent o : agents) {
            if (o.getID().equals(ID)) {
                return o;
            }
        }

        for (Effect o : effects) {
            if (o.getID().equals(ID)) {
                return o;
            }
        }

        for (Field o : city.getFields()) {
            if (o.getID().equals(ID)) {
                return o;
            }
        }

        for (Citizen o : city.getPlayers()) {
            if (o.getID().equals(ID)) {
                return o;
            }
        }

        return null;
    }

    private static boolean compareResults(String f1, String f2) {
        File act = new File(wdPath + "/tests/output/" + f1);
        File exp = new File(wdPath + "/tests/expected/" + f2);

        Scanner aSc = null, eSc = null;

        try {
            aSc = new Scanner(act);
        } catch (FileNotFoundException e) {
            System.err.println(f1 + " nem talalhato");
            return false;
        }

        try {
            eSc = new Scanner(exp);
        } catch (FileNotFoundException e) {
            System.err.println(f2 + " nem talalhato");
            return false;
        }

        int lineCount = 0;
        while (eSc.hasNextLine()) {
            lineCount++;
            String actLine = aSc.nextLine();
            String expLine = eSc.nextLine();
            if (!actLine.equals(expLine)) {
                return false;
            }
        }
        return lineCount != 0;
    }
}