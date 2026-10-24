package com.developer.disputaback.controller;


import com.developer.disputaback.dto.DisputaDto;
import com.developer.disputaback.dto.DisputasCompletaDto;
import com.developer.disputaback.entity.Filtro;
import com.developer.disputaback.service.ReadServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/read")
@RequiredArgsConstructor
public class ReaderCsvController {

    private static final Logger log = LoggerFactory.getLogger(ReaderCsvController.class);
    private final ReadServiceImpl readService;

    @GetMapping("/on")
    public String estaOn() {
        log.info("O serviço de leitura do arquivo CSV esta no ar.");
        return "O serviço de leitura do arquivo CSV esta no ar.";
    }

    @GetMapping
    public ResponseEntity<List<DisputasCompletaDto>> readCsv(){
        return ResponseEntity.ok(readService.getList());
    }

    @PostMapping
    public ResponseEntity<List<DisputasCompletaDto>> getListFilter(@RequestBody Filtro filtro){

        return ResponseEntity.ok(readService.getListFilter(filtro));
    }

    @PostMapping("/upload")
    public ResponseEntity<List<DisputaDto>> fazerUploadCSV(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().build();
//        }

//        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//
//            CsvToBean<DisputasDto> csvToBean = new CsvToBeanBuilder<DisputasDto>(reader)
//                    .withType(DisputasDto.class)
//                    .withSeparator(';')
//                    .withIgnoreLeadingWhiteSpace(true)
//                    .build();
//
//            List<DisputasDto> disputas = csvToBean.parse();
//
//            // Aqui você pode processar a lista ou salvar no banco de dados
//            return ResponseEntity.ok(disputas);
//
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body(null);
//        }
        return ResponseEntity.ok(readService.readCsv(file));
    }
}
