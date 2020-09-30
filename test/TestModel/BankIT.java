/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestModel;

import model.ActiveClient;
import model.Bank;
import model.BankAccount;
import model.Card;
import model.Client;
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
public class BankIT {
    
    public BankIT() {
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
     * Test of openABankAccount method, of class Bank.
     */
    @Test
    public void testOpenABankAccount() throws Exception {
        System.out.println("openABankAccount");
        String clientId = "";
        BankAccount newBA = null;
        Bank instance = new Bank();
        instance.openABankAccount(clientId, newBA);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToBackUp method, of class Bank.
     */
    @Test
    public void testAddToBackUp() throws Exception {
        System.out.println("addToBackUp");
        String clientId = "";
        Bank instance = new Bank();
        instance.addToBackUp(clientId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of undo method, of class Bank.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("undo");
        String clientId = "";
        Bank instance = new Bank();
        instance.undo(clientId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addClient method, of class Bank.
     */
    @Test
    public void testAddClient() {
        System.out.println("addClient");
        ActiveClient newC = null;
        Bank instance = new Bank();
        instance.addClient(newC);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inactivateClient method, of class Bank.
     */
    @Test
    public void testInactivateClient() throws Exception {
        System.out.println("inactivateClient");
        String clientId = "";
        String cause = "";
        Bank instance = new Bank();
        instance.inactivateClient(clientId, cause);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchActiveClient method, of class Bank.
     */
    @Test
    public void testSearchActiveClient() throws Exception {
        System.out.println("searchActiveClient");
        String clientId = "";
        Bank instance = new Bank();
        ActiveClient expResult = null;
        ActiveClient result = instance.searchActiveClient(clientId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToLine method, of class Bank.
     */
    @Test
    public void testAddToLine() throws Exception {
        System.out.println("addToLine");
        String clientId = "";
        Bank instance = new Bank();
        instance.addToLine(clientId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attendLine method, of class Bank.
     */
    @Test
    public void testAttendLine() {
        System.out.println("attendLine");
        Bank instance = new Bank();
        instance.attendLine();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCard method, of class Bank.
     */
    @Test
    public void testAddCard() throws Exception {
        System.out.println("addCard");
        String clientId = "";
        Card newC = null;
        Bank instance = new Bank();
        instance.addCard(clientId, newC);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of heapSortId method, of class Bank.
     */
    @Test
    public void testHeapSortId() {
        System.out.println("heapSortId");
        Client[] c = null;
        Bank instance = new Bank();
        instance.heapSortId(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quickSortPhone method, of class Bank.
     */
    @Test
    public void testQuickSortPhone() {
        System.out.println("quickSortPhone");
        Bank instance = new Bank();
        instance.quickSortPhone();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of qsort method, of class Bank.
     */
    @Test
    public void testQsort() {
        System.out.println("qsort");
        int low = 0;
        int high = 0;
        Bank instance = new Bank();
        instance.qsort(low, high);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCard method, of class Bank.
     */
    @Test
    public void testDeleteCard() throws Exception {
        System.out.println("deleteCard");
        String clientId = "";
        int cardID = 0;
        Bank instance = new Bank();
        instance.deleteCard(clientId, cardID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of payCardCash method, of class Bank.
     */
    @Test
    public void testPayCardCash() throws Exception {
        System.out.println("payCardCash");
        String clientId = "";
        int cardId = 0;
        long amount = 0L;
        Bank instance = new Bank();
        instance.payCardCash(clientId, cardId, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of payCardDebit method, of class Bank.
     */
    @Test
    public void testPayCardDebit() throws Exception {
        System.out.println("payCardDebit");
        String clientId = "";
        int cardId = 0;
        int cardDebitId = 0;
        long amount = 0L;
        Bank instance = new Bank();
        instance.payCardDebit(clientId, cardId, cardDebitId, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdraw method, of class Bank.
     */
    @Test
    public void testWithdraw() throws Exception {
        System.out.println("withdraw");
        String clientId = "";
        int cardId = 0;
        long amount = 0L;
        Bank instance = new Bank();
        instance.withdraw(clientId, cardId, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deposit method, of class Bank.
     */
    @Test
    public void testDeposit() throws Exception {
        System.out.println("deposit");
        String clientId = "";
        int cardId = 0;
        long amount = 0L;
        Bank instance = new Bank();
        instance.deposit(clientId, cardId, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showClientInfo method, of class Bank.
     */
    @Test
    public void testShowClientInfo() {
        System.out.println("showClientInfo");
        Bank instance = new Bank();
        String expResult = "";
        String result = instance.showClientInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showCards method, of class Bank.
     */
    @Test
    public void testShowCards() throws Exception {
        System.out.println("showCards");
        String clientId = "";
        Bank instance = new Bank();
        String expResult = "";
        String result = instance.showCards(clientId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showLineStatus method, of class Bank.
     */
    @Test
    public void testShowLineStatus() {
        System.out.println("showLineStatus");
        Bank instance = new Bank();
        String expResult = "";
        String result = instance.showLineStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
