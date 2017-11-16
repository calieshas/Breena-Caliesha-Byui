/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.control;

import byui.cit260.byuiSeekAndFind.model.Actor;
import byui.cit260.byuiSeekAndFind.model.Game;
import byui.cit260.byuiSeekAndFind.model.Item;
import byui.cit260.byuiSeekAndFind.model.Location;
import byui.cit260.byuiSeekAndFind.model.Map;
import byui.cit260.byuiSeekAndFind.model.Player;
import byui.cit260.byuiSeekAndFind.model.Question;
import byui.cit260.byuiSeekAndFind.model.QuestionType;
import byui.cit260.byuiSeekAndFind.model.Scene;
import byui.cit260.byuiSeekAndFind.model.SceneType;
import byuiseekandfind.ByuiSeekAndFind;

/**
 *
 * @author breen
 */
public class GameControl {

    public static Player savePlayer(String name) {

        if (name == null || name.length() < 1) {
            return null;
        }
        Player player = new Player();
        player.setName(name);
        ByuiSeekAndFind.setPlayer(player);
        return player;
    }

    public static int createNewGame(Player player) {
        if (player == null) {
            return -1;
        }

        Game game = new Game();
        game.setPlayer(player);
        ByuiSeekAndFind.setCurrentGame(game);

        player.setActor(Actor.Girl);
        
        Item[] items = GameControl.createItems();
        game.setItems(items);

        Map map = GameControl.createMap(5, 5, items);
        if (map == null) {
            return -1;
        }
        game.setMap(map);
        return 1;

    }

    public static Item[] createItems() {

        Item[] items = new Item[5];

        Item textbook = new Item();
        textbook.setItemType("Textbook");
        textbook.setNumberInPossesion(0);
        textbook.setItemNeeded("Textbook");
        items[0] = textbook;
        //item1 = new InventoryItem object
        //Assign values to each attribute in the InventoryItem object
        //Assign items1 to a position in the items array
        Item phone = new Item();
        phone.setItemType("phone");
        phone.setNumberInPossesion(0);
        phone.setItemNeeded("phone");
        items[1] = phone;
        //item2 = new InventoryItem object
        //Assign values to each attribute in the InventoryItem object
        //Assign items2 to a position in the items array
        Item computer = new Item();
        computer.setItemType("computer");
        computer.setNumberInPossesion(0);
        computer.setItemNeeded("computer");
        items[2] = computer;

        Item significant = new Item();
        significant.setItemType("Significant Other");
        significant.setNumberInPossesion(0);
        significant.setItemNeeded("Significant Other");
        items[3] = significant;

        Item professor = new Item();
        professor.setItemType("Professor");
        professor.setNumberInPossesion(0);
        professor.setItemNeeded("Professor");
        items[4] = professor;

        return items;
    }

    public static Map createMap(int rowCount, int columnCount, Item[] items) {

        if (rowCount < 0 || columnCount < 0) {
            return null;
        }
        if (items == null || items.length < 1) {
            return null;
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

    private static Location[][] createLocations(int rowCount, int columnCount) {
        System.out.println("createLocations() called");
        if(rowCount < 1 || columnCount < 1) {
        return null;
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
        
        Scene scene1 = new Scene();
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
        
        Scene scene6 = new Scene();
        scene6.setSymbol("1");
        scene6.setDescription("computer");
        scenes[SceneType.computer.ordinal()] = scene6;
        
        Scene scene7 = new Scene();
        scene7.setSymbol(" ");
        scene7.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene7;
        
        Scene scene8 = new Scene();
        scene8.setSymbol(" ");
        scene8.setDescription("phone");
        scenes[SceneType.phone.ordinal()] = scene8;
        
        Scene scene9 = new Scene();
        scene9.setSymbol("1");
        scene9.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene9;
        
        Scene scene10 = new Scene();
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
        
        Scene scene17 = new Scene();
        scene17.setSymbol("X");
        scene17.setDescription("Trap Scene");
        scenes[SceneType.question3.ordinal()] = scene17;
        
        Scene scene18 = new Scene();
        scene18.setSymbol("3");
        scene18.setDescription("Significant Other");
        scenes[SceneType.significantOther.ordinal()] = scene18;
        
        Scene scene19 = new Scene();
        scene19.setSymbol("X");
        scene19.setDescription("Trap Scene");
        scenes[SceneType.question4.ordinal()] = scene19;
        
        Scene scene20 = new Scene();
        scene20.setSymbol("1");
        scene20.setDescription("Professor");
        scenes[SceneType.professor.ordinal()] = scene20;
        
        Scene scene21 = new Scene();
        scene21.setSymbol("1");
        scene21.setDescription("Textbook");
        scenes[SceneType.textbook.ordinal()] = scene21;
        
        Scene scene22 = new Scene();
        scene22.setSymbol("2");
        scene22.setDescription("Blank Scene");
        scenes[SceneType.blank.ordinal()] = scene22;
        
        Scene scene23 = new Scene();
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
        
        System.out.println("CreateScenes() called");
        return scenes;
    }

    
    
    
    private static Question[] createQuestions() {
        Question[] questions = new Question[5];
        
        Question question1 = new Question();
        question1.setQuestionType("Math");
        question1.setAnswer(1);
        questions[QuestionType.volume.ordinal()] = question1;
        
//----------------------------------- ... --------------------------------------
 
 
        return questions;
    }

    private static void assignQuestionsToScenes(Question[] questions, Scene[] scenes) {
          
//        questionScene1 = scenes(indexOfScene)
//        questionsInScene = Create a new Questions array
//        questionsInScene[0] = questions[indexOfQuestion]
//                
//        assign questionsInScene array to questionScene1 
    }

    private static void assignItemsToScenes(Item[] items, Scene[] scenes) {
        System.out.println("assignItemsToScenes() called");
    }

    private static void assignScenesToLocations(Scene[] scenes, Location[][] locations) {
        System.out.println("assignScenesToLocations() called");
    }

}
