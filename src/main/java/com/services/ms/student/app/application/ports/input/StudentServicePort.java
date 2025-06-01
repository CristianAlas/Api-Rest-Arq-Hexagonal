package com.services.ms.student.app.application.ports.input;

import com.services.ms.student.app.domain.model.Student;

import java.util.List;

/**
 * Interfaz que define el contrato para las operaciones de servicio relacionadas con la entidad Estudiante.
 * Esta forma parte del Puerto de Entrada (Input Port) en la Arquitectura Hexagonal, permitiendo que la aplicación
 * exponga la lógica de negocio a capas externas (por ejemplo, controladores).
 *
 * Explicación:
 * - **Propósito de la clase:** Esta interfaz define las operaciones de la capa de servicio para la entidad `Student`.
 *   Actúa como un Puerto de Entrada en la Arquitectura Hexagonal, exponiendo la lógica de negocio a capas externas como los controladores.
 * - **Métodos:** Cada método representa una operación específica, como obtener, guardar, actualizar o eliminar un `Student`.
 *   Los comentarios describen el propósito y los parámetros de cada método.
 *
 * @author CristianAlas
 *
 */
public interface StudentServicePort {

    /**
     * Busca un Estudiante por su identificador único.
     * @param id El ID del Estudiante a buscar.
     * @return La entidad Estudiante si se encuentra.
     */
    Student findById(Long id);

    /**
     * Obtiene todos los Estudiantes.
     * @return Una lista con todas las entidades Estudiante.
     */
    List<Student> findAll();

    /**
     * Guarda una nueva entidad Estudiante.
     * @param student La entidad Estudiante a guardar.
     * @return La entidad Estudiante guardada.
     */
    Student save(Student student);

    /**
     * Actualiza una entidad Estudiante existente.
     * @param id El ID del Estudiante a actualizar.
     * @param student La entidad Estudiante actualizada.
     * @return La entidad Estudiante actualizada.
     */
    Student update(Long id, Student student);

    /**
     * Elimina una entidad Estudiante por su identificador único.
     * @param id El ID del Estudiante a eliminar.
     */
    void deleteById(Long id);
}
