package br.com.contmatic.prova.empresa.templates;

import com.mifmif.common.regex.Generex;

import br.com.contmatic.prova.empresa.Departamento;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class DepartamentoFixtureFactoryTemplate implements TemplateLoader {

    @Override
    public void load() {
        
        Fixture.of(Departamento.class).addTemplate("valido", new Rule() {
            {
                add("nome", random("Recursos Humanos","Desenvolvimento","Tencologia","Programação"));
            }
        });
        
        Fixture.of(Departamento.class).addTemplate("atributo nome com apenas um caracter alfabetico maiusculo").inherits("valido", new Rule() {
            {
                
                add("nome", new Generex("[A-Z]{1}").random());
            }
        });
        
        Fixture.of(Departamento.class).addTemplate("atributo nome com apenas um caracter alfabetico minusculo").inherits("valido", new Rule() {
            {
                add("nome", new Generex("[a-z]{1}").random());
            }
        });
        
        Fixture.of(Departamento.class).addTemplate("atributo nome com apenas um caracter numerico").inherits("valido", new Rule() {
            {
                add("nome", new Generex("[0-9]{1}").random());
            }
        });
        
        Fixture.of(Departamento.class).addTemplate("atributo nome com caracteres numericos").inherits("valido", new Rule() {
            {
                add("nome", new Generex("[0-9]{2,100}").random());
            }
        });
    }

}
