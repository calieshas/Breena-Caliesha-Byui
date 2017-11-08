/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

/**
 *
 * @author breen
 */
class ViewListActors extends View {

    
    
     public String[] getInputs() {

        String[] inputs = new String[1];
        System.out.println("=================================================================================================================================="
                + "\nIn this game there are three actors:" + "\n-Male Student"
                + "\n-Female Student" + "\n-Professor" 
                + "\nEach of these actors can be moved individually to different spaces to collect each of the items required to complete the game." 
                + "\nQ - Quit"
                + "\n==================================================================================================================================");

        inputs[0] = this.getInput("\nReturn to Game Menu");

        return inputs;
    }

    public boolean doAction(String[] inputs) {
        String viewActorItem = inputs[0];
        viewActorItem = viewActorItem.toUpperCase();

        switch (viewActorItem) {
            case "Q":
                return true;
            default:
                System.out.println("Invalid menu item.");
        }

        return false;
    }
    
    
}
