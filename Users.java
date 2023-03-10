/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import static java.lang.System.exit;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Solimna Sore
 */
 class Users{

    DatabaseConnection DB;
    private String username;
    private String password;
    private int id;
    private int age;
    private String address;
    private int role;
    private int id_cust;
    private String prod_name;
    private Date date;
    private int quantity;
    private int total_bill;

    public Users() {
        DB=new DatabaseConnection("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/market","root","");
    }

    public Users(String username, String password, int id,int role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role=role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username,int id) {
        this.username = username;
    }

    public void setpassword(String password,int id) {
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getpassword() {
        return this.password;
    }

    public boolean login(String username, String password) throws SQLException {
        int count = 0;
        String sql = "select count(1) from users where username='" + username + "' and password='" + password + "'";
        ResultSet rs = DB.s.executeQuery(sql);
        while (rs.next()) {
            count = rs.getInt("count(1)");
        }
        if (count == 1) {
            return true;
        }
        return false;
    }

    public void LogOut() {
        System.exit(0);
    }
    int Update(String username,int age,String address,int role, String password,int id) throws SQLException{
       // if(this.login(username,password)==true)
        //{
            String sql="update users set username='"+username+"',Password='"+password+"',address='"+address+"',age='"+age+"',role='"+role+"' where id='"+id+"'";
            int result =DB.s.executeUpdate(sql);
             return result;
    }

    public int getAge() {
        return this.age;
    }

    public String getAddress() {
        return this.address;
    }
    public void showAllActions(int id_cust) throws SQLException
    {
        
           String sql="select * from orders where id_cust='"+id_cust+"'"; 
           ResultSet rs = DB.s.executeQuery(sql);
           while(rs.next())
           {
              id= rs.getInt("id");
              id_cust=rs.getInt("id_cust");
              String prod_name=rs.getString("prod_name");
              quantity= rs.getInt("quantity");
              total_bill =rs.getInt("total_bill");
              date=rs.getDate("date");
           }
           //System.out.format("%s, %s, %s, %s, %s, %s\n", id, id_cust, prod_name, quantity, total_bill, date);
          
        
    }
    public int delete(int id) throws SQLException
    {     
            String sql="delete from users where id='"+id+"'";
            int result =DB.s.executeUpdate(sql);
           
            return result;
    }
    public int addData(String username,int age,String address,int role, String password,int id) throws SQLException{
         String sql="insert into users(id,username,address,age,role,password) values('"+id+"','"+username+"','"+age+"','"+address+"','"+role+"','"+password+"')";
         int result=DB.s.executeUpdate(sql);
         return result;
    }
    

   

}
