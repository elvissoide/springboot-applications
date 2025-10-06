# Spring Boot Multimodular Application

Este proyecto ha sido convertido de una aplicación monolítica a una arquitectura multimodular para mejorar la organización, mantenibilidad y escalabilidad del código.

## Estructura de Módulos

```
springboot-applications-parent/
├── pom.xml (Módulo padre)
├── springboot-applications-core/     # Entidades, DTOs, modelos de dominio
├── springboot-applications-service/  # Lógica de negocio y servicios
├── springboot-applications-web/      # Controladores web y configuración REST
└── springboot-applications-app/      # Aplicación principal ejecutable
```

### Descripción de Módulos

#### 1. **springboot-applications-parent**
- Módulo padre que contiene la configuración común
- Gestiona las versiones de dependencias
- Define la configuración de plugins Maven

#### 2. **springboot-applications-core**
- Contiene DTOs, entidades y modelos del dominio
- Sin dependencias de Spring Framework
- Puede ser reutilizado por otros módulos

#### 3. **springboot-applications-service**
- Contiene la lógica de negocio
- Depende del módulo `core`
- Implementa servicios con anotaciones de Spring

#### 4. **springboot-applications-web**
- Contiene controladores REST y web
- Depende del módulo `service`
- Maneja la capa de presentación

#### 5. **springboot-applications-app**
- Módulo ejecutable principal
- Depende del módulo `web` (que transitivamente incluye los demás)
- Contiene la configuración de Spring Boot y recursos

## Ventajas de la Arquitectura Multimodular

### ✅ **Separación de Responsabilidades**
- Cada módulo tiene una responsabilidad específica
- Facilita el mantenimiento y la comprensión del código

### ✅ **Reutilización de Código**
- El módulo `core` puede ser reutilizado en otros proyectos
- Los servicios pueden ser usados independientemente

### ✅ **Mejores Tiempos de Compilación**
- Maven compila solo los módulos que han cambiado
- Compilación paralela de módulos independientes

### ✅ **Escalabilidad**
- Fácil añadir nuevos módulos (data, security, etc.)
- Posibilidad de descomponer en microservicios más adelante

### ✅ **Mejor Testing**
- Tests unitarios más focalizados por módulo
- Posibilidad de testear módulos independientemente

## Cómo Ejecutar

### Compilar todo el proyecto
```bash
mvn clean compile
```

### Ejecutar tests
```bash
mvn test
```

### Instalar en repositorio local
```bash
mvn clean install
```

### Ejecutar la aplicación
```bash
cd springboot-applications-app
mvn spring-boot:run
```

### Construcción y empaquetado
```bash
mvn clean package
java -jar springboot-applications-app/target/springboot-applications-app-0.0.1-SNAPSHOT.jar
```

## Endpoints Disponibles

- **Web UI**: http://localhost:8080/path
- **API JSON**: http://localhost:8080/api/info
- **Health Check**: http://localhost:8080/actuator/health

## Próximos Pasos

Para continuar mejorando la arquitectura, considera:

1. **Añadir módulo de datos**: `springboot-applications-data` para entidades JPA y repositorios
2. **Módulo de seguridad**: `springboot-applications-security` para configuración de seguridad
3. **Módulo de configuración**: `springboot-applications-config` para configuraciones específicas
4. **Testing avanzado**: Tests de integración entre módulos
5. **Documentación API**: Integración con Swagger/OpenAPI

## Estructura de Archivos

```
├── springboot-applications-core/
│   └── src/main/java/com/elvis/app1/springboot_applications/core/
│       └── dto/InfoDto.java
├── springboot-applications-service/
│   └── src/main/java/com/elvis/app1/springboot_applications/service/
│       └── InfoService.java
├── springboot-applications-web/
│   └── src/main/java/com/elvis/app1/springboot_applications/web/
│       └── controller/EjemploController.java
└── springboot-applications-app/
    ├── src/main/java/com/elvis/app1/springboot_applications/
    │   └── SpringbootApplicationsApplication.java
    └── src/main/resources/
        ├── application.properties
        └── templates/detalles_info.html
```