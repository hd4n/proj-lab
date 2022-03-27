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
     * Minden korben meghivodik, eggyel csokkenti a Duration tagvaltozot.
     * @return Ha letelik a hatásido, igazat ad vissza.
     */
    public boolean update(){
        System.out.println("Effect: egyel csokkenti a Duration tagvaltozot");

        //Duration--;
        //if (Duration == 0){
        //    return true;
        //}
        return false;
    }

    /**
     * Beallitja a Duration-t
     * @param duration hosszú ideig hat az effect
     */
    public void setDuration(int duration){
        //Duration = duration;
        System.out.println("Update: beallitja a Durationt");
    }

    /**
     * Visszaadja a Duration-t
     */
    public void getDuration(){
        //Duration = duration;
        System.out.println("Update: visszaadja a Durationt");
    }

    /**
     * A parameterkent kapott Citizen tulajdonsagait modositja, mindig a korok vegen hivodnak meg.
     * @param affectedCitizen Ennek a tulajdonsagait modositja.
     */
    public void applyEffect(Citizen affectedCitizen){
        System.out.println("Update: modositja a Citizen tulajdonsagait");
    }
}
