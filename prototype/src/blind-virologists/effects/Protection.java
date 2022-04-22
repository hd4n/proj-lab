package effects;

import citizens.Citizen;

// ki kell kommentezni, ha az osszes metodus keszen van

/**
 * A kopeny hatasat megvalosito osztaly. A tamadasok ellen 82,3%-os vedelmet nyujt.
 *
 * @author Eros Pal
 * @since 2022-04-22
 */
public class Protection extends Effect {

    /**
     * A Protection osztaly konstruktora, 3 meretu durationnal.
     */
    public Protection() {
        duration = 3;
    }

    /**
     * A Protection osztaly konstruktora.
     * @param dur ilyen hosszan tart az effekt.
     */
    public Protection(double dur) {
        duration = dur;
    }

    /**
     * A Protection osztaly konstruktora.
     * @param citizen akire hat az effekt.
     * @param dur ilyen hosszan tart az effekt.
     */
    public Protection(Citizen citizen, double dur) {
        duration = dur;
        //citizen.addEffect(this);
    }

    /**
     * Beallitja a Duration-t.
     * @param dur hosszú ideig hat az effect.
     */
    @Override
    public void setDuration(double dur) {
        duration = dur;
    }

    /**
     * Visszaadja a Duration-t.
     */
    @Override
    public double getDuration() {
        return duration;
    }

    /**
     * A Citizen resistance tagvaltozojat 82.3-ra allitja.
     * @param affectedCitizen resistance tagvaltozojat allitja at.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
    /*    if (duration == 0){
            if(affectedCitizen.getResistance() == 82.3) {
                affectedCitizen.setResistance(0);
            }
        }else {
            affectedCitizen.setResistance(82.3);
        }*/
    }
}
