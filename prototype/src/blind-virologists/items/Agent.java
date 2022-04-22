package items;

import effects.*;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public abstract class Agent {
    Effect effect;

    public Agent(){}

    public Agent(Effect effect){
        this.effect=effect;
    }

    /**
     * A fuggveny létrehozza a megfelelő effect-et és visszaadja azt.
     */
    public abstract Effect use();

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
