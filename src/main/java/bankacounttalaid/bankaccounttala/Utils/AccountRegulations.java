/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankacounttalaid.bankaccounttala.Utils;

/**
 *
 * @author danial
 */
public class AccountRegulations {
    
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
    
    /////////////////////Deposit Rules /////////////////////////////////////////
    public boolean DepositRules_frequency( )
    {
       return (next_DepositCounter > 4);  //Regulation breached 
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
       return (next_WithdrawalCounter > 3);  //Regulation breached 
    }
    
   public boolean WithdrawalRules_maxWithdrawalPerDay(double _withdrawalAmount )
    {
        return (_withdrawalAmount > maxWithdrawalAmountPerDay );  //Regulation breached 
    }
   public boolean WithdrawalRules_maxWithdrawalPerTransaction(double _withdrawalAmount )
    {
        return(_withdrawalAmount > maxWithdrawalPerTransaction );  //Regulation breached 
    }

    
}
