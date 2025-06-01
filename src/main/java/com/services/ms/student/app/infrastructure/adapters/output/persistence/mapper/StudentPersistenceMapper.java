package com.services.ms.student.app.infrastructure.adapters.output.persistence.mapper;

import com.services.ms.student.app.domain.model.Student;
import com.services.ms.student.app.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper que se encarga de convertir entre la entidad de persistencia {@link StudentEntity}
 * y el modelo de dominio {@link Student}.
 *
 * <p>Utiliza MapStruct para generar automáticamente las implementaciones de mapeo,
 * facilitando la conversión bidireccional entre capas de dominio y persistencia.</p>
 *
 * <p>También incluye métodos para convertir listas de entidades a listas de modelos.</p>
 *
 * @author CristianAlas
 *
 */
@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    /**
     * Convierte un objeto de dominio {@link Student} a su correspondiente entidad de persistencia {@link StudentEntity}.
     *
     * @param student Objeto de dominio a convertir.
     * @return Entidad de persistencia resultante.
     */
    StudentEntity toStudentEntity(Student student);

    /**
     * Convierte una entidad de persistencia {@link StudentEntity} a su correspondiente modelo de dominio {@link Student}.
     *
     * @param entity Entidad de persistencia a convertir.
     * @return Modelo de dominio resultante.
     */
    Student toStudent(StudentEntity entity);

    /**
     * Convierte una lista de entidades de persistencia {@link StudentEntity} a una lista de modelos de dominio {@link Student}.
     *
     * @param entityList Lista de entidades de persistencia.
     * @return Lista de modelos de dominio convertidos.
     */
    List<Student> toStudentList(List<StudentEntity> entityList);
}
