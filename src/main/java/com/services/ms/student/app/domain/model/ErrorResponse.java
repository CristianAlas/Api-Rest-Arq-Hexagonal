package com.services.ms.student.app.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Representa una respuesta de error que puede ser enviada al cliente en caso de una excepción o error.
 * Esta clase encapsula detalles sobre el error, incluyendo un código, un mensaje, detalles adicionales y una marca de tiempo.
 *
 * @author CristianAlas
 *
 */
@Builder
@Setter
@Getter
public class ErrorResponse {


    /**
     * Código único que representa el tipo de error.
     */
    private String code;

    /**
     * Mensaje legible para humanos que describe el error.
     */
    private String message;

    /**
     * Lista de detalles adicionales o causas relacionadas con el error.
     */
    private List<String> details;

    /**
     * Marca de tiempo que indica cuándo ocurrió el error.
     */
    private LocalDateTime timestamp;
}
