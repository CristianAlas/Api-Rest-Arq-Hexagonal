package com.services.ms.student.app.utils;

import lombok.Getter;

/**
 * Catálogo de errores utilizados en la aplicación.
 * <p>
 * Define códigos y mensajes estándar para distintos tipos de errores,
 * facilitando la gestión y la comunicación de errores a través de la aplicación.
 * </p>
 *
 * <ul>
 *   <li><b>STUDENT_NOT_FOUND:</b> Error para cuando un estudiante no es encontrado.</li>
 *   <li><b>INVALID_STUDENT:</b> Error para parámetros inválidos en un estudiante.</li>
 *   <li><b>GENERIC_ERROR:</b> Error genérico para situaciones inesperadas.</li>
 * </ul>
 *
 * Cada constante tiene un código de error único y un mensaje asociado.
 *
 * @author CristianAlasSv
 */
@Getter
public enum ErrorCatalog {

    STUDENT_NOT_FOUND("ERR_STUDENT_001", "Student not found."),
    INVALID_STUDENT("ERR_STUDENT_002", "Invalid Student parameters."),
    GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred.");

    /**
     * Código único que identifica el error.
     */
    private final String code;

    /**
     * Mensaje descriptivo del error.
     */
    private final String message;

    /**
     * Constructor privado para inicializar el código y mensaje del error.
     *
     * @param code Código de error único.
     * @param message Mensaje descriptivo del error.
     */
    ErrorCatalog(String code, String message){
        this.code = code;
        this.message = message;
    }
}
