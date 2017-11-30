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
class ViewMoveActor extends View {

    void displayViewMoveActor() {
    }
    
    private String[] getInput(){
        String[] inputs = new String[2];
        System.out.println("Enter the coordinates of new location.");
        String[] input1 = getInput();
        inputs[0] = this.getInput("Enter the row number.");
        
        String[] input2 = getInput();
        inputs[1] = this.getInput("Enter the column number.");
        
        return inputs;
    }
    @Override
    private boolean doAction(String[] inputs){
        String row = inputs[0];
        String column = inputs[1];
        try {
        int row2 = Integer.parseInt(row);
        int column2 = Integer.parseInt(column);
        } catch (NumberFormatException nf){
            System.out.println(nf.getMessage());
            return false;
        }
       // System.out.println(get descriptions from location); ???????????????????????????????????????????
       return true;
    }
//    private boolean doAction(String [] inputs) {
// row = get first value in inputs array
// column = get second value in inputs array
// try
// convert the row and column to integers
// catch NumberFormatException
// Print “The row and column must be a number”
// return false to repeat the view
// endTry
// player = get the player from the main class
// actor = get the Actor in the player object
//
// try
// newLocation = moveActor(actor, row, column)
// catch MapControlException
// Print error passed with the exception
// return false to repeat the view
// endTry
// Print the description of the scene in the
// newLocation
// return true to end the view
//}
    
    
}
