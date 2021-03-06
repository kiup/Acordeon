/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juan
 */
public class ConnectionHandler {
    
    private static String URLBD_STRING = "jdbc:mysql://localhost:3306/";
    private static String NOMBRECONTROLADOR_STRING = "com.mysql.jdbc.Driver";
    private static String USUARIO_STRING = "root";
    private static String CONTRASENIA_STRING = "";
    private static ConnectionHandler instanciaManejadorConexion = null;
    private static Connection conexion;
    
    private ConnectionHandler(){
        
    }
    
    private static void generarInstancia( ){
        instanciaManejadorConexion = new ConnectionHandler( );
    }
    
    public static ConnectionHandler obtenerInstancia( ){
        if( instanciaManejadorConexion == null ){
             generarInstancia( );
        }
        
        return instanciaManejadorConexion;
    }

    public void conectarConBD ( ) throws ClassNotFoundException, SQLException {
        Class.forName( NOMBRECONTROLADOR_STRING );
        conexion=DriverManager.getConnection( URLBD_STRING + "acordeon", USUARIO_STRING, CONTRASENIA_STRING );
    }

    public void desconectarConBD( ) throws SQLException {
        conexion.close( );
    }

    public static Connection obtenerConexion( ) {
        return conexion;
    }
    
    
    
}
