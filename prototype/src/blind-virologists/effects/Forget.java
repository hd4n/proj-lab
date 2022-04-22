package effects;

import citizens.Citizen;
import items.Code;

import java.util.ArrayList;
import java.util.Random;

// ki kell kommentezni, ha az osszes metodus keszen van

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
    duration = 3;
    }

    /**
     * A Forget osztaly konstruktora.
     * @param citizen ra lesz hatassal az effect.
     */
    public Forget(Citizen citizen) {
    //    citizen.addEffect(this);
        duration = 1;
    }

    /**
     * Kitorli a virologus osszes ismert genetikai kodjat.
     * @param affectedCitizen felejti el a kodokat.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
    /*    Random random = new Random();
        double randomNumber = random.nextDouble()*1000;
        if( randomNumber > affectedCitizen.getResistance() *10) {
            affectedCitizen.getCodes().remove();
        }*/
    }
}
