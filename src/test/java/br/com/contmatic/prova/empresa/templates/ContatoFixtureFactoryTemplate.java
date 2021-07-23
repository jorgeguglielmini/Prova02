package br.com.contmatic.prova.empresa.templates;

import br.com.contmatic.prova.empresa.Contato;
import br.com.contmatic.prova.empresa.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ContatoFixtureFactoryTemplate implements TemplateLoader {


    @Override
    public void load() {
        new TelefoneFixtureFactoryTemplate().load();

        Telefone telefone = Fixture.from(Telefone.class).gimme("valido");
        
        Fixture.of(Contato.class).addTemplate("valido", new Rule() {
            {
                add("email", random("jorgeguglielmini@gmail.com","jorge_luiz.m.g@hotmail.com","jorge.luiz@contmatic.com.br"));
                add("telefone", telefone);
            }
        });
        
        Fixture.of(Contato.class).addTemplate("atributo email com espaco em branco no inicio").inherits("valido", new Rule() {
            {
                add("email", random(" jorgeguglielmini@gmail.com"," jorge_luiz.m.g@hotmail.com"," jorge.luiz@contmatic.com.br"));
            }
        });
        
        Fixture.of(Contato.class).addTemplate("atributo email com espaco em branco no final").inherits("valido", new Rule() {
            {
                add("email", random("jorgeguglielmini@gmail.com ","jorge_luiz.m.g@hotmail.com ","jorge.luiz@contmatic.com.br "));
            }
        });
    }

}
