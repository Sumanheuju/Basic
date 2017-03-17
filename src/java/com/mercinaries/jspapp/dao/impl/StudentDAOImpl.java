/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mercinaries.jspapp.dao.impl;

import com.mercinaries.jspapp.dao.StudentDAO;
import com.mercinaries.jspapp.dbutil.DBConn;
import com.mercinaries.jspapp.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sumanheuju
 */
public class StudentDAOImpl implements StudentDAO{
    private DBConn conn = new DBConn();
    private String sql= null;
    private List<Student> stList = new ArrayList<>();
    @Override
    public boolean insert(Student s) throws ClassNotFoundException, SQLException {
            conn.openConnection();
            sql = "Insert into tbl_student (first_name, last_name,email,contact_no) values (?,?,?,?)";
            
            PreparedStatement stmt = conn.initComponent(sql);
            stmt.setString(1, s.getFirstName());
            stmt.setString(2, s.getLastName());
            stmt.setString(3, s.getEmail());
            stmt.setString(4, s.getContactNo());
            
            int result = conn.executeUpdate();
            
            if(result > 0){
                return true;
            }
            conn.closeConnection();
            return false;
        }

    @Override
    public List<Student> getAll() throws ClassNotFoundException, SQLException {
        conn.openConnection();
        sql = "Select * from tbl_student";
        conn.initComponent(sql);
        
        ResultSet result = conn.executeQuery();
        
        while(result.next()){
            Student st = new Student();
            st.setId(result.getInt("id"));
            st.setFirstName(result.getString("first_name"));
            st.setLastName(result.getString("last_name"));
            st.setEmail(result.getString("email"));
            st.setContactNo(result.getString("contact_no"));
            
            stList.add(st);
        }
        conn.closeConnection();
        return stList;
        }
    
}
