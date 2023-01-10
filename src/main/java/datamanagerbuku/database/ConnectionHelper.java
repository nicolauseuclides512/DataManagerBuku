/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamanagerbuku.database;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nicoe
 */
public class ConnectionHelper {
    private static final String DATABASE_NAME = "rumah_coding";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/"+DATABASE_NAME;
    
    public static Connection getConnection()throws SQLException{
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        return connection;
    }
}
