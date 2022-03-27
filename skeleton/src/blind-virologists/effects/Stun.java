package effects;

import citizens.Citizen;

/**
 * A benito effektet valositja meg. Ha ervenyben van, akkor az ido lejartaig a jatekos nem tud mozogni.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class Stun extends Effect {

    /**
     * A Stun osztaly konstruktora
     */
    public Stun() {
        System.out.println("Stun: letrejon egy Stun effekt");
        //Duration = 10;
    }

    /**
     * A Stun osztaly konstruktora
     *
     * @param duration ilyen hosszan tart az effekt
     */
    public Stun(int duration) {
        System.out.println("Stun: letrejon egy Stun effekt es beallitja az idejet");
        //Duration = duration;
    }

    /**
     * Beallitja a Duration-t
     *
     * @param duration hosszú ideig hat az effect
     */
    public void setDuration(int duration) {
        //Duration = duration;
        System.out.println("Stun: beallitja a Durationt");
    }

    /**
     * Visszaadja a Duration-t
     */
    public void getDuration() {
        //Duration = duration;
        System.out.println("Stun: visszaadja a Durationt");
    }

    /**
     * Az adott Citizen stunned parameteret igazra allitja.
     *
     * @param affectedCitizen stunned parameteret alitja at.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
        System.out.println("Stun: igazra allitja a stunned parametert");
    }
}
