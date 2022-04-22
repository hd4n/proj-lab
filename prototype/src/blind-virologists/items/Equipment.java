package items;

import citizens.Citizen;
import effects.*;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-04-22
 */
public abstract class Equipment {
    /**
     * A fuggveny létrehozza a megfelelő effect-et és visszaadja azt.
     */
    protected Effect e;
    public abstract Effect use(Citizen target);
}
