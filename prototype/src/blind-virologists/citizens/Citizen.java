package citizens;

import effects.*;
import map.Empty;
import map.Field;
import map.Laboratory;
import map.Shelter;

import java.util.*;

/**
 * A varosban lako player altal iranyitott karakter absztarkt osztalya
 *
 * @author Barta Daniel
 * @since 2022-03-26
 */
public abstract class Citizen implements Visitor {
    protected boolean stunned = false;
    protected ArrayList<Effect> effects = new ArrayList<>();
    protected int resistance = 0;
    protected Field direction;
    protected Field currentField;
    protected boolean reflect = false;
    protected int maxMaterial = 10;

    public Citizen() {
    }

    public Citizen(Field start) {
        currentField = start;
        direction = currentField;
    }

    /**
     * Kivalasztott mezore lep
     */
    public void move() {
        currentField.setCitizen(null);
        currentField = direction;
        currentField.setCitizen(this);
    }

    /**
     * Torli az osszes hatast, torli a lejart effecteket, majd beallitja az uj ertekeket
     */
    public void nextRound() {
        stunned = false;
        resistance = 0;
        direction = currentField;
        maxMaterial = 10;

        ArrayList<Effect> torolni = new ArrayList<>();
        for (Effect item : effects) {
            boolean letlet = item.update();
            if (letlet) {
                torolni.add(item);
            } else {
                item.applyEffect(this);
            }
        }
        for (Effect item : torolni) {
            effects.remove(item);
        }
    }

    /**
     * A fuggveny a szabad szomszedos mezoket adja vissza, ahova lephet az adott Citizen. (nem all rajta senki)
     *
     * @return Field listat ad vissza
     */
    public List<Field> getMoves() {
        ArrayList<Field> neighbors = currentField.getNeighbors();
        ArrayList<Field> toReturn = new ArrayList<>();
        for (Field field : neighbors) {
            if (field.getCitizen() == null) {
                toReturn.add(field);
            }
        }
        return toReturn;
    }

    /**
     * @param effect kenni kivant effekt
     * @return sikeres volt e a kenes, false ha visszakeni
     */
    public boolean addEffect(Effect effect) {
        int szam = new Random().nextInt(100);   //random szam az immunitas veletlenszerusegehez
        if (reflect) {
            return false;
        }
        if (this.resistance <= szam) {
            effects.add(effect);
        }
        return true;
    }

    public void interact() {
        currentField.accept(this);
    }

    public void setCurrentField(Field field) {
        currentField = field;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public Field getDirection() {
        return direction;
    }

    public void setDirection(Field direction) {
        this.direction = direction;
    }

    public boolean isReflect() {
        return reflect;
    }

    public void setReflect(boolean reflect) {
        this.reflect = reflect;
    }

    public int getMaxMaterial() {
        return maxMaterial;
    }

    public void setMaxMaterial(int maxMaterial) {
        this.maxMaterial = maxMaterial;
    }
}
