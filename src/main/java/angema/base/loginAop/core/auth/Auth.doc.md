# Documentacion Auth

## Dependencias necesarias

```
<!-- auth -->
<dependency>
	<groupId>io.fusionauth</groupId>
	<artifactId>fusionauth-jwt</artifactId>
	<version>5.0.0</version>
</dependency>
```

## Configuraciones necesarias: application.properties
```
## habilita el uso del login auth.
configs.auth.security.enabled=true
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



