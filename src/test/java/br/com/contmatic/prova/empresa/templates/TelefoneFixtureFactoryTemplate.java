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
			add("numero", regex("^[1-9]{1}[0-9]{7-8}"));
		}});
	}
	
}
