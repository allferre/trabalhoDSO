package br.ufsc.ine5605.sisclaviculario.controle;

import br.ufsc.ine5605.sisclaviculario.tela.TelaVeiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.CargoVeiculo;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Allan
 */
public class ControladorVeiculo {

  
    private ArrayList<Veiculo> listaVeiculos;
    private static ControladorVeiculo INSTANCE; 

    private ControladorVeiculo() {
        listaVeiculos = new ArrayList<>();
    }

    public static ControladorVeiculo getINSTANCE() {
        if (INSTANCE == null) {
            return INSTANCE = new ControladorVeiculo();
        }
        return INSTANCE;
    }


    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public void exibeTelaVeiculo() {
        TelaVeiculo.getINSTANCE().exibeTelaVeiculo();
    }

    public void incluiVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }

    public void cabecalhoTelaVeiculo() {
        TelasCabecalho.getINSTANCE().cabecalhoTelaVeiculo();
    }

    public void voltaTelaInicial() {
        ControladorPrincipal.getINSTANCE().inicia();
    }

    public void cabecalhoAlteraVeiculo() {
        TelasCabecalho.getINSTANCE().cabecalhoAlteraVeiculo();
    }

    public boolean excluiVeiculoPelaPlaca(String placaParaExcluir) {
        boolean conseguiuExcluir = false;

        for (Veiculo veiculoExcluir : listaVeiculos) {
            if (veiculoExcluir.getPlaca().equals(placaParaExcluir)) {
                listaVeiculos.remove(veiculoExcluir);
                conseguiuExcluir = true;
                break;
            }
        }
        return conseguiuExcluir;
    }

    public ArrayList<Veiculo> solicitarListaVeiculos() {
        return ControladorPrincipal.getINSTANCE().pedirListaVeiculos();
    }

    void incluirVeiculo(Veiculo veiculo1, Veiculo veiculo2, Veiculo veiculo3, Veiculo veiculo4) {
        listaVeiculos.add(veiculo1);
        listaVeiculos.add(veiculo2);
        listaVeiculos.add(veiculo3);
        listaVeiculos.add(veiculo4);
    }

    public Veiculo procuraVeiculoPelaPlaca(String placa) {
        for (Veiculo veiculoLocalizar : listaVeiculos) {
            if (veiculoLocalizar.getPlaca().equals(placa)) {
                return veiculoLocalizar;
            }
        }
        return null;
    }

    public Veiculo procuraDisponibilidadeVeiculo(String placa) {
        for (Veiculo veiculoLocalizar : listaVeiculos) {
            if (placa.equals(veiculoLocalizar.getPlaca())) {
                if (!veiculoLocalizar.getEmprestado()) {
                    return veiculoLocalizar;
                }
            }
        }
        return null;
    }

    public void setaVeiculoOcupado(String placa, boolean veiculoOcupado) {
        for (Veiculo localizarVeiculo : listaVeiculos) {
            if (placa.equals(localizarVeiculo.getPlaca())) {
                localizarVeiculo.setEmprestado(veiculoOcupado);
            }
        }
    }

    public Veiculo verificaAcessoVeiculo(String placa) {
        for (Veiculo veiculoLocalizar : listaVeiculos) {
            if (placa.equals(veiculoLocalizar.getPlaca())) {
                if (veiculoLocalizar.getCargoVeiculo() == CargoVeiculo.FUNCIONARIO) {
                    return veiculoLocalizar;

                }
            }
        }
        return null;
    }
}
