/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.control;

import byui.cit260.byuiSeekAndFind.model.Player;
import byuiseekandfind.ByuiSeekAndFind;


/**
 *
 * @author breen
 */
public class GameControl {
    public static Player savePlayer(String name) {

        if(name == null || name.length() < 1) {
            return null;
        }
        Player player = new Player();
        player.setName(name);
        ByuiSeekAndFind.setPlayer(player);
        return player;
    }
    public static void createNewGame(Player player) {
        System.out.println("create new game was called");
    }
}
