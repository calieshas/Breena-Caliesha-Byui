/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byuiseekandfind;

import byui.cit260.byuiSeekAndFind.model.Game;
import byui.cit260.byuiSeekAndFind.model.Player;
import byui.cit260.byuiSeekAndFind.view.StartProgramView;

/**
 *
 * @author breen
 */
public class ByuiSeekAndFind {

    /**
     * @param args the command line arguments
     */
    private static Game currentGame = null;
    private static Player player = null;
    
    public static void main(String[] args) {
        try{
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
        } catch (Throwable t){
            System.out.println("Start program failed");
            t.printStackTrace();
            return;
            }
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        ByuiSeekAndFind.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        ByuiSeekAndFind.player = player;
    }
    
    
}
