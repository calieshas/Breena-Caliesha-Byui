/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.control.MapControl;
import byuiseekandfind.ByuiSeekAndFind;

/**
 *
 * @author breen
 */
class ViewPercentExplored extends View {

    // we need to get percent explored from map control.
    @Override
    public String[] getInputs() {

        String[] inputs = {"abc"};
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        int percent = MapControl.percentVisited();
        this.console.println("=================================================================================================================================="
                + "\nYou have explored " + percent + "% of the map"
                + "\n==================================================================================================================================");

        return true;
    }

}
