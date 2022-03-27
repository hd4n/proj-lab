package map;

import citizens.Visitor;
import items.Code;

/**
 * A laboratory mezot megvalosito osztaly.
 *
 * @author Kovacs Aron
 * @since 2022-03-26
 */
public class Laboratory extends Field {

    private Code code;

    /**
     * Az laboratory mezot letrehozo konstruktor
     *
     * @param code a laboratoryban levo kodot adja meg
     */
    public Laboratory(Code code) {
        this.code = code;
    }

    /**
     * Az laboratory mezot letrehozo parameter nelkuli konstruktor
     */
    public Laboratory() {
        this.code = null;
    }

    /**
     * Az laboratory mezo gettere
     *
     * @return code visszaadja a mezon levo kodot
     */
    public Code getCode() {
        System.out.println("Laboratory mezo: getter fuggvenye meghivodott");
        return code;
    }

    /**
     * Az laboratory mezo settere
     *
     * @param code a laboratoryn levo kodot allitja be
     */
    public void setCode(Code code) {
        System.out.println("Laboratory mezo: setter fuggvenye meghivodott");
        this.code = code;
    }

    /**
     * Az laboratory mezon levo kodot adja vissza a
     */
    public Code readCode() {
        System.out.println("Laboratory: kod leolvasasa");
        return getCode();
    }

    /**
     * Az laboratory mezore lepo visitor fogadasat vegzo fuggveny
     *
     * @param v a mezore lepo visitor
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
