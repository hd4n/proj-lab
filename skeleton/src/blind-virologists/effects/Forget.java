package effects;

import citizens.Citizen;

/**
 * A felejto virus altal kifejtett hatas, a megfertozott virologus az altala osszegyujtött genetikai kodokat elfelejti.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class Forget extends Effect{

    /**
     * A Forget osztaly konstruktora
     */
    public Forget(){
        System.out.println("Forget: letrehoz egy Forget effektet");
        //Duration = 10;
    }

    /**
     * A Forget osztaly konstruktora
     * @param duration ilyen hosszan tart az effekt
     */
    public Forget(int duration){
        System.out.println("Forget: letrehoz egy Forget effektet es beallitja az idejet");
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
     * Kitorli a virologus osszes ismert genetikai kodjat.
     * @param affectedCitizen felejti el a kodokat.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen){
        System.out.println("Forget: kitorli az ismert genetikai kodokat");
    }
}
