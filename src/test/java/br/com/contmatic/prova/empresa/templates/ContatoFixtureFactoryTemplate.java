package br.com.contmatic.prova.empresa.templates;

import br.com.contmatic.prova.empresa.Contato;
import br.com.contmatic.prova.empresa.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ContatoFixtureFactoryTemplate implements TemplateLoader {

    Telefone telefone = Fixture.from(Telefone.class).gimme("valido");

    @Override
    public void load() {
        Fixture.of(Contato.class).addTemplate("valido", new Rule() {
            {
                add("email", random("jorgeguglielmini@gmail.com","jorge_luiz.m.g@hotmail.com","jorge.luiz@contmatic.com.br"));
                add("telefone", telefone);
            }
        });
        
        
    }

}
