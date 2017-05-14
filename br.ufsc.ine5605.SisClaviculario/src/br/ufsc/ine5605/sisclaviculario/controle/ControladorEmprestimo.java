package br.ufsc.ine5605.sisclaviculario.controle;

import Enum.Motivo;
import br.ufsc.ine5605.sisclaviculario.entidade.Emprestimo;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario.CargoFuncionario;
import br.ufsc.ine5605.sisclaviculario.tela.TelaEmprestimo;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.CargoVeiculo;
import Enum.Motivo;
import br.ufsc.ine5605.sisclaviculario.entidade.RelatorioAcesso;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author Allan
 */
public class ControladorEmprestimo {

    private ArrayList<Emprestimo> listaEmprestimos;
    private Scanner teclado;
    private Date dataDoEvento;
    private static ControladorEmprestimo INSTANCE;
    private int guardaMatricula;
    private int contadorDeAcessos;
    private ArrayList<Emprestimo> eventosEmprestimo;
    private boolean veiculoOcupado;
    private int contadorAcessoNegado;

    ; // = new ControladorEmprestimo();
    
    private ControladorEmprestimo() {
        this.listaEmprestimos = new ArrayList<>();
        this.eventosEmprestimo = new ArrayList<>();
        this.teclado = new Scanner(System.in);
        this.dataDoEvento = dataDoEvento;
        this.guardaMatricula = 0;
        this.contadorDeAcessos = 0;
        this.veiculoOcupado = false;
        this.contadorAcessoNegado = 0;

    }

    public static ControladorEmprestimo getINSTANCE() {

        if (INSTANCE == null) {
            return INSTANCE = new ControladorEmprestimo();
        }
        return INSTANCE;
    }

    public void exibeTelaEmprestimo() {
        TelaEmprestimo.getINSTANCE().exibeMenuEmprestimo();
    }

    public void voltarTelaInicial() {
        ControladorPrincipal.getINSTANCE().inicia();
    }

    public void telaEmprestimo() {
        TelasCabecalho.getINSTANCE().cabecalhoTelaEmprestimo();
    }

    public ArrayList<Funcionario> solicitarListaFuncionarios() {
        return ControladorPrincipal.getINSTANCE().pedirListaFuncionarios();
    }

    public ArrayList<Veiculo> solicitaListaVeiculos() {
        return ControladorPrincipal.getINSTANCE().pedirListaVeiculos();
    }

    public ArrayList<Veiculo> solicitarListaVeiculos() {
        return ControladorPrincipal.getINSTANCE().pedirListaVeiculos();
    }

    public void incluirEmprestimo(Emprestimo emprestimo) {
        listaEmprestimos.add(emprestimo);
    }

    public ArrayList<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    public void setListaEmprestimos(ArrayList<Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }

    public void solicitarVeiculo() {
        int matricula = TelaEmprestimo.getINSTANCE().recebeMatricula();
        Funcionario funcionario = ControladorPrincipal.getINSTANCE().verificaExisteMatricula(matricula); // verifica se a matrícula existe
        String placa = TelaEmprestimo.getINSTANCE().recebePlaca();
        Veiculo veiculo = ControladorPrincipal.getINSTANCE().verificaExistePlaca(placa); // verifica se o veículo existe
        if (funcionario == null) {
            geraAcesso(matricula, "", Motivo.MatriculaNaoExiste.mensagem, dataDoEvento);
            String motivo = Motivo.MatriculaNaoExiste.mensagem;
            TelaEmprestimo.getINSTANCE().exibeMensagem(motivo);
        } else if (veiculo == null) {
            geraAcesso(matricula, placa, Motivo.VeiculoNaoExiste.mensagem, dataDoEvento);
            String motivo = Motivo.VeiculoNaoExiste.mensagem;
            TelaEmprestimo.getINSTANCE().exibeMensagem(motivo);
        } else if (funcionario.getCargoFuncionario() == CargoFuncionario.DIRETOR) {
            solicitarVeiculoDiretor(matricula, placa);
        } else if (funcionario.getCargoFuncionario() == CargoFuncionario.FUNCIONARIO) {
            solicitarVeiculoFuncionario(matricula, placa);
        }
    }

    public void solicitarVeiculoDiretor(int matricula, String placa) {

        if (ControladorPrincipal.getINSTANCE().verificaDisponibilidadeVeiculo(placa) != null) { // verifica se o veículo está disponível para o Diretor
            geraAcesso(matricula, placa, Motivo.VeiculoIndisponível.mensagem, dataDoEvento);
            String motivo = Motivo.VeiculoIndisponível.mensagem;
            TelaEmprestimo.getINSTANCE().exibeMensagem(motivo);
        } else {
            geraAcesso(matricula, placa, Motivo.VeiculoLiberado.mensagem, dataDoEvento);
            String motivo = Motivo.VeiculoLiberado.mensagem;
            TelaEmprestimo.getINSTANCE().exibeMensagem(motivo);
            veiculoOcupado = true;
            ControladorPrincipal.getINSTANCE().setaVeiculoOcupado(placa, veiculoOcupado); // altera a disponibilidade do veículo para ocupado
        }
    }

    public void solicitarVeiculoFuncionario(int matricula, String placa) {

        if (ControladorPrincipal.getINSTANCE().verificaDisponibilidadeVeiculo(placa) != null) { // verifica se o veículo está dispoível para o funcionário
            geraAcesso(matricula, placa, Motivo.VeiculoIndisponível.mensagem, dataDoEvento);
            String motivo = Motivo.VeiculoIndisponível.mensagem;
            TelaEmprestimo.getINSTANCE().exibeMensagem(motivo);
        } else if (ControladorPrincipal.getINSTANCE().verificaAcessoVeiculo(placa) == null && contadorAcessoNegado(placa) <=3) { // verifica se o funcionário tem acesso aquele veículo
            geraAcesso(matricula, placa, Motivo.AcessoNaoPermitido.mensagem, dataDoEvento);
            contadorAcessoNegado++;
            String motivo = Motivo.AcessoNaoPermitido.mensagem;
            TelaEmprestimo.getINSTANCE().exibeMensagem(motivo);
        } else {
            geraAcesso(matricula, placa, Motivo.VeiculoLiberado.mensagem, dataDoEvento);
            String motivo = Motivo.VeiculoLiberado.mensagem;
            TelaEmprestimo.getINSTANCE().exibeMensagem(motivo);
            veiculoOcupado = true;
            ControladorPrincipal.getINSTANCE().setaVeiculoOcupado(placa, veiculoOcupado); // altera a disponibilidade do veículo para ocupado
        }
    }

    public void geraAcesso(int matricula, String placa, String mensagem, Date dataDoEvento) {
        int matriculaAcesso = matricula;
        String placaAcesso = placa;
        String mensagemAcesso = mensagem;
        Date dataAcesso = dataDoEvento;
        ControladorRelatorioAcesso.getINSTANCE().adicionaNovoAcesso(matriculaAcesso, placaAcesso, mensagemAcesso, dataAcesso);
    }
/*
    public void devolverVeiculo() {
        int matricula = TelaEmprestimo.getINSTANCE().recebeMatricula();
        // método para verificar se essa matrícula emprestou um veículo
        String placa = TelaEmprestimo.getINSTANCE().recebePlaca();
        // método para verificar se o veículo está mesmo emprestado.
        
        if (funcionario == null) {
            geraAcesso(matricula, "", Motivo.FuncionarioSemVeiculo.mensagem, dataDoEvento);
            String motivo = Motivo.FuncionarioSemVeiculo.mensagem;
            TelaEmprestimo.getINSTANCE().exibeMensagem(motivo);
        } else if (veiculo == null) {
            geraAcesso(matricula, placa, Motivo.VeiculoSemEmprestimo.mensagem, dataDoEvento);
            String motivo = Motivo.VeiculoSemEmprestimo.mensagem;
            TelaEmprestimo.getINSTANCE().exibeMensagem(motivo);
        } else {
            geraAcesso(matricula, placa, Motivo.VeiculoDevolvido.mensagem, dataDoEvento);
            int km = TelaEmprestimo.getINSTANCE().receberNovaQuilometragem();
            boolean setaDevolvido = false;
            ControladorPrincipal.getINSTANCE().setaNovaKm(km, placa);
            ControladorPrincipal.getINSTANCE().setaDisponibilidade(setaDevolvido, placa);
            
        }
    }*/

    public int contadorAcessoNegado(String placa) {
        return 0;
    }

}
