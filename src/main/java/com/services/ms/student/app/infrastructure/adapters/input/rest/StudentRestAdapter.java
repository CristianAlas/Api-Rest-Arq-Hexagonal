package com.services.ms.student.app.infrastructure.adapters.input.rest;

import com.services.ms.student.app.application.ports.input.StudentServicePort;
import com.services.ms.student.app.infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import com.services.ms.student.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.services.ms.student.app.infrastructure.adapters.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Adaptador REST que expone los endpoints relacionados con la gestión de estudiantes.
 * Actúa como entrada del sistema (input adapter) en una arquitectura hexagonal.
 *
 * Se encarga de recibir solicitudes HTTP, validar los datos, invocar los servicios del dominio
 * y devolver las respuestas adecuadas al cliente. Utiliza un mapper para transformar los
 * objetos del dominio a modelos REST y viceversa.
 *
 * @author CristianAlas
 *
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentRestAdapter {

    /**
     * Puerto que define las operaciones del caso de uso relacionadas con los estudiantes.
     * Este puerto permite desacoplar la lógica del dominio de la capa de infraestructura,
     * facilitando la implementación de pruebas y el cumplimiento de la arquitectura hexagonal.
     */
    private final StudentServicePort servicePort;

    /**
     * Mapper responsable de convertir entre objetos del dominio (Student) y objetos
     * de transporte utilizados en la capa REST (StudentCreateRequest, StudentResponse).
     * Utiliza la biblioteca MapStruct para realizar la conversión de forma automática.
     */
    private final StudentRestMapper restMapper;

    /**
     * Obtiene la lista de todos los estudiantes registrados.
     *
     * @return lista de objetos StudentResponse
     */
    @GetMapping("/v1/api")
    public List<StudentResponse> findAll() {
        return restMapper.toStudentResponseList((servicePort.findAll()));
    }

    /**
     * Obtiene un estudiante por su identificador único.
     *
     * @param id identificador del estudiante
     * @return objeto StudentResponse con los datos del estudiante
     */
    @GetMapping("/v1/api/{id}")
    public StudentResponse findById(@PathVariable Long id) {
        return restMapper.toStudentResponse((servicePort.findById(id)));
    }

    /**
     * Crea un nuevo estudiante a partir de los datos recibidos en la solicitud.
     *
     * @param request objeto con los datos necesarios para crear un estudiante
     * @return respuesta con estado HTTP 201 (CREATED) y el objeto StudentResponse creado
     */
    @PostMapping("/v1/api")
    public ResponseEntity<StudentResponse> save(@Valid @RequestBody StudentCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toStudentResponse(
                        servicePort.save(restMapper.toStudent(request))
                ));
    }

    /**
     * Actualiza los datos de un estudiante existente.
     *
     * @param id identificador del estudiante a actualizar
     * @param request objeto con los nuevos datos del estudiante
     * @return objeto StudentResponse con la información actualizada
     */
    @PutMapping("/v1/api/{id}")
    public StudentResponse update(@PathVariable Long id, @Valid @RequestBody StudentCreateRequest request) {
        return restMapper.toStudentResponse(
                servicePort.update(id, restMapper.toStudent(request))
        );
    }

    /**
     * Elimina un estudiante por su identificador.
     *
     * @param id identificador del estudiante a eliminar
     */
    @DeleteMapping("/v1/api/{id}")
    public void delete(@PathVariable Long id) {
        servicePort.deleteById(id);
    }
}
