package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.empresa.validar.Validacao.assertNotBlank;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaEspacoEmBranco;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaNulidade;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoEmail;

public class Contato {

    private String email;

    private Telefone telefone;

    public Contato(String email, Telefone telefone) {
        this.setEmail(email);
        this.setTelefone(telefone);
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        verificaNulidade(telefone, "Telefone");
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        verificaNulidade(email, "Email");
        assertNotBlank(email, "Email");
        verificaEspacoEmBranco(email, "Email");
        verificaTamanhoEmail(email);
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato [email=" + email + ", telefone=" + telefone + "]";
    }
}
