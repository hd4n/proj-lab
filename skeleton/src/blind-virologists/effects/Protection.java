package effects;

import citizens.Citizen;

/**
 * A kopeny hatasat megvalosito osztaly. A tamadasok ellen 82,3%-os vedelmet nyujt.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class Protection extends Effect{

    /**
     * A Protection osztaly konstruktora
     */
    public Protection(){
        System.out.println("Protection: letrehoz egy Protection effektet");
        //Duration = 10;
    }

    /**
     * A Protection osztaly konstruktora
     * @param duration ilyen hosszan tart az effekt
     */
    public Protection(int duration){
        System.out.println("Protection: letrehoz egy Protection effektet es beallitja az idejet");
        //Duration = duration;
    }

    /**
     * Beallitja a Duration-t
     * @param duration hosszú ideig hat az effect
     */
    public void setDuration(int duration){
        //Duration = duration;
        System.out.println("Protection: beallitja a Durationt");
    }

    /**
     * Visszaadja a Duration-t
     */
    public void getDuration(){
        //Duration = duration;
        System.out.println("Protection: visszaadja a Durationt");
    }

    /**
     * A Citizen resistance tagvaltozojat 82.3-ra allitja.
     * @param affectedCitizen resistance tagvaltozojat allitja at.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen){
        System.out.println("Protection: atallitja a resistance tagvaltozot 82.3-ra");
        //affectedCitizen.setResistance(82.3);
    }
}
