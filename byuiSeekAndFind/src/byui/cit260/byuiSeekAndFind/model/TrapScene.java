/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author breen
 */
public class TrapScene implements Serializable{
    
    private String question;

    public TrapScene() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.question);
        return hash;
    }

    @Override
    public String toString() {
        return "TrapScene{" + "question=" + question + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TrapScene other = (TrapScene) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
