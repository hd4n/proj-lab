package items;


/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Code {
    /**
     * A fuggveny visszaadja a magaban eltarolt agens egy masolatát.
     */
    public Agent getAgent() {
        Vaccine v = new Vaccine();
        System.out.println("Code: Egy uj agens letrehozasa, es az eltarolt agens lemasolasa.");
        System.out.println("Code: Visszaadja az uj agenst.");
        return v;
    }

    public int getNucleoCost() {
        System.out.println("Code: Visszaadja a szukseges nukleoidot az agens elkeszitesehez.");
        return 0;
    }

    public int getAminoCost() {
        System.out.println("Code: Visszaadja a szukséges aminoacidot az agens elkeszitesehez.");
        return 0;
    }
}
