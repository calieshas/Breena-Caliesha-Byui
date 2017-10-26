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
public class HelpMenuView {
       public void HelpMenuView() {
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
        System.out.println("Choose one of the following:" + "\nG - What is the goal of the game?" +
                "\nM - How to move" + "\nE - Estimating the amount of items in game" + "\nQ - Quit");

        boolean valid = false;
        while(!valid) {
       
            Scanner userInputs = new Scanner(System.in);
            String helpLetter;
            System.out.println("Enter a letter");
            helpLetter = userInputs.nextLine().trim();

            if(helpLetter.length() < 1) {
                System.out.println("You must enter a value.");
                continue;
            }
            inputs[0] = helpLetter;
            valid = true;
        }
        
        return inputs;
    }

    
    


    private boolean doAction(String[] inputs) {
        String menuItem = inputs[0];
        menuItem.toUpperCase();
// to upper case not working ask on monday! 

         switch (menuItem) {
             case "G" : gameGoal();
                break;
             case "M" : howMove();
                break;
             case "E" : estimateItems();
                break;
             case "Q" : return true;
             default : System.out.println("Invalid menu item.");
    }

         return false;
    }

    private void gameGoal() {
       System.out.println("game goal called");
    }

    private void howMove() {
        System.out.println("how move called");
            }

    private void estimateItems() {
        System.out.println("estimate items called");
    }

    void displayHelpMenuView() {
        System.out.println("display help menu view called");
            }
    
    
}
