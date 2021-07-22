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
        Fixture.of(Telefone.class).addTemplate("valido", new Rule() {
            {
                add("ddd", DDD.values()[RandomUtils.nextInt(0, DDD.values().length)]);
                add("numero", random("123456789", "235689784", "45781232", "123654987", "258147963", "98765432", "35795128"));
            }
        });

        Fixture.of(Telefone.class).addTemplate("atributo numero com menos de 8 dígitos").inherits("valido", new Rule() {
            {
                add("numero", random("123456", "5689784", "457", "87", "2", "5432", "95128"));
            }
        });

        Fixture.of(Telefone.class).addTemplate("atributo numero com mais de 9 dígitos").inherits("valido", new Rule() {
            {
                add("numero", random("1234516789", "23568978412", "457812312122", "1236549871234", "25814796312345", "98765432321423", "3579512832143243"));
            }
        });

        Fixture.of(Telefone.class).addTemplate("atributo numero com digito 0 no início e contendo a quantidade correta de digitos").inherits("valido", new Rule() {
            {
                add("numero", random("023456789", "035689784", "05781232", "023654987", "058147963", "08765432", "05795128"));
            }
        });
        
        Fixture.of(Telefone.class).addTemplate("atributo numero com caracteres alfabeticos").inherits("valido", new Rule() {
            {
                add("numero", random("asssdassd","sfasduih","dhausdhus"));
            }
        });
        
        Fixture.of(Telefone.class).addTemplate("atributo numero com caracteres alfabeticos e numericos").inherits("valido", new Rule() {
            {
                add("numero", random("a250assd","sfa666uih","d36987hus"));
            }
        });
        
        Fixture.of(Telefone.class).addTemplate("atributo numero com espaco em branco no inicio").inherits("valido", new Rule() {
            {
                add("numero", random(" 23654715"," 89562314"," 12345678"));
            }
        });
        
        Fixture.of(Telefone.class).addTemplate("atributo numero com espaco em branco no final").inherits("valido", new Rule() {
            {
                add("numero", random("23654715 ","89562314 ","12345678 "));
            }
        });

    }

}
