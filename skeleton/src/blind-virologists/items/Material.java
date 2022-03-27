package items;

/**
 * Az anyagokat megvalosito osztaly.
 *
 * @author Kovacs Aron
 * @since 2022-03-26
 */
public abstract class Material {

    /**
     * Megnezi, hogy van-e elegendo anyag valamilyen agens elkeszitesehez,
     * a leszarmazottakban levo fuggvenyek felulirjak
     */
    public abstract void prepareForCraft();
}
