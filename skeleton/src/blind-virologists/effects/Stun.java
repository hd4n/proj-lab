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
     * @param time ennyi ideig ervenyes a hatasa
     */
    public Stun(int time){
        //Duration = time;
        System.out.println("Stun: letrehoz egy Stun effektet es beallitja az idejet");
    }

    /**
     * Az adott Citizen stunned parameteret igazra allitja.
     * @param affectedCitizen stunned parameteret alitja at.
     */
    public void ApplyEffect(Citizen affectedCitizen){
        System.out.println("Stun: igazra allitja a stunned parametert");
        //affectedCitizen.SetStun(true);
    }
}
