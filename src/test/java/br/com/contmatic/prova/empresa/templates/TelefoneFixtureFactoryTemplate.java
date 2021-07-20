package br.com.contmatic.prova.empresa.templates;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.prova.empresa.Telefone;
import br.com.contmatic.prova.empresa.enums.DDD;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class TelefoneFixtureFactoryTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Telefone.class).addTemplate("valido", new Rule() {{
			add("ddd", DDD.values()[RandomUtils.nextInt(0, DDD.values().length)]);
			add("numero", regex("^[1-9]{1}[0-9]{7,8}"));
		}});
		
		Fixture.of(Telefone.class).addTemplate("atributo numero com menos de 7 dígitos").inherits("valido" , new Rule() {{
			add("numero", regex("^[1-9]{1}[0-9]{1-5}"));
		}});
		
		Fixture.of(Telefone.class).addTemplate("atributo numero com mais de 9 dígitos").inherits("valido" , new Rule() {{
			add("numero", regex("^[1-9]{1}[0-9]{9,15}"));
		}});
		
		Fixture.of(Telefone.class).addTemplate("atributo numero com digito 0 no início e contendo a quantidade correta de digitos").inherits("valido" , new Rule() {{
			add("numero", regex("^[0]{1}[1-9]{7,8}"));
		}});
	}
	
}
