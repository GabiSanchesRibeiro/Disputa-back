package com.developer.disputaback.service;

import com.developer.disputaback.dto.DisputaDto;

import com.developer.disputaback.dto.DisputasCompletaDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReadService {

    List<DisputaDto> readCsv(MultipartFile file);
    List<DisputasCompletaDto> getList();
}
