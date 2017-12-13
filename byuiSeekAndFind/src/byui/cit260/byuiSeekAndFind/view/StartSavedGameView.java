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

/**
 *
 * @author calie
 */
public class StartSavedGameView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        this.console.println("Get Saved Game");
        String input1 = this.getInput("Enter your file path and name");
        inputs[0] = input1;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        String filePath = inputs[0];
        try {
           Game game = GameControl.getGame();
        } catch (GameControlException ex) {
            ErrorView.display("SaveGameView", ex.getMessage());
            return false;
        }
        
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
        return true;
    }
    
//    private boolean doAction(String [] inputs) {
// filePath = get first value in inputs array
// try
// call the getGame() control method
// catch GameControlException
// Print error passed with the exception
// return false to repeat the view
// endTry
// gameMenuView = Create a new GameMenuView object
// display the gameMenuView
// return true to end the view
//}

}
