package br.com.fiveacademy.reserva.services;

import java.io.IOException;
import java.util.Scanner;

public class VoltarMenu {
    public static void voltarMenu(Scanner sc) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        sc.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}
