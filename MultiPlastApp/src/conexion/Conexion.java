/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sebac
 */

    
     
        
    public class Conexion {
        // Datos de conexión
        private static final String URL = "jdbc:mysql://localhost:3306/multiplast";
        private static final String USER = "root";
        private static final String PASSWORD = "";

    // Método para obtener una conexión
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

       
      
    
       

