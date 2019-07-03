/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser.Interface;

import java.sql.SQLException;
import webbrowser.Classes.Usuario;

/**
 *
 * @author BalbiNOTE
 */
public interface InterfaceUsuario {

    public void Inserir(Usuario u) throws SQLException, ClassNotFoundException;

    public void Excluir(Usuario u) throws SQLException, ClassNotFoundException;

    public void Consultar(String SQL) throws SQLException, ClassNotFoundException;

}
