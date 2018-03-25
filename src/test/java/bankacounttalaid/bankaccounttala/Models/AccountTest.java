/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankacounttalaid.bankaccounttala.Models;

import java.sql.SQLException;
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

/*

Make a deposit of 1000 then withdraw 500
Expected balance should be 500 on account number 1. 

Just one sample - Should be many :)
*/


public class AccountTest extends Account {
    
    public AccountTest() {
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
     * Test of deposit method, of class Account.
     */
    @Test
    public void testDeposit()  {
        System.out.println("deposit");
        double depositAmount = 1000.0;
        int accountNumber = 1;
        Account instance = new Account();
        try{
            instance.deposit(depositAmount, accountNumber);
            System.out.println("Deposit successful");
        }catch (SQLException sq)
        {
             fail("Database failure: Unable to deposit: "+sq+"");
        }
       
    }

    /**
     * Test of withdraw method, of class Account.
     */
    @Test
    public void testWithdraw()  {
        System.out.println("withdraw");
        double withdrawAmount = 500.0;
        int accountNumber = 1;
        Account instance = new Account();
        try{
            instance.deposit(withdrawAmount, accountNumber);
             System.out.println("withdraw successful");
        }catch (SQLException sq)
        {
             fail("Database failure: Unable to withdraw: "+sq+"");
        }
    }

    /**
     * Test of getBalance method, of class Account.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        int accountNumber = 1;
        Account instance = new Account();
        double expResult = 500.0;
        try{
        double result = instance.getBalance(accountNumber);
         assertEquals(expResult, result, 0.0);
         System.out.println("get balance successful");
        }catch (SQLException sq)
        {
           fail(" Database Error: "+sq+"");
        }

    }
    
}
