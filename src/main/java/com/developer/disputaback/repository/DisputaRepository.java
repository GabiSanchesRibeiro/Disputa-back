package com.developer.disputaback.repository;

import com.developer.disputaback.entity.Disputa;
import com.developer.disputaback.entity.Filtro;
import com.developer.disputaback.entity.Teste;
import com.developer.disputaback.enuns.StatusDisputa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DisputaRepository extends JpaRepository<Disputa,Long> {

    Optional<Disputa> findByTransacao(Long transacao);

    @Query("select d from Disputa d" +
            " where 1 = 1 " +
            " and (:status is null or d.status = :status)" +
            " and (:dataCompra is null or d.dataCompra = :dataCompra)" +
            " and (:transacao is null or d.transacao = :transacao)" +
            " and (:valor is null or d.valor = :valor)" +
            " and (:nomeVendedor is null or d.nomeVendedor = :nomeVendedor)" +
            " and (:nickVendedor is null or d.nickVendedor = :nickVendedor)" +
            " and (:emailVendedor is null or d.emailVendedor = :emailVendedor)" +
            " and (:nomeComprador is null or d.nomeComprador = :nomeComprador)" +
            " and (:nickComprador is null or d.nickComprador = :nickComprador)" +
            " and (:emailComprador is null or d.emailComprador = :emailComprador)" +
            " and (:dataPrimeiroComent is null or d.dataPrimeiroComent = :dataPrimeiroComent)" +
            " and (:dataUltComent is null or d.dataUltComent = :dataUltComent)" +
            " and (:nomeUltComent is null or d.nomeUltComent = :nomeUltComent)" +
            " and (:nickUltComent is null or d.nickUltComent = :nickUltComent)" +
            " and (:observacao is null or d.observacao = :observacao)" +
            " and (:classificacao is null or d.classificacao = :classificacao)" +
            " and (:acompanhamento is null or d.retorno = :acompanhamento)")
    List<Disputa> findByFilter(
            @Param("status") StatusDisputa status,
            @Param("dataCompra") LocalDateTime dataCompra,
            @Param("transacao") Long transacao,
            @Param("valor") Double valor,
            @Param("nomeVendedor") String nomeVendedor,
            @Param("nickVendedor") String nickVendedor,
            @Param("emailVendedor") String emailVendedor,
            @Param("nomeComprador") String nomeComprador,
            @Param("nickComprador") String nickComprador,
            @Param("emailComprador") String emailComprador,
            @Param("dataPrimeiroComent") LocalDate dataPrimeiroComent,
            @Param("dataUltComent") LocalDate dataUltComent, // Adicionado (faltava nos parâmetros do método)
            @Param("nomeUltComent") String nomeUltComent,
            @Param("nickUltComent") String nickUltComent,
            @Param("observacao") String observacao,
            @Param("classificacao") String classificacao,
            @Param("retorno") String retorno
    );

    @Query(value = "select d from Disputa d" +
            " where 1 = 1 " +
            " and (:#{#filtro.status} is null or d.status = :#{#filtro.status})" +
            " and (:#{#filtro.dataCompra} is null or d.dataCompra between :#{#filtro.dataCompraIni} and :#{#filtro.dataCompraFim})"+
            " and (:#{#filtro.transacao} is null or d.transacao = :#{#filtro.transacao})" +
            " and (:#{#filtro.valor} is null or d.valor = :#{#filtro.valor})" +
            " and (:#{#filtro.nomeVendedor} is null or d.nomeVendedor = :#{#filtro.nomeVendedor})" +
            " and (:#{#filtro.nickVendedor} is null or d.nickVendedor = :#{#filtro.nickVendedor})" +
            " and (:#{#filtro.emailVendedor} is null or d.emailVendedor = :#{#filtro.emailVendedor})" +
            " and (:#{#filtro.nomeComprador} is null or d.nomeComprador = :#{#filtro.nomeComprador})" +
            " and (:#{#filtro.nickComprador} is null or d.nickComprador = :#{#filtro.nickComprador})" +
            " and (:#{#filtro.emailComprador} is null or d.emailComprador = :#{#filtro.emailComprador})" +
            " and (:#{#filtro.dataPrimeiroComent} is null or d.dataPrimeiroComent between :#{#filtro.dataPrimeiroComentIni} and :#{#filtro.dataPrimeiroComentFim})"+
            " and (:#{#filtro.dataUltComent}  is null or d.dataUltComent  between :#{#filtro.dataUltComentIni} and :#{#filtro.dataUltComentFim})"+
            " and (:#{#filtro.nomeUltComent} is null or d.nomeUltComent = :#{#filtro.nomeUltComent})" +
            " and (:#{#filtro.nickUltComent} is null or d.nickUltComent = :#{#filtro.nickUltComent})" +
            " and (:#{#filtro.observacao} is null or d.observacao = :#{#filtro.observacao})" +
            " and (:#{#filtro.classificacao} is null or d.classificacao = :#{#filtro.classificacao})" +
            " and (:#{#filtro.retorno} is null or d.retorno between :#{#filtro.retornoIni} and :#{#filtro.retornoFim})"
    )
    List<Disputa> findByFilter(@Param("filtro") Filtro filtro);
// " and (:#{#filtro.dtPrimComentInicio} is null or :#{#filtro.dtPrimComentFim} is null or d.dtPrimComent between :#{#filtro.dtPrimComentInicio} and :#{#filtro.dtPrimComentFim})"
}
