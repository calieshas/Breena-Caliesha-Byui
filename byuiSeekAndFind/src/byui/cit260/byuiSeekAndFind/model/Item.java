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
    
    private String itemType; 
    private double numberInPossesion;
    private String itemNeeded;

    public Item() {
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getNumberInPossesion() {
        return numberInPossesion;
    }

    public void setNumberInPossesion(double numberInPossesion) {
        this.numberInPossesion = numberInPossesion;
    }

    public String getItemNeeded() {
        return itemNeeded;
    }

    public void setItemNeeded(String itemNeeded) {
        this.itemNeeded = itemNeeded;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + java.util.Objects.hashCode(this.itemType);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.numberInPossesion) ^ (Double.doubleToLongBits(this.numberInPossesion) >>> 32));
        hash = 29 * hash + java.util.Objects.hashCode(this.itemNeeded);
        return hash;
    }

    @Override
    public String toString() {
        return "Item{" + "itemType=" + itemType + ", numberInPossesion=" + numberInPossesion + ", itemNeeded=" + itemNeeded + '}';
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
        if (!java.util.Objects.equals(this.itemType, other.itemType)) {
            return false;
        }
        if (!java.util.Objects.equals(this.itemNeeded, other.itemNeeded)) {
            return false;
        }
        return true;
    }
    
    
    
}
