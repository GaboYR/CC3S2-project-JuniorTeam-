# REPORTE NRO 1
## 1. Informe del proyecto
## I. Descripcion del proyecto
Presentacion de la microcarta : [Microcarta Grupo 7](https://github.com/GaboYR/JuniorTeam-CC3S2/blob/main/Sprint1/Entrega/Microcarta.md)
## II. Historias de usuarios

| ID | Nombre de la  historia de usuario | Descripción de la historia de usuario | Prioridad              | Esfuerzo Estimado | Esfuerzo real | Estado | Desarrollador |
|:--:|:---------------------------------:|:-------------------------------------:|:----------------------:|:-----------------:|:-------------:|:------:|:-------------:|
| 1 | Registro cuenta de usuario        | Como `nuevo usuario`, necesito `crear una cuenta` para que con esa misma `pueda iniciar sesión`.| ALTO | 3 horas | 5 horas | Completado | Dieso Quispe |       
| 2 | Iniciar sesión                    | Como `usuario`, necesito `iniciar sesión` para poder `entrar al juego` de  PlayDamas.| ALTO | 3 horas | 5 horas | Completado | Juan Silva |
| 3 | Cierre de sesión                  | Como `usuario`, necesito poder `cerrar sesión` para `evitar accesos no autorizados` si dejo mi sesión abierta accidentalmente.| ALTO | 3 horas | 5 horas | Completado | Juan Silva|

                             

## III. Criterios de aceptacion(AC)

| ID y nombre de la lista de usuario | AC  ID |Descripcion del criterio de aceptacion | Estado | Desarrollador |
|:----------------------------------:|:------:|:--------------------------------------:|:------------------------------------------:|:-------------:|
| 1 Iniciar sesión             | 1.1 | **Inicio de sesión exitoso con credenciales válidas**.<br> **Dado** un *username* <br> **y** una contraseña asociada, <br>**cuando** inicie sesión con estas credenciales <br>**entonces** el sistema debería permitirme acceder al juego de PlayDamas.       | Completada | Juan Silva |
| 1 Iniciar sesión             | 1.2 | **Error del inicio de sesión con *username* inexistente**. <br>**Dado** un *username* inexistente <br>**cuando** intento iniciar sesión con este *username* <br>**Entonces** el sistema no debería permitirme acceder al juego <br>**y** mostrar un mensaje de error.| Completada | Juan Silva |
| 1 Iniciar sesión             | 1.3 | **Fallo del inicio de sesión con una contraseña inválida**. <br>**Dado** un username con una contraseña no asociada a este mismo<br> **cuando** intento iniciar sesión con estas credenciales<br> **Entonces** el sistema no debería permitirme acceder al juego y debería mostrar un mensaje de error indicando *"Credenciales incorrecta"*.| Completada | Juan Silva |
| 1 Iniciar sesión             | 1.4 | **Protección contra intentos de inicio de sesión maliciosos** <br>**Dado** unas credenciales inválidas Cuando se realizan más de 3 intentos de inicio de sesión con esas mismas <br>**Entonces** el sistema debería bloquear por 2 minuto el acceso después de esos intentos fallidos <br>**Y** debería mostrar un mensaje de *"Cuenta bloqueda por multiples intentos"*.| Completada | Juan Silva |
| 2 Registro cuenta de usuario | 2.1 | **Creación `exitosa` de una *username* válida**. <br>**Dado** un *username* inexistente <br>**Cuando** creo una cuenta con este *username* <br>**Y** una contraseña válida que coincida con la contraseña confirmada <br>**Y** una dirección de correo electrónico <br>**Entonces** el sistema debería crear una nueva cuenta <br>**Y** mostrar un mensaje de *"Registro exitoso"*.| Completado | Diego Quispe |
| 2 Registro cuenta de usuario | 2.2 | **Creación de una cuenta `fallida` con un *username* existente**. <br>**Dado** un *username* que ya existe, **cuando** creo una cuenta con este username <br>**Y** una contraseña válida que coincida con la contraseña confirmada <br>**Y** una dirección de correo electrónica valida <br>**Entonces** el sistema no deberían crear una nueva cuenta<br> **Y** debería mostrar un mensaje de error de *"el username ya existe"*| Completado | Diego Quispe |
| 2 Registro cuenta de usuario | 2.3 | **Creacion de una cuenta `fallida` debido a una incorrecta confirmacion de contraseña**.<br> **Dado** un *username* válido <br>**Cuando** un usuario crea una cuenta con este *username*, <br>**y** una contraseña; el sistema pide confirmar la contraseña,<br> **y** se ingresa una contraseña diferente, <br>**entonces** no crea la nueva cuenta debido a la no validacion de contraseña. <br>**Y** el sistema debería mostrar mensajes de error diciendo *"la contraseñas no coinciden"*| Completado | Diego Quispe |
| 3 Cierre de sesión | 3.1 | **Cierre de sesión exitoso al tener una cuenta abierta**. <br>**Cuando** selecciono la opción de cerrar sesión <br>**Entonces** el sistema debería cerrar mi sesión actual <br>**y** redirigirme a la página de inicio de sesión. | Completado | Juan Silva |
| 3 Cierre de sesión | 3.2 | **No acceso después del cierre de sesión.**<br> **Dado** que he cerrado sesión en mi cuenta <br>**Cuando** intento acceder a páginas restringidas que requieren inicio de sesión **Entonces** el sistema no debería permitirme acceder a esas páginas. Y debería redirigirme a la página de inicio de sesión con un mensaje de "Debes inciar sesión primero".| Completado | Juan Silva |


## IV. Tareas de implementacion
Resumen del codigo de produccion.

| ID y nombre de la lista de usuario | AC  ID | Nombre(s) de clase | Nombre(s) del metodo | Desarrollador | Estado | Notas(op cional) |
|:----------------------------------:|:------:|:------------------:|:--------------------:|:-------------:|--------|------------------|
|                  1                 |   1.1  |                    |                      |               |        |                  |
|                                    |   1.2  |                    |                      |               |        |                  |
|                  2                 |   2.1  |                    |                      |               |        |                  |
|                                    |   2.2  |                    |                      |               |        |                  |

Resumen del código de prueba automatizado (que corresponde directamente a algunos criterios de aceptación)

| ID y nombre de la lista de usuario | AC  ID | Nombre(s) de clase del  código de prueba | Nombre(s) del método del  código de prueba | Descripción del caso de prueba (entrada y salida esperada) | Estado | Desarrollador |
|:----------------------------------:|:------:|:----------------------------------------:|:------------------------------------------:|:----------------------------------------------------------:|--------|---------------|
|                  1                 |   1.1  |                                          |                                            |                                                            |        |               |
|                                    |   1.2  |                                          |                                            |                                                            |        |               |
|                  2                 |   2.1  |                                          |                                            |                                                            |        |               |
|                                    |   2.2  |                                          |                                            |                                                            |        |               |

Resumen de casos de prueba manuales (que corresponden directamente a algunos criterios de aceptación)

| ID y nombre de la lista de usuario | AC  ID | Entrada de caso de prueba | Nombre(s) del método del  código de prueba | Prueba de Oracle (resultado esperado) | Estado | Notas | Desarrollador |
|:----------------------------------:|:------:|:-------------------------:|:------------------------------------------:|:-------------------------------------:|--------|-------|---------------|
|                  1                 |   1.1  |                           |                                            |                                       |        |       |               |
|                                    |   1.2  |                           |                                            |                                       |        |       |               |
|                  2                 |   2.1  |                           |                                            |                                       |        |       |               |
|                                    |   2.2  |                           |                                            |                                       |        |       |               |

Resumen de otras pruebas automatizadas o manuales (que no corresponden a los criterios de aceptación)

| Numero | Entrada de prueba | Resultado esperado | Nombre de clase del  código de prueba | Nombre del metodo del codigo de prueba | Estado | Desarrollador |
|:------:|:-----------------:|:------------------:|:-------------------------------------:|:--------------------------------------:|--------|---------------|
|        |                   |                    |                                       |                                        |        |               |
|        |                   |                    |                                       |                                        |        |               |
|        |                   |                    |                                       |                                        |        |               |
|        |                   |                    |                                       |                                        |        |               |

## V. Acta de reuniones

| Fecha | Tiempo y duracion | Lugar | Participante | Proposito de la reunion | Elementos de accion especificos |
|:-----:|:-----------------:|:-----:|:------------:|:-----------------------:|---------------------------------|
|   31/03/24    |  30 minutos      | Remoto(meet)    |  JuniorTeam| Acordar las partes             | Realizar un analilis del proyecto para acordar otra reunion                                    |
|  1/04/24     |      40 minutos             | Remoto(meet)      | JuniorTeam | Ver dificultades del proyecto            |  Acordar las partes y el entorno de trabajo                       |     
|  6/07/24     |      60 minutos             |   Remoto(meet)    |    JuniorTeam          |   Verificar el login                     |    Integrar la base de datos y testing                             |
|  7/04/24     |     90 minutos              |  Remoto(meet)     |  JuniorTeam            |  Ver avance del tablero                       |           Continuar con el tablero                      |

## VI. Tabla de calificaciones de amigos

| Calificador\Calificado | Diego Quispe | Sebastian Silva | Gabriel Yarleque |
|------------------------|--------------|-----------------|------------------|
| Diego Quispe           |              |                 |                  |
| Sebastian Silva        |              |                 |                  |
| Gabriel Yarleque       |              |                 |                  |

## 2. Demostracion
## a.
## b.
## c.

