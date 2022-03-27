package effects;

import citizens.Citizen;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class Dance extends Effect{

    /**
     * A Dance osztaly konstruktora
     */
    public Dance(){
        System.out.println("Dance: letrehoz egy Dance effektet");
        //Duration = 10;
    }

    /**
     * A Dance osztaly konstruktora
     * @param duration ilyen hosszan tart az effekt
     */
    public Dance(int duration){
        System.out.println("Dance: letrehoz egy Dance effektet es beallitja az idejet");
        //Duration = duration;
    }

    /**
     * Beallitja a Duration-t
     * @param duration hosszú ideig hat az effect
     */
    public void setDuration(int duration){
        //Duration = duration;
        System.out.println("Dance: beallitja a Durationt");
    }

    /**
     * Visszaadja a Duration-t
     */
    public void getDuration(){
        //Duration = duration;
        System.out.println("Dance: visszadja a Durationt");
    }

    /**
     * Megvaltoztatja a jatekos altal korabban beallitott lepest egy veletlenszeru szomszedos mezore.
     * @param affectedCitizen lepeset allitja at.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
        System.out.println("Dance: egy random szomszedos mezore lepteti");
    }
}
