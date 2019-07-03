/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser.ConectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class ConexaoMySQL {

    public static String status = "Não conectou...";

    public ConexaoMySQL() {

    }

    public Connection getConexaoMySQL() {

        Connection connection = null;          //atributo do tipo Connection

        try {
            System.out.println("Tentando conectar com Banco de Dados....");
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.cj.jdbc.Driver";//"com.mysql.cj.jdbc.Driver";                        
            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//
            String serverName = "127.0.0.1:3306";
            String mydatabase = "webbrowser";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";      //nome de um usuário de seu BD      
            String password = "root";      //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("....Conexão realizada com sucesso !!!!");
            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;

        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados. getConexaoMySQL");
            return null;
        }
    }

    public Connection getConnection() {
        Connection connection = null;          //atributo do tipo Connection

        try {
            System.out.println("Tentando conectar com Banco de Dados....");
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.cj.jdbc.Driver";//"com.mysql.cj.jdbc.Driver";                        
            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//
            String serverName = "127.0.0.1:3306";
            String mydatabase = "webbrowser";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";        //nome de um usuário de seu BD      
            String password = "root";        //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;

        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.statusConection");
            return null;
        }
    }

    public static String statusConection() {
        return status;

    }

//Método que fecha sua conexão//
//    public static boolean FecharConexao() {
//
//        try {          
//            
//            //ConexaoMySQL.getConexaoMySQL().close();
//
//            return true;
//
//        } catch (SQLException e) {
//
//            return false;
//
//        }
//
//    }
    //Método que reinicia sua conexão//
//    public static java.sql.Connection ReiniciarConexao() {
//
//        FecharConexao();
//
//        return ConexaoMySQL.getConexaoMySQL();
//
//    }
}
