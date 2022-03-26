package items;
import effects.*;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public abstract class Equipment {
    /**
     * A fuggveny létrehozza a megfelelő effect-et és visszaadja azt.
     */
    public abstract Effect use();
}
