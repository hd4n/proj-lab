package effects;

import citizens.Citizen;
import map.Field;

import java.util.ArrayList;
import java.util.Random;

/**
 * A benito effektet valositja meg. Ha ervenyben van, akkor az ido lejartaig a jatekos nem tud mozogni.
 *
 * @author Eros Pal
 * @since 2022-04-22
 */
public class Stun extends Effect {

    /**
     * A Stun osztaly konstruktora, 3 meretu durationnal.
     */
    public Stun() {
        duration = 3;
    }

    /**
     * A Stun osztaly konstruktora.
     * @param dur ilyen hosszan tart az effekt.
     */
    public Stun(int dur) {
        duration = dur;
    }

    /**
     * A Stun osztaly konstruktora.
     * @param citizen akire hat az effekt.
     * @param dur ilyen hosszan tart az effekt.
     */
    public Stun(Citizen citizen, int dur) {
        duration = dur;
        citizen.setStunned(true);
        citizen.addEffect(this);
    }

    /**
     * Lekerdezi az aktualis mezot, majd beallitja celmezonek.
     * @param affectedCitizen ennek allitja at a celmezojet az aktualis mezore.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
        Random random = new Random();
        double randomNumber = random.nextDouble()*1000;
        if( randomNumber > affectedCitizen.getResistance() *10) {
            affectedCitizen.setDirection(affectedCitizen.getCurrentField());
            if (duration == 0) {
                affectedCitizen.setStunned(false);
            } else {
                affectedCitizen.setStunned(true);
            }
        }
    }
}
