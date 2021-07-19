package br.com.contmatic.prova.empresa;

import java.math.BigDecimal;

import org.joda.time.LocalDate;

import br.com.contmatic.prova.empresa.validar.CpfValidator;
import br.com.contmatic.prova.empresa.validar.Validacao;

public class Funcionario {

    private String nome;

    private String sobreNome;

    private LocalDate dataNascimento;

    private String cpf;

    private Contato contato;

    private String cargo;

    private BigDecimal salario;

    private Departamento departamento;

    public Funcionario(String cpf) {
    }

    public Funcionario(String nome, String sobreNome, LocalDate dataNascimento, String cpf, Contato contato, String cargo, BigDecimal salario, Departamento departamento) {
        this.setNome(nome);
        this.setSobreNome(sobreNome);
        this.setdataNascimento(dataNascimento);
        this.setCpf(cpf);
        this.setContato(contato);
        this.setCargo(cargo);
        this.setSalario(salario);
        this.setDepartamento(departamento);
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        Validacao.verificaNulidade(salario, "Salário");
        Validacao.assertNotBlankSalario(salario);
        verificaSalarioPositivo(salario);
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        Validacao.verificaNulidade(departamento, "Departamento");
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Validacao.verificaNulidade(nome, "Nome");
        Validacao.assertNotBlank(nome, "Nome");
        Validacao.verificaEspacoEmBranco(nome, "Nome");
        Validacao.verificaTamanhoNome(nome);
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        Validacao.verificaNulidade(sobreNome, "Sobrenome");
        Validacao.assertNotBlank(sobreNome, "SobreNome");
        Validacao.verificaEspacoEmBranco(sobreNome, "Sobrenome");
        Validacao.verificaTamanhoSobreNome(sobreNome);
        this.sobreNome = sobreNome;
    }

    public LocalDate getdataNascimento() {
        return dataNascimento;
    }

    public void setdataNascimento(LocalDate dataNascimento) {
        Validacao.verificaNulidade(dataNascimento, "Data de Nascimento");
        Validacao.verificaValidadeData(dataNascimento);
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        Validacao.verificaNulidade(cpf, "CPF");
        Validacao.assertNotBlank(cpf, "CPF");
        Validacao.verificaEspacoEmBranco(cpf, "CPF");
        CpfValidator.validaCpf(cpf);
        this.cpf = cpf;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        Validacao.verificaNulidade(contato, "Contato");
        this.contato = contato;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        Validacao.verificaNulidade(cargo, "Cargo");
        Validacao.assertNotBlank(cargo, "Cargo");
        Validacao.verificaEspacoEmBranco(cargo, "Cargo");
        this.cargo = cargo;
    }

    private void verificaSalarioPositivo(BigDecimal parametro) {
        if (!(parametro.compareTo(BigDecimal.ZERO) > 0)) {
            throw new IllegalArgumentException("O salário deve ser um valor positivo");
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", sobreNome=" + sobreNome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", contato=" + contato + ", cargo=" + cargo + ", salario=" + salario +
            ", departamento=" + departamento + "]";
    }

}
