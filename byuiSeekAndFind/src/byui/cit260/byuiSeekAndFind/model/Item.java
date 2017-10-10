/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author calie
 */
public class Item implements Serializable {
    
    private String objectType; 
    private double numberInPossesion;
    private String objectsNeeded;
    private Game game;
    private ArrayList<ItemScene> itemScenes = new ArrayList<ItemScene>();

    public Item() {
    }

    public ArrayList<ItemScene> getItemScenes() {
        return itemScenes;
    }

    public void setItemScenes(ArrayList<ItemScene> itemScenes) {
        this.itemScenes = itemScenes;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public double getNumberInPossesion() {
        return numberInPossesion;
    }

    public void setNumberInPossesion(double numberInPossesion) {
        this.numberInPossesion = numberInPossesion;
    }

    public String getObjectsNeeded() {
        return objectsNeeded;
    }

    public void setObjectsNeeded(String objectsNeeded) {
        this.objectsNeeded = objectsNeeded;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + java.util.Objects.hashCode(this.objectType);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.numberInPossesion) ^ (Double.doubleToLongBits(this.numberInPossesion) >>> 32));
        hash = 29 * hash + java.util.Objects.hashCode(this.objectsNeeded);
        return hash;
    }

    @Override
    public String toString() {
        return "Objects{" + "objectType=" + objectType + ", numberInPossesion=" + numberInPossesion + ", objectsNeeded=" + objectsNeeded + '}';
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (Double.doubleToLongBits(this.numberInPossesion) != Double.doubleToLongBits(other.numberInPossesion)) {
            return false;
        }
        if (!java.util.Objects.equals(this.objectType, other.objectType)) {
            return false;
        }
        if (!java.util.Objects.equals(this.objectsNeeded, other.objectsNeeded)) {
            return false;
        }
        return true;
    }
    
    
    
}
