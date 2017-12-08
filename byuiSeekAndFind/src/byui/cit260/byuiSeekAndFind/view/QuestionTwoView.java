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
class QuestionTwoView extends View {

    private static int randomHeight;
    private static int randomLength;
    private static int randomWidth;

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        Random randomNumber = new Random();
        randomHeight = randomNumber.nextInt(8) + 2;
        randomLength = randomNumber.nextInt(3) + 2;
        randomWidth = randomNumber.nextInt(100);
        System.out.println("A room has a height of " + randomHeight
                + " and length of " + randomLength + " and a width of "
                + randomWidth + " what is the volume of the room?"
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
            QuestionControl.calcQuestionAnswerVolume(randomHeight, randomLength, randomWidth, answer);
            System.out.println("*******************************************************"
                    + "\nCONGRATULATIONS!!! You avoided the trap!"
                    + "\n*******************************************************");
        } catch (QuestionControlException ex) {
            ErrorView.display("QuestionTwoView", ex.getMessage());
            return false;
        }
        return true;
    }

}
