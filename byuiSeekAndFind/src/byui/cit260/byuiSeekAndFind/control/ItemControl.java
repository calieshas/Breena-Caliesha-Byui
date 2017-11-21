/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.control;

import byui.cit260.byuiSeekAndFind.model.ItemType;

/**
 *
 * @author breen
 */
public class ItemControl {
    int SumListOfItems() {
       ItemType[] items = ItemType.values();
       int sum = 0;
        for (ItemType item : items) {
            sum ++;
    }
        return sum;
    }

}
