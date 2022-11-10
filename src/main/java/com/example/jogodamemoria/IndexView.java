package com.example.jogodamemoria;

import lombok.Getter;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IndexView {

    @Getter
    private String[] escondidas = {
            "/imagens/aviao.png",
            "/imagens/balao.png",
            "/imagens/barco.png",
            "/imagens/bicicleta.png",
            "/imagens/carro.png",
            "/imagens/dirigivel.png",
            "/imagens/foguete.png",
            "/imagens/helicoptero.png",
            "/imagens/moto.png",
            "/imagens/navio.png",
            "/imagens/aviao.png",
            "/imagens/balao.png",
            "/imagens/barco.png",
            "/imagens/bicicleta.png",
            "/imagens/carro.png",
            "/imagens/dirigivel.png",
            "/imagens/foguete.png",
            "/imagens/helicoptero.png",
            "/imagens/moto.png",
            "/imagens/navio.png"
    };

    @Getter
    private String[] imagens = {
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png",
            "/imagens/interrogacao.png"
    };

    private int escolha = 1;
    private int ind1 = 0;
    private int ind2 = 0;
    private boolean iguais = false;

    public IndexView() {
        Collections.shuffle(Arrays.asList(escondidas));
    }

    @Command
    @NotifyChange("imagens")
    public void mostrar(@BindingParam("ind") int ind) {

        if (!imagens[ind].equals("/imagens/interrogacao.png")) {
            // se a imagem clicada nao é uma interrogacao, nao faz nada
            return;
        }

        if (escolha == 1) {
            // se eh a primeira escolha
            if (!iguais) {
                // se a escolha anterior nao foi de duas imagens iguais
                // voltar as imagens para interrogacao
                imagens[ind1] = "/imagens/interrogacao.png";
                imagens[ind2] = "/imagens/interrogacao.png";
            }

            imagens[ind] = escondidas[ind];
            ind1 = ind;

        }

        if (escolha == 2) {
            // se eh a segunda escolha
            imagens[ind] = escondidas[ind];
            ind2 = ind;

            if (escondidas[ind1].equals(escondidas[ind2])) {
                // as imagens sao iguais
                iguais = true;
            }
            else {
                // as imagens sao diferentes
                iguais = false;
            }


        }

        // muda escolha de 1 para 2 e vice-versa
        escolha = (escolha == 1) ? 2: 1;

    }

    @Command
    @NotifyChange("imagens")
    public void reiniciar() {
        escolha = 1;
        ind1 = 0;
        ind2 = 0;
        iguais = false;
        for(int i = 0; i < imagens.length; i++) {
            imagens[i] = "/imagens/interrogacao.png";
        }
    }

}
