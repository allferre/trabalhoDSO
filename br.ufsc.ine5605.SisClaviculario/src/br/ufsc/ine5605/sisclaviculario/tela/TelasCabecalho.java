package br.ufsc.ine5605.sisclaviculario.tela;

import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;
import java.util.Scanner;

/**
 *
 * @author Allan
 */
public class TelasCabecalho {
    
    private Scanner teclado;
    private ControladorPrincipal ctrlP;
    
    public void TelasCabecalho(ControladorPrincipal ctrlP){
        this.teclado = new Scanner(System.in);
        this.ctrlP = ctrlP;
    }
    
    public void cabecalhoTelaPrincipal(){              
            System.out.println(" _____________________________________________ ");
            System.out.println("|                                             |");
            System.out.println("|            Sistema Claviculário             |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|                                             |");
            System.out.println("|    Escolha uma opção:                       |");
            System.out.println("|       1 - Funcionários                      |");
            System.out.println("|       2 - Veículos                          |");
            System.out.println("|       3 - Empréstimo/devolução de veículos  |");
            System.out.println("|       4 - Relatórios                        |");
            System.out.println("|_____________________________________________|");        
    }
    
    public void cabecalhoTelaFuncionario(){
            System.out.println(" _______________________________________ ");
            System.out.println("|                                       |");
            System.out.println("|            Funcionário                |");
            System.out.println("|---------------------------------------|");
            System.out.println("|                                       |");
            System.out.println("|    Escolha uma opção:                 |");
            System.out.println("|   (1) - Cadastrar um funcionário      |");
            System.out.println("|   (2) - Excluir um funcionário        |");
            System.out.println("|   (3) - Alterar um funcionário        |");
            System.out.println("|   (4) - Exibir lista de Funcionários  |");
            System.out.println("|   (5) - Voltar ao menu inicial        |");
            System.out.println("|_______________________________________|");
    }
    
    public void cabecalhoAlteraFuncionario(){
            System.out.println(" ________________________________________ ");
            System.out.println("|                                        |");
            System.out.println("|     Escolha um campo para alterar      |");
            System.out.println("|                                        |");
            System.out.println("|    (1) - (Número de matrícula)         |");
            System.out.println("|    (2) - (Nome)                        |");
            System.out.println("|    (3) - (Data de nascimento)          |");
            System.out.println("|    (4) - (Telefone)                    |");
            System.out.println("|    (5) - (Cargo)                       |");
            System.out.println(" ________________________________________ ");      
    }
    
    public void cabecalhoTelaVeiculo(){
            System.out.println(" _____________________________________ ");
            System.out.println("|                                     |");
            System.out.println("|            Veículo                  |");
            System.out.println("|-------------------------------------|");
            System.out.println("|                                     |");
            System.out.println("|    Escolha uma opção:               |");
            System.out.println("|   (1) - Cadastrar um veículo        |");
            System.out.println("|   (2) - Excluir um veículo          |");
            System.out.println("|   (3) - Alterar um veículo          |");
            System.out.println("|   (4) - Exibir lista de veículos    |");
            System.out.println("|   (5) - Voltar ao menu inicial      |");
            System.out.println("|_____________________________________|");
    }
    
    public void cabecalhoAlteraVeiculo(){
            System.out.println(" _____________________________________ ");
            System.out.println("|                                     |");
            System.out.println("|   Escolha um campo para alterar     |");
            System.out.println("|                                     |");
            System.out.println("|    (1) - Placa                      |");
            System.out.println("|    (2) - Modelo                     |");
            System.out.println("|    (3) - Marca                      |");
            System.out.println("|    (4) - Ano                        |");
            System.out.println("|    (5) - Quilometragem              |");
            System.out.println("|_____________________________________| ");      
    }
    
    public void cadastradoSucesso(){
            System.out.println("|*********************************|");
            System.out.println("|      Cadastrado com sucesso!    |");
            System.out.println("|*********************************|");
    }
    
    public void cabecalhoTelaEmprestimo(){
            System.out.println(" __________________________________");
            System.out.println("|      Empréstimo/devolução        |");
            System.out.println("|           de veículo             |");
            System.out.println("|----------------------------------|");
            System.out.println("|  Escolha uma opção:              |");
            System.out.println("|  1 - Solicitar um veículo        |");
            System.out.println("|  2 - Devolver um veículo         |");
            System.out.println("|  3 - Exibe lista de Emprestimos  |");
            System.out.println("|  4 - Voltar ao menu inicial      |");
            System.out.println("|__________________________________|");
    }
    
}

