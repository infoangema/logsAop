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

3- FEAT: Conectar base con PartnerThemeController.
4- FEAT: getCarouselImage y getBackGroundImage.(ok)
5- FEAT: Crear recurso nuevo para catalogo de productos.
6- FEAT: Recurso nuevo para imagenes de productos. (Analisis)

