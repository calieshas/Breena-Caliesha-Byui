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
    
}