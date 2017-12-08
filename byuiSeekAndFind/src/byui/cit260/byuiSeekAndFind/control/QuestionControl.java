/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.control;

import byui.cit260.byuiSeekAndFind.exception.QuestionControlException;
import byui.cit260.byuiSeekAndFind.model.Game;
import byuiseekandfind.ByuiSeekAndFind;

/**
 *
 * @author breen
 */
public class QuestionControl {

    public static void calcQuestionAnswer(int height, int base1,
            int base2, int answer) throws QuestionControlException {
        if (height < 0) {
            throw new QuestionControlException("Height must be 0 or greater");
        }
        if (base1 < 0) {
            throw new QuestionControlException("Base1 must be 0 or greater");
        }
        if (base2 < 0) {
            throw new QuestionControlException("Base2 must be 0 or greater");
        }
        double area = (base1 + base2) / 2 * height;
        if (answer != area) {
            throw new QuestionControlException("------------------------------------------------------\n"
                    + "\nYour Answer is incorrect, you lost a life! \n"
                    + "\nThe correct answer was: \n"
                    + area
                    + "\nYou have  + # +  lives remaining.\n"
                    + "\n------------------------------------------------------");
        }
    }

    public static void calcQuestionAnswerVolume(int height, int length,
            int width, int answer) throws QuestionControlException {
        if (height < 0) {
            throw new QuestionControlException("Height must be 0 or greater");
        }
        if (length < 0) {
            throw new QuestionControlException("Length must be 0 or greater");
        }
        if (width < 0) {
            throw new QuestionControlException("Width must be 0 or greater");
        }
        double volume = width * height * length;
        if (answer != volume) {
            throw new QuestionControlException("Answer is incorrect");
        }
    }

    public static void calcQuestionAnswerCost(int numberStudent, int numberTextbook,
            int cost, int answer) throws QuestionControlException {
        // add throws to method signature ^ 
        if (numberStudent < 0) {
            throw new QuestionControlException("Height must be 0 or greater");
        }
        if (numberTextbook < 0) {
            throw new QuestionControlException("Length must be 0 or greater");
        }
        if (cost < 0) {
            throw new QuestionControlException("Width must be 0 or greater");
        }
        int totalCost = numberStudent * numberTextbook * cost;
        if (answer != totalCost) {
            throw new QuestionControlException("Answer is incorrect");
        }
        Game game = ByuiSeekAndFind.getCurrentGame();
        if (game != null) {
            game.setIncorrectQuestions(game.getIncorrectQuestions() + 1);
        }
        // change int in method signature to voide and delete return 0 
    }
    
// need to change the int numberStudents, this just has numbers in it very little words
    // Lots of Problems 

    public static void calcQuestionAnswerNegAlgebra(int number1, int number2,
            int number3, int answer) throws QuestionControlException {
        // add throws to method signature ^ 
        if (number1 < 0) {
            throw new QuestionControlException("Height must be 0 or greater");
        }
        if (number2 < 0) {
            throw new QuestionControlException("Length must be 0 or greater");
        }
        if (number3 < 0) {
            throw new QuestionControlException("Width must be 0 or greater");
        }
        int totalCost = number1 * number2 * number3;
        if (answer != totalCost) {
            throw new QuestionControlException("Answer is incorrect");
        }
        Game game = ByuiSeekAndFind.getCurrentGame();
        if (game != null) {
            game.setIncorrectQuestions(game.getIncorrectQuestions() + 1);
        }
    }
// need to change the int numberStudents, this just has numbers in it very little words
    public static void calcQuestionAnswerPosAlgebra(int numberStudent, int numberTextbook,
            int cost, int answer) throws QuestionControlException {
        // add throws to method signature ^ 
        if (numberStudent < 0) {
            throw new QuestionControlException("Height must be 0 or greater");
        }
        if (numberTextbook < 0) {
            throw new QuestionControlException("Length must be 0 or greater");
        }
        if (cost < 0) {
            throw new QuestionControlException("Width must be 0 or greater");
        }
        int totalCost = numberStudent * numberTextbook * cost;
        if (answer != totalCost) {
            throw new QuestionControlException("Answer is incorrect");
        }
        Game game = ByuiSeekAndFind.getCurrentGame();
        if (game != null) {
            game.setIncorrectQuestions(game.getIncorrectQuestions() + 1);
        }
        // change int in method signature to voide and delete return 0 
    }
}
