package br.com.contmatic.prova.empresa.templates;

import br.com.contmatic.prova.empresa.Telefone;
import br.com.contmatic.prova.empresa.enums.DDD;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.base.Range;
import br.com.six2six.fixturefactory.function.impl.RegexFunction;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class TelefoneFixtureFactoryTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Telefone.class).addTemplate("valido", new Rule() {{
			add("ddd", random(DDD.class);
			add("numero", regex ="^[1-9]{1}[0-9]{7-8}");
		}});
	}
	

}
