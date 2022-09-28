# Documentacion Auth

## Dependencias necesarias

```
<!-- auth -->
<dependency>
    <groupId>io.fusionauth</groupId>
    <artifactId>fusionauth-jwt</artifactId>
    <version>5.0.0</version>
</dependency>
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt</artifactId>
	<version>0.9.1</version>
</dependency>
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-core</artifactId>
	<version>5.6.7</version>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

## Configuraciones necesarias: application.properties
```
## habilita el uso del login auth.
configs.auth.security.IS_SECURITY_ENABLED=true
## timezone
configs.auth.timezone=America/Argentina/Buenos_Aires
## registra dato dentro del token. Deberia ir nombre de la empresa.
configs.auth.issuer=angema
## path que sera excluido en las configuraciones de seguridad.
configs.auth.token.auth.path=/auth/login
## clave secreta para token.
configs.auth.token.secret=secret
## tiempo de expiracion del token.
configs.auth.token.expiration.seconds=3600
## lista de path excluidos en las configuraciones de seguridad.
configs.auth.exclude.paths=/auth/login,/health,/info,/error
```

## Modulos necesarios
* **core/exceptions**
* **core/globalResponse**
* **core/utils**

## Modo de uso

#### El modulo funciona con dos endpoints:

* Form-login 
```
{
  path: "/auth/login",
  method: "POST",
  headers: {
    "Content-Type": "application/x-www-form-urlencoded"
  },
  curl: "curl --location --request POST 'http://localhost:8080/auth/login?grant_type=client_credentials' \\\n--header 'Content-Type: application/x-www-form-urlencoded' \\\n--data-urlencode 'client_id=gerr' \\\n--data-urlencode 'client_secret=1233'"
}
```

* Rest-login
```
{
  path: "/auth/login",
  method: "POST",
  headers: {
    "Content-Type": "application/json"
    "Authorization": "Bearer <token>"
  },
  curl: "curl --location --request POST 'http://localhost:8080/auth?grant_type=client_credentials' \\\n--header 'Content-Type: application/json' \\\n--data-raw '{\n    \"user\": \"angema_devs11\",\n    \"password\": \"Secret..11\"\n}'"
}
```

## Funcionalidades de clases:

* **AuthSecurityConfig**: _Clase que extiende de **WebSecurityConfigurerAdapter**. Se activa si el atributo **IS_SECURITY_ENABLED** es **true**._
* **AuthFilter**: _Si **IS_SECURITY_ENABLED** esta activado hace las siguientes funciones._
 - Valida el token con **authJwt.validateToken(token)**
- Obtiene el nombre del usuario del token con **authJwt.getPayLoadObject(token).getUserName()**
- Busca los detalles del usuario del repositorio con **authUserDetailsService.loadUserByUsername(nombreUsuario)**
- Obtiene los roles del mismo y se los pasa a la clase de spring **UsernamePasswordAuthenticationToken**
- **No toma en cuenta los paths excluidos**

* **AuthInterceptor**: _Hace lo siguiente._
 - Valida paths excluidas en las properties.
 - Verifica que el Bearer sea correcto.

