package items;

import citizens.Virologist;

import java.util.Scanner;

/**
 * Az aminosav anyagot megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-04-22
 */
public class Aminoacid extends Material {

    /**
     * Megnezi, hogy van-e elegendo anyag valamilyen agens elkeszitesehez
     */
    @Override
    public void prepareForCraft(Virologist v) {
        int needed = v.getNeededAmino();
        while(needed > 0){
            v.setNeededAmino(needed-1);
            needed--;
        }

    }
}
