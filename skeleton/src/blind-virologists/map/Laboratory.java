package map;

import citizens.Visitor;
import items.Code;

/**
 * A laboratory mezőt megvalositó osztály.
 *
 * @author Kovacs Aron
 * @since 2022-03-26
 */
public class Laboratory extends Field {

    private Code code;

    /**
     * Az laboratory mezőt létrehozó konstruktor
     *@param code a laboratoryban lévő kódot adja meg
     */
    public Laboratory(Code code) {
        this.code = code;
    }

    /**
     * Az laboratory mezőt létrehozó paraméter nélküli konstruktor
     */
    public Laboratory() {
        this.code = null;
    }

    /**
     * Az laboratory mező gettere
     * @return code visszaadja a mezőn lévő kódot
     */
    public Code getCode() {
        System.out.println("Laboratory mező: getter függvénye meghívódott");
        return code;
    }

    /**
     * Az laboratory mező settere
     * @param code a laboratoryn lévő kódot állítja be
     */
    public void setCode(Code code) {
        System.out.println("Laboratory mező: setter függvénye meghívódott");
        this.code = code;
    }

    /**
     * Az laboratory mezőn lévő kódot adja vissza a
     */
    public Code readCode() {
        System.out.println("Laboratory: kód leolvasása");
        return getCode();
    }

    /**
     * Az laboratory mezőre lépő visitor fogadását végző függvény
     * @param v a mezőre lépő visitor
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
