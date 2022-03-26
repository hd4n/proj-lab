package items;

import java.util.Scanner;

/**
 * A nukleotid anyagot megvalosito osztaly.
 *
 * @author Kovacs Aron
 * @since 2022-03-26
 */
public class Nucleotide extends Material {

    /**
     * Megnezi, hogy van-e elegendo anyag valamilyen agens elkeszitesehez
     */
    @Override
    public void prepareForCraft() {
        System.out.println("Nucleotide: prepareForCraft függvenye meghivodott");
        System.out.println("Nucleotide: Van eleg nukleotid a virologusnal? (igen/nem)");
        Scanner sc = new Scanner(System.in);
        String res = sc.next();
        if (res.equalsIgnoreCase("igen")) {
            System.out.println("Nucleotide: nukleotid eltavolitva");
        } else {
            System.out.println("Nucleotide: nincs eleg nukleotid a virologusnal, nem tud craftolni");
        }
    }
}
