package br.ufsc.ine5605.sisclaviculario.tela;

import Enum.Motivo;
import java.util.Scanner;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorRelatorioAcesso;
import br.ufsc.ine5605.sisclaviculario.entidade.RelatorioAcesso;

//@author Graciela Banegas
public class TelaRelatorioAcesso extends TelasCabecalho {

    private Scanner teclado;
    private static TelaRelatorioAcesso INSTANCE;

    public TelaRelatorioAcesso() {
        this.teclado = new Scanner(System.in);
    }

    public static TelaRelatorioAcesso getINSTANCE() {
        if (INSTANCE == null) {
            return INSTANCE = new TelaRelatorioAcesso();
        }
        return INSTANCE;
    }

    public void exibeMenuRelatorio() {
        int opcao = 0;
        do {
            cabecalhoTelaRelatorioAcesso();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    listaTodosAcessos();
                    break;
                case 2:
                    listaAcessosNegados();
                    break;
                case 3:
                    listaAcessosPermitidos();
                    break;
                case 4:
                    filtrarPorMotivoNegacao();
                    break;
                case 5:
                    filtrarPorNumMatricula();
                    break;
                case 6:
                    filtrarPorPlaca();
                    break;
                case 7:
                    ControladorRelatorioAcesso.getINSTANCE().voltarTelaInicial();
                    break;
                default:
                    System.out.println("Insira apenas o número das opções do Menu");
            }

        } while (opcao != 0);
    }

    private void listaTodosAcessos() {

        for (int i = 0; i < ControladorRelatorioAcesso.getINSTANCE().listaRelatoriosAcesso.size(); i++) {
            RelatorioAcesso relatorioAcesso = ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso().get(i);
        }

        for (RelatorioAcesso relatorioAcesso : ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso()) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Número de Matrícula: " + relatorioAcesso.getMatriculaAcesso());
            System.out.println("Placa do Veículo: " + relatorioAcesso.getPlacaAcesso());
            System.out.println("Status de Acesso: " + relatorioAcesso.getMensagemAcesso());
            System.out.println("Data da Tentativa de Acesso: " + relatorioAcesso.getDataAcesso());
            System.out.println("-------------------------------------------------------");
        }
    }

    private void listaAcessosNegados() {

        for (RelatorioAcesso relatorioAcessoNegado : ControladorRelatorioAcesso.getINSTANCE().listaRelatoriosAcesso) {
            if (relatorioAcessoNegado.getMensagemAcesso().equals(Motivo.AcessoBloqueado.mensagem) && relatorioAcessoNegado.getMensagemAcesso().equals(Motivo.AcessoNaoPermitido.mensagem) && relatorioAcessoNegado.getMensagemAcesso().equals(Motivo.VeiculoIndisponível.mensagem) && relatorioAcessoNegado.getMensagemAcesso().equals(Motivo.MatriculaNaoExiste)) {

                for (RelatorioAcesso relatorioAcessoNegados : ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso()) {

                    System.out.println("-------------------------------------------------------");
                    System.out.println("Número de Matrícula: " + relatorioAcessoNegados.getMatriculaAcesso());
                    System.out.println("Placa do Veículo: " + relatorioAcessoNegados.getPlacaAcesso());
                    System.out.println("Status de Acesso: " + relatorioAcessoNegados.getMensagemAcesso());
                    System.out.println("Data da Tentativa de Acesso: " + relatorioAcessoNegados.getDataAcesso());
                    System.out.println("-------------------------------------------------------");
                }
            }

        }
    }

    private void listaAcessosPermitidos() {

        for (RelatorioAcesso relatorioAcessoPermitidos : ControladorRelatorioAcesso.getINSTANCE().listaRelatoriosAcesso) {
            if (relatorioAcessoPermitidos.getMensagemAcesso().equals(Motivo.VeiculoLiberado.mensagem)) {

                for (RelatorioAcesso relatorioAcessoPermitido : ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso()) {

                    System.out.println("-------------------------------------------------------");
                    System.out.println("Número de Matrícula: " + relatorioAcessoPermitido.getMatriculaAcesso());
                    System.out.println("Placa do Veículo: " + relatorioAcessoPermitido.getPlacaAcesso());
                    System.out.println("Status de Acesso: " + relatorioAcessoPermitido.getMensagemAcesso());
                    System.out.println("Data da Tentativa de Acesso: " + relatorioAcessoPermitido.getDataAcesso());
                    System.out.println("-------------------------------------------------------");
                }
            }
        }
    }

    private void filtrarPorNumMatricula() {

        System.out.println("Digite o número de Matricula do Funcionario: ");
        int numMatricula = teclado.nextInt();

        for (RelatorioAcesso relatorioPorMatriculas : ControladorRelatorioAcesso.getINSTANCE().listaRelatoriosAcesso) {
            if (relatorioPorMatriculas.getMatriculaAcesso() == numMatricula) {

                for (RelatorioAcesso relatorioPorMatricula : ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso()) {

                    System.out.println("-------------------------------------------------------");
                    System.out.println("Número de Matrícula: " + relatorioPorMatricula.getMatriculaAcesso());
                    System.out.println("Placa do Veículo: " + relatorioPorMatricula.getPlacaAcesso());
                    System.out.println("Status de Acesso: " + relatorioPorMatricula.getMensagemAcesso());
                    System.out.println("Data da Tentativa de Acesso: " + relatorioPorMatricula.getDataAcesso());
                    System.out.println("-------------------------------------------------------");
                }
            }
        }
    }

    private void filtrarPorPlaca() {

        System.out.println("Digite o número da placa do veículo: ");
        String placaCarro = teclado.next();

        for (RelatorioAcesso relatorioPorPlacas : ControladorRelatorioAcesso.getINSTANCE().listaRelatoriosAcesso) {
            if (relatorioPorPlacas.getPlacaAcesso().equals(placaCarro)) {

                for (RelatorioAcesso relatorioPorPlaca : ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso()) {

                    System.out.println("-------------------------------------------------------");
                    System.out.println("Número de Matrícula: " + relatorioPorPlaca.getMatriculaAcesso());
                    System.out.println("Placa do Veículo: " + relatorioPorPlaca.getPlacaAcesso());
                    System.out.println("Status de Acesso: " + relatorioPorPlaca.getMensagemAcesso());
                    System.out.println("Data da Tentativa de Acesso: " + relatorioPorPlaca.getDataAcesso());
                    System.out.println("-------------------------------------------------------");
                }
            }
        }
    }

    private void filtrarPorMotivoNegacao() {

        int opcao = 0;
        do {
            cabecalhoMotivoNegacao();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    listaMatriculasInexistentes();
                    break;
                case 2:
                    listaUsuarioNaoPossuiAcesso();
                    break;
                case 3:
                    listaVeiculoIndisponivel();
                    break;
                case 4:
                    listaAcessoBloqueado();
                    break;
                case 5:
                    ControladorRelatorioAcesso.getINSTANCE().voltarTelaInicial();
                    break;
                default:
                    System.out.println("Insira apenas o número das opções do Menu");
            }

        } while (opcao != 0);

    }

    private void listaMatriculasInexistentes() {

        for (RelatorioAcesso relatorioMatriculasInexistente : ControladorRelatorioAcesso.getINSTANCE().listaRelatoriosAcesso) {
            if (relatorioMatriculasInexistente.getMensagemAcesso().equals(Motivo.MatriculaNaoExiste.mensagem)) {

                for (RelatorioAcesso relatorioMatriculasInexistentes : ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso()) {

                    System.out.println("-------------------------------------------------------");
                    System.out.println("Número de Matrícula: " + relatorioMatriculasInexistentes.getMatriculaAcesso());
                    System.out.println("Placa do Veículo: " + relatorioMatriculasInexistentes.getPlacaAcesso());
                    System.out.println("Status de Acesso: " + relatorioMatriculasInexistentes.getMensagemAcesso());
                    System.out.println("Data da Tentativa de Acesso: " + relatorioMatriculasInexistentes.getDataAcesso());
                    System.out.println("-------------------------------------------------------");
                }
            }
        }
    }

    private void listaUsuarioNaoPossuiAcesso() {

        for (RelatorioAcesso relatorioUsuarioNaoPossuiAcessos : ControladorRelatorioAcesso.getINSTANCE().listaRelatoriosAcesso) {
            if (relatorioUsuarioNaoPossuiAcessos.getMensagemAcesso().equals(Motivo.AcessoNaoPermitido.mensagem)) {

                for (RelatorioAcesso relatorioUsuarioNaoPossuiAcesso : ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso()) {

                    System.out.println("-------------------------------------------------------");
                    System.out.println("Número de Matrícula: " + relatorioUsuarioNaoPossuiAcesso.getMatriculaAcesso());
                    System.out.println("Placa do Veículo: " + relatorioUsuarioNaoPossuiAcesso.getPlacaAcesso());
                    System.out.println("Status de Acesso: " + relatorioUsuarioNaoPossuiAcesso.getMensagemAcesso());
                    System.out.println("Data da Tentativa de Acesso: " + relatorioUsuarioNaoPossuiAcesso.getDataAcesso());
                    System.out.println("-------------------------------------------------------");
                }
            }
        }
    }

    private void listaVeiculoIndisponivel() {

        for (RelatorioAcesso relatorioVeiculosIndisponivel : ControladorRelatorioAcesso.getINSTANCE().listaRelatoriosAcesso) {
            if (relatorioVeiculosIndisponivel.getMensagemAcesso().equals(Motivo.VeiculoIndisponível.mensagem)) {

                for (RelatorioAcesso relatorioVeiculoIndisponivel : ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso()) {

                    System.out.println("-------------------------------------------------------");
                    System.out.println("Número de Matrícula: " + relatorioVeiculoIndisponivel.getMatriculaAcesso());
                    System.out.println("Placa do Veículo: " + relatorioVeiculoIndisponivel.getPlacaAcesso());
                    System.out.println("Status de Acesso: " + relatorioVeiculoIndisponivel.getMensagemAcesso());
                    System.out.println("Data da Tentativa de Acesso: " + relatorioVeiculoIndisponivel.getDataAcesso());
                    System.out.println("-------------------------------------------------------");
                }
            }
        }
    }

    private void listaAcessoBloqueado() {

        for (RelatorioAcesso relatorioAcessosBloqueado : ControladorRelatorioAcesso.getINSTANCE().listaRelatoriosAcesso) {
            if (relatorioAcessosBloqueado.getMensagemAcesso().equals(Motivo.AcessoBloqueado.mensagem)) {

                for (RelatorioAcesso relatorioAcessoBloqueado : ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso()) {

                    System.out.println("-------------------------------------------------------");
                    System.out.println("Número de Matrícula: " + relatorioAcessoBloqueado.getMatriculaAcesso());
                    System.out.println("Placa do Veículo: " + relatorioAcessoBloqueado.getPlacaAcesso());
                    System.out.println("Status de Acesso: " + relatorioAcessoBloqueado.getMensagemAcesso());
                    System.out.println("Data da Tentativa de Acesso: " + relatorioAcessoBloqueado.getDataAcesso());
                    System.out.println("-------------------------------------------------------");
                }

            }
        }
    }
}
