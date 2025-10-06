package com.elvis.app1.springboot_applications.service;

import com.elvis.app1.springboot_applications.core.dto.InfoDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Servicio de ejemplo que maneja la lógica de negocio
 */
@Service
public class InfoService {

    public InfoDto obtenerInformacion() {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return new InfoDto("Información desde el servicio multimodular", fecha);
    }

    public InfoDto obtenerInformacionPersonalizada(String mensaje) {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return new InfoDto(mensaje, fecha);
    }
}