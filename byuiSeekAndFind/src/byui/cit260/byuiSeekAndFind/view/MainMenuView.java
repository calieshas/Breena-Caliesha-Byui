/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

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
                "\nH - Get help on how to play the game" + "\nS - Save game" + "\nE - Exit");
       
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
        menuItem.toUpperCase();
// to upper case not working ask on monday! 

         switch (menuItem) {
             case "G" : startGame();
                break;
             case "H" : getHelp();
                break;
             case "S" : saveGame();
                break;
             case "E" : return true;
             default : System.out.println("Invalid menu item.");
    }
         return false;
    }

    private void startGame() {
       System.out.println("start game called");
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView(); 
    }

    private void saveGame() {
        System.out.println("save game called");
    }
    
    
}
