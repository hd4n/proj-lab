package items;

import effects.*;

/**
 * Az agenseket megvalosito osztaly.
 *
 * @author Kovacs Aron
 * @since 2022-04-22
 */
public abstract class Agent {
    Effect effect;

    /**
     * Az agent parameter nelkuli konstruktora
     */
    public Agent() {
    }

    /**
     * Az agent parameteres konstruktora
     *
     * @param effect az agens altal megvalositott effekt
     */
    public Agent(Effect effect) {
        this.effect = effect;
    }

    /**
     * Absztrakt fuggveny, letrehozza a megfelelo effect-et es visszaadja azt.
     */
    public abstract Effect use();

    /**
     * Visszaadja az agens altal megvalositott effektet
     */
    public Effect getEffect() {
        return effect;
    }

    /**
     * Beallitja az agens altal megvalositando effektet
     *
     * @param effect az agens altal megvalositando effektet
     */
    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    /**
     * Kiirja a tesztesetekhez szukseges informaciokat az adott objektumrol
     */
    public String toString(){

    }
}
