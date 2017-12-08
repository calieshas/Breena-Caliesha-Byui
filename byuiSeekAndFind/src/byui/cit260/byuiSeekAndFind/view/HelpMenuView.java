/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import java.util.Scanner;

/**
 *
 * @author calie
 */
public class HelpMenuView extends View {

    public String[] getInputs() {

        String[] inputs = new String[1];
        this.console.println("Choose one of the following:" + "\nG - What is the goal of the game?"
                + "\nM - How to move" + "\nE - Estimating the amount of items in game" + "\nQ - Quit");

        inputs[0] = this.getInput("\nEnter a menu item");

        return inputs;
    }

    public boolean doAction(String[] inputs) {
        String helpItem = inputs[0];
        helpItem = helpItem.toUpperCase();

        switch (helpItem) {
            case "G":
                gameGoal();
                break;
            case "M":
                howMove();
                break;
            case "E":
                estimateItems();
                break;
            case "Q":
                return true;
            default:
                ErrorView.display("HelpMenuView", "Invalid menu item.");
        }

        return false;
    }

    private void gameGoal() {
        GameGoalView gameGoalView = new GameGoalView();
        gameGoalView.display();
    }

    private void howMove() {
        this.console.println("how move called");
    }

    private void estimateItems() {
        this.console.println("estimate items called");
    }

}
