/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser.ConectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import webbrowser.model.Historico;

/**
 *
 * @author andre
 */
public class ClsSQLHistorico implements webbrowser.Interface.InterfaceHistorico {

    //Connection con = new ConexaoMySQL().getConnection();
    //construtor
    public void clsSQLHistorico() {

    }

    @Override
    public void Inserir(Historico historico) throws SQLException {
        Historico his = new Historico();
        his = historico;

        String sql = "insert into historico(dataAcesso,urlAcesso,usuarioAcesso,favoritoAcesso)VALUES(?,?,?,?)";

        try {
            //  Class.forName("com.mysql.cj.jdbc.Driver");
            //  Connection con = DriverManager.getConnection(
            //         "jdbc:mysql://127.0.0.1:3306/webbrowser?useTimezone=true&serverTimezone=UTC",
            //         "root",
            //         "admin");

            Connection con;

            con = new ConexaoMySQL().getConexaoMySQL();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, his.getDataAcesso());
            stmt.setString(2, his.getUrlAcesso());

            stmt.execute(); //executa comando       
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void Excluir(Historico historico) throws SQLException {
        Historico his = new Historico();
        his = historico;

        String sql = "delete from historico where dataAcesso = '" + his.getDataAcesso() + "'      ";
        System.out.println(sql);
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//               "jdbc:mysql://127.0.0.1:3306/webbrowser?useTimezone=true&serverTimezone=UTC",
//               "root",
//               "admin");
            Connection con;

            con = new ConexaoMySQL().getConexaoMySQL();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.execute(); //executa comando       
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Consultar(String SQL) throws SQLException {
        ListaConsulta.aListHistorico.clear();
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                "jdbc:mysql://127.0.0.1:3306/webbrowser?useTimezone=true&serverTimezone=UTC",
//                "root",
//                "admin");
            Connection con;

            con = new ConexaoMySQL().getConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Historico h = new Historico();
                h.setDataAcesso(rs.getString(1));
                System.out.println(rs.getString(1));
                h.setUrlAcesso(rs.getString(2));
                System.out.println(rs.getString(2));
                ListaConsulta.aListHistorico.add(h);
                //System.out.println(rs.getInt(1) + "  " + rs.getString(2));// + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
