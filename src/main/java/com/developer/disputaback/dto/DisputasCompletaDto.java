package com.developer.disputaback.dto;

import com.developer.disputaback.entity.Disputa;
import com.developer.disputaback.enuns.StatusDisputa;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.CsvDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisputasCompletaDto {

    private Long id;
    private StatusDisputa status;
    private LocalDateTime dtCompra;
    private Long transacao;
    private Double valor;
    private String nomVendedor;
    private String nicVendedor;
    private String emaVendedor;
    private String nomComprador;
    private String nicComprador;
    private String emaComprador;
    private LocalDateTime dtPrimComent;
    private LocalDateTime dtUltComent;
    private String nomUltComent;
    private String nicUltComent;
    private String observacao;
    private String classificacao;
    private LocalDateTime retorno;

    public DisputasCompletaDto(Disputa disputas){
        setId(disputas.getId());
        setDtCompra(disputas.getDataCompra());
        setTransacao(disputas.getTransacao());
        setValor(disputas.getValor());
        setNomVendedor(disputas.getNomeVendedor());
        setNicVendedor(disputas.getNickVendedor());
        setEmaVendedor(disputas.getEmailVendedor());
        setNomComprador(disputas.getNomeComprador());
        setNicComprador(disputas.getNickComprador());
        setEmaComprador(disputas.getEmailComprador());
        setDtPrimComent(disputas.getDataPrimeiroComent());
        setDtUltComent(disputas.getDataUltComent());
        setNomUltComent(disputas.getNomeUltComent());
        setNicUltComent(disputas.getNickUltComent());
        setObservacao(disputas.getObservacao());
        setClassificacao(disputas.getClassificacao());
        setRetorno(disputas.getRetorno());
    }
}
