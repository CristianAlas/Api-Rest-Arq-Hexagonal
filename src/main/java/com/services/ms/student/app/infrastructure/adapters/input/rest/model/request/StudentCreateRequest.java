package com.services.ms.student.app.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Clase que representa el cuerpo de una solicitud (request) para crear un nuevo estudiante
 * a través de la API REST.
 *
 * Utiliza anotaciones de validación para asegurar que los campos obligatorios sean proporcionados
 * correctamente por el cliente. También emplea Lombok para reducir el código repetitivo.
 *
 * @author CristianAlas
 *
 */

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {

    /**
     * Nombre del estudiante.
     * No puede estar vacío ni ser nulo.
     */
    @NotBlank(message = "Field firstname cannot be empty or null.")
    private String firstname;

    /**
     * Apellido del estudiante.
     * No puede estar vacío ni ser nulo.
     */
    @NotBlank(message = "Field lastname cannot be empty or null.")
    private String lastname;

    /**
     * Edad del estudiante.
     * No puede ser nula.
     */
    @NotNull(message = "Field age cannot be null.")
    private Integer age;

    /**
     * Dirección del estudiante.
     * No puede estar vacía ni ser nula.
     */
    @NotBlank(message = "Field address cannot be empty or null.")
    private String address;
}
