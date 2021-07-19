package br.com.contmatic.prova.empresa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class Repetidor {

	@Test
	public void test() {
		for (int i = 0; i < 100; i++) {
			org.junit.runner.Result resultado = JUnitCore.runClasses(Testador.class);
			for (Failure falha : resultado.getFailures()) {
				System.out.println(falha.getTestHeader());
				falha.getException().printStackTrace();
			}
			assertTrue(resultado.wasSuccessful());
		}

	}

}
