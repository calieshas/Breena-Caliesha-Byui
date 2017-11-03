/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.byuiSeekAndFind.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author breen
 */
public class QuestionControlTest {
    
    public QuestionControlTest() {
    }

    /**
     * Test of calcQuestionAnswer method, of class QuestionControl.
     */
    @Test
    public void testCalcQuestionAnswer() {
        System.out.println("calcQuestionAnswer");
        
        // ---- Test Case 1 -----
        System.out.println("\tTest case 1");
        double height = 5.0;
        double base1 = 3.0;
        double base2 = 2.0;
        double answer = 12.5;
        double expResult = 1;
        double result = QuestionControl.calcQuestionAnswer(height, base1, base2, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 2 -----
        System.out.println("\tTest case 2");
        height = 5.0;
        base1 = 3.0;
        base2 = 2.0;
        answer = 10;
        expResult = 0;
        result = QuestionControl.calcQuestionAnswer(height, base1, base2, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 3 -----
        System.out.println("\tTest case 3");
        height = -1;
        base1 = 3.0;
        base2 = 2.0;
        answer = 10;
        expResult = -1;
        result = QuestionControl.calcQuestionAnswer(height, base1, base2, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 4 -----
        System.out.println("\tTest case 4");
        height = 5.0;
        base1 = -1;
        base2 = 2.0;
        answer = 10;
        expResult = -1;
        result = QuestionControl.calcQuestionAnswer(height, base1, base2, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 5 -----
        System.out.println("\tTest case 5");
        height = 5.0;
        base1 = 3.0;
        base2 = -1;
        answer = 10;
        expResult = -1;
        result = QuestionControl.calcQuestionAnswer(height, base1, base2, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 6 -----
        System.out.println("\tTest case 6");
        height = 0;
        base1 = 3.0;
        base2 = 2.0;
        answer = 0;
        expResult = 1;
        result = QuestionControl.calcQuestionAnswer(height, base1, base2, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 7 -----
        System.out.println("\tTest case 7");
        height = 5.0;
        base1 = 0;
        base2 = 2.0;
        answer = 5;
        expResult = 1;
        result = QuestionControl.calcQuestionAnswer(height, base1, base2, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 8 -----
        System.out.println("\tTest case 8");
        height = 5.0;
        base1 = 3.0;
        base2 = 0;
        answer = 7.5;
        expResult = 1;
        result = QuestionControl.calcQuestionAnswer(height, base1, base2, answer);
        assertEquals(expResult, result, 0.0001);
    }
    @Test
    public void testCalcQuestionAnswerVolume() {
        System.out.println("calcQuestionAnswerVolume");
        
        // ---- Test Case 1 -----
        System.out.println("\tTest case 1");
        double height = 5.0;
        double length = 3.0;
        double width = 2.0;
        double answer = 30;
        double expResult = 1;
        double result = QuestionControl.calcQuestionAnswerVolume(height, length, width, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 2 -----
        System.out.println("\tTest case 2");
        height = 5.0;
        length = 3.0;
        width = 2.0;
        answer = 10;
        expResult = 0;
        result = QuestionControl.calcQuestionAnswerVolume(height, length, width, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 3 -----
        System.out.println("\tTest case 3");
        height = -1;
        length = 3.0;
        width = 2.0;
        answer = 10;
        expResult = -1;
        result = QuestionControl.calcQuestionAnswerVolume(height, length, width, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 4 -----
        System.out.println("\tTest case 4");
        height = 5.0;
        length = -1;
        width = 2.0;
        answer = 10;
        expResult = -1;
        result = QuestionControl.calcQuestionAnswerVolume(height, length, width, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 5 -----
        System.out.println("\tTest case 5");
        height = 5.0;
        length = 3.0;
        width = -1;
        answer = 10;
        expResult = -1;
        result = QuestionControl.calcQuestionAnswerVolume(height, length, width, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 6 -----
        System.out.println("\tTest case 6");
        height = 0;
        length = 3.0;
        width = 2.0;
        answer = 0;
        expResult = 1;
        result = QuestionControl.calcQuestionAnswerVolume(height, length, width, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 7 -----
        System.out.println("\tTest case 7");
        height = 5.0;
        length = 0;
        width = 2.0;
        answer = 0;
        expResult = 1;
        result = QuestionControl.calcQuestionAnswerVolume(height, length, width, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 8 -----
        System.out.println("\tTest case 8");
        height = 5.0;
        length = 3.0;
        width = 0;
        answer = 0;
        expResult = 1;
        result = QuestionControl.calcQuestionAnswerVolume(height, length, width, answer);
        assertEquals(expResult, result, 0.0001);
    }
    
    /*
    @Test
    public void testCalcQuestionAnswerCost() {
        System.out.println("calcQuestionAnswerCost");
        
        // ---- Test Case 1 -----
        System.out.println("\tTest case 1");
        int numberStudent = 5.0;
        int numberTextbook = 4.0;
        int cost = 50.0;
        int answer = 1000;
        int expResult = 1;
        int result = QuestionControl.calcQuestionAnswerCost(numberStudent, numberTextbook, cost, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 2 -----
        System.out.println("\tTest case 2");
        numberStudent = 5.0;
        numberTextbook = 4.0;
        cost = 50.0;
        answer = 200;
        expResult = 0;
        result = QuestionControl.calcQuestionAnswerCost(numberStudent, numberTextbook, cost, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 3 -----
        System.out.println("\tTest case 3");
        numberStudent = -1.0;
        numberTextbook = 4.0;
        cost = 50.0;
        answer = -200;
        expResult = -1;
        result = QuestionControl.calcQuestionAnswerCost(numberStudent, numberTextbook, cost, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 4 -----
        System.out.println("\tTest case 4");
        numberStudent = 5.0;
        numberTextbook = -1.0;
        cost = 50.0;
        answer = -250;
        expResult = -1;
        result = QuestionControl.calcQuestionAnswerCost(numberStudent, numberTextbook, cost, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 5 -----
        System.out.println("\tTest case 5");
        numberStudent = 5.0;
        numberTextbook = 4.0;
        cost = -1.0;
        answer = -20;
        expResult = -1;
        result = QuestionControl.calcQuestionAnswerCost(numberStudent, numberTextbook, cost, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 6 -----
        System.out.println("\tTest case 6");
        numberStudent = 0.0;
        numberTextbook = 4.0;
        cost = 50.0;
        answer = 0;
        expResult = 1;
        result = QuestionControl.calcQuestionAnswerCost(numberStudent, numberTextbook, cost, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 7 -----
        System.out.println("\tTest case 7");
        numberStudent = 5.0;
        numberTextbook = 0.0;
        cost = 50.0;
        answer = 0;
        expResult = 1;
        result = QuestionControl.calcQuestionAnswerCost(numberStudent, numberTextbook, cost, answer);
        assertEquals(expResult, result, 0.0001);
        
        // ---- Test Case 8 -----
        System.out.println("\tTest case 8");
        numberStudent = 5.0;
        numberTextbook = 4.0;
        cost = 0.0;
        answer = 0;
        expResult = 1;
        result = QuestionControl.calcQuestionAnswerCost(numberStudent, numberTextbook, cost, answer);
        assertEquals(expResult, result, 0.0001);
    }
   */ 
    
}
