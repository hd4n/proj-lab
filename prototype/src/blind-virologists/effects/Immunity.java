package effects;

import citizens.Citizen;

/**
 * A vakcina altal megszerezheto immunitas hatasat reprezentalo osztaly.
 * Hatasa alatt a virologusra kent virusok hatastalanok.
 *
 * @author Eros Pal
 * @since 2022-04-22
 */
public class Immunity extends Effect {

    /**
     * Az Immunity osztaly konstruktora, 3 meretu durationnal.
     */
    public Immunity() {
        duration = 3;
    }

    /**
     * Az Immunity osztaly konstruktora.
     *
     * @param dur ilyen hosszan tart az effekt.
     */
    public Immunity(int dur) {
        duration = dur;
    }

    /**
     * A Immunity osztaly konstruktora.
     *
     * @param citizen akire hat az effekt.
     * @param dur     ilyen hosszan tart az effekt.
     */
    public Immunity(Citizen citizen, int dur) {
        duration = dur;
        citizen.addEffect(this);
    }

    /**
     * A Citizen resistance tagvaltozojat 100-ra allitja.
     *
     * @param affectedCitizen resistance tagvaltozojat allitja at.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
        if (duration == 0){
            if(affectedCitizen.getResistance() == 100) {
                affectedCitizen.setResistance(0);
            }
        }else {
            affectedCitizen.setResistance(100);
        }
    }
}
