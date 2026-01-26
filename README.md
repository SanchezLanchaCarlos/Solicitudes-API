# API Solicitudes

API REST para la gestión de **solicitudes de préstamos bancarios**, desarrollada con **Spring Boot**, siguiendo un enfoque **API First** y una **arquitectura hexagonal**.

---

## 1. Ejecución del proyecto

### Requisitos

* Java 17+
* Maven 3.8+
* IDE recomendado: IntelliJ IDEA / Eclipse / VS Code

### Pasos para ejecutar el proyecto

#### 1. Clonar el repositorio:
```bash
git clone (https://github.com/SanchezLanchaCarlos/Solicitudes-API.git)
cd Solicitudes-API
```

#### 2. Compilar el proyecto:
```bash
mvn clean install
```

#### 3. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```
o bien ejecutando la clase principal desde el IDE.

La API estará disponible en:

```
http://localhost:8080
```

### Endpoints principales

* `GET /api/solicitudes` – Obtener todas las solicitudes
* `GET /api/solicitudes/{id}` – Obtener una solicitud por ID
* `POST /api/solicitudes` – Crear una nueva solicitud
* `PUT /api/solicitudes/{id}` – Actualizar una solicitud existente

El contrato está definido en **OpenAPI 3.0** en:

```
src/main/resources/api/solicitudes.yaml
```

---

## 2. Arquitectura

### Organización de paquetes

```
com.example.solicitudes
├── application
│   └── *UseCaseImpl
├── domain
│   ├── model
│   ├── repository
│   └── requests (ports y DTO)
├── infrastructure
│   ├── controller
│   ├── entity
│   ├── mapper
│   └── repository 
```

### Decisiones técnicas

* **API First**: la API se define primero mediante OpenAPI y se generan modelos y contratos.
* **Arquitectura hexagonal** para aislar el dominio del framework y la infraestructura.
* **Casos de uso explícitos** para cada acción (crear, obtener, actualizar).
* **Dominio independiente** de Spring y JPA.
* **Repositorios desacoplados** mediante interfaces de dominio.
* **MapStruct** para mapeo entre dominio, entidades y DTOs.
* **Lombok** para evitar código repetitivo.
* Persistencia con **H2 + JPA** como implementación sencilla e intercambiable.

---

## 3. Mejoras a implementar

### Funcionales

* Validaciones de negocio más estrictas (importe, DNI, fechas)
* Paginación y filtros en el listado
* Historial de cambios de estado

### Técnicas / arquitecturales

* Tests unitarios de dominio y casos de uso con JUnit
* Tests de integración con Mockito
* Manejo global de errores (`@ControllerAdvice`)
* Seguridad con Spring Security (JWT)
* Versionado de la API (`/api/v1`)
* Uso de Value Objects (DNI, importe)

---
