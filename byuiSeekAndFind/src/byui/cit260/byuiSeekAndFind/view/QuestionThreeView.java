/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.control.QuestionControl;
import byui.cit260.byuiSeekAndFind.exception.QuestionControlException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author calie
 */
class QuestionThreeView extends View {
//    A = ((a+b)/2)*h

    private static int randomHeight;
    private static int randomBase1;
    private static int randomBase2;

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        Random randomNumber = new Random();
        randomHeight = randomNumber.nextInt(8) + 2;
        randomBase1 = randomNumber.nextInt(3) + 2;
        randomBase2 = randomNumber.nextInt(100);
        System.out.println("A table has a height of " + randomHeight
                + " and has a top length of " + randomBase1 + " and a bottom length of "
                + randomBase2 + " what is the area of the table?"
                + "\n*Type H to know how many hints you have left, or ? to get a hint.*");

        String hint = this.getInput("Do you want a hint");
        if (hint.toUpperCase().equals("Y")) {
            System.out.println("a hint.");
        }

        String userAnswer = this.getInput("Enter your answer:");
        inputs[0] = userAnswer;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        String value = inputs[0];
        int answer = 0;
        try {
            answer = Integer.parseInt(value);
        } catch (NumberFormatException nf) {
            System.out.println("You must enter a integer");
        }

        try {
            QuestionControl.calcQuestionAnswer(randomHeight, randomBase1, randomBase2, answer);
            System.out.println("*******************************************************"
                    + "\nCONGRATULATIONS!!! You avoided the trap!"
                    + "\n*******************************************************");
        } catch (QuestionControlException ex) {
            ErrorView.display("QuestionThreeView", ex.getMessage());
            return false;
        }
        return true;
    }
}
