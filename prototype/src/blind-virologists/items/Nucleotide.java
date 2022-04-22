package items;

import citizens.Citizen;
import citizens.Virologist;

import java.util.Scanner;

/**
 * A nukleotid anyagot megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-04-22
 */
public class Nucleotide extends Material {

    /**
     * Megnezi, hogy van-e elegendo anyag valamilyen agens elkeszitesehez
     */
    @Override
    public void prepareForCraft(Virologist v) {
        int needed = v.getNeededNucleo();
        while(needed > 0){
            v.setNeededNucleo(needed-1);
            needed--;
        }
    }
}
