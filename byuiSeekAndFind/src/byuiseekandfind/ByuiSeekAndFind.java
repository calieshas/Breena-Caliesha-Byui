/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byuiseekandfind;

import byui.cit260.byuiSeekAndFind.model.Player;

/**
 *
 * @author breen
 */
public class ByuiSeekAndFind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Fred Flints");
        playerOne.setBestTime(7.00);
        
        System.out.println(playerOne.toString());
        
    }
    
}
