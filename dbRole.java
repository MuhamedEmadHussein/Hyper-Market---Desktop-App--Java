/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Solimna Sore
 */
public class dbRole {
       String nameRole="";
         int role=0;
         DatabaseConnection DB;
    public int getRole(String name) throws SQLException{
            DB=new DatabaseConnection("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/market","root","");
            String sql="select name from role'"+name+"'";
             ResultSet rs = DB.s.executeQuery(sql);
             while(rs.next())
             {
                 nameRole=rs.getString("name");
             }
            switch(nameRole)
            {
                case "admin":
                    role=1;
                    break;
                case "marketing":
                    role=2;
                    break;
                case "seller":
                    role=3;
                    break;
                case "inventory":
                    role=4;
                    break;    
            }
             return role; 
        } 
       
       
    }
    

