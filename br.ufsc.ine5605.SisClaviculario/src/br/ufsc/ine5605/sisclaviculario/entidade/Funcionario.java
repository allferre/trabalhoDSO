package br.ufsc.ine5605.sisclaviculario.entidade;

import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.Cargo;
/**
 *
 * @author Allan
 */
public class Funcionario {

    private int numMatricula;
    private String nome;
    private String dataNascimento;
    private long telefone;
    private Cargo cargo;
    

    public Funcionario(int numMatricula, String nome, String dataNascimento, long telefone, Cargo cargo) { // ArrayList veiculo) {
        this.numMatricula = numMatricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.cargo = cargo;
        
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    
    public Cargo getCargo(){
        return cargo;
    }
    
    public void setCargo(Cargo cargo){
        this.cargo = cargo;
    }

}

