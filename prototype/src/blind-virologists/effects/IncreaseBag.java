package effects;

import citizens.Citizen;

/**
 * A Bag osztaly hatasat reprezentalo osztaly. Ha aktiv a hatasa, akkor a jatekos tobb anyagot tud felvenni.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class IncreaseBag extends Effect {
    protected int duration = -1;

    /**
     * Az IncreaseBag osztaly konstruktora
     */
    public IncreaseBag() {
    }

    /**
     * A IncreaseBag osztaly konstruktora
     *
     * @param duration ilyen hosszan tart az effekt
     */
    public IncreaseBag(int duration) {
        this.duration = duration;
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
     * Visszaadja a duration-t
     *
     * @return az adott effekt idotartama
     */
    public int getDuration() {
        return duration;
    }

    /**
     * A maximum felveheto anyagok szamat noveli.
     *
     * @param affectedCitizen maximalis anyagmennyiseget noveli.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
        affectedCitizen.setMaxMaterial((affectedCitizen.getMaxMaterial() + 10));
    }
}
