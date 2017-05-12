/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

/**
 *
 * @author Allan
 */
public enum Motivo {
    
    AcessoBloqueado("Acesso bloqueado."),
    AcessoNaoPermitido("Não possui acesso ao veículo."), 
    FuncionarioComVeiculo("Funcionário com empréstimo em aberto."),
    KilometragemInvalida("O valor digitado para a kilometragem é inválido."),
    MatriculaNaoExiste("Matricula não Existe."),
    SemEmprestimosCadastrados("Não há emprestimos em aberto para este usuário."),
    VeiculoDevolvido("Veículo Devolvido com sucesso"),
    VeiculoIndisponível("Veículo não disponível."),
    VeiculoLiberado("Acesso ao veículo liberado."),
    VeiculoNaoExiste("Veículo não Existe.");
    
    public String mensagem;
    
    Motivo(String mensagem){
    
        this.mensagem = mensagem;
    }
    
}
