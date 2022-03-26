package effects;

import citizens.Citizen;

/**
 * Az agenseken es felszereleseken keresztul megkaphato effektetek reprezentalo absztrakt osztaly.
 * Az adott korben megkapott effekt a kovetkezo korben fejti ki a hatasat.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public abstract class Effect {

    /**
     * Az Effect osztaly konstruktora
     */
    public Effect(){
        System.out.println("Effect: letrehoz egy Effectet es beallitja az idejet");
        //Duration = 10;
    }

    /**
     * Minden korben meghivodik, eggyel csokkenti a Duration tagvaltozot.
     * @return Ha letelik a hatásido, igazat ad vissza.
     */
    public boolean Update(){
        System.out.println("Effect: egyel csokkenti a Duration tagvaltozot");

        //Duration--;
        //if (Duration == 0){
        //    return true;
        //}
        return false;
    }

    /**
     * A parameterkent kapott Citizen tulajdonsagait modositja, mindig a korok vegen hivodnak meg.
     * @param affectedCitizen Ennek a tulajdonsagait modositja.
     */
    public void ApplyEffect(Citizen affectedCitizen){
        System.out.println("Update: modositja a Citizen tulajdonsagait");
    }
}
