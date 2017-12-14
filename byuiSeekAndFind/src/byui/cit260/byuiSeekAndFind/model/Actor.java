/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
* Names:
* Breena Jones, ItemScene, Scene, TrapScene, Question
* Caliesha Stimpson, Map, Item, Location
*/
package byui.cit260.byuiSeekAndFind.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author breen
 */
public enum Actor {
    
    You("This is you", "You are attending Byu-Idaho", new Point(1,1));
    
    private String name;
    private String description;
    private Point coordinates;
    private ArrayList<Scene> scenesVisited = new ArrayList<>();
    private ArrayList<Item> itemsCollected = new ArrayList<>();
    private ArrayList<Item> itemsNeeded = new ArrayList<>();
    
    Actor(String name, String description, Point coordinates) {
        this.name = name;
        this.description = description;
        this.coordinates = coordinates;
    }


   
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public ArrayList<Scene> getScenesVisited() {
        return scenesVisited;
    }

    public ArrayList<Item> getItemsCollected() {
        return itemsCollected;
    }

    public ArrayList<Item> getItemsNeeded() {
        return itemsNeeded;
    }


    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", description=" + description + ", coordinates=" + coordinates + ", itemsCollected=" + itemsCollected + ", scenesVisited=" + scenesVisited + '}';
    }
    
    
    
}
