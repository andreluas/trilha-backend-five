package br.com.fiveacademy.reserva.src.services;

import java.util.List;

import br.com.fiveacademy.reserva.src.entities.Rota;
import br.com.fiveacademy.reserva.src.entities.Usuario;

public class ReservasUsuario {
    
    public void reservasUsuario(List<Usuario> usuarios) {

        for (Usuario usuario : usuarios) {
            List<Rota> rotasUsuario = usuario.getRotas();

            if (rotasUsuario.isEmpty()) {
                System.out.println("Não existe nenhuma reserva para você!");
            } else {
                rotasUsuario.forEach(System.out::println);
            }
        }
    }
}
