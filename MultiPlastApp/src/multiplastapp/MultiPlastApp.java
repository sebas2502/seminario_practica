/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multiplastapp;
import java.sql.Connection;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author sebac
 */
public class MultiPlastApp {

   public static void conectarDB(){
       try(
               Connection conn = Conexion.obtenerConexion();
              
               ){
               if(conn.isValid(2)){
                   
                  System.out.println("Conectado a base de datos...");
               
               }else{
                   System.out.println("No se pudo conectar a db...");
               }
       }catch(Exception e){
       System.out.println("Error en la conexion");
       System.out.println("Error : " + e);
       }
   };
    
 
    public static void main(String[] args) {
        
       conectarDB();
        
    }
    
}
