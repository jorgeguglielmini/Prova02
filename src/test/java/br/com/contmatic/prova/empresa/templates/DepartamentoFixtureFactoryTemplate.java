package br.com.contmatic.prova.empresa.templates;

import br.com.contmatic.prova.empresa.Departamento;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class DepartamentoFixtureFactoryTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Departamento.class).addTemplate("valido", new Rule() {
            {
                add("nome", random("Tecnologia","Programação","Recursos Humanos"));
            }
        });
        
        Fixture.of(Departamento.class).addTemplate("atributo nome com apenas um caracter alfabetico").inherits("valido", new Rule() {
            {
                add("nome", regex("[A-Z]{1}"));
            }
        });
        
        Fixture.of(Departamento.class).addTemplate("atributo nome com apenas um caracter alfabetico minusculo").inherits("valido", new Rule() {
            {
                add("nome", regex("[a-z]{1}"));
            }
        });
        
        Fixture.of(Departamento.class).addTemplate("atributo nome com apenas um caracter numerico").inherits("valido", new Rule() {
            {
                add("nome", regex("[0-9]{1}"));
            }
        });
        
        Fixture.of(Departamento.class).addTemplate("atributo nome com caracteres numericos").inherits("valido", new Rule() {
            {
                add("nome", regex("[0-9]{2,100}"));
            }
        });
    }

}
