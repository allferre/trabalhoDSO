/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sisclaviculario.controle;


import br.ufsc.ine5605.sisclaviculario.entidade.RelatorioAcesso;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Allan
 */
public class ControladorRelatorioAcesso {
    
    private static ControladorRelatorioAcesso INSTANCE;
    private ArrayList<RelatorioAcesso> listaRelatoriosAcesso;
    
    private ControladorRelatorioAcesso(){
        this.listaRelatoriosAcesso = new ArrayList<>();
        
    }
    
    public static ControladorRelatorioAcesso getINSTANCE(){
        if (INSTANCE == null){
            return INSTANCE = new ControladorRelatorioAcesso();
        }
        return INSTANCE;
    }

    public void adicionaNovoAcesso(int matriculaAcesso, String placaAcesso, String mensagemAcesso, Date dataAcesso) {
        RelatorioAcesso relatorioAcesso = new RelatorioAcesso(matriculaAcesso, placaAcesso, mensagemAcesso, dataAcesso);
        listaRelatoriosAcesso.add(relatorioAcesso);
    }
    
}
