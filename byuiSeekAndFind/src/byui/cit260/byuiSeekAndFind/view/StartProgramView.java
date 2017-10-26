/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.control.GameControl;
import byui.cit260.byuiSeekAndFind.model.Player;
import java.util.Scanner;

/**
 *
 * @author breen
 */
public class StartProgramView {
    public void displayStartProgramView(){
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
        System.out.println("Welcome to BYU-Idaho Seek and Find");
       
        boolean valid = false;
        while(!valid) {
       
            Scanner userInputs = new Scanner(System.in);
            String firstName;
            System.out.println("Enter the player's name");
            firstName = userInputs.nextLine().trim();

            if(firstName.length() < 2) {
                System.out.println("You must enter a value.");
                continue;
            }
            inputs[0] = firstName;
            valid = true;
        }
        
        return inputs;
        }

    private boolean doAction(String[] inputs) {
        String playersName = inputs[0];
        Player player = GameControl.savePlayer(playersName);
            if (player == null) {
                System.out.println("Could not creat the player. " + "\nEnter a different name.");
                return false;
            }
            
        System.out.println("================================================= "
         + "\nWelcome to the game " + playersName + "\nWe hope you have a lot of fun!"
         + "\n================================================= ");
         
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.displayMainMenuView(); 
        return true;
       
    }
}
