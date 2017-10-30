/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import java.util.Scanner;

/**
 *
 * @author breen
 */
class GameMenuView {

    public void displayGameMenuView() {
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
            String gameLetter;
            System.out.println("Enter a letter");
            gameLetter = userInputs.nextLine().trim();

            if(gameLetter.length() < 1) {
                System.out.println("You must enter a value.");
                continue;
            }
            inputs[0] = gameLetter;
            valid = true;
        }
        
        return inputs;
    }

    private boolean doAction(String[] inputs) {
        String gameItem = inputs[0];
        gameItem = gameItem.toUpperCase(); 

         switch (gameItem) {
             case "V" : viewMap();
                break;
             case "I" : listItems();
                break;
             case "A" : listActors();
                break;
             case "P" : locationPlayers();
                break;
             case "S" : percentExplored();
                break;
             case "M" : movePerson();
                break;
             case "H" : getHelp();
                break;
             case "Q" : return true;
             default : System.out.println("Invalid menu item.");
    }

         return false;
    }

    private void viewMap() {
        System.out.println("view map view called");
    }

    private void listItems() {
        System.out.println("list items view called");
    }

    private void listActors() {
        System.out.println("list of actors view called");
    }

    private void locationPlayers() {
        System.out.println("location Players view called");
    }

    private void percentExplored() {
        System.out.println("Percent Explored view called");
    }

    private void movePerson() {
        System.out.println("move person view called");
    }
    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView(); 
    }
    
}
