package effects;

import citizens.Citizen;
import citizens.Virologist;
import items.Code;

import java.util.ArrayList;
import java.util.Random;

/**
 * A felejto virus altal kifejtett hatas, a megfertozott virologus az altala osszegyujtött genetikai kodokat elfelejti.
 *
 * @author Eros Pal
 * @since 2022-04-22
 */
public class Forget extends Effect {

    /**
     * A Forget osztaly konstruktora.
     */
    public Forget() {
        duration = 1;
    }

    /**
     * A Forget osztaly konstruktora.
     * @param id az id-ja az adott peldanynak.
     */
    public Forget(String id) {
        duration = 1;
        setId(id);
    }

    /**
     * Kitorli a virologus osszes ismert genetikai kodjat.
     * @param affectedCitizen felejti el a kodokat.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
        Random random = new Random();
        double randomNumber = random.nextDouble() * 1000;
        if (randomNumber > affectedCitizen.getResistance() * 10) {
            ((Virologist) affectedCitizen).getCodes().clear();
        }
    }
}
