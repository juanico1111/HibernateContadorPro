package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Registro {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/contadorpro";
    
    private Connection connection;
    private Statement statement;

    public Registro() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            this.statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param username   el nombre de usuario
     * @param password   la contraseña del usuario
     * @param role       el rol del usuario (contador o cliente)
     */
    public void insertUser(String username, String password, String role) {
        String query = "INSERT INTO USUARIO(USERNAME, USERPASSWORD, ROLE) VALUES('" + username + "', '" + password + "', '" + role + "')";
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Registro userReg = new Registro();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Registro de Usuario");
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();
        
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        
        System.out.print("Confirme la contraseña: ");
        String confirmPassword = scanner.nextLine();
        
        if (!password.equals(confirmPassword)) {
            System.out.println("Las contraseñas no coinciden.");
            return;
        }
        
        System.out.print("Elija rol (contador/cliente): ");
        String role = scanner.nextLine();
        
        if (!role.equalsIgnoreCase("contador") && !role.equalsIgnoreCase("cliente")) {
            System.out.println("Rol no válido.");
            return;
        }
        
        userReg.insertUser(username, password, role);
        System.out.println("Usuario registrado exitosamente.");
        
        scanner.close();
    }
}