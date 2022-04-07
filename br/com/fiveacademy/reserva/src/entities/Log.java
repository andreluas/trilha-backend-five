package br.com.fiveacademy.reserva.src.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    private String timestamp;
    private String usuario;
    private String acao;
    private double valor;

    public Log() {
    }

    public Log(String timestamp, String usuario, String acao, double valor) {
        this.timestamp = timestamp;
        this.usuario = usuario;
        this.acao = acao;
        this.valor = valor;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void comprarRota(Rota rota, Usuario usuario) {
        setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss")));
        setUsuario(usuario.getNome());
        setAcao("Comprou a rota de número: " + rota.getNumero());
        setValor(rota.getValor());
    }

    public void cancelarRota(Rota rota, Usuario usuario) {
        setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss")));
        setUsuario(usuario.getNome());
        setAcao("Cancelou a rota de número: " + rota.getNumero());
        setValor(rota.getValor());
    }

    @Override
    public String toString() {
        return "Timestamp: " + timestamp + "\nUsuario: " + usuario + "\nAção: " + acao + "\nValor: " + valor + "\n----------";        
    }
}