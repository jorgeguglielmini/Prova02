package br.com.contmatic.prova.empresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.contmatic.prova.empresa.enums.DDD;
import br.com.contmatic.prova.empresa.validar.ConstantesMensagem;
import br.com.contmatic.prova.empresa.validar.ConstantesRegex;

public class Telefone {

    @NotNull
    @Pattern(regexp = ConstantesRegex.VALIDACAO_NUMERO_TELEFONE, message = ConstantesMensagem.NUMERO_INVALIDO)
    private String numero;

    @NotNull
    private DDD ddd;

    public Telefone(DDD ddd, String numero) {
        this.setDdd(ddd);
        this.setNumero(numero);
    }

    public DDD getDdd() {
        return ddd;
    }

    public void setDdd(DDD ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(this.ddd).append(this.numero).hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof Telefone) {
            Telefone telefone = (Telefone) obj;
            return new EqualsBuilder().append(this.ddd, telefone.ddd).append(this.numero, telefone.numero).isEquals();
        }
        return false;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
