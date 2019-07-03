/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates and open the template in the editor.
 */
package webbrowser.ConectDatabase;

import java.util.ArrayList;
import webbrowser.Classes.Usuario;
import webbrowser.model.Historico;

//@author andre /
public class ListaConsulta {

    public Historico historico = new Historico();

    public static ArrayList<Historico> aListHistorico = new ArrayList<>();

    public void PrintListHistorico(ArrayList<Historico> P) {
        for (int i = 0; i < P.size(); i++) {
            // P.getPos(i);
            System.out.println(P.get(i).getDataAcesso() + " " + P.get(i).getUrlAcesso());
        }
        System.out.println("");
    }
    public Usuario x = new Usuario();

    public static ArrayList<Usuario> aListUser = new ArrayList<>();

    public void PrintListUser(ArrayList<Usuario> Q) {
        for (int i = 0; i < Q.size(); i++) {
            // P.getPos(i);
            System.out.println(Q.get(i).getLogin() + " " + Q.get(i).getSenha());
        }
        System.out.println("");
    }

    public static ArrayList<String> aListFavorito = new ArrayList<>();

    public void PrintListFavorito(ArrayList<String> Q) {
        for (int i = 0; i < Q.size(); i++) {
            // P.getPos(i);
            System.out.println(Q.get(i));
        }
    }
}
