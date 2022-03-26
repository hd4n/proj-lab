package effects;

import citizens.Citizen;
import map.Empty;
import map.Field;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Eros Pal
 * @since 2022-03-26
 */
public class Dance extends Effect{

    /**
     * A Dance osztaly konstruktora
     */
    public Dance(){
        System.out.println("Dance: letrehoz egy Dance effektet");
    }

    /**
     * Megvaltoztatja a jatekos altal korabban beallitott lepest egy veletlenszeru szomszedos mezore.
     * @param affectedCitizen lepeset allitja at.
     */
    public void ApplyEffect(Citizen affectedCitizen){
        System.out.println("Dance: aktualis myField player attributum torlese");
        //affectedCitizen.myField.SetPlayer(null);
        System.out.println("Dance: myField beallitasa az uj random szomszedos mezore");
        //affectedCitizen.myField.GetNeighbours()
        //Field[] neigbours = new Field();

        //Ide valami ramdomizacio kell
        //affectedCitizen.myField.SetPlayer();
    }
}
