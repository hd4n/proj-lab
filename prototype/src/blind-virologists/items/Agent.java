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
    private String ID;

    /**
     * Az agent parameter nelkuli konstruktora
     */
    public Agent() {
        this.effect = null;
        this.ID = null;
    }

    /**
     * Az agent ID parameteres konstruktora
     *
     * @param ID az agens azonositoja
     */
    public Agent(String ID) {
        this.effect = null;
        this.ID = ID;
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
     * Az agent parameteres konstruktora
     *
     * @param effect az agens altal megvalositott effekt
     * @param ID az agens azonositoja
     */
    public Agent(Effect effect, String ID) {
        this.effect = effect;
        this.ID = ID;
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
    /*
    public String toString(){

    }
    */
}
