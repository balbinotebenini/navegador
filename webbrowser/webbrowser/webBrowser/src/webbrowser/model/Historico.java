/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;
import webbrowser.ConectDatabase.ConexaoMySQL;

/**
 *
 * @author andre
 */
public class Historico implements Comparable<Historico> {

    private String urlAcesso;
    private String dataAcesso;
    private String loginAcesso;
    private boolean favorito;

    @Override
    public int compareTo(Historico o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUrlAcesso() {
        return urlAcesso;
    }

    public void setUrlAcesso(String urlAcesso) {
        this.urlAcesso = urlAcesso;
    }

    public String getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(String dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    //salva no historico  - ta ok esse metodo
    public void salvaNoHistorico(String data, String UrlDigitada, String usuarioLogado, Boolean favorito) {
        Connection con;

        con = new ConexaoMySQL().getConexaoMySQL();
        if (con == null) {
            System.out.println("con = null");
        }
        String sql = "insert into historico(dataAcesso,urlAcesso,usuarioAcesso,favoritoAcesso)VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, data);
            stmt.setString(2, UrlDigitada);
            stmt.setString(3, usuarioLogado);
            stmt.setBoolean(4, favorito);

            stmt.execute(); //executa comando       
            stmt.close();
            con.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void salvaFavorito(String data, String UrlDigitada, String usuarioLogado, Boolean favorito) {
        Connection con;

        con = new ConexaoMySQL().getConexaoMySQL();
        if (con == null) {
            System.out.println("con = null");
        }

        String sql1 = "SET SQL_SAFE_UPDATES=0; ";
        String sql2 = "update historico set favoritoAcesso = true "
                + "where usuarioAcesso = '" + usuarioLogado + "' "
                + "and urlAcesso = '" + UrlDigitada + "'";

        try {
            PreparedStatement stmt = con.prepareStatement(sql1);
            stmt.execute(); //executa comando       
            stmt = con.prepareStatement(sql2);
            stmt.execute(); //executa comando       

            stmt.close();
            con.close();
            showMessageDialog(null, "" + UrlDigitada + " inclusida com sucesso nos favoritos");

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void RemoveFavoritoSelecionado(String UrlDigitada, String usuarioLogado) {
        Connection con;

        con = new ConexaoMySQL().getConexaoMySQL();
        if (con == null) {
            System.out.println("con = null");
        }

        String sql1 = "SET SQL_SAFE_UPDATES=0; ";
        String sql2 = "update historico set favoritoAcesso = false "
                + "where usuarioAcesso = '" + usuarioLogado + "' "
                + "and urlAcesso = '" + UrlDigitada + "'";

        try {
            PreparedStatement stmt = con.prepareStatement(sql1);
            stmt.execute(); //executa comando       
            stmt = con.prepareStatement(sql2);
            stmt.execute(); //executa comando       

            stmt.close();
            con.close();
            showMessageDialog(null, "" + UrlDigitada + " Excluida com sucesso nos favoritos");

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void RemoveFavoritoTodos(String usuarioLogado) {
        Connection con;

        con = new ConexaoMySQL().getConnection();
        if (con == null) {
            System.out.println("con = null");
        }

        String sql1 = "SET SQL_SAFE_UPDATES=0; ";
        String sql2 = "update historico set favoritoAcesso = false "
                + "where usuarioAcesso = '" + usuarioLogado + "' ";

        try {
            PreparedStatement stmt = con.prepareStatement(sql1);
            stmt.execute(); //executa comando       
            stmt = con.prepareStatement(sql2);
            stmt.execute(); //executa comando       

            stmt.close();
            con.close();
            showMessageDialog(null, "Excluido TODOS os favoritos com sucesso");

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public String getLoginAcesso() {
        return loginAcesso;
    }

    public void setLoginAcesso(String loginAcesso) {
        this.loginAcesso = loginAcesso;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
