package com.services.ms.student.app;

import com.services.ms.student.app.infrastructure.adapters.output.persistence.entity.StudentEntity;
import com.services.ms.student.app.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

/**
 * Clase principal de la aplicación Student Service.
 * <p>
 * Esta clase configura y arranca la aplicación Spring Boot.
 * Además, implementa {@link CommandLineRunner} para ejecutar
 * código al inicio de la aplicación.
 * </p>
 * <p>
 * En el método {@code run} se inicializan algunos datos de prueba
 * creando y guardando varias entidades de estudiantes en la base de datos.
 * </p>
 *
 * @author CristianAlas
 */
@SpringBootApplication
@RequiredArgsConstructor
public class StudentServiceApplication implements CommandLineRunner {

	/**
	 * Repositorio para operaciones CRUD sobre la entidad StudentEntity.
	 */
	private final StudentRepository repository;

	/**
	 * Punto de entrada de la aplicación.
	 *
	 * @param args Argumentos de línea de comandos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	/**
	 * Método ejecutado al iniciar la aplicación.
	 * <p>
	 * Inserta una lista de estudiantes de ejemplo en la base de datos
	 * para tener datos iniciales disponibles.
	 * </p>
	 *
	 * @param args Argumentos de línea de comandos.
	 * @throws Exception En caso de error durante la ejecución.
	 */
	@Override
	public void run(String... args) throws Exception {
		List<StudentEntity> entities = Arrays.asList(
			new StudentEntity(null, "Juan", "Mendoza", 28, "Calle 1"),
			new StudentEntity(null, "Carlos", "Rodriguez", 30, "Calle 2"),
			new StudentEntity(null, "Julio", "Perez", 10, "Calle 3"),
			new StudentEntity(null, "Roman", "Ramirez", 40, "Calle 4")
		);
		repository.saveAll(entities);
	}
}
