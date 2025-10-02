package com.elvis.app1.springboot_applications.core.dto;

/**
 * DTO de ejemplo para demostrar la estructura del módulo core
 */
public class InfoDto {
    private String mensaje;
    private String fecha;

    public InfoDto() {}

    public InfoDto(String mensaje, String fecha) {
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}