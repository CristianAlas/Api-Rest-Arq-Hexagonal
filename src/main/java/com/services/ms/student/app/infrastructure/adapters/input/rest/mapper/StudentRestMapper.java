package com.services.ms.student.app.infrastructure.adapters.input.rest.mapper;

import com.services.ms.student.app.domain.model.Student;
import com.services.ms.student.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.services.ms.student.app.infrastructure.adapters.input.rest.model.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Mapper REST para convertir entre objetos de dominio (Student)
 * y modelos utilizados en las solicitudes y respuestas REST.
 *
 * Esta interfaz usa MapStruct para generar automáticamente las implementaciones
 * de mapeo. Es útil para separar las capas del dominio y la presentación (API).
 *
 * Anotación @Mapper:
 * - componentModel = "spring" indica que MapStruct debe generar un bean Spring.
 * - unmappedTargetPolicy = IGNORE evita advertencias si hay campos sin mapear.
 *
 * @author CristianAlas
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentRestMapper {

    /**
     * Convierte una solicitud de creación de estudiante (DTO) a un objeto de dominio Student.
     *
     * @param request el objeto de solicitud con datos del estudiante
     * @return el objeto Student listo para usarse en la lógica de negocio
     */
    Student toStudent(StudentCreateRequest request);

    /**
     * Convierte un objeto Student de dominio a un objeto de respuesta para la API REST.
     *
     * @param student el estudiante del dominio
     * @return la respuesta con los datos del estudiante en formato para el cliente
     */
    StudentResponse toStudentResponse(Student student);

    /**
     * Convierte una lista de estudiantes del dominio a una lista de respuestas para la API.
     *
     * @param studentList lista de estudiantes
     * @return lista de respuestas para el cliente
     */
    List<StudentResponse> toStudentResponseList(List<Student> studentList);
}
