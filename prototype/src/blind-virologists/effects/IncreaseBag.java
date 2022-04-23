package effects;

import citizens.Citizen;

/**
 * A Bag osztaly hatasat reprezentalo osztaly. Ha aktiv a hatasa, akkor a jatekos tobb anyagot tud felvenni.
 *
 * @author Kovacs Aron
 * @since 2022-04-23
 */
public class IncreaseBag extends Effect {
    protected int duration = -1;

    /**
     * Az IncreaseBag osztaly konstruktora
     */
    public IncreaseBag() {
    }

    /**
     * Az IncreaseBag osztaly konstruktora
     */
    public IncreaseBag(String ID) {
        this.duration = 0;
        this.ID = ID;
    }

    /**
     * A IncreaseBag osztaly konstruktora
     *
     * @param duration ilyen hosszan tart az effekt
     * @param ID       azonosito
     */
    public IncreaseBag(int duration, String ID) {
        this.duration = duration;
        this.ID = ID;
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
     * A maximum felveheto anyagok szamat noveli.
     *
     * @param affectedCitizen maximalis anyagmennyiseget noveli.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
        affectedCitizen.setMaxMaterial(affectedCitizen.getMaxMaterial() + 10);
    }

    /**
     * A fuggveny segitsegevel tortenik az objektum azonositasa a tesztesetekhez
     *
     * @return out az objektum azonositoja
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
