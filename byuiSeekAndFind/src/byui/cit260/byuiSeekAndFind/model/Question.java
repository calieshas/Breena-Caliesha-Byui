/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author breen
 */
public class Question implements Serializable{
    
    private String questionType;
    private String answer;
    private ArrayList<TrapScene> trapScenes = new ArrayList<TrapScene>();

    public Question() {
    }

    public ArrayList<TrapScene> getTrapScenes() {
        return trapScenes;
    }

    public void setTrapScenes(ArrayList<TrapScene> trapScenes) {
        this.trapScenes = trapScenes;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.questionType);
        hash = 43 * hash + Objects.hashCode(this.answer);
        return hash;
    }

    @Override
    public String toString() {
        return "Question{" + "questionType=" + questionType + ", answer=" + answer + '}';
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
        final Question other = (Question) obj;
        if (!Objects.equals(this.questionType, other.questionType)) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
