
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.control;

import byui.cit260.byuiSeekAndFind.exception.MapControlException;
import byui.cit260.byuiSeekAndFind.model.Actor;
import byui.cit260.byuiSeekAndFind.model.Game;
import byui.cit260.byuiSeekAndFind.model.Item;
import byui.cit260.byuiSeekAndFind.model.ItemScene;
import byui.cit260.byuiSeekAndFind.model.Location;
import byui.cit260.byuiSeekAndFind.model.Map;
import byui.cit260.byuiSeekAndFind.model.Scene;
import byui.cit260.byuiSeekAndFind.view.GameOverView;
import byuiseekandfind.ByuiSeekAndFind;
import java.util.ArrayList;

/**
 *
 * @author breen
 */
public class MapControl {

    public static Location moveActor(Actor actor, int newRow, int newColumn) throws MapControlException {
        if (actor == null) {
            throw new MapControlException("actor can't be null");
        }
        Game game = ByuiSeekAndFind.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        if (newRow < 0 || newRow > map.getRowCount() || newColumn < 0 || newColumn > map.getColumnCount()) {
            throw new MapControlException("Row Count or Column Count is invalid");
        }
        int currentRow = actor.getCoordinates().x;
        int currentColumn = actor.getCoordinates().y;
        Location oldLocation = locations[currentRow][currentColumn];
        Location newLocation = locations[newRow][newColumn];
        ArrayList<Actor> actorsInLocation = oldLocation.getActors();
        for (Actor nextActor : actorsInLocation) {
            if (nextActor.equals(actor)) {
                actorsInLocation.remove(actor);
                break;
            }
        }
        newLocation.getActors().add(actor);
        actor.getCoordinates().x = newRow;
        actor.getCoordinates().y = newColumn;
        newLocation.setVisited(true);

        
        Scene scene = newLocation.getScene();
        if (scene instanceof ItemScene) {
            ItemScene itemscene = (ItemScene) scene;
            Item item = itemscene.getItem();
            int numberInPossession = item.getNumberInPossession();
            game.setTotalNoInPossession(game.getTotalNoInPossession() + 1); 
            item.setNumberInPossession(numberInPossession + 1);
        }
        return newLocation;
    }
    
    

    public static int percentVisited() {
        double totalScenes = 25;
        double totalVisited = 0;
        int rowCount = ByuiSeekAndFind.getCurrentGame().getMap().getRowCount();
        int columnCount = ByuiSeekAndFind.getCurrentGame().getMap().getColumnCount();
        Location[][] locations = ByuiSeekAndFind.getCurrentGame().getMap().getLocations();
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                Location location = locations[row][column];
                if (location.isVisited()) {
                    totalVisited++;
                }
            }
            //get location
            //check if isVisited is true
            // add 1 to total visited 
        }
        int percentVisited = (int)((totalVisited / totalScenes) * 100);
        return percentVisited;
    }
}
