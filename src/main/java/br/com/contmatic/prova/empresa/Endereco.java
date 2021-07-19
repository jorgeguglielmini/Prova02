package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.empresa.validar.Validacao.assertNotBlank;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaEspacoEmBranco;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaNulidade;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaSomenteNumeros;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoBairro;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoCep;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoCidade;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoLogradouro;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoNumeroEndereco;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoUf;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaUF;

public class Endereco {

    private String uf;

    private String cidade;

    private String bairro;

    private String logradouro;

    private String numero;

    private String cep;

    public static final String[] SIGLAS_UF = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE",
        "SP", "TO" };

    public Endereco(String cep, String numero) {
        this.setCep(cep);
        this.setNumero(numero);
    }

    public Endereco(String uf, String cidade, String bairro, String logradouro, String numero, String cep) {
        this.setUf(uf);
        this.setCidade(cidade);
        this.setBairro(bairro);
        this.setLogradouro(logradouro);
        this.setNumero(numero);
        this.setCep(cep);
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        verificaNulidade(uf, "UF");
        assertNotBlank(uf, "UF");
        verificaEspacoEmBranco(uf, "UF");
        verificaTamanhoUf(uf);
        verificaUF(uf);
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        verificaNulidade(cidade, "Cidade");
        assertNotBlank(cidade, "Cidade");
        verificaEspacoEmBranco(cidade, "Cidade");
        verificaTamanhoCidade(cidade);
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        verificaNulidade(bairro, "Bairro");
        assertNotBlank(bairro, "Bairro");
        verificaEspacoEmBranco(bairro, "Bairro");
        verificaTamanhoBairro(bairro);
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        verificaNulidade(logradouro, "Logradouro");
        assertNotBlank(logradouro, "Logradouro");
        verificaEspacoEmBranco(logradouro, "Logradouro");
        verificaTamanhoLogradouro(logradouro);
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        verificaNulidade(numero, "Número");
        assertNotBlank(numero, "Número");
        verificaEspacoEmBranco(numero, "Número");
        verificaSomenteNumeros(numero, "Número");
        verificaTamanhoNumeroEndereco(numero);
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        verificaNulidade(cep, "Cep");
        assertNotBlank(cep, "Cep");
        verificaEspacoEmBranco(cep, "Cep");
        verificaSomenteNumeros(cep, "Cep");
        verificaTamanhoCep(cep);
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
        Endereco other = (Endereco) obj;
        if (cep == null) {
            if (other.cep != null)
                return false;
        } else if (!cep.equals(other.cep))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Endereco [uf=" + uf + ", cidade=" + cidade + ", bairro=" + bairro + ", logradouro=" + logradouro + ", numero=" + numero + ", cep=" + cep + "]";
    }

}
