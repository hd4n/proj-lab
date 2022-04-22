package map;

import citizens.Visitor;
import items.Code;

/**
 * A laboratory mezot megvalosito osztaly.
 *
 * @author Kovacs Aron, Hajos Daniel
 * @since 2022-04-21
 */
public class Laboratory extends Field {

    protected Code code;

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
     * Az laboratory mezo settere
     *
     * @param code a laboratoryn levo kodot allitja be
     */
    public void setCode(Code code) {
        this.code = code;
    }

    /**
     * Az laboratory mezon levo kodot adja vissza a
     */
    public Code readCode() {
        return code;
    }

    /**
     * A mezovel interakcioba lepo visitor fogadasat vegzo fuggveny
     *
     * @param v az interakciot vegzo visitor
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
