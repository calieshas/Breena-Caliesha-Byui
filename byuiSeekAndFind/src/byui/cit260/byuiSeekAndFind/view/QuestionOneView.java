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
class QuestionOneView extends View {

    private static int randomStudent;
    private static int randomTextbook;
    private static int randomAmount;

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        Random randomNumber = new Random();
        randomStudent = randomNumber.nextInt(8) + 2;
        randomTextbook = randomNumber.nextInt(3) + 2;
        randomAmount = randomNumber.nextInt(100);
        System.out.println(randomStudent + " students are going to buy textbooks. "
                + "They each need " + randomTextbook + " textbooks. If each textbook costs $"
                + randomAmount + ", how much will be spent on textbooks total?");

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
            QuestionControl.calcQuestionAnswerCost(randomStudent, randomTextbook, randomAmount, answer);
            System.out.println("*******************************************************"
                    + "\nCONGRATULATIONS!!! You avoided the trap!"
                    + "\n*******************************************************");
        } catch (QuestionControlException ex) {
            ErrorView.display("QuestionOneView", ex.getMessage());
            return false;
        }
        return true;
    }

}
