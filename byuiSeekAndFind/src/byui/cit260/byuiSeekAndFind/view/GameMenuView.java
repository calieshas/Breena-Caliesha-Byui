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
class GameMenuView {

    public void displayGameMenuView() {
        boolean endView = false;
        do {
            String[] inputs = this.getInputs();
            if (inputs[0].toUpperCase().equals("Q")
                    || inputs.length < 1
                    || inputs == null) {
                return;
            }

            endView = doAction(inputs);
        } while (!endView);
    }

    private String[] getInputs() {
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

        boolean valid = false;
        while (!valid) {

            Scanner userInputs = new Scanner(System.in);
            String gameLetter;
            System.out.println("Enter a letter");
            gameLetter = userInputs.nextLine().trim();

            if (gameLetter.length() < 1) {
                System.out.println("You must enter a value.");
                continue;
            }
            inputs[0] = gameLetter;
            valid = true;
        }

        return inputs;
    }

    private boolean doAction(String[] inputs) {
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
                System.out.println("Invalid menu item.");
        }

        return false;
    }

    private void viewMap() {
        ViewMapView viewMapView = new ViewMapView();
        viewMapView.displayViewMapView();
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
        ViewMovePerson viewMovePerson = new ViewMovePerson();
        viewMovePerson.displayViewMovePerson();
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
