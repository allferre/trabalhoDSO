/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sisclaviculario.entidade;

import java.util.Date;

/**
 *
 * @author Allan
 */
public class RelatorioAcesso {

    private int matriculaAcesso;
    private String placaAcesso;
    private String mensagemAcesso;
    private Date dataAcesso;

    public RelatorioAcesso(int matriculaAcesso, String placaAcesso, String mensagemAcesso, Date dataAcesso) {
        this.matriculaAcesso = matriculaAcesso;
        this.placaAcesso = placaAcesso;
        this.mensagemAcesso = mensagemAcesso;
        this.dataAcesso = dataAcesso;
    }

    public int getMatriculaAcesso() {
        return matriculaAcesso;
    }

    public void setMatriculaAcesso(int matriculaAcesso) {
        this.matriculaAcesso = matriculaAcesso;
    }

    public String getPlacaAcesso() {
        return placaAcesso;
    }

    public void setPlacaAcesso(String placaAcesso) {
        this.placaAcesso = placaAcesso;
    }

    public String getMensagemAcesso() {
        return mensagemAcesso;
    }

    public void setMensagemAcesso(String mensagemAcesso) {
        this.mensagemAcesso = mensagemAcesso;
    }

    public Date getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(Date dataAcesso) {
        this.dataAcesso = dataAcesso;
    }
}
