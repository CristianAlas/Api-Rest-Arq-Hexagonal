package com.services.ms.student.app.infrastructure.adapters.input.rest;

import com.services.ms.student.app.domain.exception.StudentNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import com.services.ms.student.app.domain.model.ErrorResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.services.ms.student.app.utils.ErrorCatalog.*;

/**
 * Clase que gestiona globalmente las excepciones lanzadas por los controladores REST.
 * Se encarga de interceptar errores comunes como validaciones fallidas, recursos no encontrados
 * o errores inesperados, devolviendo respuestas con estructura consistente para el cliente.
 *
 * @author CristianAlas
 *
 */
@RestControllerAdvice
public class GlobalControllerAdvice {

    /**
     * Maneja la excepción cuando un estudiante no es encontrado en el sistema.
     *
     * @return Objeto {@link ErrorResponse} con código y mensaje predefinido en el catálogo de errores.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public ErrorResponse handleStudentNotFoundException(){
        return ErrorResponse.builder()
            .code(STUDENT_NOT_FOUND.getCode())
            .message(STUDENT_NOT_FOUND.getMessage())
            .timestamp(LocalDateTime.now())
            .build();
    }

    /**
     * Maneja errores de validación cuando un request no cumple con las anotaciones @Valid.
     *
     * @param exception Excepción lanzada por Spring al fallar la validación del request.
     * @return Objeto {@link ErrorResponse} con detalles específicos del error por campo.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleStudentNotFoundException(
            MethodArgumentNotValidException exception){
        BindingResult result = exception.getBindingResult();

        return ErrorResponse.builder()
                .code(INVALID_STUDENT.getCode())
                .message(INVALID_STUDENT.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * Maneja cualquier excepción no controlada que ocurra en la aplicación.
     *
     * @param exception Excepción genérica capturada.
     * @return Objeto {@link ErrorResponse} con un mensaje general de error y detalles técnicos.
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError(Exception exception){
        return ErrorResponse.builder()
                .code(GENERIC_ERROR.getCode())
                .message(GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }
}
