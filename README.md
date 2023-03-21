# Agenda Spring
Este proyecto es una mini agenda desarrollada en Spring Boot con fines educativos que puede servir como ejemplo de trabajos.

### Descripción:
La mini agenda fue desarrollada para un desafío de la empresa Besysoft y permite:

    Agregar personas.
    Agregar empresas.
    Relacionar personas con empresas.
    Realizar búsquedas de personas por id, apellido, dni, ciudad, teléfono, provincia y país.
    Realizar búsquedas de empresas por id, nombre, cuit, ciudad, teléfono, provincia y país.

    Las búsquedas son devueltas por APIs Rest o consultado "http://localhost:8090/swagger-ui/index.html" una vez ejecutado el proyecto.

### Contenido:

    Swagger para la documentación.
    Uso de herencia entre clases.
    Uso de clases genéricas para implementar la herencia.
    Uso de Specification para optimizar las búsquedas.
    Uso de la dependencia Faker para poblar la base de datos.

### Cómo utilizar:
Para utilizar la mini agenda, solo debes descargar el repositorio y sus dependencias. Luego, reproduce el proyecto Spring con el IDE que prefieras. Por defecto, el proyecto carga 10 personas y 10 empresas al azar para comenzar a realizar búsquedas. Las colecciones se encuentran en la carpeta utils.

### Contribuciones:
Si deseas contribuir al proyecto, puedes hacer un fork y enviar tus cambios mediante un pull request. Todas las contribuciones son bienvenidas.

UML:

<img src="https://github.com/gabynavarro/bsbAgendaSpring/blob/master/utils/diagrama_clases.png"></img>
