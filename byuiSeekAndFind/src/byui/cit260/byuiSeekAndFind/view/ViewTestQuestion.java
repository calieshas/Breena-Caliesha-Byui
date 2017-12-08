/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import java.util.Scanner;

/**
 *
 * @author breen
 */
class ViewTestQuestion {

    void displayViewTestQuestion() {
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
        System.out.println("Choose one of the following:" + "\nO - Question One" +
                "\nT - Question Two" + "\nH - Question Three" + "\nQ - Quit");

        boolean valid = false;
        while(!valid) {
       
            Scanner userInputs = new Scanner(System.in);
            String questionLetter;
            System.out.println("Enter a letter");
            questionLetter = userInputs.nextLine().trim();

            if(questionLetter.length() < 1) {
                System.out.println("You must enter a value.");
                continue;
            }
            inputs[0] = questionLetter;
            valid = true;
        }
        
        return inputs;
    }

    private boolean doAction(String[] inputs) {
            String questionItem = inputs[0];
        questionItem = questionItem.toUpperCase(); 

         switch (questionItem) {
             case "O" : questionOne();
                break;
             case "T" : questionTwo();
                break;
             case "H" : questionThree();
                break;
             case "Q" : return true;
             default : System.out.println("Invalid menu item.");
    }

         return false;
    }

    private void questionOne() {
        QuestionOneView questionOneView = new QuestionOneView();
//        questionOneView.displayQuestionOneView();
    }

    private void questionTwo() {
        QuestionTwoView questionTwoView = new QuestionTwoView();
//        questionTwoView.displayQuestionTwoView();
    }
    
    private void questionThree() {
        QuestionThreeView questionThreeView = new QuestionThreeView();
//        questionThreeView.displayQuestionThreeView();
    }
    
}
