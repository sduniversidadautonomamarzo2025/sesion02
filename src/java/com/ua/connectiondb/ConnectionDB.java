/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ua.connectiondb;
import java.sql.*;
/**
 *
 * @author AUTONOMA
 */
public class ConnectionDB {
    private static ConnectionDB instance; //Instancia de Singleton
    private static Connection con; // Connection de la API JDBC
    private static final String URL="jdbc:sqlserver://localhost\\SQLEXPRESS:7777;databaseName=supermercado;Encrypt=True;TrustServerCertificate=True";
    private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USER="usersupermercado";
    private static final String PASSWORD="123456";


    private ConnectionDB(){
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Usuario Conectado correctamente");
        } catch (Exception e) {
            System.out.println("Error al conectar la BD :"+e.getMessage());
            e.printStackTrace();
        } 
    }
    
    public synchronized static ConnectionDB getInstance(){
        if (instance==null) {
            instance= new ConnectionDB();
        }
        return instance;
    }

    public Connection getConnection(){
      return this.con;
    }
    
    public void close(){
      if(instance!=null){
          instance=null;
      }
    }
    
}
