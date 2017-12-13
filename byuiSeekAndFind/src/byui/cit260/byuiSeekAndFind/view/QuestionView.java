/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.control.QuestionControl;
import byui.cit260.byuiSeekAndFind.exception.QuestionControlException;
import byui.cit260.byuiSeekAndFind.model.Game;
import byui.cit260.byuiSeekAndFind.model.Location;
import byui.cit260.byuiSeekAndFind.model.Question;
import byui.cit260.byuiSeekAndFind.model.QuestionType;
import byui.cit260.byuiSeekAndFind.model.Scene;
import byui.cit260.byuiSeekAndFind.model.TrapScene;
import byuiseekandfind.ByuiSeekAndFind;
import java.awt.Point;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author calie
 */
class QuestionView extends View {

    private int randomValue1;
    private int randomValue2;
    private int randomValue3;
    private Question question = null;

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        Random randomNumber = new Random();
        randomValue1 = randomNumber.nextInt(8) + 2;
        randomValue2 = randomNumber.nextInt(3) + 2;
        randomValue3 = randomNumber.nextInt(100);
        Game game = ByuiSeekAndFind.getCurrentGame();
        Point actorLocation = game.getPlayer().getActor().getCoordinates();
        Location[][] locations = game.getMap().getLocations();
        Location location = locations[actorLocation.x][actorLocation.y];
        TrapScene scene = (TrapScene) location.getScene();
        if (!(scene instanceof TrapScene)) {
            return inputs;
        }
        this.question = scene.getQuestion();
        String questionDescription = question.getQuestionDescription();
        questionDescription = questionDescription.replaceFirst("randomNumber1", Integer.toString(randomValue1));
        questionDescription = questionDescription.replaceFirst("randomNumber2", Integer.toString(randomValue2));
        questionDescription = questionDescription.replaceFirst("randomNumber3", Integer.toString(randomValue3));
        this.console.println(questionDescription);

        String hint = this.getInput("Do you want a hint Y/N");
        if (hint.toUpperCase().equals("Y")) {
            this.console.println("a hint.");
        }

        String userAnswer = this.getInput("Enter your answer:");
        inputs[0] = userAnswer;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        String answer = inputs[0];

        try {
            switch (this.question.getQuestionType()) {
                case area:
                    QuestionControl.calcQuestionAnswer(randomValue1, randomValue2, randomValue3, answer);
                    break;
                case textbook:
                    QuestionControl.calcQuestionAnswerCost(randomValue1, randomValue2, randomValue3, answer);
                    break;
                case volume:
                    QuestionControl.calcQuestionAnswerVolume(randomValue1, randomValue2, randomValue3, answer);
                    break;
                case posAlgebra:
                    QuestionControl.calcQuestionAnswerPosAlgebra(randomValue1, randomValue2, randomValue3, answer);
                    break;
                case negAlgebra:
                    QuestionControl.calcQuestionAnswerNegAlgebra(randomValue1, randomValue2, randomValue3, answer);
                    break;
                default:
                    ErrorView.display("QuestionView", "Invalid question type");
                    return true;
            }
            this.console.println("*******************************************************"
                    + "\nCONGRATULATIONS!!! You avoided the trap!"
                    + "\n*******************************************************");
        } catch (QuestionControlException ex) {
            ErrorView.display("QuestionView", ex.getMessage());
            return false;
        }
        return true;
    }

}
