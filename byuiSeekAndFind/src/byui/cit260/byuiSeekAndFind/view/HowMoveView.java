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
class HowMoveView extends View{

     public String[] getInputs() {

        String[] inputs = new String[1];
        this.console.println("=================================================================================================================================="
                + "\n..."
                + "\nQ - Quit"
                + "\n==================================================================================================================================");

        inputs[0] = this.getInput("\nReturn to Game Menu");

        return inputs;
    }

    public boolean doAction(String[] inputs) {
        String viewHowView = inputs[0];
        viewHowView = viewHowView.toUpperCase();

        switch (viewHowView) {
            case "Q":
                return true;
            default:
                ErrorView.display("HowMoveView", "Invalid menu item.");
        }

        return false;
    }
    
}
