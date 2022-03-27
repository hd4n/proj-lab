package items;
import effects.*;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Cape extends Equipment{
    /**
     * A fuggveny létrehoz egy Protection effect-et és visszaadja azt.
     */
    public Effect use(){
        System.out.println("Cape: Létrehoz egy protection effect-et.");
        Protection eProtection = new Protection();
        System.out.println("Cape: Visszaadja az elöbb létrehozott protection effect-et.");
        return eProtection;
    }
}
