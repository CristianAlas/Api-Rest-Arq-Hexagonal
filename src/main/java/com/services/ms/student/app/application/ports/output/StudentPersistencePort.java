package com.services.ms.student.app.application.ports.output;

import com.services.ms.student.app.domain.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define el contrato para las operaciones de persistencia relacionadas con la entidad Estudiante.
 * Esta forma parte del Puerto de Salida (Output Port) en la Arquitectura Hexagonal, permitiendo que la aplicación
 * interactúe con la capa de persistencia sin estar fuertemente acoplada a su implementación.
 *
 * Explicación:
 * Propósito de la clase: Esta interfaz define las operaciones que la capa de servicio puede usar para la entidad Estudiante.
 * Actúa como un Puerto de Salida en la Arquitectura Hexagonal, exponiendo la lógica de negocio hacia las capas externas,
 * como los controladores.
 *
 * Métodos: Cada método representa una operación específica, como obtener, guardar, actualizar o eliminar un Estudiante.
 * Los comentarios describen el propósito y los parámetros de cada método.
 *
 * @author CristianAlas
 *
 */
public interface StudentPersistencePort {

    /**
     * Busca un Estudiante por su identificador único.
     * @param id El ID del Estudiante a buscar.
     * @return Un Optional que contiene el Estudiante si se encuentra, o vacío si no se encuentra.
     */
    Optional<Student> findById(Long id);

    /**
     * Obtiene todos los Estudiantes de la capa de persistencia.
     * @return Una lista con todos los Estudiantes.
     */
    List<Student> findAll();

    /**
     * Guarda una entidad Estudiante en la capa de persistencia.
     * @param student La entidad Estudiante a guardar.
     * @return La entidad Estudiante guardada.
     */
    Student save(Student student);

    /**
     * Elimina una entidad Estudiante por su identificador único.
     * @param id El ID del Estudiante a eliminar.
     */
    void deleteById(Long id);
}