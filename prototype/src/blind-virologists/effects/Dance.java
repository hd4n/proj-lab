package effects;

import citizens.Citizen;

import java.util.Random;

// ki kell kommentezni, ha az osszes metodus keszen van

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Eros Pal
 * @since 2022-04-22
 */
public class Dance extends Effect {

    /**
     * Az osztaly konstruktora, letrehozza az adott peldanyt 3 meretu durationnal.
     */
    public Dance() {
        duration = 3;
    }

    /**
     * Az osztaly konstruktora, letrehozza az adott peldanyt a parameter meretu durationnal.
     * @param dur ilyen hosszan tart az effekt.
     */
    public Dance(double dur) {
        duration = dur;
    }

    /**
     * A Dance osztaly konstruktora.
     * @param citizen akire hat az effekt.
     * @param dur ilyen hosszan tart az effekt.
     */
    public Dance(Citizen citizen, double dur) {
        duration = dur;
    //    citizen.addEffect(this);
    }

    /**
     * Beallitja a Duration-t.
     * @param dur hosszú ideig hat az effect.
     */
    @Override
    public void setDuration(double dur) {
        duration = dur;
    }

    /**
     * Visszaadja a Duration-t.
     */
    @Override
    public double getDuration() {
        return duration;
    }

    /**
     * Megvaltoztatja a jatekos altal korabban beallitott lepest egy veletlenszeru szomszedos mezore.
     * @param affectedCitizen lepeset allitja at.
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
        }*/
    }
}
