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
public class HistoricoTableModel extends AbstractTableModel {

    private List<Historico> DadosHistorico = new ArrayList<>();
    private String[] colunas = {"Url Visitada", "Data"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return DadosHistorico.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return DadosHistorico.get(linha).getUrlAcesso();
            case 1:
                return DadosHistorico.get(linha).getDataAcesso();
        }

        return null;
    }

    public Historico getColunaSelecionada(int linha) {
        Historico h = new Historico();
        h = DadosHistorico.get(linha);
        return h;
    }

    public int getLinhaSelecionadaInt(int linha) {
        return linha;
    }

    public int getColunaSelecionadaInt(int coluna) {
        return coluna;
    }

    public void DeleteRowInTable(Historico h) {
        this.DadosHistorico.remove(h);
        this.fireTableDataChanged();
    }

    public void DeleteAllRowsInTable() {
        this.DadosHistorico.clear();
        this.fireTableDataChanged();
    }

    public void addRowInTable(Historico h) {
        this.DadosHistorico.add(h);
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
