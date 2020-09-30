/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDataStructure;

import dataStructure.Heap;
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
public class HeapIT {
    
    public HeapIT() {
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
     * Test of buildMaxHeap method, of class Heap.
     */
    @Test
    public void testBuildMaxHeap() {
        System.out.println("buildMaxHeap");
        Heap instance = null;
        instance.buildMaxHeap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maxHeapify method, of class Heap.
     */
    @Test
    public void testMaxHeapify() {
        System.out.println("maxHeapify");
        int i = 0;
        int a = 0;
        Heap instance = null;
        instance.maxHeapify(i, a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of swap method, of class Heap.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        int i = 0;
        int j = 0;
        Heap instance = null;
        instance.swap(i, j);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exists method, of class Heap.
     */
    @Test
    public void testExists() {
        System.out.println("exists");
        int i = 0;
        Heap instance = null;
        boolean expResult = false;
        boolean result = instance.exists(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of heapSort method, of class Heap.
     */
    @Test
    public void testHeapSort() {
        System.out.println("heapSort");
        Heap instance = null;
        instance.heapSort();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of right method, of class Heap.
     */
    @Test
    public void testRight() {
        System.out.println("right");
        int i = 0;
        Heap instance = null;
        int expResult = 0;
        int result = instance.right(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of left method, of class Heap.
     */
    @Test
    public void testLeft() {
        System.out.println("left");
        int i = 0;
        Heap instance = null;
        int expResult = 0;
        int result = instance.left(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parent method, of class Heap.
     */
    @Test
    public void testParent() {
        System.out.println("parent");
        int i = 0;
        Heap instance = null;
        int expResult = 0;
        int result = instance.parent(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArray method, of class Heap.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        Heap instance = null;
        Comparable[] expResult = null;
        Comparable[] result = instance.getArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArray method, of class Heap.
     */
    @Test
    public void testSetArray() {
        System.out.println("setArray");
        Comparable[] array = null;
        Heap instance = null;
        instance.setArray(array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArraySize method, of class Heap.
     */
    @Test
    public void testGetArraySize() {
        System.out.println("getArraySize");
        Heap instance = null;
        int expResult = 0;
        int result = instance.getArraySize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArraySize method, of class Heap.
     */
    @Test
    public void testSetArraySize() {
        System.out.println("setArraySize");
        int arraySize = 0;
        Heap instance = null;
        instance.setArraySize(arraySize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeapSize method, of class Heap.
     */
    @Test
    public void testGetHeapSize() {
        System.out.println("getHeapSize");
        Heap instance = null;
        int expResult = 0;
        int result = instance.getHeapSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeapSize method, of class Heap.
     */
    @Test
    public void testSetHeapSize() {
        System.out.println("setHeapSize");
        int heapSize = 0;
        Heap instance = null;
        instance.setHeapSize(heapSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
