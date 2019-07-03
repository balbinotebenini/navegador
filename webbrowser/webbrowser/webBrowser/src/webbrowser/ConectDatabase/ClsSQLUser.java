/* To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates and open the template in the editor.
 */
package webbrowser.ConectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import webbrowser.Classes.Usuario;

//@author andre /
public class ClsSQLUser implements webbrowser.Interface.InterfaceUsuario {

//Connection con = new ConexaoMySQL().getConnection();
//construtor
    public void clsSQLUser() {

    }

    @Override
    public void Inserir(Usuario u) throws SQLException {
        Usuario x = new Usuario();
        x = u;

        String sql = "insert into usuario(login,senhaLogin)VALUES(?,?)";

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://127.0.0.1:3306/webbrowser?useTimezone=true&serverTimezone=UTC",
//                    "root",
//                    "admin");
            Connection con;

            con = new ConexaoMySQL().getConexaoMySQL();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, x.getLogin());
            stmt.setString(2, x.getSenha());

            stmt.execute(); //executa comando       
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    @Override
    public void Excluir(Usuario u) throws SQLException, ClassNotFoundException {
        Usuario x = new Usuario();
        x = u;

        String sql = "delete from usuario where login = '" + x.getLogin() + "'      ";
        System.out.println(sql);
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://127.0.0.1:3306/webbrowser?useTimezone=true&serverTimezone=UTC",
//                    "root",
//                    "admin");
            Connection con;

            con = new ConexaoMySQL().getConexaoMySQL();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.execute(); //executa comando       
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void Consultar(String SQL) throws SQLException, ClassNotFoundException {
        ListaConsulta.aListUser.clear();
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
                Usuario u = new Usuario();
                u.setLogin(rs.getString(1));
                //System.out.println(rs.getString(1));
                u.setSenha(rs.getString(2));
                //System.out.println(rs.getString(2));
                ListaConsulta.aListUser.add(u);
                //System.out.println(rs.getInt(1) + "  " + rs.getString(2));// + "  " + rs.getString(3));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
