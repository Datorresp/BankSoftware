/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDataStructure;

import dataStructure.HashTable;
import dataStructure.NodeH;
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
public class HashTableIT {
    
    public HashTableIT() {
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
     * Test of hashFunction method, of class HashTable.
     */
    @Test
    public void testHashFunction() {
        System.out.println("hashFunction");
        Object key = null;
        HashTable instance = new HashTable();
        int expResult = 0;
        int result = instance.hashFunction(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNode method, of class HashTable.
     */
    @Test
    public void testGetNode() {
        System.out.println("getNode");
        HashTable instance = new HashTable();
        NodeH[] expResult = null;
        NodeH[] result = instance.getNode();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNode method, of class HashTable.
     */
    @Test
    public void testSetNode() {
        System.out.println("setNode");
        NodeH[] node = null;
        HashTable instance = new HashTable();
        instance.setNode(node);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class HashTable.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Object key = null;
        HashTable instance = new HashTable();
        Object expResult = null;
        Object result = instance.search(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class HashTable.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Object key = null;
        Object value = null;
        HashTable instance = new HashTable();
        instance.insert(key, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class HashTable.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Object key = null;
        HashTable instance = new HashTable();
        instance.delete(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
