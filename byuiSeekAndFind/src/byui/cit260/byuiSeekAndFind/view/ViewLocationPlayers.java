/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byuiseekandfind.ByuiSeekAndFind;
import java.awt.Point;

/**
 *
 * @author breen
 */
class ViewLocationPlayers extends View{

    Point boyLocation = ByuiSeekAndFind.getPlayer().getActor().Boy.getCoordinates();
    Point girlLocation = ByuiSeekAndFind.getPlayer().getActor().Girl.getCoordinates();
    Point professorLocation = ByuiSeekAndFind.getPlayer().getActor().Professor.getCoordinates();

    public String[] getInputs() {

        String[] inputs = new String[1];
        this.console.println("=================================================================================================================================="
                + "\nThe current location of each actor is: "
                + "\n-Male Student" + boyLocation
                + "\n-Female Student" + girlLocation
                + "\n-Professor" + professorLocation
                + "\nQ - Quit"
                + "\n==================================================================================================================================");

        inputs[0] = this.getInput("\nReturn to Game Menu");

        return inputs;
    }

    public boolean doAction(String[] inputs) {
        String viewLocationPlayers = inputs[0];
        viewLocationPlayers = viewLocationPlayers.toUpperCase();

        switch (viewLocationPlayers) {
            case "Q":
                return true;
            default:
                ErrorView.display("ViewLocationPlayers", "Invalid menu item.");
        }

        return false;
    }
    
}
