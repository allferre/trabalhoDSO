package br.ufsc.ine5605.sisclaviculario.controle;

import br.ufsc.ine5605.sisclaviculario.tela.TelaFuncionario;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Allan
 */
public class ControladorFuncionario {

    private TelaFuncionario telaFuncionario;
    private ArrayList<Funcionario> listaFuncionarios;
    private TelasCabecalho telasCabecalho;
    private Scanner teclado;
    private ControladorPrincipal ctrlP;
    public static ControladorFuncionario INSTANCE = new ControladorFuncionario();

    private ControladorFuncionario() {
        this.telaFuncionario = new TelaFuncionario(this);
        listaFuncionarios = new ArrayList<>();
        this.telasCabecalho = new TelasCabecalho();
        teclado = new Scanner(System.in);

    }

    public void setControladorP(ControladorPrincipal CtrlP) {
        this.ctrlP = CtrlP;
    }

    public void exibeTelaFuncionario() {
        telaFuncionario.telaFuncionario();
    }

    public void incluiFuncionario(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    public ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public void cabecalhoTelaFuncionario() {
        telasCabecalho.cabecalhoTelaFuncionario();
    }

    public void voltaTelaInicial() {
        ctrlP.inicia();
    }

    public void excluiFuncionarioPelaMatricula(Funcionario funcionarioExcluir) {
        listaFuncionarios.remove(funcionarioExcluir);
    }

    public void cabecalhoAlteraFuncionario() {
        telasCabecalho.cabecalhoAlteraFuncionario();
    }

    public void alteraFuncionarioPelaMatricula(Funcionario funcionarioAlterar) {
        listaFuncionarios.add(funcionarioAlterar);
    }

    public void cadastradoSucesso() {
        telasCabecalho.cadastradoSucesso();
    }

    public void incluirFuncionario(Funcionario funcionario1, Funcionario funcionario2, Funcionario funcionario3) {
        listaFuncionarios.add(funcionario1);
        listaFuncionarios.add(funcionario2);
        listaFuncionarios.add(funcionario3);
        
    }

}

