package effects;

import citizens.Citizen;
import items.Gloves;

/**
 * A taszito effektet valositja meg. Ez a hatas a kesztyu kovetkezteben lephet ervenybe.
 * A virologusra felkent agenst forditja vissza.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class Reflect extends Effect {
    protected int duration;
    protected Gloves parent;


    /**
     * A Reflect osztaly konstruktora
     *
     * @param duration ilyen hosszan tart az effekt
     * @param parent   a kesztyu akitol szarmazik az effekt
     */
    public Reflect(int duration, Gloves parent) {
        this.duration = duration;
        this.parent = parent;
    }

    /**
     * Beallitja a Duration-t
     *
     * @param duration hosszú ideig hat az effect
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Visszaadja a Duration-t
     *
     * @return az ido amig kifejti hatasat
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Visszaadja a kesztyut amibol szarmazik
     *
     * @return a kesztyu
     */
    public Gloves getParent() {
        return parent;
    }

    /**
     * Ennek hatasara a virologusra egy olyan effect kerul aminek hatasara visszaforditja a ra kent agenseket.
     *
     * @param affectedCitizen kerul a hatas ala.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
        affectedCitizen.addEffect(this);
        if (affectedCitizen.getReflectCount() >= 3) {
            affectedCitizen.removeEquipment(this.getParent());
        }
    }
}
