package com.services.ms.student.app.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad JPA que representa la tabla "student" en la base de datos.
 * <p>
 * Esta clase mapea los campos de la tabla a atributos Java para su
 * persistencia y recuperación mediante JPA.
 * </p>
 *
 * <p>Incluye los datos básicos de un estudiante: id, nombre, apellido, edad y dirección.</p>
 *
 * <p>Utiliza Lombok para generar getters, setters, constructor sin argumentos y constructor con todos los argumentos.</p>
 *
 * @author CristianAlas
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class StudentEntity {

    /**
     * Identificador único del estudiante.
     * Es la clave primaria y se genera automáticamente con estrategia IDENTITY.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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