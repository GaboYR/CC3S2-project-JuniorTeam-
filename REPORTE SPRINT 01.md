# REPORTE NRO 1
## 1. Informe del proyecto
## I. Descripcion del proyecto
Presentacion de la microcarta : [Microcarta Grupo 7](https://github.com/GaboYR/JuniorTeam-CC3S2/blob/main/Microcarta.md)
## II. Historias de usuarios

| ID | Nombre de la  historia de usuario | Descripción de la historia de usuario | Prioridad              | Esfuerzo Estimado | Esfuerzo real | Estado | Desarrollador |
|:--:|:---------------------------------:|:-------------------------------------:|:----------------------:|:-----------------:|:-------------:|:------:|:-------------:|
| 1 | Registro cuenta de usuario        | Como `nuevo usuario`, necesito `crear una cuenta` para que con esa misma `pueda iniciar sesión`.| ALTO | 3 horas | 5 horas | En curso | Dieso Quispe |       
| 2 | Iniciar sesión                    | Como `usuario`, necesito `iniciar sesión` para poder `entrar al juego` de  PlayDamas.| ALTO | 3 horas | 5 horas | En curso | Juan Silva |
| 3 | Cierre de sesión                  | Como `usuario`, necesito poder `cerrar sesión` para `evitar accesos no autorizados` si dejo mi sesión abierta accidentalmente.| ALTO | 3 horas | 5 horas | En curso | Juan Silva  |
| 4 | Visualización del tablero         | Como `jugador`, necesito poder `ver el tablero` del juego de damas en una interfaz gráfica para `comenzar el juego`.| ALTO | 2 horas | 2.5 hora | En curso | Gabriel Yarlequé |
| 5 | Grabacion del juego               | Como `usuario`, necesito, `grabar la información` de las partidas para poder `retroalimentarme con esta informacion` .| BAJO | 5 horas | 8 horas | Pendiente | No definido |
| 6 | Juego multijugador                 | Como `usuario`, necesito poder `jugar contra otros usuarios` para `disfrutar la experiencia multijugador`.| MEDIO | 48 horas | 72 horas | Pendiente | No definido |
| 7 | Juego con bot                     | Como `usuario`, necesito poder `jugar contra la "computadora"` para `practicar y mejorar mis habilidades`. | MEDIO | 48 horas | 72 horas | Pendiente | No definido |
| 8 | Juego Local                       | Como `jugador`, necesito  `jugar contra otro usuario en la misma ubicación física` para conseguir una mejor experiencia en una `partida multijugador local`.| ALTO | 24 horas | 48 horas | Pendiente | No definido |

                             

## III. Criterios de aceptacion(AC)

| ID y nombre de la lista de usuario | AC  ID | Descripcion del criterio de aceptacion | Estado | Desarrollador |
|:----------------------------------:|:------:|:--------------------------------------:|:------------------------------------------:|:-------------:|
| 1 Iniciar sesión             | 1.1 | Inicio de sesión exitoso con credenciales válidas. Dado un username y una contraseña asociada, cuando inicie sesión con estas credenciales entonces el sistema debería permitirme acceder al juego de PlayDamas. | Completada | Juan Silva |
| 1 Iniciar sesión             | 1.2 | Error del inicio de sesión con username inexistente. Dado un username inexistente cuando intento iniciar sesión con este username Entonces el sistema no debería permitirme acceder al juego y mostrar un mensaje de error.| Completada | Juan Silva |
| 1 Iniciar sesión             | 1.3 | Fallo del inicio de sesión con una constraseña inválida. Dado un username con una constraseña no asociada a este mismo cuando intento iniciar sesión con estas credenciales Entonces el sistema no debería permitirme acceder al juego y debería mostrar un mensaje de error indicando "Credenciales incorrecta".| Completada | Juan Silva |
| 1 Iniciar sesión             | 1.4 | Protección contra intentos de inicio de sesión maliciosos Dado unas credenciales inválidas Cuando se realizan más de 3 intentos de inicio de sesión con esas mismas Entonces el sistema debería bloquear por 1 minuto el acceso después de esos intentos fallidos.Y debería mostrar un mensaje de "Cuenta bloqueda por multiples intentos".| Completada | Juan Silva |
| 2 Registro cuenta de usuario | 2.1 | Creación exitosa de una username válida. Dado un username inexistente Cuando creo una cuenta con este username Y una contraseña válida que coincida con la contraseña confirmada Y una dirección de correo electrónico Entonces el sistema debería crear una nueva cuenta. Y mostrar un mensaje de "Registro exitoso".| En progreso | Diego Quispe |
| 2 Registro cuenta de usuario | 2.2 | Creación de una cuenta fallida con un username existente. Dado un username que ya existe, cuando creo una cuenta con este username Y una contraseña válida que coincida con la contraseña confirmada Y una dirección de correo electrónica valida Entonces el sistema no deberían crear una nueva cuenta Y debería mostrar un mensaje de error de "el username ya existe"| En progreso | Diego Quispe |
| 2 Registro cuenta de usuario | 2.3 | Creación de una cuenta fallida con una contraseña no válida. Dado un username válido Cuando un usuario crea una cuenta con este username Y una contraseña no válida Y la misma contraseña confirmada Y una dirección de correo electrónico no válida Entonces no se crea la nueva cuenta. Y el sistema debería mostrar mensajes de error diciendo "credenciales invalidas"| En progreso | Diego Quispe |
| 2 Registro cuenta de usuario | 2.4 | Prevención de creación de cuentas con información maliciosa. Dado un username no válido malicioso, una contraseña válida y una dirección de correo electrónico válida Cuando intento crear una cuenta con estos datos Entonces el sistema debería rechazar la creación de la cuenta.| En progreso | Diego Quispe |
| 3 Cierre de sesión | 3.1 | Cierre de sesión exitoso al tener una cuenta abierta. Cuando selecciono la opción de cerrar sesión Entonces el sistema debería cerrar mi sesión actual y redirigirme a la página de inicio de sesión. | En progreso | Juan Silva |
| 3 Cierre de sesión | 3.2 | No acceso después del cierre de sesión. Dado que he cerrado sesión en mi cuenta Cuando intento acceder a páginas restringidas que requieren inicio de sesión Entonces el sistema no debería permitirme acceder a esas páginas. Y debería redirigirme a la página de inicio de sesión con un mensaje de "Debes inciar sesión primero".| En progreso | Juan Silva |
| 4 Visualización del tablero  |  4.1  | Inicializacion de un tablero de damas con las fichas en sus respectivas posiciones. Dada una nueva partida, se ubican las piezas en las posiciones por defecto. Entonces, se podra comezar una partida  | En progreso | Gabriel Yarleque
| 4 Visualización del tablero  |  4.2  | Visualizacion de la accion de click al momento de seleccionar una ficha. Dada una partida, al presionar sobre una pieza, podremos ver que se selecciona esta ficha.Entonces, podremos mover la pieza(a futuro)  | En progreso | Gabriel Yarleque
| 5 Grabación del Juego        |  5.1  | Opcion de grabacion de partida en la aplicacion. | |
| 6 Juego Multijudaor          |    | | |
| 7 Juego con bot              |    | | |
| 8 Juego Local                |    | | |

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
|       |                   |       |              |                         |                                 |
|       |                   |       |              |                         |                                 |
|       |                   |       |              |                         |                                 |
|       |                   |       |              |                         |                                 |

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

