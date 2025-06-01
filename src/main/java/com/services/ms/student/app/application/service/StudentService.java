package com.services.ms.student.app.application.service;

import com.services.ms.student.app.application.ports.input.StudentServicePort;
import com.services.ms.student.app.application.ports.output.StudentPersistencePort;
import com.services.ms.student.app.domain.exception.StudentNotFoundException;
import com.services.ms.student.app.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase de servicio que implementa la lógica de negocio para la entidad Estudiante.
 * Esta clase actúa como la implementación del Puerto de Entrada (StudentServicePort) en la Arquitectura Hexagonal.
 * Interactúa con el Puerto de Salida (StudentPersistencePort) para realizar operaciones de persistencia.
 *
 * Explicación:
 * - **Propósito de la clase:** Contiene la lógica de negocio para la gestión de entidades Estudiante.
 *   Hace de puente entre el puerto de entrada (capa de servicio) y el puerto de salida (capa de persistencia) en la Arquitectura Hexagonal.
 * - métodos: Cada método implementa una operación específica del negocio, como obtener, guardar, actualizar o eliminar un Estudiante.
 *   Los comentarios describen el propósito y comportamiento de cada método.
 *
 * @author CristianAlas
 *
 **/
@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {

    private final StudentPersistencePort persistencePort;

    /**
     * Busca un Estudiante por su identificador único.
     * @param id El ID del Estudiante a buscar.
     * @return La entidad Estudiante si es encontrada.
     * @throws StudentNotFoundException si no se encuentra el Estudiante.
     */
    @Override
    public Student findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(StudentNotFoundException::new);
    }

    /**
     * Obtiene todos los Estudiantes.
     * @return Una lista con todas las entidades Estudiante.
     */
    @Override
    public List<Student> findAll() {
        return persistencePort.findAll();
    }

    /**
     * Guarda una nueva entidad Estudiante.
     * @param student La entidad Estudiante a guardar.
     * @return La entidad Estudiante guardada.
     */
    @Override
    public Student save(Student student) {
        return persistencePort.save(student);
    }

    /**
     * Actualiza una entidad Estudiante existente.
     * @param id El ID del Estudiante a actualizar.
     * @param student La entidad Estudiante con los datos actualizados.
     * @return La entidad Estudiante actualizada.
     * @throws StudentNotFoundException si no se encuentra el Estudiante.
     */
    @Override
    public Student update(Long id, Student student) {
        return persistencePort.findById(id)
            .map(savedStudent -> {
                savedStudent.setFirstname(student.getFirstname());
                savedStudent.setLastname(student.getLastname());
                savedStudent.setAge(student.getAge());
                savedStudent.setAddress(student.getAddress());
                return persistencePort.save(savedStudent);
            })
            .orElseThrow(StudentNotFoundException::new);
    }

    /**
     * Elimina una entidad Estudiante por su identificador único.
     * @param id El ID del Estudiante a eliminar.
     * @throws StudentNotFoundException si no se encuentra el Estudiante.
     */
    @Override
    public void deleteById(Long id) {
        if(persistencePort.findById(id).isEmpty()) {
            throw new StudentNotFoundException();
        }
        persistencePort.deleteById(id);
    }
}
