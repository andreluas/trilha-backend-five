package br.com.fiveacademy.reserva.src.entities;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.MaskFormatter;

public class Usuario {

    private String nome;
    private String cpf;
    private List<Rota> rotas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws ParseException {
        if (cpf.length() == 11) {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);
            this.cpf = mask.valueToString(cpf);
        } else {
            throw new RuntimeException("CPF deve conter 11 dígitos!");
        }
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public void buyRota(Rota rota) {
        rotas.add(rota);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
