/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankacounttalaid.bankaccounttala.Models;

import bankacounttalaid.bankaccounttala.DataAccess.databaseAccess;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author danial
 */
public class Account {
    
    private double balance; //Only this class can modify balance
    databaseAccess db = new databaseAccess();
    Connection conn =  db.getRemoteConnection();

    public Account ()
    {
       this.balance = 0.0; 
    }
    
    public void deposit(double depositAmount, int accountNumber) throws SQLException{
        db.insertDeposits(conn, depositAmount, accountNumber);
    }
    
    public void withdraw (double withdrawAmount, int accountNumber) throws SQLException{
        db.insertWithdrawals(conn, withdrawAmount, accountNumber);
    }
    
    public double getBalance (int accountNumber) throws SQLException{
        this.balance = db.GetTotalDeposits(conn, accountNumber) - db.GetTotalWithDrawals(conn, accountNumber);
        return balance;
       
    }
    
    
}
