package br.com.contmatic.prova.empresa;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Contato {

	@NotNull
	@Pattern(regexp = ("^([A-Za-z0-9._%+-]{4,20})+@([a-z0-9.-]{2,10})?([a-z]{2,4})"), message = "e-mail inválido")
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
	public String toString() {
		return "Contato [email=" + email + ", telefone=" + telefone + "]";
	}
}
