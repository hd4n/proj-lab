package items;
import effects.*;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Vaccine extends Agent{
    /**
     * A fuggveny létrehozza egy immunity effect-et és visszaadja azt.
     */
    public Effect use(){
        System.out.println("Vaccine: Létrehoz egy immunitás effectet.");
        Immunity eImmunity = new Immunity();
        System.out.println("Vaccine: Visszaadja ezt az effectet.");
        return eImmunity;
    }
}
