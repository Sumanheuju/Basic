/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mercinaries.jspapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sumanheuju
 */
public class DBConn {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    public void openConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/tbl_ecom", "root", "");
    }
    
    public PreparedStatement initComponent(String sql) throws SQLException{
        stmt = conn.prepareStatement(sql);
        return stmt;
    }
    
    public int executeUpdate() throws SQLException{
        return stmt.executeUpdate();
    }
    
    public ResultSet executeQuery() throws SQLException{
        return stmt.executeQuery();
    }
    
    public void closeConnection() throws SQLException {
        if(conn!=null && !conn.isClosed()){
            conn.close();
            conn= null;
        }
    }
}
