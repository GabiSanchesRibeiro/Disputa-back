package com.developer.disputaback.service;


import com.developer.disputaback.dto.DisputaDto;
import com.developer.disputaback.dto.DisputasCompletaDto;
import com.developer.disputaback.entity.Disputa;
import com.developer.disputaback.entity.Filtro;
import com.developer.disputaback.enuns.StatusDisputa;
import com.developer.disputaback.repository.DisputaRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadServiceImpl implements ReadService {

    private static final Logger log = LoggerFactory.getLogger(ReadServiceImpl.class);
    private final DisputaRepository repository;

    public List<DisputaDto> readCsv(MultipartFile file){
        if (file.isEmpty()) {
            throw new IllegalArgumentException();
        }

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            CsvToBean<DisputaDto> csvToBean = new CsvToBeanBuilder<DisputaDto>(reader)
                    .withType(DisputaDto.class)
                    .withSeparator(';')
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<DisputaDto> disputas = csvToBean.parse();

            disputas.forEach(dto -> {
                if (dto == null || dto.getTransacao() == null) {
                    log.info("Pulando linha inválida ou com transação em branco. Pulando linha inválida ou com transação em branco.");
                    return;
                }

                if (repository.findByTransacao(dto.getTransacao()).isEmpty()){
                    Disputa novaDisputa = new Disputa(dto);
                    novaDisputa.setStatus(StatusDisputa.ABERTO);

                    repository.save(novaDisputa);
                    log.info("Transação " + dto.getTransacao() + " salva com sucesso.");
                } else {
                    log.info("Transação " + dto.getTransacao() + " já existe no banco. Pulando...");
                }
            });

            return disputas;

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Erro ao processar o CSV: " + e.getMessage(), e);
            throw new IllegalArgumentException("Erro ao processar o CSV: " + e.getMessage(), e);
        }
    }

    @Override
    public List<DisputasCompletaDto> getList() {
        List<DisputasCompletaDto> disputas = repository.findAll().stream()
                .map(DisputasCompletaDto::new)
                .toList();
        return disputas;
    }

   // @Override
    public List<DisputasCompletaDto> getListFilter(Filtro filtro) {
        if(filtro.getDataPrimeiroComent() != null){
            filtro.setDataPrimeiroComentIni(filtro.getDataPrimeiroComent().toLocalDate().atStartOfDay());
            filtro.setDataPrimeiroComentFim(filtro.getDataPrimeiroComent().toLocalDate().atTime(23, 59, 59));
        }

        if(filtro.getDataCompra() != null){
            filtro.setDataCompraIni(filtro.getDataCompra().toLocalDate().atStartOfDay());
            filtro.setDataCompraFim(filtro.getDataCompra().toLocalDate().atTime(23, 59, 59));
        }

        if(filtro.getDataUltComent() != null){
            filtro.setDataUltComentIni(filtro.getDataUltComent().toLocalDate().atStartOfDay());
            filtro.setDataUltComentFim(filtro.getDataUltComent().toLocalDate().atTime(23, 59, 59));
        }

      //  if(filtro.getAcompanhamento() != null){
      //      filtro.setAcompanhamentoIni(filtro.getAcompanhamento().toLocalDate().atStartOfDay());
      //     filtro.setAcompanhamentoFim(filtro.getAcompanhamento().toLocalDate().atTime(23,59,59));
       // }


        List<DisputasCompletaDto> list = repository.findByFilter(filtro).stream()
                .map(disputa -> new DisputasCompletaDto(disputa)).toList();
        return list;
    }
}
/*
@Override
public List<DisputasCompletaDto> getListFilter(Filtro filtro) {
    LocalDate dataDoFiltro = filtro.getDtPrimComent();
    // 1. Converte para LocalDateTime
    LocalDateTime dataConvertidaParaDateTime = dataDoFiltro != null ? dataDoFiltro.atStartOfDay() : null;

    // 2. Passa a data convertida explicitamente para o repositório (ajuste a assinatura no seu Repository se necessário)
    List<DisputasCompletaDto> list = repository.findByFilter(dataConvertidaParaDateTime).stream()
            .map(disputa -> new DisputasCompletaDto(disputa)).toList();
    return list;
}

 */