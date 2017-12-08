/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

/**
 *
 * @author calie
 */
class GameGoalView extends View {
    
     public String[] getInputs() {

        String[] inputs = new String[1];
        this.console.println("=================================================================================================================================="
                + "\nThe goal of this game is to move each of the three actors around the map to find all five of the items for each actor." 
                + "\nOnce you have found each of the items with every actor you win the game!"
                + "\nQ - Quit"
                + "\n==================================================================================================================================");

        inputs[0] = this.getInput("\nReturn to Game Menu");

        return inputs;
    }

    public boolean doAction(String[] inputs) {
        String viewGoal = inputs[0];
        viewGoal = viewGoal.toUpperCase();

        switch (viewGoal) {
            case "Q":
                return true;
            default:
                ErrorView.display("GameGoalView", "Invalid menu item.");
        }

        return false;
    }
    
}
