package com.services.ms.student.app.infrastructure.adapters.input.rest.model.response;

import lombok.*;

/**
 * Clase que representa el modelo de respuesta (response) enviado al cliente
 * cuando se consultan o crean datos de un estudiante a través de la API REST.
 *
 * Contiene información básica del estudiante, incluyendo su identificador único,
 * y utiliza anotaciones de Lombok para generar automáticamente getters, setters,
 * constructores y el patrón builder.
 *
 * @author CristianAlas
 *
 */

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    /**
     * Identificador único del estudiante.
     */
    private Long id;

    /**
     * Nombre del estudiante.
     */
    private String firstname;

    /**
     * Apellido del estudiante.
     */
    private String lastname;

    /**
     * Edad del estudiante.
     */
    private Integer age;

    /**
     * Dirección del estudiante.
     */
    private String address;

}
