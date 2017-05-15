package br.ufsc.ine5605.sisclaviculario.entidade;

/**
 *
 * @author Allan
 */
public class Funcionario {

    public enum CargoFuncionario {
        DIRETOR("Diretor"),
        FUNCIONARIO("Funcionario");
        public String mensagem;

        CargoFuncionario(String mensagem) {

            this.mensagem = mensagem;
        }
    }

    private int numMatricula;
    private String nome;
    private String dataNascimento;
    private long telefone;
    private CargoFuncionario cargo;
    private boolean acessoLiberado;

    public Funcionario(int numMatricula, String nome, String dataNascimento, long telefone, CargoFuncionario cargo) {
        this.numMatricula = numMatricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.cargo = cargo;
        this.acessoLiberado = false;

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

    public CargoFuncionario getCargoFuncionario() {
        return cargo;
    }

    public void setCargo(CargoFuncionario cargo) {
        this.cargo = cargo;
    }

    public boolean getAcessoLiberado() {
        return acessoLiberado;
    }

    public void setAcessoLiberado(boolean acessoLiberado) {
        this.acessoLiberado = acessoLiberado;
    }
}
