/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.control.GameControl;
import byui.cit260.byuiSeekAndFind.exception.GameControlException;
import byui.cit260.byuiSeekAndFind.model.Game;
import byuiseekandfind.ByuiSeekAndFind;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author breen
 */
public class SaveGameView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        this.console.println("need instructions to Save Game");
        String input1 = this.getInput("Enter your file Path");
        inputs[0] = input1;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        String filePath = inputs[0];
        Game game = ByuiSeekAndFind.getCurrentGame();
        try {
            GameControl.saveGame(game, filePath);
        } catch (GameControlException ex) {
            ErrorView.display("SaveGameView", ex.getMessage());
            return false;
        }
        this.console.println("Your Game was Saved at the following location" + filePath);
        return true;
    }
    

}
