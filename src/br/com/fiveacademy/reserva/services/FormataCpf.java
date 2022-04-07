package br.com.fiveacademy.reserva.services;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class FormataCpf {

    public String formataCpf(String cpf) throws ParseException {
        MaskFormatter mask = new MaskFormatter("###.###.###-##");
        mask.setValueContainsLiteralCharacters(false);
        return mask.valueToString(cpf);
    }
}
