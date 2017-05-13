package br.ufsc.ine5605.sisclaviculario.controle;

import br.ufsc.ine5605.sisclaviculario.tela.TelaVeiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Allan
 */
public class ControladorVeiculo {

    private TelaVeiculo telaVeiculo;
    private ArrayList<Veiculo> listaVeiculos;
    private TelasCabecalho telasCabecalho;
    private ControladorPrincipal ctrlP;
    public static ControladorVeiculo INSTANCE; // = new ControladorVeiculo();

    private ControladorVeiculo() {
        this.telaVeiculo = new TelaVeiculo(this);
        listaVeiculos = new ArrayList<>();
        this.telasCabecalho = new TelasCabecalho();

    }

    public static ControladorVeiculo getINSTANCE() {
        if (INSTANCE == null) {
            return INSTANCE = new ControladorVeiculo();
        }
        return INSTANCE;
    }

    public void setControladorP(ControladorPrincipal CtrlP) {
        this.ctrlP = CtrlP;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public void exibeTelaVeiculo() {
        telaVeiculo.exibeTelaVeiculo();
    }

    public void incluiVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }

    public void cabecalhoTelaVeiculo() {
        telasCabecalho.cabecalhoTelaVeiculo();
    }

    public void voltaTelaInicial() {
        ctrlP.inicia();
    }

    public void cabecalhoAlteraVeiculo() {
        telasCabecalho.cabecalhoAlteraVeiculo();
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
        return ctrlP.pedirListaVeiculos();
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
        for (Veiculo localizarVeiculo : listaVeiculos){
            if (placa.equals(localizarVeiculo.getPlaca())){
                localizarVeiculo.setEmprestado(veiculoOcupado);
            }
        }
    }

    Veiculo verificaAcessoVeiculo(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
