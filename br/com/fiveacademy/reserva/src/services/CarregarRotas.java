package br.com.fiveacademy.reserva.src.services;

import java.util.List;

import br.com.fiveacademy.reserva.src.entities.Rota;

public class CarregarRotas {

    public void carregarRotas(List<Rota> rotas) {
        
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
    }
}
