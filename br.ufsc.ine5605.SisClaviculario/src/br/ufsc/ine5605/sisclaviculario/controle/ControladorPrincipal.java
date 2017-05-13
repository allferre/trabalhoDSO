package br.ufsc.ine5605.sisclaviculario.controle;

import br.ufsc.ine5605.sisclaviculario.tela.TelaPrincipal;
import br.ufsc.ine5605.sisclaviculario.entidade.Emprestimo;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class ControladorPrincipal {


    private static ControladorPrincipal INSTANCE;


    private ControladorPrincipal() {

    }
    
       public static ControladorPrincipal getINSTANCE(){
        if(INSTANCE == null){
            return INSTANCE= new ControladorPrincipal();
        }
        return INSTANCE;
    }

    public void inicia() {
        TelaPrincipal.getINSTANCE().exibeMenuInicial();
    }

    public void iniciarEmprestimo() {
       ControladorEmprestimo.getINSTANCE().exibeTelaEmprestimo();
    }

    public void iniciarCadastroVeiculo() {
        ControladorVeiculo.getINSTANCE().exibeTelaVeiculo();
    }
    
    public void iniciarCadastroFuncionario(){
        ControladorFuncionario.getINSTANCE().exibeTelaFuncionario();
    }
    
    public void cabecalhoTelaPrincipal(){
         TelasCabecalho.getINSTANCE().cabecalhoTelaPrincipal();       
    }

    public  ArrayList<Funcionario> pedirListaFuncionarios() {
        return ControladorFuncionario.getINSTANCE().getListaFuncionarios();
    }

    public ArrayList<Veiculo> pedirListaVeiculos() {
        return ControladorVeiculo.getINSTANCE().getListaVeiculos();
    }

    public void incluirFuncionario(Funcionario funcionario1, Funcionario funcionario2, Funcionario funcionario3, Funcionario funcionario4) {
        ControladorFuncionario.getINSTANCE().incluirFuncionario(funcionario1, funcionario2, funcionario3, funcionario4);
    }

    public void incluirVeiculo(Veiculo veiculo1, Veiculo veiculo2, Veiculo veiculo3, Veiculo veiculo4) {
        ControladorVeiculo.getINSTANCE().incluirVeiculo(veiculo1, veiculo2, veiculo3, veiculo4);
    }


    public Funcionario verificaExisteMatricula(int matricula) {
        return ControladorFuncionario.getINSTANCE().procuraFuncPelaMatricula(matricula);        
    }
    
     public ArrayList<Veiculo> getListaDeVeiculos() {
        return ControladorVeiculo.getINSTANCE().getListaVeiculos();
    }

   public void alteraAcesso(int matricula, boolean acessoLiberado){
        ControladorFuncionario.getINSTANCE().marcaAcesso(matricula, acessoLiberado);
    }

    public Veiculo verificaExistePlaca(String placa) {
        return ControladorVeiculo.getINSTANCE().procuraVeiculoPelaPlaca(placa);
    }

    public Veiculo verificaDisponibilidadeVeiculo(String placa) {
         return ControladorVeiculo.getINSTANCE().procuraDisponibilidadeVeiculo(placa);
    }

    public void iniciarRelatorio() {
    
        //ctrlR.exibeTelaRelatorioAcesso();
        
    }

    public ArrayList<Emprestimo> pedirListaEmprestimos() {
        return ControladorEmprestimo.getINSTANCE().getListaEmprestimos();
        

    }

    public void setaVeiculoOcupado(String placa, boolean veiculoOcupado) {
        ControladorVeiculo.getINSTANCE().setaVeiculoOcupado(placa, veiculoOcupado);
    }

    public Veiculo verificaAcessoVeiculo(String placa) {
        return ControladorVeiculo.getINSTANCE().verificaAcessoVeiculo(placa);
    }

    public void setaNovaKm(int km, String placa) {
        ControladorVeiculo.getINSTANCE().setarNovaKm(km, placa);
    }

    public void setaDisponibilidade(boolean setaDevolvido, String placa) {
         ControladorVeiculo.getINSTANCE().setaDisponibilidade(setaDevolvido, placa);
    }

 

  

}

