package effects;

import citizens.Citizen;

/**
 * A kopeny hatasat megvalosito osztaly. A tamadasok ellen 82,3%-os vedelmet nyujt.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class Protection extends Effect{

    /**
     * A Protection osztaly konstruktora
     */
    public Protection(){
        System.out.println("Protection: letrehoz egy Protection effektet");
    }

    /**
     * A Protection osztaly konstruktora
     * @param duration ilyen hosszan tart az effekt
     */
    public Protection(int duration){
        System.out.println("Protection: letrehoz egy Protection effektet es beallitja az idejet");
    }

    /**
     * A Citizen resistance tagvaltozojat 82.3-ra allitja.
     * @param affectedCitizen resistance tagvaltozojat allitja at.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen){
        System.out.println("Protection: atallitja a resistance tagvaltozot 82.3-ra");
    }
}
