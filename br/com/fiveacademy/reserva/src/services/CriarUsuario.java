package br.com.fiveacademy.reserva.src.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import br.com.fiveacademy.reserva.src.entities.Usuario;

public class CriarUsuario {

    public void criarUsuario(List<Usuario> usuarios) throws InterruptedException, IOException, ParseException {

        Scanner sc = new Scanner(System.in);
        Usuario usuario = new Usuario();
        System.out.print("Insira seu nome: ");
        usuario.setNome(sc.nextLine());
        System.out.println("Insira seu CPF (obs: 11 dígitos)");
        usuario.setCpf(sc.nextLine());
        usuarios.add(usuario);

        VoltarMenu.voltarMenu(sc);
        System.out.println("Usuário " + usuario.getCpf() + " cadastrado!");
    }
}
