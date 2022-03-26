package effects;

import citizens.Citizen;

/**
 * A felejto virus altal kifejtett hatas, a megfertozott virologus az altala osszegyujtött genetikai kodokat elfelejti.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class Forget extends Effect{

    /**
     * A Forget osztaly konstruktora
     */
    public Forget(){
        System.out.println("Forget: letrehoz egy Forget effektet");
    }

    /**
     * Kitorli a virologus osszes ismert genetikai kodjat.
     * @param affectedCitizen felejti el a kodokat.
     */
    public void ApplyEffect(Citizen affectedCitizen){
        System.out.println("Forget: kitorli az ismert genetikai kodokat");

        //Ide jon a torles csak meg nincsen kesz
    }
}
