package effects;

import citizens.Citizen;

/**
 * A taszito effektet valositja meg. Ez a hatas a kesztyu kovetkezteben lephet ervenybe.
 * A virologusra felkent agenst forditja vissza.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class Reflect extends Effect{

    /**
     * A Reflect osztaly konstruktora
     */
    public Reflect(){
        System.out.println("Reflect: letrehoz egy Reflect effektet");
        //Duration = 10;
    }

    /**
     * A Reflect osztaly konstruktora
     * @param duration ilyen hosszan tart az effekt
     */
    public Reflect(int duration){
        System.out.println("Reflect: letrehoz egy Reflect effektet es beallitja az idejet");
        //Duration = duration;
    }

    /**
     * Beallitja a Duration-t
     * @param duration hosszú ideig hat az effect
     */
    public void setDuration(int duration){
        //Duration = duration;
    }

    /**
     * Visszaadja a Duration-t
     */
    public void getDuration(){
        //Duration = duration;
    }

    /**
     * Ennek hatasara a virologusra egy olyan effect kerul aminek hatasara visszaforditja a ra kent agenseket.
     * @param affectedCitizen kerul a hatas ala.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen){
        System.out.println("Reflect: visszafordito efekt hatas kerul ra");
    }
}
