
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.control;

import byui.cit260.byuiSeekAndFind.exception.MapControlException;
import byui.cit260.byuiSeekAndFind.model.Actor;
import byui.cit260.byuiSeekAndFind.model.Game;
import byui.cit260.byuiSeekAndFind.model.Location;
import byui.cit260.byuiSeekAndFind.model.Map;
import byuiseekandfind.ByuiSeekAndFind;
import java.util.ArrayList;

/**
 *
 * @author breen
 */
public class MapControl {
    public static Location moveActor (Actor actor, int newRow, int newColumn) throws MapControlException{
        if (actor == null){
            throw new MapControlException ("actor can't be null");
        }
       Game game = ByuiSeekAndFind.getCurrentGame();
       Map map = game.getMap();
       Location[][] locations = map.getLocations();
       if (newRow < 1 || newRow > map.getRowCount() || newColumn < 1 || newColumn > map.getColumnCount()){
           throw new MapControlException ("Row Count or Column Count is invalid");
       }
       int currentRow = actor.getCoordinates().x;
       int currentColumn = actor.getCoordinates().y;
       Location oldLocation = locations[currentRow][currentColumn];
       Location newLocation = locations[newRow][newColumn];
       ArrayList<Actor> actorsInLocation= oldLocation.getActors();
       for (Actor nextActor : actorsInLocation){
           if (nextActor.equals(actor)){
               actorsInLocation.remove(actor);
               break;
           }
       }
       newLocation.getActors().add(actor);
       actor.getCoordinates().x = newRow;
       actor.getCoordinates().y = newColumn;
       return newLocation;
 
    }
}
    

