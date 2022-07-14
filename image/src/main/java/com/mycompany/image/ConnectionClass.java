/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.image;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author login
 */
public class ConnectionClass {

    private static ConnectionClass single_instance = null;
    Connection connection;

    private ConnectionClass() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
            if (connection != null) {
                System.out.println("connected");
                String stm = "CREATE TABLE IF NOT EXISTS image (id INT NOT NULL AUTO_INCREMENT, img VARCHAR(255)  ,"
                        + "PRIMARY KEY(id))";
                //String stm2=""
//                String stm1="DROP TABLE students";

                PreparedStatement preparedStatement = connection.prepareStatement(stm);
                preparedStatement.execute();
System.out.println("image table in db  created successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConnectionClass getInstance() {
        if (single_instance == null) {
            single_instance = new ConnectionClass();

        }
        return single_instance;
    }

}

