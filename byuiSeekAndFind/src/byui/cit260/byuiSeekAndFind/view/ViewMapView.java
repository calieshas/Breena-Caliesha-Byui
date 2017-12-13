/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.model.Game;
import byui.cit260.byuiSeekAndFind.model.Location;
import byuiseekandfind.ByuiSeekAndFind;

/**
 *
 * @author breen
 */
class ViewMapView extends View{

    @Override
    public String[] getInputs() {
       String[] inputs = new String[1];
       Game game = ByuiSeekAndFind.getCurrentGame();
        Location[][] locations = game.getMap().getLocations();
        this.console.println("     BYU-I Seek And Find");
        this.console.print("     0    1    2    3    4");

        for (int row = 0; row < locations.length; row++) {
            this.console.println("\n-----------------------------");
            this.console.print(row);
            for (int column = 0; column < locations[row].length; column++) {
                this.console.print(" |");
                Location location = locations[row][column];
                if (location.isVisited()) {
                    this.console.print(location.getScene().getSymbol());
                } else {
                    this.console.print(" --");
                }
            }
            this.console.print(" |");
        }
        this.console.println("\n-----------------------------");
        inputs[0] = this.getInput("\nReturn to Game Menu by entering Q");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        String viewMapView = inputs[0];
        viewMapView = viewMapView.toUpperCase();

        switch (viewMapView) {
            case "Q":
                return true;
            default:
                ErrorView.display("ViewLocationPlayers", "Invalid menu item.");
        }

        return false;
    }
    
    
    
}
