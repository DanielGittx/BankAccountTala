/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankacounttalaid.bankaccounttala.Utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import java.time.temporal.ChronoUnit;
import java.util.Timer;
import org.joda.time.DateTime;
import bankacounttalaid.bankaccounttala.Controllers.BankAccountController;
import static bankacounttalaid.bankaccounttala.Controllers.BankAccountController.MaxDepositFrequency;

/**
 *
 * @author danial
 */
public class DateEvaluation  {
    
     public  double t0 = System.currentTimeMillis(); //Variable "t0" stores the initial time when the application was just opened
     public int numberOfDeposits;
     
     public DateEvaluation()
     {
         numberOfDeposits = numberOfDeposits++;
     }
     
     
    public String evaluation ( String typeOfService)
    {
        //this.BankContr = BankContr;
     
           

        // currentTimeMillis - returns the current time in milliseconds (as a difference between the actual moment and the 1st of January of 1960
       // double t0 = System.currentTimeMillis(); //Variable "t0" stores the initial time when the application was just opened
        double t1;                              //Variable "t1" updates its time value during the workflow of the application
        //double diff =0;
        //while(true) {
          //if((t1 = System.currentTimeMillis()) - t0 >= 1000 * 60 * 60 * 24) {    //converting 24 hours (1 Day) to milliseconds
             
           if (numberOfDeposits > 200 /*MaxDepositFrequency*/ )
           {
            switch (typeOfService)
               {
                case "Deposits":
                      return "Sorry, Today's maximum Frequency of making deposits reached! "+numberOfDeposits+"";
                case "Withdrawal":
                      return "Sorry, Today's maximum Frequency of making withdrawals reached! "+numberOfDeposits+"";
      
            }
           }
           
           while(true) {
              t1 = System.currentTimeMillis();
            
              System.out.println (  "EvaluateDiff:t1:t2:diff "+numberOfDeposits+"------"+t0+"------"+t1+"------"+(t1-t0)+"");
              
            if((t1-t0) >= 20000) { 
               
                 numberOfDeposits = 0;
                  System.out.println (  "Reset:t1:t2:diff "+numberOfDeposits+"------"+t0+"------"+t1+"------"+(t1-t0)+"");
                 t0=t1;
                //return "Reset:t1:t2:diff "+DateEvaluation.numberOfDeposits+"------"+t0+"------"+t1+"------"+(t1-t0)+"";
            
            }
            
            
            return "Your deposits for today! "+numberOfDeposits+"";
    }

    }
    
    
}
        //DateEvaluation de = new DateEvaluation();
              //Joda
        //DateTime today = new DateTime().withTimeAtStartOfDay();           // Start of day today - midnight
        //DateTime tomorrow = today.plusDays(1).withTimeAtStartOfDay();     // Start of day tomorrow - midnight