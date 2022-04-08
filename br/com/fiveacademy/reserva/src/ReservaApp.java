package br.com.fiveacademy.reserva.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fiveacademy.reserva.src.entities.Log;
import br.com.fiveacademy.reserva.src.entities.Rota;
import br.com.fiveacademy.reserva.src.entities.Usuario;
import br.com.fiveacademy.reserva.src.services.CarregarRotas;
import br.com.fiveacademy.reserva.src.services.CriarUsuario;
import br.com.fiveacademy.reserva.src.services.LoginSistema;
import br.com.fiveacademy.reserva.src.services.RotasDisponiveis;
import br.com.fiveacademy.reserva.src.services.VoltarMenu;

public class ReservaApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();
        List<Rota> rotas = new ArrayList<>();
        List<Log> logs = new ArrayList<>();

        CarregarRotas lista = new CarregarRotas();
        lista.carregarRotas(rotas);

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
                CriarUsuario usuario = new CriarUsuario();
                usuario.criarUsuario(usuarios);
            }

            if (opcao == 2) {
                LoginSistema login = new LoginSistema();
                login.logarSistema(usuarios, rotas, logs);
            }

            if (opcao == 3) {
                RotasDisponiveis rotasDisp = new RotasDisponiveis();
                rotasDisp.rotasDisponiveis(rotas);
            }

        } while (opcao != 0);

        sc.close();
    }

}