package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.empresa.validar.Validacao.assertNotBlank;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaEspacoEmBranco;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaNulidade;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaSomenteNumeros;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoDdd;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaTamanhoNumeroTelefone;
import static br.com.contmatic.prova.empresa.validar.Validacao.verificaValidadeDdd;

public class Telefone {
    
	private static final String DDD_TEXTO = "DDD";

    private String ddd;
	
	private String numero;
	
	public static final String[] DDD = { "11", "12", "13", "14", "15", "16", "17", "18", "19", "21", "22", "24", "27",
			"28", "31", "32", "33", "34", "35", "37", "38", "41", "42", "43", "44", "45", "46", "47", "48", "49", "51",
			"53", "54", "55", "61", "62", "63", "64", "65", "66", "67", "68", "69", "71", "73", "74", "75", "77", "79",
			"81", "82", "83", "84", "85", "86", "87", "88", "89", "91", "92", "93", "94", "95", "96", "97", "98",
			"99", };

	public Telefone(String ddd, String numero) {
		this.setDdd(ddd);
		this.setNumero(numero);
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		verificaNulidade(ddd,DDD_TEXTO);
		assertNotBlank(ddd, DDD_TEXTO);
		verificaSomenteNumeros(ddd, DDD_TEXTO);
		verificaEspacoEmBranco(ddd, DDD_TEXTO);
		verificaTamanhoDdd(ddd);
		verificaValidadeDdd(ddd);
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		verificaNulidade(numero,"Número");
		assertNotBlank(numero, "Número");
	    verificaEspacoEmBranco(numero, "Número");
		verificaTamanhoNumeroTelefone(numero);
		verificaSomenteNumeros(numero, "Número do telefone");
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
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
		Telefone other = (Telefone) obj;
		if (ddd == null) {
			if (other.ddd != null)
				return false;
		} else if (!ddd.equals(other.ddd))
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
		return "Telefone [ddd=" + ddd + ", numero=" + numero + "]";
	}

}
