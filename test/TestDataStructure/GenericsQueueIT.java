/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDataStructure;

import dataStructure.GenericsQueue;
import dataStructure.Node;
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
public class GenericsQueueIT {
    
    public GenericsQueueIT() {
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
     * Test of getHead method, of class GenericsQueue.
     */
    @Test
    public void testGetHead() {
        System.out.println("getHead");
        GenericsQueue instance = new GenericsQueue();
        Node expResult = null;
        Node result = instance.getHead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHead method, of class GenericsQueue.
     */
    @Test
    public void testSetHead() {
        System.out.println("setHead");
        GenericsQueue instance = new GenericsQueue();
        instance.setHead(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTail method, of class GenericsQueue.
     */
    @Test
    public void testGetTail() {
        System.out.println("getTail");
        GenericsQueue instance = new GenericsQueue();
        Node expResult = null;
        Node result = instance.getTail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTail method, of class GenericsQueue.
     */
    @Test
    public void testSetTail() {
        System.out.println("setTail");
        GenericsQueue instance = new GenericsQueue();
        instance.setTail(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class GenericsQueue.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        GenericsQueue instance = new GenericsQueue();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSize method, of class GenericsQueue.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        int size = 0;
        GenericsQueue instance = new GenericsQueue();
        instance.setSize(size);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of offer method, of class GenericsQueue.
     */
    @Test
    public void testOffer() {
        System.out.println("offer");
        Object newE = null;
        GenericsQueue instance = new GenericsQueue();
        instance.offer(newE);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class GenericsQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        GenericsQueue instance = new GenericsQueue();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peek method, of class GenericsQueue.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        GenericsQueue instance = new GenericsQueue();
        Object expResult = null;
        Object result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poll method, of class GenericsQueue.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        GenericsQueue instance = new GenericsQueue();
        Object expResult = null;
        Object result = instance.poll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class GenericsQueue.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        GenericsQueue instance = new GenericsQueue();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class GenericsQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        GenericsQueue instance = new GenericsQueue();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
