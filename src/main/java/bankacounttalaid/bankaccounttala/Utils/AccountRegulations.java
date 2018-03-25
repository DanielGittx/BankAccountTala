/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankacounttalaid.bankaccounttala.Utils;


/******************************************************************************
* Class: AccountRegulations 
* Methods:  DepositRules_frequency, DepositRules_maxDepositPerDay, DepositRules_maxDepositPerTransaction
*           WithdrawalRules_frequency,  WithdrawalRules_maxWithdrawalPerDay, WithdrawalRules_maxWithdrawalPerTransaction, WithdrawalRules_WithdrawingMoreThanBalance
* Overview - Inherits members to, t1 from BankAccount class to help determination of time since application launch
****************************************************************************/



import bankacounttalaid.bankaccounttala.Controllers.BankAccountMain;
import bankacounttalaid.bankaccounttala.Models.Account;
import java.sql.SQLException;

/**
 *
 * @author danial
 */
public class AccountRegulations extends BankAccountMain {          
    
     //members init
    
    //deposit
        private static int next_DepositCounter = 0;
        private  double maxDepositAmountPerDay = 0;
        private  double maxDepositPerTransaction = 0;
        private  int depositCounter = 0;
    //withdrawal    
        private static int next_WithdrawalCounter = 0;
        private  double maxWithdrawalAmountPerDay = 0;
        private  double maxWithdrawalPerTransaction = 0;
        private  int withdrawalCounter = 0;
   
    
    //constructor  
    public AccountRegulations( )
    {  
        //deposit limits
        depositCounter = next_DepositCounter;
        next_DepositCounter++;
        maxDepositAmountPerDay = 150000;
        maxDepositPerTransaction = 40000;
        
        //withdrawal limits
        withdrawalCounter = next_WithdrawalCounter;
        next_WithdrawalCounter++;
        maxWithdrawalAmountPerDay = 50000;
        maxWithdrawalPerTransaction = 20000;
        
    }
    
/******************************************************************************
* The methods below (deposits and withdrawala) return boolean value
* True - Breach of Account Rule has occured
* False - Happy state :)
*****************************************************************************/
    
//////////////////////////////deposit rules///////////////////////////////////////////
    public boolean DepositRules_frequency( )
    {
        while(true) {
        if((t1 = System.currentTimeMillis()) - t0 >= 1000 * 60 * 60 * 24) {
        next_DepositCounter = 0;      // unlock deposits after 24 hours
        t0 = t1;
        }
         return (next_DepositCounter > 4);  //Regulation breached (return True)
      }
    }
    
   public boolean DepositRules_maxDepositPerDay(double _depositAmount )
    {
        return (_depositAmount > maxDepositAmountPerDay );  //Regulation breached 
    }
   public boolean DepositRules_maxDepositPerTransaction(double _depositAmount )
    {
        return(_depositAmount > maxDepositPerTransaction );  //Regulation breached 
    }
    
       /////////////////////Withdrawal Rules ///////////////////////////////////////// 
    public boolean WithdrawalRules_frequency( )
    {
        while(true) {
        if((t1 = System.currentTimeMillis()) - t0 >= 1000 * 60 * 60 * 24) {     //
        next_DepositCounter = 0;      // Unlock withdrawals after 24Hours
        t0 = t1;
        }
          return (next_WithdrawalCounter > 3);  //Regulation breached 
      }
    }
    
   public boolean WithdrawalRules_maxWithdrawalPerDay(double _withdrawalAmount )    
    {
        return (_withdrawalAmount > maxWithdrawalAmountPerDay );  //Regulation breached 
    }
   public boolean WithdrawalRules_maxWithdrawalPerTransaction(double _withdrawalAmount )
    {
        return(_withdrawalAmount > maxWithdrawalPerTransaction );  //Regulation breached 
    }
    public boolean WithdrawalRules_WithdrawingMoreThanBalance(double _withdrawalAmount, int accountNumber )throws SQLException
    {
        Account transaction = new Account();
        return(_withdrawalAmount >  transaction.getBalance(accountNumber) );  //Regulation breached 
    }
   
}
