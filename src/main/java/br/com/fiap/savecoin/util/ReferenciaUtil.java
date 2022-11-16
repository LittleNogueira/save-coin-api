package br.com.fiap.savecoin.util;

import java.time.LocalDate;

import static java.lang.String.format;

public class ReferenciaUtil {

    public static String atual(){
        LocalDate dataAtual = LocalDate.now();
        return format("%s%s", dataAtual.getMonthValue(), dataAtual.getYear());
    }

}
