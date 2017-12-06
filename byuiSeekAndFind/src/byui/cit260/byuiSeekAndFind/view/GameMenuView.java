/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.view;

import byui.cit260.byuiSeekAndFind.model.Game;
import byui.cit260.byuiSeekAndFind.model.Location;
import byuiseekandfind.ByuiSeekAndFind;
import java.util.Scanner;

/**
 *
 * @author breen
 */
class GameMenuView extends View{


    public String[] getInputs() {
        String[] inputs = new String[1];
        System.out.println("Choose one of the following:"
                + "\nV - View Map"
                + "\nI - View list of items"
                + "\nA - View list of actors"
                + "\nL - View location of actors"
                + "\nS - View percent explored"
                + "\nM - Move person to new location"
                + "\nT - Test questions"
                + "\nH - Help" + "\nQ - Quit");
        
        String gameLetter = this.getInput("Enter a letter");
        inputs[0] = gameLetter;

        return inputs;
    }
@Override
    public boolean doAction(String[] inputs) {
        String gameItem = inputs[0];
        gameItem = gameItem.toUpperCase();

        switch (gameItem) {
            case "V":
                viewMap();
                break;
            case "I":
                listItems();
                break;
            case "A":
                listActors();
                break;
            case "L":
                locationPlayers();
                break;
            case "S":
                percentExplored();
                break;
            case "M":
                movePerson();
                break;
            case "T":
                testQuestion();
                break;
            case "H":
                getHelp();
                break;
            case "Q":
                return true;
            default:
                ErrorView.display("GameMenuView", "Invalid menu item.");
        }

        return false;
    }

    private void viewMap() {
        Game game = ByuiSeekAndFind.getCurrentGame();
        Location[][] locations = game.getMap().getLocations();
        System.out.println("     BYU-I Seek And Find");
        System.out.print("     0    1    2    3    4");

        for (int row = 0; row < locations.length; row++) {
            System.out.println("\n-----------------------------");
            System.out.print(row);
            for (int column = 0; column < locations[row].length; column++ ) {
                System.out.print(" |");
                Location location = locations[row][column];
                    if (location.isVisited()) {
                        System.out.print(location.getScene().getSymbol());
                    }
                    else 
                        System.out.print(" --");
            }
            System.out.print(" |");
        }
        System.out.println("\n-----------------------------");
    }

    private void listItems() {
        ViewListItems viewListItems = new ViewListItems();
        viewListItems.display();
    }

    private void listActors() {
        ViewListActors viewListActors = new ViewListActors();
        viewListActors.display();
    }

    private void locationPlayers() {
        ViewLocationPlayers viewLocationPlayers = new ViewLocationPlayers();
        viewLocationPlayers.displayViewLocationPlayers();
    }

    private void percentExplored() {
        ViewPercentExplored viewPercentExplored = new ViewPercentExplored();
        viewPercentExplored.displayViewPercentExplored();
    }

    private void movePerson() {
        ViewMoveActor viewMoveActor = new ViewMoveActor();
        viewMoveActor.displayViewMoveActor();
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void testQuestion() {
        ViewTestQuestion viewTestQuestion = new ViewTestQuestion();
        viewTestQuestion.displayViewTestQuestion();
    }

}
