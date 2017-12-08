/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.control.GameControl;
import byui.cit260.byuiSeekAndFind.exception.GameControlException;
import byui.cit260.byuiSeekAndFind.model.Player;
import byuiseekandfind.ByuiSeekAndFind;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author calie
 */
public class MainMenuView extends View {

    public String[] getInputs() {

        String[] inputs = new String[1];
        this.console.println("Choose one of the following:" + "\nG - Start game"
                + "\nH - Help Menu" + "\nR - Restart game" + "\nQ - Quit");

        inputs[0] = this.getInput("\nEnter a menu item");

        return inputs;
    }

    public boolean doAction(String[] inputs) {
        String menuItem = inputs[0];
        menuItem = menuItem.toUpperCase();

        switch (menuItem) {
            case "G":
                startGame();
                break;
            case "H":
                getHelp();
                break;
            case "R":
                restartGame();
                break;
            case "Q":
                return true;
            default:
                ErrorView.display("MainMenuView", "Invalid menu item.");
        }
        return false;
    }

    private void startGame() {
        Player player = ByuiSeekAndFind.getPlayer();
        try {
            GameControl.createNewGame(player);
        } catch (GameControlException ex) {
            this.console.println(ex.getMessage());
            return;
        }
        
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void restartGame() {
        RestartGameView restartGameView = new RestartGameView();
        restartGameView.displayRestartGameView();
    }

}
