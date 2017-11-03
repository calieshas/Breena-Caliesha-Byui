/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.control.GameControl;
import byuiseekandfind.ByuiSeekAndFind;
import java.util.Scanner;

/**
 *
 * @author calie
 */
public class MainMenuView {
    public void displayMainMenuView() {
        boolean endView = false;
        do {
            String[] inputs = this.getInputs();
            if (inputs[0].toUpperCase().equals("Q") || 
                    inputs.length < 1 || 
                    inputs == null) {   
                return;
            }
            
         endView = doAction(inputs);
        } while (!endView);

    }

    private String[] getInputs() {

        String[] inputs = new String[1];
        System.out.println("Choose one of the following:" + "\nG - Start game" +
                "\nH - Get help on how to play the game" + "\nR - Restart game" + "\nQ - Quit");
       
        boolean valid = false;
        while(!valid) {
       
            Scanner userInputs = new Scanner(System.in);
            String menuLetter;
            System.out.println("Enter a letter");
            menuLetter = userInputs.nextLine().trim();

            if(menuLetter.length() < 1) {
                System.out.println("You must enter a value.");
                continue;
            }
            inputs[0] = menuLetter;
            valid = true;
        }
        
        return inputs;
    }

    private boolean doAction(String[] inputs) {
        String menuItem = inputs[0];
        menuItem = menuItem.toUpperCase(); 

         switch (menuItem) {
             case "G" : startGame();
                break;
             case "H" : getHelp();
                break;
             case "R" : restartGame();
                break;
             case "Q" : return true;
             default : System.out.println("Invalid menu item.");
    }
         return false;
    }

    private void startGame() {
        GameControl.createNewGame(ByuiSeekAndFind.getPlayer());
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.displayGameMenuView();
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView(); 
    }

    private void restartGame() {
        RestartGameView restartGameView = new RestartGameView();
        restartGameView.displayRestartGameView(); 
    }
    
    
}
