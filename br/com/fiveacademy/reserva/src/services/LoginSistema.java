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

    public void logarSistema(List<Usuario> usuarios, List<Rota> rotas, List<Log> logs) throws ParseException, InterruptedException, IOException {

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

                if (opcao == 2) {
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

                if (opcao == 3) {
                    ReservasUsuario reservas = new ReservasUsuario();
                    reservas.reservasUsuario(usuarios);
                }

                if (opcao == 4) {
                    RelatorioLogs relatorio = new RelatorioLogs();
                    relatorio.relatorioLogs(logs);
                }

            } while (opcao != 0);
        }
    }
}
