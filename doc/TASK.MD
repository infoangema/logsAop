Task

1- FEAT: Conexion al servicio de PartnerTheme.
2- FEAT: Crecion de BDD para temas del socio.
- conexion del back:

```
<dependency>
<groupId>org.postgresql</groupId>
<artifactId>postgresql</artifactId>
<scope>runtime</scope>
</dependency>
```
properties datasource
```
spring.datasource.url=jdbc:postgresql://localhost:5432/registros
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

```

3- FEAT: Partner configs.
    1. Conectar base con PartnerThemeController.
    2. Modelado de datos. 
4- FEAT: getCarouselImage y getBackGroundImage.
5- FEAT: Catalogo de productos.
6- FEAT: Recurso nuevo para imagenes de productos. (Analisis)
7- FEAT: Conexion a Heroku.
    1. Crear properties.
    2. Encriptar pass.
    3. Crear tablas.

