package effects;

import citizens.Citizen;
import citizens.Virologist;
import items.Gloves;

/**
 * A taszito effektet valositja meg. Ez a hatas a kesztyu kovetkezteben lephet ervenybe.
 * A virologusra felkent agenst forditja vissza.
 *
 * @author Kovacs Aron
 * @since 2022-04-23
 */
public class Reflect extends Effect {
    protected Gloves parent;


    /**
     * A Reflect osztaly konstruktora
     *
     * @param duration ilyen hosszan tart az effekt
     * @param parent   a kesztyu akitol szarmazik az effekt
     */
    public Reflect(int duration, Gloves parent) {
        this.duration = duration;
        this.parent = parent;
    }

    /**
     * A Reflect osztaly konstruktora
     *
     * @param duration ilyen hosszan tart az effekt
     * @param parent   a kesztyu akitol szarmazik az effekt
     * @param ID aznosito
     */
    public Reflect(int duration, Gloves parent, String ID) {
        this.duration = duration;
        this.parent = parent;
        this.ID = ID;
    }

    /**
     * A Reflect osztaly konstruktora
     * @param ID aznosito
     */
    public Reflect (String ID){
        this.ID = ID;
    }

    /**
     * Visszaadja a kesztyut amibol szarmazik
     *
     * @return a kesztyu
     */
    public Gloves getParent() {
        return parent;
    }

    /**
     * Ennek hatasara a virologusra egy olyan effect kerul aminek hatasara visszaforditja a ra kent agenseket.
     *
     * @param affectedCitizen kerul a hatas ala.
     */
    @Override
    public void applyEffect(Citizen affectedCitizen) {
        affectedCitizen.addEffect(this);
        if (affectedCitizen.getReflectCount() >= 3) {
            ((Virologist)affectedCitizen).removeEquipment(this.getParent());
            affectedCitizen.setReflectCount(0);
        }
    }

    /**
     * A fuggveny segitsegevel tortenik az objektum azonositasa a tesztesetekhez
     *
     * @return out az objektum azonositoja
     */
    @Override
    public String toString() {
        String out = super.toString();
        out +="\n\tpa_";
        if(parent == null){
            out+="null";
        }else{
            out+=parent.getID();
        }
        return out;
    }
}
