package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.empresa.validar.CnpjValidator.validaCnpj;
import static br.com.contmatic.prova.empresa.validar.Validacao.assertNotBlank;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaEspacoEmBranco;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaNulidade;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoNomeFantasia;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoRazaoSocial;

public class Empresa {

    private String cnpj;

    private String nomeFantasia;

    private String razaoSocial;

    private Endereco endereco;

    private Contato contato;

    private Funcionario funcionario;

    public Empresa(String cnpj) {
        this.setCnpj(cnpj);
    }

    public Empresa(String cnpj, String nomeFantasia, String razaoSocial, Endereco endereco, Contato contato, Funcionario funcionario) {
        this.setCnpj(cnpj);
        this.setNomeFantasia(nomeFantasia);
        this.setRazaoSocial(razaoSocial);
        this.setEndereco(endereco);
        this.setContato(contato);
        this.setFuncionario(funcionario);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        verificaNulidade(endereco, "Endereço");
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        verificaNulidade(contato, "Contato");
        this.contato = contato;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        verificaNulidade(funcionario, "Funcionario");
        this.funcionario = funcionario;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        verificaNulidade(cnpj, "Cnpj");
        assertNotBlank(cnpj, "CNPJ");
        verificaEspacoEmBranco(cnpj, "CNPJ");
        validaCnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        verificaNulidade(nomeFantasia, "Nome Fantasia");
        assertNotBlank(nomeFantasia, "Nome Fantasia");
        verificaEspacoEmBranco(nomeFantasia, "Nome Fantasia");
        verificaTamanhoNomeFantasia(nomeFantasia);
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        verificaNulidade(razaoSocial, "Razão Social");
        assertNotBlank(razaoSocial, "Razão Social");
        verificaEspacoEmBranco(razaoSocial, "Razão Social");
        verificaTamanhoRazaoSocial(razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
        Empresa other = (Empresa) obj;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empresa [cnpj=" + cnpj + ", nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial + ", endereco=" + endereco + ", contato=" + contato + ", funcionario=" + funcionario + "]";
    }

}
