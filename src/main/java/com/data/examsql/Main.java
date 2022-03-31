package com.data.examsql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;

    public void main() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            makeConnection();
            addData("Nodirbekrr", "Ayitbaevtt","nodir5",12345, "Tashkent", "Male");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void addData(String firstname, String lastname, String username, int password, String location, String gender) {
        String insertQueryStatement = "INSERT  INTO  users(firstname, lastname,username,password,location,gender)  VALUES  (?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(insertQueryStatement);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, username);
            preparedStatement.setInt(4, password);
            preparedStatement.setString(5, location);
            preparedStatement.setString(6, gender);

            // execute insert SQL statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void makeConnection() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "1234");
                System.out.println("True");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("False");
            }
        }
    }
