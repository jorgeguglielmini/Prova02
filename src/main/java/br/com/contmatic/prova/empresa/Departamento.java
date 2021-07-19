package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.empresa.validar.Validacao.assertNotBlank;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaNulidade;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaSomenteLetras;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoDepartamento;

public class Departamento {

	private String nome;
	
	public Departamento(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificaNulidade(nome, "Nome");
		assertNotBlank(nome,"Nome");
		verificaSomenteLetras(nome, "Departamento");
		verificaTamanhoDepartamento(nome);
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Departamento other = (Departamento) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [nome=" + nome + "]";
	}

}
