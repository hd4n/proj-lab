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
     * @param time ennyi ideig ervenyes a hatasa
     */
    public Immunity(int time){
        //Duration = time;
        System.out.println("Immunity: letrehoz egy Immunity effektet es beallitja az idejet");
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
