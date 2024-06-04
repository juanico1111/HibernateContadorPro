/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package contadorpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para gestionar operaciones de base de datos en la aplicación ContadorPro.
 */
public class ContadorPro {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/contadorpro";
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    public ContadorPro() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            this.statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ContadorPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param username   el nombre de usuario
     * @param password   la contraseña del usuario
     */
    public void insertUser(String username, String password) {
        String query = "INSERT INTO USUARIO(USERNAME, USERPASSWORD) VALUES('" + username + "', '" + password + "')";
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ContadorPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Consulta y muestra todos los usuarios en la base de datos.
     */
    public void queryUsers() {
        String query = "SELECT * FROM USUARIO";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("userid") + " : " + resultSet.getString("username"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContadorPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Actualiza la información de un usuario en la base de datos.
     *
     * @param userId      el ID del usuario
     * @param newUsername el nuevo nombre de usuario
     * @param newPassword la nueva contraseña del usuario
     */
    public void updateUser(int userId, String newUsername, String newPassword) {
        String query = "UPDATE USUARIO SET USERNAME = '" + newUsername + "', USERPASSWORD = '" + newPassword + "' WHERE USERID = " + userId;
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ContadorPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param userId el ID del usuario
     */
    public void deleteUser(int userId) {
        String query = "DELETE FROM USUARIO WHERE USERID = " + userId;
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ContadorPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        ContadorPro dbManager = new ContadorPro();
        
        dbManager.insertUser("Juan11", "Elnico");
        
        dbManager.queryUsers();
        
        dbManager.updateUser(1, "NEWUSER", "NEWPASS123");
        
        dbManager.deleteUser(1);
        
        dbManager.queryUsers();
    }
}