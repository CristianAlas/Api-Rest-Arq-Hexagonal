package com.services.ms.student.app.infrastructure.adapters.output.persistence;

import com.services.ms.student.app.application.ports.output.StudentPersistencePort;
import com.services.ms.student.app.domain.model.Student;
import com.services.ms.student.app.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.services.ms.student.app.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia para la entidad {@link Student}.
 * <p>
 * Implementa el puerto de salida {@link StudentPersistencePort} y se encarga
 * de la comunicación con la capa de persistencia (base de datos) utilizando
 * el repositorio {@link StudentRepository} y el mapper {@link StudentPersistenceMapper}.
 * </p>
 * <p>
 * Proporciona métodos para buscar, listar, guardar y eliminar estudiantes en la base de datos,
 * realizando la conversión entre el modelo de dominio y la entidad de persistencia.
 * </p>
 *
 * Esta clase está anotada con {@link Component} para ser detectada automáticamente por Spring
 * y usar inyección de dependencias.
 *
 * @author CristianAlas
 */

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

    /**
     * Repositorio JPA para acceso a datos de estudiantes.
     */
    private final StudentRepository repository;

    /**
     * Mapper para convertir entre entidad de persistencia y modelo de dominio.
     */
    private final StudentPersistenceMapper mapper;

    /**
     * Busca un estudiante por su ID.
     *
     * @param id Identificador del estudiante.
     * @return {@link Optional} con el estudiante si se encuentra, vacío si no.
     */
    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toStudent);
    }

    /**
     * Obtiene todos los estudiantes registrados.
     *
     * @return Lista de estudiantes.
     */
    @Override
    public List<Student> findAll() {
        return mapper.toStudentList(repository.findAll());
    }

    /**
     * Guarda un estudiante en la base de datos.
     *
     * @param student Modelo de dominio del estudiante a guardar.
     * @return Estudiante guardado con su ID asignado.
     */
    @Override
    public Student save(Student student) {
        return mapper.toStudent(
                repository.save(mapper.toStudentEntity(student)));
    }

    /**
     * Elimina un estudiante por su ID.
     *
     * @param id Identificador del estudiante a eliminar.
     */
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
