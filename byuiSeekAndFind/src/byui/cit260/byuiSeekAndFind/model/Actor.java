/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.model;

import java.awt.Point;

/**
 *
 * @author breen
 */
public enum Actor {
    
    Boy("John", "He is a male student attending BYU-Idaho", new Point(1,1)),
    Girl("Jane", "She is a female student attending BYU-Idaho", new Point(1,2)),
    Professor("Brother Jackson", "He is a professor who teaches at BYU-Idaho", new Point(1,3));
    
    private String name;
    private String description;
    private Point coordinates;
    private String itemsCollected;
    private String scenesVisited;
    
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

    public String getItemsCollected() {
        return itemsCollected;
    }

    public String getScenesVisited() {
        return scenesVisited;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", description=" + description + ", coordinates=" + coordinates + ", itemsCollected=" + itemsCollected + ", scenesVisited=" + scenesVisited + '}';
    }
    
    
    
}
