/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.control.GameControl;
import byui.cit260.byuiSeekAndFind.exception.GameControlException;
import byui.cit260.byuiSeekAndFind.model.Player;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breen
 */
public class StartProgramView extends View {

    public String[] getInputs() {

        String[] inputs = new String[1];
        System.out.println("Welcome to BYU-Idaho Seek and Find");

        inputs[0] = this.getInput("\nEnter players name");

        return inputs;
    }

    public boolean doAction(String[] inputs) {
        String playersName = inputs[0];
        Player player;
        try {
            player = GameControl.savePlayer(playersName);
        } catch (GameControlException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        if (player == null) {
            System.out.println("Could not creat the player. " + "\nEnter a different name.");
            return false;
        }

        System.out.println("================================================= "
                + "\nWelcome to the game " + playersName + "\nWe hope you have a lot of fun!"
                + "\n================================================= ");

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
        return true;

    }
}
