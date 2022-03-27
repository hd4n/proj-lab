package items;

import java.util.Scanner;

/**
 * Az aminosav anyagot megvalosito osztaly.
 *
 * @author Kovacs Aron
 * @since 2022-03-26
 */
public class Aminoacid extends Material {

    /**
     * Megnezi, hogy van-e elegendo anyag valamilyen agens elkeszitesehez
     */
    @Override
    public void prepareForCraft() {
        System.out.println("Aminoacid: prepareForCraft függvénye meghívódott");
        System.out.println("Aminoacid: Van eleg aminosav a virologusnal? (igen/nem)");
        Scanner sc = new Scanner(System.in);
        String res = sc.next();
        if (res.equalsIgnoreCase("igen")) {
            System.out.println("Aminoacid: aminosav eltavolitva");
        } else {
            System.out.println("Aminoacid: nincs eleg aminosav a virologusnal, nem tud craftolni");
        }

    }
}
