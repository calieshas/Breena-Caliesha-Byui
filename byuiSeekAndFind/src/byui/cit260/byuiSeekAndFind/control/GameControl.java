/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.control;

import byui.cit260.byuiSeekAndFind.model.Game;
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
    public static int createNewGame(Player player) {
          if(player == null){
             return -1;
          }
          
          
    public static game() {
          game.setPlayer(player);
          ByuiSeekAndFind.setCurrentGame(game); 
//        Save a reference to the Player object in the game
//        Save a reference to the game in the main class

    }
    public static actors() {
        game.setActors(actors);
        player = actor;
    }
//        actors = createActors()
//        Save the list of actors in the Game object
//        Assign an actor to the player

    
    public static InventoryItem[] createItems(); {
          System.out.println("createItems called");
    }
//        items = createItems()
//        Save the list of items in the game

    public static Map createMap(int noOfRows, int noOfColumns)
            if(map == null) {
                return -1;
//        map = createMap(noOfRows, noOfColumns)
//        IF map == null THEN
//         RETURN -1
//        ENDIF
            } 
    
    game = map {
        return 1
    }
}
//        Assign the map to the game
//        RETURN 1 // indicates success 
    }
}
