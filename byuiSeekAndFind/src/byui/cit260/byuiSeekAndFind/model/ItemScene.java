/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author breen
 */
public class ItemScene implements Serializable{
    
    private String foundItem;
    private Question question;
    private Item item;

    public ItemScene() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
    

    public String getFoundItem() {
        return foundItem;
    }

    public void setFoundItem(String foundItem) {
        this.foundItem = foundItem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.foundItem);
        return hash;
    }

    @Override
    public String toString() {
        return "ItemScene{" + "foundItem=" + foundItem + '}';
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
        final ItemScene other = (ItemScene) obj;
        if (!Objects.equals(this.foundItem, other.foundItem)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
