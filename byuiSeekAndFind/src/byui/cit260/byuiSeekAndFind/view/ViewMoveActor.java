/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.control.MapControl;
import byui.cit260.byuiSeekAndFind.exception.MapControlException;
import byui.cit260.byuiSeekAndFind.model.Location;
import byuiseekandfind.ByuiSeekAndFind;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breen
 */
class ViewMoveActor extends View {

    void displayViewMoveActor() {
    }
    
     @Override
    public String[] getInputs() {
        String[] inputs = new String[2];
        System.out.println("Enter the coordinates of new location.");
        inputs[0] = this.getInput("Enter the row number.");
        
        inputs[1] = this.getInput("Enter the column number.");
        
        return inputs;
    }
    
    @Override
    public boolean doAction (String[] inputs){
        String row = inputs[0];
        String column = inputs[1];
        int row2 = 0;
        int column2 = 0;
        try {
        row2 = Integer.parseInt(row);
        column2 = Integer.parseInt(column);
        } catch (NumberFormatException nf){
            System.out.println(nf.getMessage());
            return false;
        }
        try {
            Location newLocation = MapControl.moveActor(ByuiSeekAndFind.getPlayer().getActor(), row2, column2);
            System.out.println(newLocation.getScene().getDescription()); 
        } catch (MapControlException ex) {
            System.out.println(ex.getMessage());
        }
        
       return true;
    }



    
    
}
