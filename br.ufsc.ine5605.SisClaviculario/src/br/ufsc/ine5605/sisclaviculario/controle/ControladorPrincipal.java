package br.ufsc.ine5605.sisclaviculario.controle;

import br.ufsc.ine5605.sisclaviculario.controle.ControladorEmprestimo;
import br.ufsc.ine5605.sisclaviculario.tela.TelaPrincipal;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorVeiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class ControladorPrincipal {

    private TelaPrincipal telaPrincipal;
    private ControladorEmprestimo ctrlE;
    private ControladorVeiculo ctrlV;
    private ControladorFuncionario ctrlF;
    private TelasCabecalho telasCabecalho;

    public ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal(this);
        this.ctrlE = ControladorEmprestimo.INSTANCE;
        this.ctrlE.setControladorP(this);
        this.ctrlV = ControladorVeiculo.INSTANCE;
        this.ctrlV.setControladorP(this);
        this.ctrlF = ControladorFuncionario.INSTANCE;
        this.ctrlF.setControladorP(this);
        this.telasCabecalho = new TelasCabecalho();

    }

    public void inicia() {
        telaPrincipal.exibeMenuInicial();
    }

    public void iniciarEmprestimo() {
        ctrlE.exibeTelaEmprestimo();
    }

    public void iniciarCadastroVeiculo() {
        ctrlV.exibeTelaVeiculo();
    }
    
    public void iniciarCadastroFuncionario(){
        ctrlF.exibeTelaFuncionario();
    }
    
    public void iniciarListaFuncionarios(){
     //   ctrlF.aListaFuncionarios();
    }
    
    public void cabecalhoTelaPrincipal(){
         telasCabecalho.cabecalhoTelaPrincipal();       
    }

    public  ArrayList<Funcionario> pedirListaFuncionarios() {
        return ctrlF.getListaFuncionarios();
    }

    public ArrayList<Veiculo> pedirListaVeiculos() {
        return ctrlV.getListaVeiculos();
    }

}

