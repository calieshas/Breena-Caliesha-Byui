/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.model.Item;

/**
 *
 * @author calie
 */
public class GameOverView extends View{
    
    public String[] getInputs() {

        String[] inputs = new String[1];
        this.console.println("=================================================================================================================================="
                + "CONGRATULATIONS YOU WON THE GAME!!!!!!!!!"
                + "\n Thanks For Playing"
                + "\n You found all 5 Items"
                + "\n==================================================================================================================================");

        inputs[0] = this.getInput("\nReturn to Game Menu");

        return inputs;
    }

    public boolean doAction(String[] inputs) {
        String ViewOver = inputs[0];
        ViewOver = ViewOver.toUpperCase();

        switch (ViewOver) {
            case "Q":
                return true;
            default:
                ErrorView.display("GameOverView", "Invalid menu item.");
        }

        return false;
    }
    
}

