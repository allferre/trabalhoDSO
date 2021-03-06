package br.ufsc.ine5605.sisclaviculario.tela;

import br.ufsc.ine5605.sisclaviculario.controle.ControladorEmprestimo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import java.util.Scanner;
import java.util.Date;
/**
 *
 * @author Allan
 */
public class TelaEmprestimo extends TelasCabecalho {

    private Scanner teclado;
    private Veiculo veiculoVerificado;
    private int numeroMatricula;
    private String motivo;
    private Date dataDoEvento;
    private static TelaEmprestimo INSTANCE;

    private TelaEmprestimo() {
        teclado = new Scanner(System.in);
        this.numeroMatricula = numeroMatricula;
        this.motivo = motivo;
        this.dataDoEvento = dataDoEvento;

    }

    public static TelaEmprestimo getINSTANCE() {

        if (INSTANCE == null) {
            return INSTANCE = new TelaEmprestimo();
        }
        return INSTANCE;
    }

    public void exibeMenuEmprestimo() {
        int opcao = 0;

        do {
            cabecalhoTelaEmprestimo();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    ControladorEmprestimo.getINSTANCE().solicitarVeiculo();
                    break;
                case 2:
                    ControladorEmprestimo.getINSTANCE().devolverVeiculo();
                    break;
                case 3:
                    ControladorEmprestimo.getINSTANCE().voltarTelaInicial();
                    break;
                default:
                    System.out.println("Insira apenas o número das opções do Menu");
            }

        } while (opcao != 0);
    }

    public void mensagemDoEvento(String tipo) {
        System.out.println(tipo);
        System.out.println("-----------------------------------------------");
        System.out.println("");
    }

    public int recebeMatricula() {

        System.out.println("Digite a Matrícula: ");
        int matricula = teclado.nextInt();
        return matricula;
    }

    public String recebePlaca() {
        System.out.println("Digite a placa: ");
        String placa = teclado.next();
        teclado.nextLine();
        return placa;
    }

    public void exibeMensagem(String motivo) {
        System.out.println("");
        System.out.println(motivo);
        System.out.println("");
    }

    public int receberNovaQuilometragem() {
        System.out.println("Digite a quilometragem movimentada pelo veículo");
        int km = teclado.nextInt();
        return km;
    }
}
