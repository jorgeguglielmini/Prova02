package br.com.contmatic.prova.empresa;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Contato {

    @NotNull
    @Pattern(regexp = ("^([A-Za-z0-9._%+-]{4,20})+@([a-z0-9.-]{2,15})?([a-z]{2,4})"), message = "e-mail inválido")
    private String email;

    @Valid
    @NotNull
    private Telefone telefone;

    public Contato(String email, Telefone telefone) {
        this.setEmail(email);
        this.setTelefone(telefone);
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.email).append(this.telefone).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contato) {
            Contato contato = (Contato) obj;
            return new EqualsBuilder().append(this.email, contato.email).append(this.telefone, contato.telefone).isEquals();
        }
        return false;
    }

    @Override
	public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
