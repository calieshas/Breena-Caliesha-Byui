/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.control.QuestionControl;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author calie
 */
class QuestionOneView {

    private static int randomStudent;
    private static int randomTextbook;
    private static int randomAmount;
    
    void displayQuestionOneView() {
             boolean endView = false;
        do {
            String[] inputs = this.getInputs();
            if (inputs[0].toUpperCase().equals("Q") || 
                    inputs.length < 1 || 
                    inputs == null) {   
                return;
            }
            
         endView = doAction(inputs);
        } while (!endView);

    }

    private String[] getInputs() {
                        String[] inputs = new String[1];
            Random randomNumber = new Random();
            randomStudent = randomNumber.nextInt(8) +2;
            randomTextbook = randomNumber.nextInt(3) +2;
            randomAmount = randomNumber.nextInt(100);
        System.out.println( randomStudent + " students are going to buy textbooks. "
                + "They each need " + randomTextbook + " textbooks. If each textbook costs $" 
                + randomAmount + ", how much will be spent on textbooks total?" 
                + "\n*Type H to know how many hints you have left, or ? to get a hint.*");

        boolean valid = false;
        while(!valid) {
       
            Scanner userInputs = new Scanner(System.in);
            String userAnswer;
            //^ Int ?
            System.out.println("Enter your answer:");
            userAnswer = userInputs.nextLine().trim();

            if(userAnswer.length() < 1) {
                System.out.println("Enter a value");
                continue;
            }
            inputs[0] = userAnswer;
            valid = true;
        }
        
        return inputs;
    }

    
    private String getHintInput() {
                        String input = new String();
        System.out.println( "H= hints");

        boolean valid = false;
        while(!valid) {
       
            Scanner userInputs = new Scanner(System.in);
            String userAnswer;
            //^ Int ?
            System.out.println("Enter letter");
            userAnswer = userInputs.nextLine().trim();

            if(userAnswer.length() < 1) {
                System.out.println("Enter a value");
                continue;
            }
            input = userAnswer;
            valid = true;
        }
        
        return input;
    }
    
    private boolean doAction(String[] inputs) {
        String questionItem = inputs[0];
        questionItem = questionItem.toUpperCase(); 
        String userLetter = this.getHintInput();
         switch (userLetter) {
             case "H" : numberHints();
                break;
             case "?" : showHint();
                break;
             case "Q" : return true;
             
    }
         
         String value = inputs[0];
         int answer = Integer.parseInt(value);
         int result = QuestionControl.calcQuestionAnswerCost(randomStudent, randomTextbook, randomAmount, answer);
         switch (result) {
            case -1: System.out.println("student, textbook, or amount is invalid");
                break;
            case 0: System.out.println("answer incorrect");
                break;
            
            default: System.out.println("Correct!");
             
        }
                 
            return true;
        }

    private void numberHints() {
        System.out.println("number of Hints");
    }

    private void showHint() {
        System.out.println("Hint");
    }
    
}
	