/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankacounttalaid.bankaccounttala.Utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danial
 */
public class AccountRegulationsTest extends AccountRegulations{
    
    public AccountRegulationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of DepositRules_frequency method, of class AccountRegulations.
     */
    @Test
    public void testDepositRules_frequency() {
        System.out.println("DepositRules_frequency");
        boolean result = false;    //Happy state :) - default
        boolean expResult = true;  // After iterations below
        
        AccountRegulations instance = new AccountRegulations();
       
         for (int x=0; x<5; x++)
            result = instance.DepositRules_frequency();       //bool result should become true after 4 iterations
        
       assertEquals(expResult, result);
       if(!result)
          fail("DepositRules_frequency method doesnt work as expected");
    }

    /**
     * Test of DepositRules_maxDepositPerDay method, of class AccountRegulations.
     */
    @Test
    public void testDepositRules_maxDepositPerDay() {
        System.out.println("DepositRules_maxDepositPerDay");
        double _depositAmount = 20000000.0;
        AccountRegulations instance = new AccountRegulations();
        boolean expResult = true;
        boolean result = instance.DepositRules_maxDepositPerDay(_depositAmount);
        assertEquals(expResult, result);
        if(!result)
         fail("DepositRules_maxDepositPerDay method doesnt work as expected");
    }

    /**
     * Test of DepositRules_maxDepositPerTransaction method, of class AccountRegulations.
     */
    @Test
    public void testDepositRules_maxDepositPerTransaction() {
        System.out.println("DepositRules_maxDepositPerTransaction");
        double _depositAmount = 20000000.0;
        AccountRegulations instance = new AccountRegulations();
        boolean expResult = true;
        boolean result = instance.DepositRules_maxDepositPerTransaction(_depositAmount);
        assertEquals(expResult, result);
        if(!result)
           fail("testDepositRules_maxDepositPerTransaction method doesnt work as expected.");
    }

    /**
     * Test of WithdrawalRules_frequency method, of class AccountRegulations.
     */
    @Test
    public void testWithdrawalRules_frequency() {
        System.out.println("WithdrawalRules_frequency");
        boolean result = false; //Default - Happy statr :)
        boolean expResult = true;
        AccountRegulations instance = new AccountRegulations();
        
        for (int x=0; x<4; x++)
             result = instance.WithdrawalRules_frequency();
        
        assertEquals(expResult, result);
        
        if (!result)
            fail("WithdrawalRules_frequency() doesnt work as expected");
    }

    /**
     * Test of WithdrawalRules_maxWithdrawalPerDay method, of class AccountRegulations.
     */
    @Test
    public void testWithdrawalRules_maxWithdrawalPerDay() {
        System.out.println("WithdrawalRules_maxWithdrawalPerDay");
        double _withdrawalAmount = 5000000.0;
        AccountRegulations instance = new AccountRegulations();
        boolean expResult = true;
        boolean result = instance.WithdrawalRules_maxWithdrawalPerDay(_withdrawalAmount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result)
           fail("testWithdrawalRules_maxWithdrawalPerDay doesnt work as expected");
        
    }

    /**
     * Test of WithdrawalRules_maxWithdrawalPerTransaction method, of class AccountRegulations.
     */
    @Test
    public void testWithdrawalRules_maxWithdrawalPerTransaction() {
        System.out.println("WithdrawalRules_maxWithdrawalPerTransaction");
        double _withdrawalAmount = 50000000.0;
        AccountRegulations instance = new AccountRegulations();
        boolean expResult = true;
        boolean result = instance.WithdrawalRules_maxWithdrawalPerTransaction(_withdrawalAmount);
        assertEquals(expResult, result);
        
        if(!result)
        fail("WithdrawalRules_maxWithdrawalPerTransaction method doesnt work as expected");
    }

    /**
     * Test of WithdrawalRules_WithdrawingMoreThanBalance method, of class AccountRegulations.
     */
    @Test
    public void testWithdrawalRules_WithdrawingMoreThanBalance() throws Exception {
        System.out.println("WithdrawalRules_WithdrawingMoreThanBalance");
        double _withdrawalAmount = 2000.0;
        int accountNumber = 1; // Balance on account Number 1 is 500 (from Account.class)
        
        
        AccountRegulations instance = new AccountRegulations();
        boolean expResult = true;
        boolean result = instance.WithdrawalRules_WithdrawingMoreThanBalance(_withdrawalAmount, accountNumber);
        assertEquals(expResult, result);
       if(!result)
          fail("WithdrawalRules_WithdrawingMoreThanBalance() method doesnt work as expected");
    }
    
}
