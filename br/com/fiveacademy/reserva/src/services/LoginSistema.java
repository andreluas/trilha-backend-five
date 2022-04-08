package br.com.fiveacademy.reserva.src.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.fiveacademy.reserva.src.entities.Log;
import br.com.fiveacademy.reserva.src.entities.Rota;
import br.com.fiveacademy.reserva.src.entities.Usuario;

public class LoginSistema {

    public void logarSistema(List<Usuario> usuarios, List<Rota> rotas, List<Log> logs)
            throws ParseException, InterruptedException, IOException {

        Scanner sc = new Scanner(System.in);
        FormataCpf formataCpf = new FormataCpf();

        int opcao = 1;

        System.out.println("Insira seu CPF (obs: 11 dígitos)");
        String cpfValidacao = sc.nextLine();
        String cpfValidado = formataCpf.formataCpf(cpfValidacao);

        List<Usuario> findCpf = usuarios.stream().filter(usuario -> usuario.getCpf().contains(cpfValidado))
                .collect(Collectors.toList());

        if (findCpf.isEmpty()) {
            System.out.println("CPF inexistente, favor se cadastrar no sistema.");
        } else {
            System.out.print("\nOlá ");
            findCpf.forEach(System.out::print);
            System.out.println(", seja bem-vindo(a)!");

            VoltarMenu.voltarMenu(sc);

            do {
                System.out.println("\n****\nMENU\n****\n");
                System.out.println("[1] - Reservar uma rota");
                System.out.println("[2] - Cancelar uma reserva");
                System.out.println("[3] - Visualizar minhas reservas");
                System.out.println("[4] - Relatório de Logs");
                System.out.println("[0] - Sair");
                System.out.print("Opção: ");
                opcao = sc.nextInt();
                VoltarMenu.voltarMenu(sc);

                if (opcao == 1) {
                    ReservarRota reserva = new ReservarRota();
                    reserva.reservarRota(rotas, usuarios, logs, cpfValidado);
                }

                if (opcao == 2) {
                    CancelarReserva cancelarReserva = new CancelarReserva();
                    cancelarReserva.cancelarReserva(usuarios, logs, cpfValidado);
                }

                if (opcao == 3) {
                    VisualizarReservas visualizarReservas = new VisualizarReservas();
                    visualizarReservas.visualizarReservas(usuarios, cpfValidado);
                }

                if (opcao == 4) {
                    RelatorioLogs relatorio = new RelatorioLogs();
                    relatorio.relatorioLogs(logs);
                }

            } while (opcao != 0);
        }
    }
}
