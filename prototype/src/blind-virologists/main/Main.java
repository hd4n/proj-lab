package main;

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

    private HashMap<String, Equipment> equipments = new HashMap<>();
    private HashMap<String, Material> materials = new HashMap<>();
    private HashMap<String, Code> codes = new HashMap<>();
    private HashMap<String, Agent> agents = new HashMap<>();

    private HashMap<String, Effect> effects = new HashMap<>();

    private HashMap<String, Field> fields = new HashMap<>();

    private HashMap<String, Virologist> virologists = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Vilagtalan virologusok vilaga - Proto");
        System.out.println("Csapat: alma");
        System.out.println("-------------------------------");
        //todo path fix
        Scanner sc;
        PrintStream ps = null;
        var stdout = System.out;
        Main main = new Main();

        if (args.length == 3 && args[0].equals("-t")) {
            System.out.println("Teszt futtatasa: " + args[1]);
            System.out.println("-------------------------------");

            File testFile = new File("prototype/tests/input/" + args[1]);
            try {
                sc = new Scanner(testFile);
            } catch (FileNotFoundException e) {
                System.err.println("Nem talalhato a teszt file");
                return;
            }

            //stdout fileba
            File outFile = new File("prototype/tests/output/" + args[1]);
            try {
                outFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ps = new PrintStream(outFile);
                System.setOut(ps);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            sc = new Scanner(System.in);
            sc.useDelimiter(System.getProperty("line.separator"));
        }

        while (sc.hasNextLine()) {
            String command = sc.nextLine();
            main.execCommand(command);
        }

        if (ps != null) {
            ps.close();
            System.setOut(stdout);
        }

        //kimenet ellenorzes
        if (compareResults(args[1], args[2])) {
            System.out.println("A teszt futasa sikeres");
        } else {
            System.err.println("A teszt futasa sikertelen");
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
        File input = new File("prototype/tests/config/" + commandArgs[1]);
        Scanner sc;
        try {
            sc = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.err.println("A teszt nem talalhato");
            return;
        }

        String section = "@item";
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
                    codes.put(args[1], new Code(agents.get(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])));
                    city.increaseCodeCount();
                    break;
                case "@fields":
                    addField(args);
                    break;
                case "@neighbors":
                    fields.get(args[0]).addNeighbor(fields.get(args[1]));
                    fields.get(args[1]).addNeighbor(fields.get(args[0]));
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
                equipments.put(args[1], new Axe());
                break;
            case "ba":
                equipments.put(args[1], new Bag());
                break;
            case "ca":
                equipments.put(args[1], new Cape());
                break;
            case "gl":
                equipments.put(args[1], new Gloves());
                break;
            case "am":
                materials.put(args[1], new Aminoacid());
                break;
            case "nu":
                materials.put(args[1], new Nucleotide());
                break;
        }
    }

    private void addEffect(String[] args) {
        switch (args[0]) {
            case "be":
                effects.put(args[1], new BearDance(Integer.parseInt(args[2])));
                break;
            case "da":
                effects.put(args[1], new Dance(Integer.parseInt(args[2])));
                break;
            case "fo":
                effects.put(args[1], new Forget());
                break;
            case "im":
                effects.put(args[1], new Immunity(Integer.parseInt(args[2])));
                break;
            case "in":
                effects.put(args[1], new IncreaseBag(Integer.parseInt(args[2])));
                break;
            case "pr":
                effects.put(args[1], new Protection(Integer.parseInt(args[2])));
                break;
            case "re":
                effects.put(args[1], new Reflect(Integer.parseInt(args[2]), (Gloves) equipments.get(args[3])));
                break;
            case "st":
                effects.put(args[1], new Stun(Integer.parseInt(args[2])));
                break;
        }
    }

    private void addAgent(String[] args) {
        switch (args[0]) {
            case "vi":
                agents.put(args[1], new Virus(effects.get(args[2])));
                break;
            case "va":
                agents.put(args[1], new Vaccine(effects.get(args[2])));
                break;
        }
    }

    private void addField(String[] args) {
        Field field = null;
        switch (args[0]) {
            case "em":
                field = args.length == 3 ? new Empty(equipments.get(args[2])) : new Empty();
                break;
            case "in":
                field = args.length == 3 ? new InfectedLaboratory(codes.get(args[2])) : new InfectedLaboratory();
                break;
            case "la":
                field = args.length == 3 ? new Laboratory(codes.get(args[2])) : new Laboratory();
                break;
            case "sh":
                field = args.length == 3 ? new Shelter(equipments.get(args[2])) : new Shelter();
                break;
            case "wa":
                field = args.length == 3 ? new Warehouse(materials.get(args[2])) : new Warehouse();
        }
        fields.put(args[1], field);
        city.addField(field);
    }

    private void addVirologist(String[] args) {
        Virologist v = new Virologist();
        virologists.put(args[0], v);
        city.addPlayer(v);
        virologists.get(args[0]).setCurrentField(fields.get(args[1]));
        fields.get(args[1]).setCitizen(v);

        if (args.length == 3) {
            if (!args[2].equals("null")) {
                String[] eq = args[2].split(";");
                for (int i = 0; i < eq.length; ++i) {
                    virologists.get(args[0]).addEquipment(equipments.get(eq[i]));
                }
            }
        }

        if (args.length >= 4) {
            if (!args[3].equals("null")) {
                String[] ma = args[3].split(";");
                for (int i = 0; i < ma.length; ++i) {
                    virologists.get(args[0]).addMaterial(materials.get(ma[i]));
                }
            }
        }

        if (args.length >= 5) {
            if (!args[4].equals("null")) {
                String[] ef = args[4].split(";");
                for (int i = 0; i < ef.length; ++i) {
                    virologists.get(args[0]).addEffect(effects.get(ef[i]));
                }
            }
        }
    }
    //endregion

    //step virologus_id celmezo_id
    private void step(String[] commandArgs) {
        Virologist virologist = (Virologist) getByKey(commandArgs[1]);
        Field target = (Field) getByKey(commandArgs[2]);
        virologist.setCurrentField(target);
        System.out.println("step: " + commandArgs[1] + " " + commandArgs[2]);
    }

    //getstats id
    private void getStats(String[] commandArgs) {
        if (commandArgs[1].equals("map")) {
            System.out.println("stat map:");
            for (Map.Entry<String, Field> entry : fields.entrySet()) {
                List<Field> neighbors = entry.getValue().getNeighbors();
                for (Field f : neighbors) {
                    System.out.println("\t" + entry.getValue().hashCode() + " - " + f.hashCode());
                }
            }
        } else {
            Object o = getByKey(commandArgs[1]);
            if (o != null) {
                String out = "stats: " + commandArgs[1] + " hash: " + o.hashCode() + "\n" + o.toString();
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
        Virologist virologist = (Virologist) getByKey(commandArgs[1]);
        Field current = virologist.getCurrentField();
        current.accept(virologist);
        System.out.println("interact: " + commandArgs[1] + ", mezo hash: " + current.hashCode());
    }

    //drop virologus_id equipment_id
    private void drop(String[] commandArgs) {
        Virologist virologist = (Virologist) getByKey(commandArgs[1]);
        Equipment equipment = (Equipment) getByKey(commandArgs[2]);
        virologist.drop(equipment);
        System.out.println("drop: " + commandArgs[1] + " " + commandArgs[2]);
    }

    //equip virologus_id equipment_id
    private void equip(String[] commandArgs) {
        Virologist virologist = (Virologist) getByKey(commandArgs[1]);
        Equipment equipment = (Equipment) getByKey(commandArgs[2]);
        virologist.equip(equipment);
        System.out.println("equip: " + commandArgs[1] + " " + commandArgs[2]);
    }

    //useagent virologus_id cel_id agent_id
    private void useAgent(String[] commandArgs) {
        Virologist virologist = (Virologist) getByKey(commandArgs[1]);
        Virologist target = (Virologist) getByKey(commandArgs[2]);
        Agent agent = (Agent) getByKey(commandArgs[3]);
        virologist.useAgent(target, agent);
        System.out.println("useagent: " + commandArgs[1] + " " + commandArgs[2] + " " + commandArgs[3]);
    }

    //unequip virologus_id equipment_id
    private void unequip(String[] commandArgs) {
        Virologist virologist = (Virologist) getByKey(commandArgs[1]);
        Equipment equipment = (Equipment) getByKey(commandArgs[2]);
        virologist.unequip(equipment);
        System.out.println("unequip: " + commandArgs[1] + " " + commandArgs[2]);
    }

    //steal virologus_id target_id materials/equipment
    private void steal(String[] commandArgs) {
        Virologist virologist = (Virologist) getByKey(commandArgs[1]);
        Virologist target = (Virologist) getByKey(commandArgs[2]);
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
        Virologist virologist = (Virologist) getByKey(commandArgs[1]);
        Code code = (Code) getByKey(commandArgs[2]);
        virologist.craft(code);
        System.out.println("craft: " + commandArgs[1] + " " + commandArgs[2]);
    }

    private Object getByKey(String key) {
        Object o;
        o = equipments.get(key);
        if (o != null) {
            return o;
        }

        o = materials.get(key);
        if (o != null) {
            return o;
        }

        o = codes.get(key);
        if (o != null) {
            return o;
        }

        o = agents.get(key);
        if (o != null) {
            return o;
        }

        o = effects.get(key);
        if (o != null) {
            return o;
        }

        o = fields.get(key);
        if (o != null) {
            return o;
        }

        o = virologists.get(key);
        if (o != null) {
            return o;
        }

        return null;
    }

    private static boolean compareResults(String f1, String f2) {
        File act = new File("prototype/tests/output/" + f1);
        File exp = new File("prototype/tests/expected/" + f2);

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