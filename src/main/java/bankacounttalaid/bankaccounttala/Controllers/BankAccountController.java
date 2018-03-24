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
import bankacounttalaid.bankaccounttala.Utils.DateEvaluation;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
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
       
        public static int MaxDepositAmount = 150000;
        public static int MaxDepositPerTransaction = 40000;
        public static int MaxDepositFrequency = 4;
        public int numberOfDeposits = 0;
        
       // public  double t0 = System.currentTimeMillis(); //Variable "t0" stores the initial time when the application was just opened
        @RequestMapping(value="/Balance",method = RequestMethod.GET)            //Endpoint - 
        public String account_Balance( @RequestParam(value="accountNumber") int accountNumber){
            
                Account transaction = new Account(); //create Account Object
                try{
                       return "Your Balance is $ "+transaction.getBalance(accountNumber)+"";
                }catch (SQLException sq)
                        {
                            return "Sorry, unable to get balance: ";
                        }
         }

        @RequestMapping(value="/Deposit",method = RequestMethod.GET)              //Endpoint - 
         public String account_Deposit( @RequestParam(value="accountNumber") int accountNumber,
                                        @RequestParam(value="depositAmount") double depositAmount){
                  
                Account transaction = new Account(); //create Account Object
                try{
                     transaction.deposit(depositAmount, accountNumber);
                     return "You have credited $ "+depositAmount+" to your account"; 
                     
                }catch (SQLException sq)
                    {
                       return "Sorry, unable to deposit, please try again";
                    }
           }
         
         @RequestMapping(value="/Withdrawal",method = RequestMethod.GET)              //Endpoint - 
         public String account_Withdrawal(@RequestParam(value="accountNumber") int accountNumber,
                                          @RequestParam(value="withdrawalAmount") double withdrawalAmount){
             
              Account transaction = new Account(); //create Account Object
              
              try{
                    transaction.withdraw(withdrawalAmount, accountNumber);
                    return "You have withdrawn $ "+withdrawalAmount+" from your account";
                    
              }catch (SQLException sq)
              {
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
