package br.com.fiveacademy.reserva.src.entities;

public class Rota {

    private int numero;
    private String de;
    private String para;
    private double valor;
    private int assentos;

    public Rota() {
    }

    public Rota(int numero, String de, String para, double valor, int assentos) {
        this.numero = numero;
        this.de = de;
        this.para = para;
        this.valor = valor;
        this.assentos = assentos;
    }

    public String getDe() {
        return de;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

    public void subtraiAssento() {
        assentos = assentos - 1;
    }

    public void adicionaAssento() {
        assentos = assentos + 1;
    }

    @Override
    public String toString() {
        return "[" + numero + "] " + de + " -> " + para + " | Valor: R$ " + valor + " | Assentos disponíveis: "
                + assentos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
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
        Rota other = (Rota) obj;
        if (numero != other.numero)
            return false;
        return true;
    }

}
