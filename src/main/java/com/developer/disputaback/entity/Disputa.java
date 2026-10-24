package com.developer.disputaback.entity;

import com.developer.disputaback.dto.DisputaDto;
import com.developer.disputaback.enuns.StatusDisputa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Disputa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataCompra;
    private Long transacao;
    private Double valor;
    private String nomeVendedor;
    private String nickVendedor;
    private String emailVendedor;
    private String nomeComprador;
    private String nickComprador;
    private String emailComprador;
    private LocalDateTime dataPrimeiroComent;
    private LocalDateTime dataUltComent;
    private String nomeUltComent;
    private String nickUltComent;
    private String observacao;
    private String classificacao;
    private LocalDateTime retorno;
    private StatusDisputa status;

    public Disputa(DisputaDto disputasDto){
        setDataCompra(disputasDto.getDtCompra());
        setTransacao(disputasDto.getTransacao());
        setValor(disputasDto.getValor());
        setNomeVendedor(disputasDto.getNomVendedor());
        setNickVendedor(disputasDto.getNicVendedor());
        setEmailVendedor(disputasDto.getEmaVendedor());
        setNomeComprador(disputasDto.getNomComprador());
        setNickComprador(disputasDto.getNicComprador());
        setEmailComprador(disputasDto.getEmaComprador());
        setDataPrimeiroComent(disputasDto.getDtPrimComent());
        setDataUltComent(disputasDto.getDtUltComent());
        setNomeUltComent(disputasDto.getNomUltComent());
        setNickUltComent(disputasDto.getNicUltComent());
        setStatus(disputasDto.getStatus());
       //setObservacao(disputasDto.getObservacao());
        //setClassificacao(disputasDto.getClassificacao());
        //setRetorno(disputasDto.getAcompanhamento());
    }
}
