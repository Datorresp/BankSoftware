/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDataStructure;

import dataStructure.Stack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author diegoa.torres
 */
public class StackIT {
    
    public StackIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object newE = null;
        Stack instance = new Stack();
        instance.push(newE);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Stack instance = new Stack();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of top method, of class Stack.
     */
    @Test
    public void testTop() {
        System.out.println("top");
        Stack instance = new Stack();
        Object expResult = null;
        Object result = instance.top();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        Stack instance = new Stack();
        Object expResult = null;
        Object result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class Stack.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Stack instance = new Stack();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Stack instance = new Stack();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
