/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mandregr
 */
public class FavoritoTableModel extends AbstractTableModel {

    private List<String> DadosFavorito = new ArrayList<>();
    private String[] colunas = {"Url Favorita"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return DadosFavorito.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return DadosFavorito.get(linha).toString();
        }
        return null;
    }

    public String getColunaSelecionada(int linha) {
        String h;//= new Historico();
        h = DadosFavorito.get(linha).toString();
        return h;
    }

    public void DeleteRowInTable(String h) {
        this.DadosFavorito.remove(h);
        this.fireTableDataChanged();
    }

    public void DeleteAllRowsInTable() {
        this.DadosFavorito.clear();
        this.fireTableDataChanged();
    }

    public void addRowInTable(String h) {
        this.DadosFavorito.add(h);
        //DadosPagar.sort(e.compareTo(e));
        this.fireTableDataChanged();
    }

    private void tamanho_colunas() {
        //centraliza
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        //alinha a direita
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        //alinha a esquerda
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);
        //JTableHeader header = tb_local.getTableHeader();
        //header.setPreferredSize(new Dimension(0, 20));   // define a largura do cabeçalho
        //TableColumnModel modeloDaColuna = tb_local.getColumnModel();
        //modeloDaColuna.getColumn(0).setCellRenderer(rendererEsquerda);
        //modeloDaColuna.getColumn(1).setCellRenderer(rendererDireita);
        //modeloDaColuna.getColumn(2).setCellRenderer(rendererDireita);
        //modeloDaColuna.getColumn(3).setCellRenderer(rendererEsquerda);
        //modeloDaColuna.getColumn(4).setCellRenderer(rendererCentro);
        //modeloDaColuna.getColumn(5).setCellRenderer(rendererDireita);
        //modeloDaColuna.getColumn(6).setCellRenderer(rendererDireita);
        //modeloDaColuna.getColumn(7).setCellRenderer(rendererDireita);
        //modeloDaColuna.getColumn(0).setMinWidth(10);
        //modeloDaColuna.getColumn(1).setMinWidth(10);
        //modeloDaColuna.getColumn(2).setMinWidth(10);
        //modeloDaColuna.getColumn(3).setMinWidth(350);
        //modeloDaColuna.getColumn(4).setMinWidth(10);
        //modeloDaColuna.getColumn(5).setMinWidth(200);
        //modeloDaColuna.getColumn(6).setMinWidth(200);
        //modeloDaColuna.getColumn(7).setMinWidth(15);
    }
}
