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
class ViewListItems extends View {

    public String[] getInputs() {

        String[] inputs = new String[1];
        System.out.println("=================================================================================================================================="
                + "\nYou will be collecting these items:" + "\n-Textbook"
                + "\n-Phone" +"\n-Computer" +"\n-Significant Other" +"\n-Professor" 
                + "\nYou will need to collect all these items to win the game." 
                + "\nQ - Quit"
                + "\n==================================================================================================================================");

        inputs[0] = this.getInput("\nReturn to Game Menu");

        return inputs;
    }

    public boolean doAction(String[] inputs) {
        String viewListItem = inputs[0];
        viewListItem = viewListItem.toUpperCase();

        switch (viewListItem) {
            case "Q":
                return true;
            default:
                System.out.println("Invalid menu item.");
        }

        return false;
    }
    
}
