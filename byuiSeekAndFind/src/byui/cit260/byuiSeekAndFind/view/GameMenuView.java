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
class GameMenuView extends View {

    public String[] getInputs() {
        String[] inputs = new String[1];
        this.console.println(
                "\n"
                + "\n----------------------------------------------------"
                + "\n|  GAME MENU                                       |"
                + "\n----------------------------------------------------"
                + "\nChoose one of the following:"
                + "\nV - View Map"
                + "\nI - View list of items"
                + "\nL - View your location"
                + "\nP - View percent explored"
                + "\nM - Move actor to new location"
                + "\nS - Save the Game"
                + "\nH - Help"
                + "\nQ - Quit"
                + "\n----------------------------------------------------");

        String gameLetter = this.getInput("\nEnter a letter");
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
            case "L":
                locationPlayers();
                break;
            case "P":
                percentExplored();
                break;
            case "M":
                boolean gameOver = movePerson();
                if(gameOver){
                    return true;
                }
                break;
            case "S":
                saveGame();
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
        ViewMapView viewMapView = new ViewMapView();
        viewMapView.display();
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
        viewLocationPlayers.display();
    }

    private void percentExplored() {
        ViewPercentExplored viewPercentExplored = new ViewPercentExplored();
        viewPercentExplored.display();
    }

    private boolean movePerson() {
        ViewMoveActor viewMoveActor = new ViewMoveActor();
        viewMoveActor.display();
        if (ByuiSeekAndFind.getCurrentGame().getTotalNoInPossession() == 5){
           GameOverView gameOverView = new GameOverView();
            gameOverView.display(); 
            return true;
        }
        return false;
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void saveGame() {
        SaveGameView saveGameView = new SaveGameView();
        saveGameView.display();
    }

}
