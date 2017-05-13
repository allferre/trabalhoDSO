package br.ufsc.ine5605.sisclaviculario.controle;

import br.ufsc.ine5605.sisclaviculario.controle.ControladorEmprestimo;
import br.ufsc.ine5605.sisclaviculario.tela.TelaPrincipal;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorVeiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Emprestimo;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import java.util.ArrayList;
import java.util.List;

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

    public static ControladorPrincipal INSTANCE;

    private ControladorRelatorioAcesso ctrlR;


    private ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal(this);
        //this.ctrlE = ControladorEmprestimo.INSTANCE;
        //this.ctrlE.setControladorP(this);
        this.ctrlV = ControladorVeiculo.INSTANCE;
        this.ctrlV.setControladorP(this);
        this.ctrlF = ControladorFuncionario.INSTANCE;

//        this.ctrlF.setControladorP(this);

        this.ctrlF.setControladorP(this);
       // this.ctrlR = ControladorRelatorioAcesso.INSTANCE;

        this.telasCabecalho = new TelasCabecalho();

    }
    
       public static ControladorPrincipal getINSTANCE(){
        if(INSTANCE == null){
            return INSTANCE= new ControladorPrincipal();
        }
        return INSTANCE;
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

    public void incluirFuncionario(Funcionario funcionario1, Funcionario funcionario2, Funcionario funcionario3, Funcionario funcionario4) {
        ControladorFuncionario.getINSTANCE().incluirFuncionario(funcionario1, funcionario2, funcionario3, funcionario4);
    }

    public void incluirVeiculo(Veiculo veiculo1, Veiculo veiculo2, Veiculo veiculo3, Veiculo veiculo4) {
        ctrlV.incluirVeiculo(veiculo1, veiculo2, veiculo3, veiculo4);
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
        return ctrlE.getListaEmprestimos();
        

    }

    public void setaVeiculoOcupado(String placa, boolean veiculoOcupado) {
        ControladorVeiculo.getINSTANCE().setaVeiculoOcupado(placa, veiculoOcupado);
    }

    public Veiculo verificaAcessoVeiculo(String placa) {
        return ControladorVeiculo.getINSTANCE().verificaAcessoVeiculo(placa);
    }

}

