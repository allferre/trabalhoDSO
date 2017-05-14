/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sisclaviculario.tela;

/**
 *
 * @author Allan
 */
public interface ITelaVeiculo {

    void cadastrarVeiculo();

    void excluirVeiculo();

    void alterarVeiculo();

    void exibeListaVeiculos();

    void voltaTelaInicial();

    String pedeNumPlaca();

    void exibeTelaVeiculo();

}
