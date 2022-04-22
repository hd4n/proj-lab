package effects;

import citizens.Citizen;
import map.Field;
import java.util.*;

// ki kell kommentezni, ha az osszes metodus keszen van

/**
 * A medvetancot megvalosito osztaly.
 * Ha megfertozodik vele a virologus, akkor veletlenszeruen fog mozogni.
 *
 * @author Eros Pal
 * @since 2022-04-22
 */
public class BearDance extends Effect {

    /**
     * Az osztaly konstruktora, letrehozza az adott peldanyt.
     * @param dur hosszu durationnal.
     */
    public BearDance(double dur) {
        duration = dur;
    }

    /**
     * Az osztaly konstruktora, letrehozza az adott peldanyt.
     * @param citizen aktiv effektjeihez adja hozzá.
     */
    public BearDance(Citizen citizen) {
    //    citizen.addEffect(this);
          duration = 1;
    }

    /**
     * Alkalmazza az effektet a parameteren.
     * Lekerdezi az eppen aktualis mezot, majd annak a szomszedjait. Ha a szomszéd mezokon áll virologus,
     * akkor azokat megfertozi. A szomszedos mezok kozul random kivalaszt egyet es azt allitja be celmezonek,
     * a jatekos valasztasatol fuggetlenul.
     * @param affectedCitizen Ennek a tulajdonsagait modositja.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
    /*    Random random = new Random();
        double randomNumber = random.nextDouble()*1000;
        if( randomNumber > affectedCitizen.getResistance() *10) {
            ArrayList<Field> neighborsFreeFields = new ArrayList<>();
            neighborsFreeFields = affectedCitizen.getMoves();
            Random rand = new Random();
            Field randomNeighborsField = neighborsFreeFields.get(rand.nextInt(neighborsFreeFields.size()));
            affectedCitizen.setDirection(randomNeighborsField);

            ArrayList<Field> neighboursFields = new ArrayList<>();
            neighboursFields = affectedCitizen.getNeighborsField();
            ArrayList<Citizen> neighborsCitizen = new ArrayList<>();
            for (Field neighboursField : neighboursFields) {
                if (neighboursField != null) {
                    neighborsCitizen.add(neighboursField.getCitizen());
                }
            }
            for (Citizen citizen : neighborsCitizen) {
                new BearDance(citizen);
            }
            duration++;
        }*/
    }
}
