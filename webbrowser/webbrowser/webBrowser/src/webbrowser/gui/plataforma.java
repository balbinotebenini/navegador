/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser.gui;

import webbrowser.model.TabHistorico;
import webbrowser.model.tab;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import webbrowser.Classes.Usuario;
import webbrowser.ConectDatabase.ClsSQLUser;
import webbrowser.ConectDatabase.ListaConsulta;
import webbrowser.model.ButtonTabComponent;
import webbrowser.model.HistoricoTableModel;
import webbrowser.model.TabFavorito;
import webbrowser.model.tabLink;

/**
 *
 * @author andre
 */
public class plataforma extends javax.swing.JFrame {

    private Object displayEditorPane;
    HistoricoTableModel HistoricoTable = new HistoricoTableModel();

    public plataforma() {
        initComponents();
        //jTableHistorico.setModel(HistoricoTable);
        jButtonAddTab.doClick();
        webbrowser.Classes.UsuarioLogado.setUsuarioLogado("default");
        mostraUsuarioLogado(webbrowser.Classes.UsuarioLogado.getUsuarioLogado());
    }

    public void mostraUsuarioLogado(String UsuarioLog) {
        jTextFieldUsuarioLogado.setText(webbrowser.Classes.UsuarioLogado.getUsuarioLogado());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAddTab = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        BotaoLogin = new javax.swing.JButton();
        jTextFieldUsuarioLogado = new javax.swing.JTextField();
        jButtonFavorito = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAddTab.setText("Nova Aba");
        jButtonAddTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTabActionPerformed(evt);
            }
        });

        jButton1.setText("Histórico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BotaoLogin.setText("Login");
        BotaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoLoginActionPerformed(evt);
            }
        });

        jTextFieldUsuarioLogado.setEditable(false);
        jTextFieldUsuarioLogado.setEnabled(false);
        jTextFieldUsuarioLogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioLogadoActionPerformed(evt);
            }
        });

        jButtonFavorito.setText("Favoritos");
        jButtonFavorito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFavoritoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFavorito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                        .addComponent(jTextFieldUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddTab, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddTab, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(BotaoLogin)
                    .addComponent(jTextFieldUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFavorito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTabActionPerformed

        try {
            tab t = new tab();

            createTabPanel(t, visibleTabPanels.size());
            jTabbedPane1.setSelectedIndex(visibleTabPanels.size() - 1);
        } catch (IndexOutOfBoundsException ex) {
            //showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButtonAddTabActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            TabHistorico th;
            th = new TabHistorico();
            createTabPanelHistorico(th, visibleTabPanels.size());
            jTabbedPane1.setSelectedIndex(visibleTabPanels.size() - 1);

        } catch (Exception e) {
            //Logger.getLogger(plataforma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoLoginActionPerformed
        JTextField usuario = new JTextField();
        JTextField senha = new JPasswordField();
        Object[] message = {
            "Usuário:", usuario,
            "Senha:", senha
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String sql = "SELECT * FROM USUARIO where login = '" + usuario.getText() + "'";
            ClsSQLUser c = new ClsSQLUser();
            Usuario u = new Usuario();
            try {
                c.Consultar(sql);
                if (ListaConsulta.aListUser.size() > 0) {
                    u = ListaConsulta.aListUser.get(0);
                }
            } catch (SQLException ex) {
                Logger.getLogger(plataforma.class.getName()).log(Level.SEVERE, null, ex);
                showMessageDialog(null, "Banco de dados está corrompido");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(plataforma.class.getName()).log(Level.SEVERE, null, ex);
                showMessageDialog(null, "Você não está conectado ao banco (ver Driver)");
            } catch (IndexOutOfBoundsException ex) {
                Logger.getLogger(plataforma.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (usuario.getText().equals(u.getLogin()) && senha.getText().equals(u.getSenha())) {
                webbrowser.Classes.UsuarioLogado.setUsuarioLogado(u.getLogin());
                webbrowser.Classes.UsuarioLogado.getUsuarioLogado();
                mostraUsuarioLogado(webbrowser.Classes.UsuarioLogado.getUsuarioLogado());
                showMessageDialog(null, "Você está logado!");
                //System.out.println(webbrowser.Classes.UsuarioLogado.getUsuarioLogado());
            } else {
                showMessageDialog(null, "Usuário ou Senha inválidos, tente novamente!");
            }
        }
    }//GEN-LAST:event_BotaoLoginActionPerformed

    private void jTextFieldUsuarioLogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioLogadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuarioLogadoActionPerformed

    private void jButtonFavoritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFavoritoActionPerformed
        try {
            if (webbrowser.Classes.UsuarioLogado.getUsuarioLogado().equals("default")) {
                showMessageDialog(null, "Você precisa estar Logado abrir a aba Favoritos");
            } else {
                TabFavorito tf;
                tf = new TabFavorito();
                createTabPanelFavorito(tf, visibleTabPanels.size());
                jTabbedPane1.setSelectedIndex(visibleTabPanels.size() - 1);
            }
        } catch (Exception e) {
            //Logger.getLogger(plataforma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFavoritoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new plataforma().setVisible(true);
            }
        });
    }

    public static void carregaTAbComLink() {
        tabLink t = new tabLink();
        createTabPanel(t, visibleTabPanels.size() - 1);
        try {
            jTabbedPane1.setSelectedIndex(visibleTabPanels.size() - 1);
        } catch (IndexOutOfBoundsException ex) {

        }
    }

    public static void createTabPanel(JPanel _newPanel, int _i) {
        visibleTabPanels.add(_newPanel);
        jTabbedPane1.addTab("Tab" + visibleTabPanels.size(), _newPanel);
        jTabbedPane1.setSelectedComponent(_newPanel);
        int i = jTabbedPane1.getSelectedIndex();
        jTabbedPane1.setTabComponentAt(i, new ButtonTabComponent(jTabbedPane1));
    }

    public void createTabPanelHistorico(JPanel _newPanel, int _i) {
        visibleTabPanels.add(_newPanel);
        jTabbedPane1.addTab("Historico", _newPanel);
        jTabbedPane1.setSelectedComponent(_newPanel);
        int i = jTabbedPane1.getSelectedIndex();
        jTabbedPane1.setTabComponentAt(i, new ButtonTabComponent(jTabbedPane1));
    }

    public void createTabPanelFavorito(JPanel _newPanel, int _i) {
        visibleTabPanels.add(_newPanel);
        jTabbedPane1.addTab("Favoritos", _newPanel);
        jTabbedPane1.setSelectedComponent(_newPanel);
        int i = jTabbedPane1.getSelectedIndex();
        jTabbedPane1.setTabComponentAt(i, new ButtonTabComponent(jTabbedPane1));
    }

    public void createCloseButton(final JPanel _c, Integer _pos) {
        java.awt.FlowLayout f = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTabbedPane1.remove(_c);
                visibleTabPanels.remove(_c);
                hiddenTabPanels.add(_c);
            }
        };
    }

    public void RemoveSelectedTab(int x, int y) {

        jTabbedPane1.removeTabAt(jTabbedPane1.indexAtLocation(x, y));
        visibleTabPanels.remove(jTabbedPane1.getSelectedIndex());
    }

    public void setFocusOnTab(int _i) {
        jTabbedPane1.setSelectedIndex(_i);
    }

    public static List<JPanel> visibleTabPanels = new ArrayList<JPanel>();
    public static List<JPanel> hiddenTabPanels = new ArrayList<JPanel>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAddTab;
    private javax.swing.JButton jButtonFavorito;
    private static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldUsuarioLogado;
    // End of variables declaration//GEN-END:variables
}
