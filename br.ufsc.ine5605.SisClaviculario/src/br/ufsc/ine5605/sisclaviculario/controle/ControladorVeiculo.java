package br.ufsc.ine5605.sisclaviculario.controle;

import br.ufsc.ine5605.sisclaviculario.tela.TelaVeiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class ControladorVeiculo {

    private TelaVeiculo telaVeiculo;
    private ArrayList<Veiculo> listaVeiculos;
    private TelasCabecalho telasCabecalho;
    private ControladorPrincipal ctrlP;
    public static ControladorVeiculo INSTANCE = new ControladorVeiculo();

    private ControladorVeiculo() {
        this.telaVeiculo = new TelaVeiculo(this);
        listaVeiculos = new ArrayList<>();
        this.telasCabecalho = new TelasCabecalho();
        
    }
    
    public void setControladorP(ControladorPrincipal CtrlP){
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
}

