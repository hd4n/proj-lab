package effects;

import citizens.Citizen;

/**
 * A benito effektet valositja meg. Ha ervenyben van, akkor az ido lejartaig a jatekos nem tud mozogni.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class Stun extends Effect{

    /**
     * A Stun osztaly konstruktora
     */
    public Stun(){
        System.out.println("Stun: letrehoz egy Stun effektet");
    }

    /**
     * A Stun osztaly konstruktora
     * @param duration ilyen hosszan tart az effekt
     */
    public Stun(int duration){
        System.out.println("Stun: letrehoz egy Stun effektet es beallitja az idejet");
    }

    /**
     * Az adott Citizen stunned parameteret igazra allitja.
     * @param affectedCitizen stunned parameteret alitja at.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen){
        System.out.println("Stun: igazra allitja a stunned parametert");
    }
}
