/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.control;

import byui.cit260.byuiSeekAndFind.exception.GameControlException;
import byui.cit260.byuiSeekAndFind.model.Actor;
import byui.cit260.byuiSeekAndFind.model.Game;
import byui.cit260.byuiSeekAndFind.model.Item;
import byui.cit260.byuiSeekAndFind.model.ItemScene;
import byui.cit260.byuiSeekAndFind.model.ItemType;
import byui.cit260.byuiSeekAndFind.model.Location;
import byui.cit260.byuiSeekAndFind.model.Map;
import byui.cit260.byuiSeekAndFind.model.Player;
import byui.cit260.byuiSeekAndFind.model.Question;
import byui.cit260.byuiSeekAndFind.model.QuestionType;
import byui.cit260.byuiSeekAndFind.model.Scene;
import byui.cit260.byuiSeekAndFind.model.SceneType;
import byui.cit260.byuiSeekAndFind.model.TrapScene;
import byuiseekandfind.ByuiSeekAndFind;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author breen
 */
public class GameControl {

    public static Player savePlayer(String name) throws GameControlException {
        if (name == null || name.length() < 1) {
            throw new GameControlException("name can't be null");
        }
    
        Player player = new Player();
        player.setName(name);
        ByuiSeekAndFind.setPlayer(player);
        return player;
    }
    
    public static void saveGame(Game game, String filePath) throws GameControlException {
        if (game == null || filePath == null) {
            throw new GameControlException("Input is invaild");
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))){
            out.writeObject(game);
        } catch (IOException ex){
            throw new GameControlException(ex.getMessage());
        }
    }
    

    public static void createNewGame(Player player) throws GameControlException {
        if (player == null) {
            throw new GameControlException("player can't be null");
        }

        Game game = new Game();
        game.setPlayer(player);
        ByuiSeekAndFind.setCurrentGame(game);

        player.setActor(Actor.Girl);
        
        Item[] items = GameControl.createItems();
        game.setItems(items);


        Map map = GameControl.createMap(5, 5, items);
        if (map == null) {
            throw new GameControlException("map can't be null");
        }
        game.setMap(map);

    }

    public static Item[] createItems() {

        Item[] items = new Item[5];

        Item textbook = new Item();
        textbook.setItemType("Textbook");
        textbook.setNumberInPossesion(0);
        textbook.setItemNeeded("Textbook");
        items[ItemType.textbook.ordinal()] = textbook;

        Item phone = new Item();
        phone.setItemType("phone");
        phone.setNumberInPossesion(0);
        phone.setItemNeeded("phone");
        items[ItemType.phone.ordinal()] = phone;
        
        Item computer = new Item();
        computer.setItemType("computer");
        computer.setNumberInPossesion(0);
        computer.setItemNeeded("computer");
        items[ItemType.computer.ordinal()] = computer;

        Item significant = new Item();
        significant.setItemType("Significant Other");
        significant.setNumberInPossesion(0);
        significant.setItemNeeded("Significant Other");
        items[ItemType.significant.ordinal()] = significant;

        Item professor = new Item();
        professor.setItemType("Professor");
        professor.setNumberInPossesion(0);
        professor.setItemNeeded("Professor");
        items[ItemType.professor.ordinal()] = professor;

        return items;
    }
//    int SumListOfItems() {
//       NumberInPossesion items = NumberInPossesion.values();
//       int sum = 0;
//        for (numberInPossesion item : items) {
//            sum ++;
//    }
//        return sum;
//    }

    public static Map createMap(int rowCount, int columnCount, Item[] items) throws GameControlException {

        if (rowCount < 0 || columnCount < 0) {
            throw new GameControlException("Row count and Column count can't be a negative number");
        }
        if (items == null || items.length < 1) {
            throw new GameControlException("Items can't be null or less than 1");
        }

        Map map = new Map();
        map.setRowCount(rowCount);
        map.setColumnCount(columnCount);
        
        Location[][] locations = GameControl.createLocations(rowCount, columnCount);
        map.setLocations(locations);
        
        Scene[] scenes = GameControl.createScenes();
        Question[] questions = GameControl.createQuestions();
        GameControl.assignQuestionsToScenes(questions, scenes);
        GameControl.assignItemsToScenes(items, scenes);
        return map;
      
    }

    private static Location[][] createLocations(int rowCount, int columnCount) throws GameControlException {
//        System.out.println("createLocations() called");
        if(rowCount < 1 || columnCount < 1) {
        throw new GameControlException("Row count and Column count can't be less then 1");
        }
        Location[][] locations = new Location[rowCount][columnCount];
        long total = 0;
        
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++ ) {
                
                Location locate = new Location();
                locate.setRow(row);
                locate.setColumn(column);
                locations[row][column] = locate;
                
            }
        }

        return locations;
    }

    private static Scene[] createScenes() {
        Scene[] scenes = new Scene[25];
        
        TrapScene scene1 = new TrapScene();
        scene1.setSymbol("X");
        scene1.setDescription("Trap Scene");
        scenes[SceneType.question1.ordinal()] = scene1;
        
        Scene scene2 = new Scene();
        scene2.setSymbol("1");
        scene2.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene2;    
        
        Scene scene3 = new Scene();
        scene3.setSymbol(" ");
        scene3.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene3;
        
        Scene scene4 = new Scene();
        scene4.setSymbol("1");
        scene4.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene4;
        
        Scene scene5 = new Scene();
        scene5.setSymbol("1");
        scene5.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene5;
        
        ItemScene scene6 = new ItemScene();
        scene6.setSymbol("1");
        scene6.setDescription("computer");
        scenes[SceneType.computer.ordinal()] = scene6;
        
        Scene scene7 = new Scene();
        scene7.setSymbol(" ");
        scene7.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene7;
        
        ItemScene scene8 = new ItemScene();
        scene8.setSymbol(" ");
        scene8.setDescription("phone");
        scenes[SceneType.phone.ordinal()] = scene8;
        
        Scene scene9 = new Scene();
        scene9.setSymbol("1");
        scene9.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene9;
        
        TrapScene scene10 = new TrapScene();
        scene10.setSymbol("X");
        scene10.setDescription("Trap Scene");
        scenes[SceneType.question2.ordinal()] = scene10;
        
        Scene scene11 = new Scene();
        scene11.setSymbol("1");
        scene11.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene11;
        
        Scene scene12 = new Scene();
        scene12.setSymbol("1");
        scene12.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene12;
        
        Scene scene13 = new Scene();
        scene13.setSymbol("2");
        scene13.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene13;
        
        Scene scene14 = new Scene();
        scene14.setSymbol("2");
        scene14.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene14;
        
        Scene scene15 = new Scene();
        scene15.setSymbol("2");
        scene15.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene15;
        
        Scene scene16 = new Scene();
        scene16.setSymbol("1");
        scene16.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene16;
        
        TrapScene scene17 = new TrapScene();
        scene17.setSymbol("X");
        scene17.setDescription("Trap Scene");
        scenes[SceneType.question3.ordinal()] = scene17;
        
        ItemScene scene18 = new ItemScene();
        scene18.setSymbol("3");
        scene18.setDescription("Significant Other");
        scenes[SceneType.significant.ordinal()] = scene18;
        
        TrapScene scene19 = new TrapScene();
        scene19.setSymbol("X");
        scene19.setDescription("Trap Scene");
        scenes[SceneType.question4.ordinal()] = scene19;
        
        ItemScene scene20 = new ItemScene();
        scene20.setSymbol("1");
        scene20.setDescription("Professor");
        scenes[SceneType.professor.ordinal()] = scene20;
        
        ItemScene scene21 = new ItemScene();
        scene21.setSymbol("1");
        scene21.setDescription("Textbook");
        scenes[SceneType.textbook.ordinal()] = scene21;
        
        Scene scene22 = new Scene();
        scene22.setSymbol("2");
        scene22.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene22;
        
        TrapScene scene23 = new TrapScene();
        scene23.setSymbol("X");
        scene23.setDescription("Trap Scene");
        scenes[SceneType.question5.ordinal()] = scene23;
        
        Scene scene24 = new Scene();
        scene24.setSymbol("2");
        scene24.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene24;
        
        Scene scene25 = new Scene();
        scene25.setSymbol("1");
        scene25.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene25;
        
//-------------------------- ... ---------------------------------        
        
//        System.out.println("CreateScenes() called");
        return scenes;
    }

    
    
    
    private static Question[] createQuestions() {
        Question[] questions = new Question[5];
        
        Question question1 = new Question();
        question1.setQuestionType(QuestionType.volume);
        question1.setAnswer(1);
        String question = 
                "A table has a height of randomHeight"
                + " and has a top length of randomBase1 and a bottom length of "
                + "randomBase2 what is the area of the table?";
        
        question1.setQuestionDescription(question);
        questions[QuestionType.volume.ordinal()] = question1;
        
        Question question2 = new Question();
        question2.setQuestionType(QuestionType.area);
        question2.setAnswer(1);
        question = 
                "A room has a height of randomHeight"
                + " and length of randomLength and a width of "
                + "randomWidth what is the volume of the room?";
        question2.setQuestionDescription(question);
        questions[QuestionType.area.ordinal()] = question2;
        
        Question question3 = new Question();
        question3.setQuestionType(QuestionType.textbook);
        question3.setAnswer(1);
        question = 
                "randomStudent students are going to buy textbooks. "
                + "They each need  randomTextbook textbooks. If each textbook costs $ randomAmount ,"
                + " how much will be spent on textbooks total?";
        question3.setQuestionDescription(question);
        questions[QuestionType.textbook.ordinal()] = question3;
        
        Question question4 = new Question();
        question4.setQuestionType(QuestionType.posAlgebra);
        question4.setAnswer(1);
        question = 
                "randomNumber1 * x - randomNumber2 = randomNumber3"
                + "Solve for x.";
        question4.setQuestionDescription(question);
        questions[QuestionType.posAlgebra.ordinal()] = question4;
        
        Question question5 = new Question();
        question5.setQuestionType(QuestionType.negAlgebra);
        question5.setAnswer(1);
        question = 
                "randomNumber + randomNumber2 z = randomNumber3"
                + "Solve for z.";
        question5.setQuestionDescription(question);
        questions[QuestionType.negAlgebra.ordinal()] = question5;
        
//----------------------------------- ... --------------------------------------
 
 
        return questions;
    }

    private static void assignQuestionsToScenes(Question[] questions, Scene[] scenes) {
        TrapScene trapScene = (TrapScene)scenes[SceneType.question1.ordinal()];
        trapScene.setQuestion(questions[QuestionType.volume.ordinal()]);
        
        trapScene = (TrapScene)scenes[SceneType.question2.ordinal()];
        trapScene.setQuestion(questions[QuestionType.area.ordinal()]);
        
        trapScene = (TrapScene)scenes[SceneType.question3.ordinal()];
        trapScene.setQuestion(questions[QuestionType.textbook.ordinal()]);
        
        trapScene = (TrapScene)scenes[SceneType.question4.ordinal()];
        trapScene.setQuestion(questions[QuestionType.posAlgebra.ordinal()]);
        
        trapScene = (TrapScene)scenes[SceneType.question5.ordinal()];
        trapScene.setQuestion(questions[QuestionType.negAlgebra.ordinal()]);

    }

    private static void assignItemsToScenes(Item[] items, Scene[] scenes) {
        ItemScene itemScene = (ItemScene)scenes[SceneType.textbook.ordinal()];
        itemScene.setItem(items[ItemType.textbook.ordinal()]);
        
        itemScene = (ItemScene)scenes[SceneType.phone.ordinal()];
        itemScene.setItem(items[ItemType.phone.ordinal()]);
        
        itemScene = (ItemScene)scenes[SceneType.computer.ordinal()];
        itemScene.setItem(items[ItemType.computer.ordinal()]);
        
        itemScene = (ItemScene)scenes[SceneType.significant.ordinal()];
        itemScene.setItem(items[ItemType.significant.ordinal()]);
        
        itemScene = (ItemScene)scenes[SceneType.professor.ordinal()];
        itemScene.setItem(items[ItemType.professor.ordinal()]);
        
    }

    private static void assignScenesToLocations(Scene[] scenes, Location[][] locations) {
        locations[0][0].setScene(scenes[SceneType.question1.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.blank.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.blank.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.blank.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.blank.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.computer.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.blank.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.phone.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.blank.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.question2.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.blank.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.blank.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.blank.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.blank.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.blank.ordinal()]);
        locations[3][0].setScene(scenes[SceneType.blank.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.question3.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.significant.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.question4.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.textbook.ordinal()]);
        locations[4][0].setScene(scenes[SceneType.professor.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.blank.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.question5.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.blank.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.blank.ordinal()]);
    }
//    public static void test(String [] args) {
//        ItemControl test1 = new ItemControl();
//        int aVal = test1.SumListOfItems();
//        System.out.println("Results = " + aVal);
//    }

}
