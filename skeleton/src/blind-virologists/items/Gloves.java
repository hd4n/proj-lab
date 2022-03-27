package items;

import effects.*;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Gloves extends Equipment {
    /**
     * A fuggveny létrehoz egy Reflect effect-et és visszaadja azt.
     */
    public Effect use() {
        System.out.println("Gloves: Letrehoz egy reflect effectet.");
        Reflect eReflect = new Reflect();
        System.out.println("Gloves: Visszaadja az elobb letrehozott reflect effect-et.");
        return eReflect;
    }
}
