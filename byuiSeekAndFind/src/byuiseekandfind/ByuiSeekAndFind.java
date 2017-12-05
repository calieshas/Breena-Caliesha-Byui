/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byuiseekandfind;

import byui.cit260.byuiSeekAndFind.model.Game;
import byui.cit260.byuiSeekAndFind.model.Player;
import byui.cit260.byuiSeekAndFind.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breen
 */
public class ByuiSeekAndFind {

    /**
     * @param args the command line arguments
     */
    private static Game currentGame = null;
    private static Player player = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;

    public static void main(String[] args) {
        try {
            ByuiSeekAndFind.inFile = new BufferedReader(new InputStreamReader(System.in));
            ByuiSeekAndFind.outFile = new PrintWriter(System.out, true);
            
            String filePath = "log.txt";
            ByuiSeekAndFind.logFile = new PrintWriter(filePath);
            
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
        } catch (Throwable t) {
            System.out.println("Exception: " + t.toString() +
                               "\nCause: " + t.getCause() +
                               "\nMessage: " + t.getMessage());
            System.out.println("Start program failed");
            t.printStackTrace();
            return;
        }
        finally {
            try {
                if (ByuiSeekAndFind.inFile != null)
                    ByuiSeekAndFind.inFile.close();
                if (ByuiSeekAndFind.outFile != null)
                    ByuiSeekAndFind.outFile.close();
                if (ByuiSeekAndFind.logFile != null)
                    ByuiSeekAndFind.logFile.close();
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        ByuiSeekAndFind.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        ByuiSeekAndFind.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        ByuiSeekAndFind.inFile = inFile;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        ByuiSeekAndFind.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        ByuiSeekAndFind.player = player;
    }

}
