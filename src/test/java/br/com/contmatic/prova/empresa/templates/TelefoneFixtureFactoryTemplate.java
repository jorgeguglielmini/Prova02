package br.com.contmatic.prova.empresa.templates;

import org.apache.commons.lang3.RandomUtils;

import com.mifmif.common.regex.Generex;

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
                add("numero", new Generex("[0-9]{1,7}").random());
            }
        });

        Fixture.of(Telefone.class).addTemplate("atributo numero com mais de 9 dígitos").inherits("valido", new Rule() {
            {
                add("numero", new Generex("[0-9]{10,20}").random());
            }
        });

        Fixture.of(Telefone.class).addTemplate("atributo numero com digito 0 no início e contendo a quantidade correta de digitos").inherits("valido", new Rule() {
            {
                add("numero", new Generex("^[0][0-9]{7,8}").random());
            }
        });

        Fixture.of(Telefone.class).addTemplate("atributo numero com caracteres alfabeticos").inherits("valido", new Rule() {
            {
                add("numero", new Generex("[a-zA-Z]{8,9}").random());
            }
        });

        Fixture.of(Telefone.class).addTemplate("atributo numero com caracteres alfabeticos e numericos").inherits("valido", new Rule() {
            {
                add("numero", new Generex("[a-zA-Z0-9]{8,9}").random());
            }
        });

        Fixture.of(Telefone.class).addTemplate("atributo numero com espaco em branco no inicio").inherits("valido", new Rule() {
            {
                add("numero", new Generex("[ 0-9]{8,9}").random());
            }
        });

        Fixture.of(Telefone.class).addTemplate("atributo numero com espaco em branco no final").inherits("valido", new Rule() {
            {
                add("numero", new Generex("[0-9 ]{8,9}").random());
            }
        });

    }

}
