package br.com.fiveacademy.reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.fiveacademy.reserva.entities.Rota;
import br.com.fiveacademy.reserva.entities.Usuario;
import br.com.fiveacademy.reserva.services.FormataCpf;
import br.com.fiveacademy.reserva.services.VoltarMenu;

public class ReservaApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();
        List<Rota> rotas = new ArrayList<>();

        Rota rota1 = new Rota();
        rota1.setNumero(121);
        rota1.setDe("Rio de Janeiro");
        rota1.setPara("São Paulo");
        rota1.setValor(1580.00);
        rota1.setAssentos(34);

        Rota rota2 = new Rota();
        rota2.setNumero(211);
        rota2.setDe("São Paulo");
        rota2.setPara("Miami");
        rota2.setValor(3690.00);
        rota2.setAssentos(14);

        Rota rota3 = new Rota();
        rota3.setNumero(231);
        rota3.setDe("São Paulo");
        rota3.setPara("Nova Your");
        rota3.setValor(2390.00);
        rota3.setAssentos(11);

        rotas.add(rota1);
        rotas.add(rota2);
        rotas.add(rota3);

        int opcao = 1;

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("[1] - Criar usuário");
            System.out.println("[2] - Login no sistema");
            System.out.println("[3] - Visualizar rotas disponíveis");
            System.out.println("[0] - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            VoltarMenu.voltarMenu(sc);

            if (opcao == 1) {
                Usuario usuario = new Usuario();
                System.out.print("Insira seu nome: ");
                usuario.setNome(sc.nextLine());
                System.out.println("Insira seu CPF (obs: 11 dígitos)");
                usuario.setCpf(sc.nextLine());
                usuarios.add(usuario);

                VoltarMenu.voltarMenu(sc);
                System.out.println("Usuário " + usuario.getCpf() + " cadastrado!");
            }

            if (opcao == 2) {
                FormataCpf formataCpf = new FormataCpf();

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
                                            usuario.buyRota(rota);
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
                                    rotasUsuario.remove(rota);
                                    rota.adicionaAssento();
                                    VoltarMenu.voltarMenu(sc);

                                    System.out.println("Cancelamento realizado!");

                                    break;
                                } else {
                                    System.out.println("Nenhuma rota cadastrada!");
                                }
                            }
                        }

                        if (opcao == 3) {
                            for (Usuario usuario : usuarios) {
                                List<Rota> rotasUsuario = usuario.getRotas();

                                if (rotasUsuario.isEmpty()) {
                                    System.out.println("Não existe nenhuma reserva para você!");
                                } else {
                                    rotasUsuario.forEach(System.out::println);
                                }
                            }
                        }

                    } while (opcao != 0);
                }
            }

            if (opcao == 3) {
                System.out.println("*****************\nRotas disponíveis\n*****************\n");
                rotas.forEach(System.out::println);

                System.out.print("\n\n0 - Voltar ao menu: ");
                int menu = sc.nextInt();
                if (menu == 0) {
                    VoltarMenu.voltarMenu(sc);
                }
            }

        } while (opcao != 0);

        sc.close();
    }

}