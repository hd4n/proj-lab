package items;
import effects.*;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Virus extends Agent{
    /**
     * A fuggveny létrehozza a megfelelő effect-et és visszaadja azt.
     */
    public Effect use(){
        System.out.printf("Virus: Létrehoz egy forget effect-et.");
        Forget eForget = new Forget();
        System.out.printf("Virus: Visszaadja ezt az effect-et.");
        return eForget;

    }
}
