//hd

package map;

import citizens.Visitor;

/**
 * A visitor patternhez tartozo interface
 */
public interface Visitable {
    /**
     * Elfogadja a parameterkent kapott Visitort
     * @param v az elfogadando Visitor
     */
    public void accept(Visitor v);
}
