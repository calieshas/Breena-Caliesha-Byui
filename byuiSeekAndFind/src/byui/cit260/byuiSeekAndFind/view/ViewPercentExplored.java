/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byuiseekandfind.ByuiSeekAndFind;

/**
 *
 * @author breen
 */
class ViewPercentExplored extends View{
     // how to get to getAmountRemaining() ????????????????????????????????????????????????????????????????
     //long percent = ((.getAmountRemaining() - 25)/25)*100;
    
//    Location[][] locations = Location.isVisited();
    
    
// fix the percent error!!!!!!!!!!!!!! in the text. the consol.println
    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        this.console.println("=================================================================================================================================="
                + "\nThe percent explored is: " + "percent" 
                + "\n==================================================================================================================================");

        inputs[0] = this.getInput("\nReturn to Game Menu by entering Q");

        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        String viewPercentExplored = inputs[0];
        viewPercentExplored = viewPercentExplored.toUpperCase();

        switch (viewPercentExplored) {
            case "Q":
                return true;
            default:
                ErrorView.display("ViewLocationPlayers", "Invalid menu item.");
        }

        return false;
    }
    
    
}
