/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.exception.GameControlException;
import byui.cit260.byuiSeekAndFind.model.Game;
import byuiseekandfind.ByuiSeekAndFind;

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
//        String filePath = inputs[0]; 
//        Game game = ByuiSeekAndFind.getCurrentGame();
//        try{
//            GameMenuView.saveGame(game);
//        } catch (GameControlException ex){
//            ErrorView.display("SaveGameView", ex.getMessage());
//            return false;
//        }
//        this.console.println("Your Game was Saved at the following location" + inputs);
        return true;
    }

//    filePath = get first value in inputs array
// game = get the currentGame in the main class
// try
// call the saveGame(game)control method
// catch GameControlException
// Print error passed with the exception
// return false to repeat the view
// endTry
// Print a success message indicating where the
// file was saved
// return true to end the view
    
    
    // what is the filePath????????????????????????????????????????????????
    public static void saveGame(Game game, String filePath) {
        System.out.println("saveGame() in GameControl class");
//        if(game || filePath = false){
        
}
//    if invalid a game or filePath passed to method then
// throw a new GameControlException
// endIf
// create a new FileOutputStream for the filePath
// create a new ObjectOutputStream from the FileOutputStream
// write the game object to the ObjectOutputStream
    
    
}
