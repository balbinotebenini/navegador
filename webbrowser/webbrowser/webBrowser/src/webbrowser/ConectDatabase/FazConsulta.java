/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser.ConectDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import webbrowser.model.Historico;

/**
 *
 * @author andre
 */
public class FazConsulta {

    public void fazConsultaSQL(String SQL) throws SQLException {
        ListaConsulta.aListHistorico.clear();
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://127.0.0.1:3306/webbrowser?useTimezone=true&serverTimezone=UTC",
//                    "root",
//                    "admin");
            Connection con;
            con = new ConexaoMySQL().getConexaoMySQL();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Historico h = new Historico();
                h.setDataAcesso(rs.getString(2));
                System.out.println(rs.getString(2));
                h.setUrlAcesso(rs.getString(3));
                System.out.println(rs.getString(3));
                ListaConsulta.aListHistorico.add(h);
                //System.out.println(rs.getInt(1) + "  " + rs.getString(2));// + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void fazConsultaFavoritoSQL(String SQL) throws SQLException {
        ListaConsulta.aListFavorito.clear();
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://127.0.0.1:3306/webbrowser?useTimezone=true&serverTimezone=UTC",
//                    "root",
//                    "admin");
            Connection con;
            con = new ConexaoMySQL().getConexaoMySQL();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                ListaConsulta.aListFavorito.add(rs.getString(1));//
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
