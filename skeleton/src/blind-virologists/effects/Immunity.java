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
    }

    /**
     * A Citizen resistance tagvaltozojat 100-ra allitja.
     * @param affectedCitizen resistance tagvaltozojat allitja at.
     */
    public void ApplyEffect(Citizen affectedCitizen){
        System.out.println("Immunity: atallitja a resistance tagvaltozot 100-ra");
        //affectedCitizen.SetResistance(100);
    }
}
