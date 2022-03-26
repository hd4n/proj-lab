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
    }

    /**
     * A Reflect osztaly konstruktora
     * @param duration ilyen hosszan tart az effekt
     */
    public Reflect(int duration){
        //Duration = duration;
        System.out.println("Reflect: letrehoz egy Reflect effektet es beallitja az idejet");
    }

    /**
     * Ennek hatasara a virologusra egy olyan effect kerul aminek hatasara visszaforditja a ra kent agenseket.
     * @param affectedCitizen kerul a hatas ala.
     */
    public void ApplyEffect(Citizen affectedCitizen){
        System.out.println("Reflect: visszafordito efekt hatas kerul ra");

        //visszaforditas
    }
}
