/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.control;

import byui.cit260.byuiSeekAndFind.model.Actor;
import byui.cit260.byuiSeekAndFind.model.Game;
import byui.cit260.byuiSeekAndFind.model.Item;
import byui.cit260.byuiSeekAndFind.model.Map;
import byui.cit260.byuiSeekAndFind.model.Player;
import byuiseekandfind.ByuiSeekAndFind;

/**
 *
 * @author breen
 */
public class GameControl {

    public static Player savePlayer(String name) {

        if (name == null || name.length() < 1) {
            return null;
        }
        Player player = new Player();
        player.setName(name);
        ByuiSeekAndFind.setPlayer(player);
        return player;
    }

    public static int createNewGame(Player player) {
        if (player == null) {
            return -1;
        }

        Game game = new Game();
        game.setPlayer(player);
        ByuiSeekAndFind.setCurrentGame(game);

        Item[] items = GameControl.createItems();
        game.setItems(items);

        Map map = GameControl.createMap(5, 5, items);
        if (map == null) {
            return -1;
        }
        game.setMap(map);
        return 1;
    }
    

    public static Item[] createItems() {
        Item textbook = new Item();
        textbook.setObjectType("Textbook");
        textbook.setNumberInPossesion(0);
        textbook.setObjectsNeeded("Textbook");
        //item1 = new InventoryItem object
        //Assign values to each attribute in the InventoryItem object
        //Assign items1 to a position in the items array
        Item phone = new Item();
        phone.setObjectType("phone");
        phone.setNumberInPossesion(0);
        phone.setObjectsNeeded("phone");
        //item2 = new InventoryItem object
        //Assign values to each attribute in the InventoryItem object
        //Assign items2 to a position in the items array
        Item computer = new Item();
        phone.setObjectType("computer");
        phone.setNumberInPossesion(0);
        phone.setObjectsNeeded("computer");
        
        Item significant = new Item();
        significant.setObjectType("Significant Other");
        significant.setNumberInPossesion(0);
        significant.setObjectsNeeded("Significant Other");
        
        Item professor = new Item();
        professor.setObjectType("Professor");
        professor.setNumberInPossesion(0);
        professor.setObjectsNeeded("Professor");
        return 1;
    }

    public static Map createMap(int noOfRows, int noOfColumns, Item[] items) {
        System.out.println("createMap called");
        return new Map();

    }
    

}
