package br.com.contmatic.prova.empresa.gerador;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Gerador {

    private Gerador() {

    }

    public static Calendar geraDataAtual() {
        Date dataAtual = new Date();
        Calendar dataDiaAtual = Calendar.getInstance();
        dataDiaAtual.setTime(dataAtual);
        return dataDiaAtual;
    }

    public static int geraNumeroAleatorio(int minimo, int maximo) {
        Random random = new Random();
        return random.nextInt((maximo - minimo) + 1) + minimo;
    }

    public static String geraStringAleatoria(int casas) {
        StringBuilder palavra = new StringBuilder();
        for(int i = 0 ; i < casas ; i++) {
            palavra.append((char) (geraIntervaloCaracteresNormaisTabelaAscII(geraNumeroAleatorio(0, 50))));
        }
        return palavra.toString();
    }

    public static int geraIntervaloCaracteresNormaisTabelaAscII(int numeroAleatorio) {
        if (numeroAleatorio < 26) {
            return numeroAleatorio + 65;
        }
        if (numeroAleatorio >= 26) {
            return numeroAleatorio + 71;
        }
        return -1;
    }

    public static String geraStringEspecialAleatoria(int casas) {
        StringBuilder palavraEspecial = new StringBuilder();
        for(int i = 0 ; i < casas ; i++) {
            palavraEspecial.append((char) (geraIntervaloCaracteresEspeciaisTabelaAscII(geraNumeroAleatorio(0, 42))));
        }
        return palavraEspecial.toString();
    }

    public static int geraIntervaloCaracteresEspeciaisTabelaAscII(int numeroAleatorio) {
        if (numeroAleatorio < 32) {
            return numeroAleatorio + 32;
        }
        if (numeroAleatorio >= 32 && numeroAleatorio < 37) {
            return numeroAleatorio + 59;
        }
        if (numeroAleatorio >= 37 && numeroAleatorio < 41) {
            return numeroAleatorio + 86;
        }

        return -1;
    }

}
