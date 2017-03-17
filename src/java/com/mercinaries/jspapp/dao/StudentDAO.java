/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mercinaries.jspapp.dao;

import com.mercinaries.jspapp.entity.Student;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sumanheuju
 */
public interface StudentDAO {
    boolean insert(Student s)throws ClassNotFoundException, SQLException;
    List<Student> getAll() throws ClassNotFoundException, SQLException;
}
