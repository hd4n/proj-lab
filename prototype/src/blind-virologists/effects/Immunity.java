package effects;

import citizens.Citizen;

// ki kell kommentezni, ha az osszes metodus keszen van

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
     * @param dur ilyen hosszan tart az effekt.
     */
    public Immunity(double dur) {
        duration = dur;
    }

    /**
     * A Immunity osztaly konstruktora.
     * @param citizen akire hat az effekt.
     * @param dur ilyen hosszan tart az effekt.
     */
    public Immunity(Citizen citizen, double dur) {
        duration = dur;
    //    citizen.addEffect(this);
    }

    /**
     * Beallitja a Duration-t.
     * @param dur hosszú ideig hat az effect.
     */
    public void setDuration(double dur) {
        duration = dur;
    }

    /**
     * Visszaadja a Duration-t
     */
    public double getDuration() {
        return duration;
    }

    /**
     * A Citizen resistance tagvaltozojat 100-ra allitja.
     * @param affectedCitizen resistance tagvaltozojat allitja at.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
    /*    if (duration == 0){
            if(affectedCitizen.getResistance() == 100) {
                affectedCitizen.setResistance(0);
            }
        }else {
            affectedCitizen.setResistance(100);
        }*/
    }
}
