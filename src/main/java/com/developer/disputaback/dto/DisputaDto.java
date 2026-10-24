package com.developer.disputaback.dto;


import com.developer.disputaback.enuns.StatusDisputa;
import com.developer.disputaback.util.MoneyConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import com.opencsv.bean.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisputaDto {

    //    @CsvBindByName(column = "Data Compra")
//    @CsvDate("dd/MM/yyyy HH:mm")
//    private LocalDateTime dtCompra;
    @CsvBindByPosition(position = 0)
    @CsvDate("dd/MM/yyyy HH:mm")
    private LocalDateTime dtCompra;

    @CsvBindByPosition(position = 1)
    private Long transacao;

    //@CsvCustomBindByName(column = "Valor", converter = MoneyConverter.class)
    @CsvCustomBindByPosition(position = 2, converter = MoneyConverter.class)
    private Double valor;

    @CsvBindByPosition(position = 3)
    private String nomVendedor;

    @CsvBindByPosition(position = 4)
    private String nicVendedor;

    @CsvBindByPosition(position = 5)
    private String emaVendedor;

    @CsvBindByPosition(position = 6)
    private String nomComprador;

    @CsvBindByPosition(position = 7)
    private String nicComprador;

    @CsvBindByPosition(position = 8)
    private String emaComprador;

    @CsvBindByPosition(position = 9)
    @CsvDate("dd/MM/yyyy HH:mm")
    private LocalDateTime dtPrimComent;

    @CsvBindByPosition(position = 10)
    @CsvDate("dd/MM/yyyy HH:mm")
    private LocalDateTime dtUltComent;

    @CsvBindByPosition(position = 11)
    private String nomUltComent;

    @CsvBindByPosition(position = 12)
    private String nicUltComent;

    private StatusDisputa status;

//    public DisputasDto(Disputas disputas){
//        setId(disputas.getId());
//        setDtCompra(disputas.getDtCompra());
//        setTransacao(disputas.getTransacao());
//        setValor(disputas.getValor());
//        setNomVendedor(disputas.getNomVendedor());
//        setNicVendedor(disputas.getNicVendedor());
//        setEmaVendedor(disputas.getEmaVendedor());
//        setNomComprador(disputas.getNomComprador());
//        setNicComprador(disputas.getNicComprador());
//        setEmaComprador(disputas.getEmaComprador());
//        setDtPrimComent(disputas.getDtPrimComent());
//        setDtUltComent(disputas.getDtUltComent());
//        setNomUltComent(disputas.getNomUltComent());
//        setNicUltComent(disputas.getNicUltComent());
//        setObservacao(disputas.getObservacao());
//        setClassificacao(disputas.getClassificacao());
//        setAcompanhamento(disputas.getAcompanhamento());
//    }
}
