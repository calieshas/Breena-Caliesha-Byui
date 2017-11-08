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
        System.out.println("Choose one of the following:" + "\nG - What is the goal of the game?"
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
                System.out.println("Invalid menu item.");
        }

        return false;
    }

    private void gameGoal() {
        System.out.println("game goal called");
    }

    private void howMove() {
        System.out.println("how move called");
    }

    private void estimateItems() {
        System.out.println("estimate items called");
    }

}
