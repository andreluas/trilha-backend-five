package br.com.fiveacademy.reserva.src.services;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.fiveacademy.reserva.src.entities.Log;
import br.com.fiveacademy.reserva.src.entities.Rota;
import br.com.fiveacademy.reserva.src.entities.Usuario;

public record ReservarRota() {

    public void reservarRota(List<Rota> rotas, List<Usuario> usuarios, List<Log> logs, String cpfValidado)
            throws InterruptedException, IOException {

        Scanner sc = new Scanner(System.in);

        rotas.forEach(System.out::println);
        System.out.print("Digite o número da rota desejada: ");
        int rotaEscolhida = sc.nextInt();

        for (Rota rota : rotas) {
            if (rota.getNumero() == rotaEscolhida) {
                for (Usuario usuario : usuarios) {
                    if (usuario.getCpf().equals(cpfValidado)) {
                        Log log = new Log();
                        usuario.buyRota(rota);
                        log.comprarRota(rota, usuario);
                        logs.add(log);
                        VoltarMenu.voltarMenu(sc);
                    }
                }

                rota.subtraiAssento();
                System.out.println("Rota adicionada!");
            }
        }
    }
}
