package com.LabMovix.Movix.client;


import lombok.Getter;
import lombok.Setter;

public class Correo {
    @Getter
    @Setter
    private String usuarioCorreo;
    @Getter
    @Setter
    private String contrasena;
    @Getter
    @Setter
    private String rutaArchivo;
    @Getter
    @Setter
    private String nombreArchivo;
    @Getter
    @Setter
    private String destino;
    @Getter
    @Setter
    private String asunto;
    @Getter
    @Setter
    private String mensaje;
}