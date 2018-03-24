/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankacounttalaid.bankaccounttala.Controllers;

/**
 *
 * @author daniel
 * This package has one controller - BankAccountController class
 * 
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bankacounttalaid.bankaccounttala.Models.Account;
import bankacounttalaid.bankaccounttala.Utils.AccountRegulations;
import java.sql.SQLException;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;


/******************************************************************************
* Class: BankAccountController 
* Input: 
* Output:
* Side Effects:
* Overview:
*****************************************************************************/

@RestController
public class BankAccountController {

        @RequestMapping(value="/Balance",method = RequestMethod.GET)            //Endpoint - 
        public String account_Balance( @RequestParam(value="accountNumber") int accountNumber){
            
                Account transaction = new Account(); //create Account Object
                   try{
                       return "Your Balance is $ "+transaction.getBalance(accountNumber)+"";

                }catch ( SQLException ex)           //SQLException
                        {
                            return "Sorry, unable to get balance: ";
                        }
         }

        @RequestMapping(value="/Deposit",method = RequestMethod.GET)              //Endpoint - 
         public String account_Deposit( @RequestParam(value="accountNumber") int accountNumber,
                                        @RequestParam(value="depositAmount") double depositAmount){
             
                AccountRegulations regulations = new AccountRegulations();    //create Object
                Account transaction = new Account();                         //create Account Object
                try{
                 
                      if(regulations.DepositRules_frequency())        // Rule breached!
                         return "Sorry, Exceeded maximum daily deposits";
                      if(regulations.DepositRules_maxDepositPerTransaction(depositAmount)) //Rule Breached!
                         return "Sorry, Deposit amount exceeds maximum allowed for single transaction";
                      if(regulations.DepositRules_maxDepositPerDay(depositAmount)) //Rule Breached!
                         return "Sorry, Deposit amount exceeds maximum allowed in a day";
                      
                    transaction.deposit(depositAmount, accountNumber);   
                    return "You have credited $ "+depositAmount+" to your account"; 
                     
                }catch (SQLException sq)
                    {
                       System.out.println(sq);       //Log Database Exception
                       return "Sorry, unable to deposit, please try again";
                    }
           }
         
         @RequestMapping(value="/Withdrawal",method = RequestMethod.GET)              //Endpoint - 
         public String account_Withdrawal(@RequestParam(value="accountNumber") int accountNumber,
                                          @RequestParam(value="withdrawalAmount") double withdrawalAmount){
             
                AccountRegulations regulations = new AccountRegulations();     //create  Object
                Account transaction = new Account();                           //create  Object 
              
              try{
                 
                      if(regulations.WithdrawalRules_frequency())        // Rule breached!
                         return "Sorry, Exceeded maximum daily withdrawals";
                      if(regulations.WithdrawalRules_maxWithdrawalPerTransaction(withdrawalAmount)) //Rule Breached!
                         return "Sorry, Withdrawal amount exceeds maximum allowed for single transaction";
                      if(regulations.WithdrawalRules_maxWithdrawalPerDay(withdrawalAmount)) //Rule Breached!
                         return "Sorry, Withdrawal amount exceeds maximum allowed in a day";
                      
                    transaction.deposit(withdrawalAmount, accountNumber);   
                    return "You have withdrawn $ "+withdrawalAmount+" from your account"; 
                    
              }catch (SQLException sq)
              {
                  System.out.println(sq);     //Log Database Exception
                  return "Sorry, unable to withdraw, please try again";
              }

         }
              

   @Configuration
   public class ServletConfig {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            container.setPort(8012);          //Set port on runtime
        });
    }
 }
    
}
