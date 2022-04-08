package br.com.fiveacademy.reserva.src.services;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.fiveacademy.reserva.src.entities.Rota;

public class RotasDisponiveis {

    public void rotasDisponiveis(List<Rota> rotas) throws InterruptedException, IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("*****************\nRotas disponíveis\n*****************\n");
        rotas.forEach(System.out::println);

        System.out.print("\n\n0 - Voltar ao menu: ");
        int menu = sc.nextInt();
        if (menu == 0) {
            VoltarMenu.voltarMenu(sc);
        }
    }
}
