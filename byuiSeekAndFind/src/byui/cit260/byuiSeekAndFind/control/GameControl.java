/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.control;

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
        if(map == null) {
            return -1;
        }
        game.setMap(map);
        return 1;
    }

    public static Item[] createItems()    {
        System.out.println("createItems called");
        return new Item[1];
    }

    public static Map createMap(int noOfRows, int noOfColumns, Item[] items) {
            System.out.println("createMap called");
            return new Map();

}


}
