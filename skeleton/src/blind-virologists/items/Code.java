package items;


/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Code {
    /**
     * A fuggveny visszaadja a magában eltárolt ágens egy másolatát.
     */
    public Agent getAgent(){
        Vaccine v = new Vaccine();
        System.out.println("Code: Egy új ágens létrehozása, és az eltárolt ágens lemásolása.");
        System.out.println("Code: Visszaadja az új ágenst.");
        return v;
    }
    public int getNucleoCost(){
        System.out.println("Code: Visszaadja a szükséges nukleoidot az ágens elkészítéséhez.");
        return 0;
    }
    public int getAminoCost(){
        System.out.println("Code: Visszaadja a szükséges aminoacidot az ágens elkészítéséhez.");
        return 0;
    }
}
