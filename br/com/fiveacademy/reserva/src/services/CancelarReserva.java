package br.com.fiveacademy.reserva.src.services;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.fiveacademy.reserva.src.entities.Log;
import br.com.fiveacademy.reserva.src.entities.Rota;
import br.com.fiveacademy.reserva.src.entities.Usuario;

public class CancelarReserva {

    public void cancelarReserva(List<Usuario> usuarios, List<Log> logs, String cpfValidado) throws InterruptedException, IOException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número da rota desejada, para exclusão: ");
        int rotaEscolhida = sc.nextInt();

        Usuario usuarioSelecionado = new Usuario();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCpf().equals(cpfValidado)) {
                Usuario usuarioCapturado = usuarios.get(i);
                usuarioSelecionado = usuarioCapturado;
            }
        }

        List<Rota> rotasUsuario = usuarioSelecionado.getRotas();

        for (Rota rota : rotasUsuario) {
            if (rota.getNumero() == rotaEscolhida) {
                Log log = new Log();
                rotasUsuario.remove(rota);
                rota.adicionaAssento();
                log.cancelarRota(rota, usuarioSelecionado);
                logs.add(log);
                VoltarMenu.voltarMenu(sc);

                System.out.println("Cancelamento realizado!");

                break;
            } else {
                System.out.println("Nenhuma rota cadastrada!");
            }
        }
    }
}
