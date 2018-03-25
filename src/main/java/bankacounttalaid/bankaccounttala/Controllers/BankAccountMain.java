/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankacounttalaid.bankaccounttala.Controllers;

/**
 *
 * @author danial
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/******************************************************************************
* Class: BankAccountMain 
* Methods:  main
* This is the base package and the service starts here
*****************************************************************************/


@SpringBootApplication
public class BankAccountMain {
    
     public double t0 = System.currentTimeMillis(), t1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SpringApplication.run(BankAccountMain.class, args);
    }
    
}
