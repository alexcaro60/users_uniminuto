
package model;

import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;


public class Administrator_SQL {
    
    private Connection obj_connection;
    private String user = "root";
    private String passw = "";
    private String url = "jdbc:mysql://localhost:3306";
    private String database = "db_50510";
    
    public boolean connect(){
        try {
            obj_connection = DriverManager.getConnection(url+"/"+database, user, passw);
            //JOptionPane.showMessageDialog(null, "Succesful Connection");
            return true;
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err);
            return false;
        }        
    }
    
    public void register(String name, int id, String date){
        String instruction = "INSERT INTO users (id, fullname, birthday) VALUES ("+id+",'" + name + "', ' " + date + " ')";
        try {
            obj_connection.prepareStatement(instruction).execute();
            JOptionPane.showMessageDialog(null, "User registered");
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err);
        }
    }
    
    public ArrayList<String> consult(){
        String instruction = "SELECT * FROM users";
        ArrayList<String> array_users = new ArrayList<>();
        try {
            ResultSet data_table = obj_connection.prepareStatement(instruction).executeQuery();
            while(data_table.next()) {
                array_users.add(data_table.getString("fullname") + " " + data_table.getInt("id")
                + data_table.getString("birthday"));
            }
            return array_users;
                    
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err);
            return null;
        }                
    }  
}
// CÓDIGO PARA CREAR BASE DE DATOS Y TABLA EN MYSQL
/*
CREATE DATABASE users_form;
USE users_form;

CREATE TABLE users (
	fullname VARCHAR(20) NOT NULL,
        id INT PRIMARY KEY NOT NULL,
        birthday VARCHAR(20) NOT NULL
);

SELECT * FROM users;

INSERT INTO users VALUES("jonier", 2065, "1990-08-05");
*/
