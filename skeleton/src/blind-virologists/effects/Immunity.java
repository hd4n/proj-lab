package effects;

import citizens.Citizen;

/**
 * A vakcina altal megszerezheto immunitas hatasat reprezentalo osztaly.
 * Hatasa alatt a virologusra kent virusok hatastalanok.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class Immunity extends Effect{

    /**
     * Az Immunity osztaly konstruktora
     */
    public Immunity(){
        System.out.println("Immunity: letrehoz egy Immunity effektet");
        //Duration = 10;
    }

    /**
     * A Immunity osztaly konstruktora
     * @param duration ilyen hosszan tart az effekt
     */
    public Immunity(int duration){
        System.out.println("Immunity: letrehoz egy Immunity effektet es beallitja az idejet");
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
     * A Citizen resistance tagvaltozojat 100-ra allitja.
     * @param affectedCitizen resistance tagvaltozojat allitja at.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen){
        System.out.println("Immunity: atallitja a resistance tagvaltozot 100-ra");
        //affectedCitizen.setResistance(100);
    }
}
