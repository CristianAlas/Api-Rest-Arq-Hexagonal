# 🎓 Student Service API

Microservicio de gestión de estudiantes construido con **Java 21** y **Spring Boot 3.5.0**, 
siguiendo una arquitectura **Hexagonal (Ports and Adapters)**, aplicando principios **SOLID** 
y buenas prácticas de diseño orientado al dominio (DDD ligero).

---

## 📚 Tabla de Contenidos

- [Características](#características)
- [Tecnologías](#tecnologías)
- [Arquitectura](#arquitectura)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Principios de Diseño](#principios-de-diseño)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [Endpoints Principales](#endpoints-principales)
- [Manejo de Errores](#manejo-de-errores)
- [Licencia](#licencia)

---

## ✅ Características

- Gestión de entidades de tipo estudiante.
- Exposición de endpoints RESTful.
- Manejo de errores global.
- Separación limpia entre capas (dominio, aplicación, infraestructura).
- Arquitectura basada en puertos (hexagonal).
- Uso de Java moderno (Java 21).

---

## 🛠 Tecnologías

| Tecnología         | Versión     |
|--------------------|-------------|
| Java               | 21          |
| Spring Boot        | 3.5.0       |
| Maven              | 4.0.0       |
| REST API           | Sí          |
| Arquitectura Hexagonal | Sí     |

---

## 🧱 Arquitectura

El proyecto implementa una **arquitectura hexagonal**, también conocida como **Ports and Adapters**, en donde:

- La **lógica de negocio** reside en la capa de dominio.
- La **interacción con el exterior** (REST, DB) se realiza mediante **adaptadores**.
- Las **interfaces (ports)** desacoplan la lógica del framework o la base de datos.

```
┌──────────────────────────┐
│ Infrastructure │
│ (adapters: REST / DB) │
└────────────┬─────────────┘
│
┌────────────▼─────────────┐
│ Application │
│ (use cases / services) │
└────────────┬─────────────┘
│
┌────────────▼─────────────┐
│ Domain │
│ (modelos, lógica pura)│
└──────────────────────────┘
```
---

# 📂 Estructura del Proyecto

```
src/
└── main/
└── java/
└── com.services.ms.student/
├── app/
│ ├── application/
│ │ ├── ports/input
│ │ ├── ports/output
│ │ └── service
│ ├── domain/
│ │ ├── model
│ │ └── exception
│ └── infrastructure/
│ └── adapters/
│ └── input/rest/
│ └── mapper
```

---

## 🧠 Principios de Diseño

- ✅ **S**: Responsabilidad Única – Cada clase tiene un único propósito.
- ✅ **O**: Abierto/Cerrado – Fácil de extender sin modificar.
- ✅ **L**: Sustitución de Liskov – Interfaces port definidas y coherentes.
- ✅ **I**: Segregación de interfaces – Separación clara entre puertos de entrada y salida.
- ✅ **D**: Inversión de dependencias – Uso de interfaces para desacoplar implementaciones.

---

## 🚀 Instalación y Ejecución

---

# Clona el repositorio
git clone https://github.com/tu-usuario/student-service.git
cd student-service

# Compila el proyecto
./mvnw clean install

# Ejecuta la aplicación
./mvnw spring-boot:run
La aplicación estará disponible en: http://localhost:8080

## 🔗 Endpoints Principales (ejemplo)

```
Método	Endpoint	Descripción.
- GET	/api/students	Lista todos los estudiantes.
- GET	/api/students/{id}	Obtiene un estudiante por ID.
- POST	/api/students	Crea un nuevo estudiante.
- PUT	/api/students/{id}	Actualiza un estudiante existente.
- DELETE	/api/students/{id}	Elimina un estudiante.
```

## ⚠️ Manejo de Errores
Este proyecto implementa manejo global de excepciones usando @ControllerAdvice. Las respuestas de error siguen un formato uniforme:

```
{
  "timestamp": "2025-06-01T12:00:00Z",
  "message": "Student not found with ID: 42",
  "status": 404
}
```

## 🪪 Licencia
Este proyecto está licenciado bajo la MIT License. Consulta el archivo LICENSE para más detalles.

## 👨‍💻 Autor
Desarrollado por { CaTree Developer Sv /}.

