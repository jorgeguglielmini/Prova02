package br.com.contmatic.prova.empresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.contmatic.prova.empresa.validar.ConstantesMensagem;
import br.com.contmatic.prova.empresa.validar.ConstantesRegex;

public class Departamento {

    @NotNull
    @Pattern(regexp = ConstantesRegex.VALIDACAO_NOME_DEPARTAMENTO, message = ConstantesMensagem.NOME_DEPARTAMENTO_INVALIDO)
    private String nome;

    public Departamento(String nome) {
        this.setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public final int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public final boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
