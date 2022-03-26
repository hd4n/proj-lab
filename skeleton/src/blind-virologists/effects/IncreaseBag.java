package effects;

import citizens.Citizen;

/**
 * A Bag osztaly hatasat reprezentalo osztaly. Ha aktiv a hatasa, akkor a jatekos tobb anyagot tud felvenni.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class IncreaseBag extends Effect{

    /**
     * Az IncreaseBag osztaly konstruktora
     */
    public IncreaseBag(){
        System.out.println("IncreaseBag: letrehoz egy IncreaseBag effektet");
    }

    /**
     * A IncreaseBag osztaly konstruktora
     * @param duration ilyen hosszan tart az effekt
     */
    public IncreaseBag(int duration){
        //Duration = duration;
        System.out.println("IncreaseBag: letrehoz egy IncreaseBag effektet es beallitja az idejet");
    }

    /**
     * A maximum felveheto anyagok szamat noveli.
     * @param affectedCitizen maximalis anyagmennyiseget noveli.
     */
    public void ApplyEffect(Citizen affectedCitizen){
        System.out.println("IncreaseBag: noveli a maximalisan felveheto anyagmennyiseget");
        //affectedCitizen.SetMaxItem(20);
    }
}
