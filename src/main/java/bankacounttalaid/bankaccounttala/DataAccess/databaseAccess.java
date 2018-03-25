/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankacounttalaid.bankaccounttala.DataAccess;


/******************************************************************************
* Class:- databaseAccess 
* Methods:- getRemoteConnection, insertDeposits, insertWithdrawals, GetTotalDeposits, GetTotalWithdrawals
* Overview:- get database connections and perform database operations
*****************************************************************************/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author danial
 */
public class databaseAccess {
    
    
    
    public static Connection getRemoteConnection() {
      try {
      Class.forName("com.mysql.jdbc.Driver");
      String jdbcUrl = "jdbc:mysql://localhost:3306/BankTala?user=root&password=mobimobi1234*#";
      Connection con = DriverManager.getConnection(jdbcUrl);
      System.out.println ("Remote connection successful............");

      return con;
    }
    catch (ClassNotFoundException e) {System.out.println (e.toString()); return null;}
    catch (SQLException e) { System.out.println (e.toString()); return null;}
   }
    
   public void insertDeposits (Connection conn, double deposits, int accountNumber) throws SQLException
   {
            String sql = "INSERT INTO Transactions (deposits,accountNumber) VALUES(?,?)";
 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,deposits);
            pstmt.setInt(2,accountNumber);
            
            pstmt.executeUpdate();
   }

   public void insertWithdrawals (Connection conn, double withdrawal, int accountNumber) throws SQLException
   {
            String sql = "INSERT INTO Transactions (withdrawals,accountNumber) VALUES(?,?)";
 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,withdrawal);
            pstmt.setInt(2,accountNumber);
            
            pstmt.executeUpdate();
   }
  
  public double GetTotalDeposits (Connection conn, int accountNumber) throws SQLException
   {
            double totalDeposits = 0;
            String sql = "SELECT SUM(deposits) FROM Transactions WHERE accountNumber = '"+accountNumber+"' ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeQuery();
            
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
              double Deposits = res.getDouble(1);
              totalDeposits = totalDeposits + Deposits;
            }
           return totalDeposits;
      
   }
  
    public double GetTotalWithDrawals (Connection conn, int accountNumber) throws SQLException
   {
            double totalWithdrawals = 0;
            String sql = "SELECT SUM(withdrawals) FROM Transactions WHERE accountNumber = '"+accountNumber+"' ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeQuery();
            
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
              double Withdrawals = res.getDouble(1);
              totalWithdrawals = totalWithdrawals + Withdrawals;
            }
           return totalWithdrawals;
      
   }

}
