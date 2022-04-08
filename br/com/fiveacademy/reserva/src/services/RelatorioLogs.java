package br.com.fiveacademy.reserva.src.services;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.fiveacademy.reserva.src.entities.Log;

public class RelatorioLogs {

    public void relatorioLogs(List<Log> logs) throws InterruptedException, IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("********************\n RELATORIO DE LOGS \n********************");

        if (logs.isEmpty()) {
            System.out.println("Nenhum log de transação capturado!");
        } else {
            logs.forEach(System.out::println);
        }

        System.out.print("\n\n0 - Voltar ao menu: ");
        int menu = sc.nextInt();
        if (menu == 0) {
            VoltarMenu.voltarMenu(sc);
        }
    }
}
