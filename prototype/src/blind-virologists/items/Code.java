package items;


/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Code {
    protected Agent agent;
    protected int nucleoCost;
    protected int aminoCost;


    /**
     * Konstruktor. A fuggveny letrehoz egy kodot, a parameterek szerint.
     *
     * @param agent      a kodban tarolt agens
     * @param nucleoCost a kod nukleotid ara
     * @param aminoCost  a kod aminosav ara
     */
    public Code(Agent agent, int nucleoCost, int aminoCost) { //new code(new agent(mew effect))
        this.agent = agent;
        this.nucleoCost = nucleoCost;
        this.aminoCost = aminoCost;
    }

    /**
     * Konstruktor. A fuggveny letrehoz egy kodot, a parameterek nelkul a tesztesetekhez.
     */
    public Code(){
        this.agent = null;
        this.nucleoCost = 0;
        this.aminoCost = 0;
    }

    /**
     * Getter. A fuggveny visszaadja a magaban eltarolt agens egy masolatát.
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * Getter. A fuggveny visszaadja a magaban eltarolt agens nukleotid arat.
     */
    public int getNucleoCost() {
        return nucleoCost;
    }

    /**
     * Getter. A fuggveny visszaadja a magaban eltarolt agens aminosav arat.
     */
    public int getAminoCost() {
        return aminoCost;
    }

    /**
     * Kiirja a tesztesetekhez szukseges informaciokat az adott objektumrol
     */
    /*
    public String toString(){
        //return
    }
    */

}
