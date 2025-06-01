package com.services.ms.student.app.infrastructure.adapters.output.persistence.repository;

import com.services.ms.student.app.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que representa el repositorio de acceso a datos para la entidad {@link StudentEntity}.
 * <p>
 * Extiende de {@link JpaRepository}, lo que proporciona una implementación automática
 * de operaciones CRUD básicas como guardar, buscar, eliminar y listar entidades.
 * <p>
 * Este repositorio se comunica directamente con la base de datos utilizando JPA (Java Persistence API).
 *
 * @author CristianAlas
 */
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
