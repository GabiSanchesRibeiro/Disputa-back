package com.developer.disputaback.entity;

import com.developer.disputaback.enuns.StatusDisputa;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filtro {

    private StatusDisputa status;
    //@JsonFormat(pattern = "yyyy-MM-dd[ HH:mm:ss][ 'T'HH:mm:ss]")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    private LocalDateTime dataCompra;
    private Long transacao;
    private Double valor;
    private String nomeVendedor;
    private String nickVendedor;
    private String emailVendedor;
    private String nomeComprador;
    private String nickComprador;
    private String emailComprador;
    //@JsonFormat(pattern = "yyyy-MM-dd[ HH:mm:ss][ 'T'HH:mm:ss]")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    private LocalDateTime dataPrimeiroComent;
    //@JsonFormat(pattern = "yyyy-MM-dd[ HH:mm:ss][ 'T'HH:mm:ss]")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    private LocalDateTime dataUltComent;
    private String nomeUltComent;
    private String nickUltComent;
    private String observacao;
    private String classificacao;
    //@JsonFormat(pattern = "yyyy-MM-dd[ HH:mm:ss][ 'T'HH:mm:ss]")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    private LocalDateTime retorno;

    //variaveis para implementaçao between
    private LocalDateTime dataCompraIni;
    private LocalDateTime dataCompraFim;
    private LocalDateTime dataPrimeiroComentIni;
    private LocalDateTime dataPrimeiroComentFim;
    private LocalDateTime dataUltComentIni;
    private LocalDateTime dataUltComentFim;
    private LocalDateTime retornoIni;
    private LocalDateTime retornoFim;

//    public void setDtPrimComent(Object dtPrimComent) {
//        if (dtPrimComent instanceof String str) {
//            this.dtPrimComent = LocalDate.parse(str).atStartOfDay();
//        } else if (dtPrimComent instanceof LocalDateTime ldt) {
//            this.dtPrimComent = ldt;
//        } else if (dtPrimComent instanceof LocalDate ld) {
//            this.dtPrimComent = ld.atStartOfDay();
//        }
//    }
}

class FlexibleLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd")
            .optionalStart()
            .appendPattern("'T'HH:mm:ss")
            .optionalEnd()
            .optionalStart()
            .appendPattern(" HH:mm:ss")
            .optionalEnd()
            // Se o horário for omitido no JSON, preenche por padrão com 00:00:00
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
            .toFormatter();

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dateStr = p.getText();
        if (dateStr == null || dateStr.isBlank()) {
            return null;
        }
        return LocalDateTime.parse(dateStr.trim(), FORMATTER);
    }
}


