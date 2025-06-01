package com.services.ms.student.app.domain.model;

import lombok.*;

/**
 * Representa una entidad Estudiante en el sistema.
 * Esta clase encapsula los atributos básicos de un estudiante, como su ID, nombre, edad y dirección.
 * Se utiliza en toda la aplicación para gestionar y transferir datos de estudiantes.
 *
 * @author CristianAlas
 *
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    /**
     * Identificador único del estudiante.
     */
    private Long id;

    /**
     * Nombre(s) del estudiante.
     */
    private String firstname;

    /**
     * Apellido(s) del estudiante.
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