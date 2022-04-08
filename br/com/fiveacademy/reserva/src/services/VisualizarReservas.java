package br.com.fiveacademy.reserva.src.services;

import java.util.List;

import br.com.fiveacademy.reserva.src.entities.Rota;
import br.com.fiveacademy.reserva.src.entities.Usuario;

public class VisualizarReservas {

    public void visualizarReservas(List<Usuario> usuarios, String cpfValidado) {

        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpfValidado)) {
                List<Rota> rotasUsuario = usuario.getRotas();

                if (rotasUsuario.isEmpty()) {
                    System.out.println("Não existe nenhuma reserva para você!");
                } else {
                    rotasUsuario.forEach(System.out::println);
                }
            }
        }
    }
}
