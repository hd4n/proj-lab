package items;
import effects.*;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Bag extends Equipment{
    /**
     * A fuggveny létrehoz egy IncreaseBag effect-et és visszaadja azt.
     */
    public Effect use(){
        System.out.println("Bag: Létrehoz egy increasebag effect-et.");
        IncreaseBag eIncreaseBag = new IncreaseBag();
        System.out.println("Bag: Visszaadja az elöbb létrehozott increasebag effect-et.");
        return eIncreaseBag;
    }
}
