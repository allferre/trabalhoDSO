package br.ufsc.ine5605.sisclaviculario.controle;

import br.ufsc.ine5605.sisclaviculario.tela.TelaFuncionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Allan
 */
public class ControladorFuncionario {

    private ArrayList<Funcionario> listaFuncionarios;
    private Scanner teclado;
    private static ControladorFuncionario INSTANCE;

    private ControladorFuncionario() {
        listaFuncionarios = new ArrayList<>();
        teclado = new Scanner(System.in);
    }

    public static ControladorFuncionario getINSTANCE() {
        if (INSTANCE == null) {
            return INSTANCE = new ControladorFuncionario();
        }
        return INSTANCE;
    }

    public void exibeTelaFuncionario() {
        TelaFuncionario.getINSTANCE().telaFuncionario();
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
        TelasCabecalho.getINSTANCE().cabecalhoTelaFuncionario();
    }

    public void voltaTelaInicial() {
        ControladorPrincipal.getINSTANCE().inicia();
    }

    public void excluiFuncionarioPelaMatricula(Funcionario funcionarioExcluir) {
        listaFuncionarios.remove(funcionarioExcluir);
    }

    public void cabecalhoAlteraFuncionario() {
        TelasCabecalho.getINSTANCE().cabecalhoAlteraFuncionario();
    }

    public void alteraFuncionarioPelaMatricula(Funcionario funcionarioAlterar) {
        listaFuncionarios.add(funcionarioAlterar);
    }

    public void cadastradoSucesso() {
        TelasCabecalho.getINSTANCE().cadastradoSucesso();
    }

    public void incluirFuncionario(Funcionario funcionario1, Funcionario funcionario2, Funcionario funcionario3, Funcionario funcionario4) {
        listaFuncionarios.add(funcionario1);
        listaFuncionarios.add(funcionario2);
        listaFuncionarios.add(funcionario3);
        listaFuncionarios.add(funcionario4);
    }

    Funcionario procuraFuncPelaMatricula(int matricula) {
        for (Funcionario funcionarioEncontrar : listaFuncionarios) {
            if (funcionarioEncontrar.getNumMatricula() == matricula) {
                return funcionarioEncontrar;
            }
        }
        return null;
    }

    public void marcaAcesso(int matricula, boolean acessoLiberado) {
        procuraFuncPelaMatricula(matricula).setAcessoLiberado(acessoLiberado);
    }

    public void incluiFuncionario(int numMatricula, String nome, String dataNascimento, long telefone, Funcionario.CargoFuncionario cargo) {
        Funcionario funcionario = new Funcionario(numMatricula, nome, dataNascimento, telefone, cargo);
        listaFuncionarios.add(funcionario);
    }

    public boolean excluirFuncionario(int matriculaParaExcluir) {
        boolean conseguiuExcluir = false;
        for (Funcionario funcionarioExcluir : listaFuncionarios) {
            if (funcionarioExcluir.getNumMatricula() == matriculaParaExcluir) {
                listaFuncionarios.remove(funcionarioExcluir);
                conseguiuExcluir = true;
                break;
            }
        }
        return conseguiuExcluir;
    }


}
