## Actividad : metodologias y procesos de desarrollo de software
### Pasos
**1. ANÁLISIS DEL ESCENARIO**:

1) `Requisitos del cliente bien definidas`: caracteristica basada en la afirmación de que **los
   requisitos desde la perspectiva del cliente son muy conocidos y no es necesario cambiarlos**.

2) `Rediseño del sistema para alta escalabilidad`: caracteristica basada en que el sistema **no puede soportar la crenciente demanda**

3) `Existencia de un componente problemático`: característica basa en la afirmación de que hay 4 componentes independientes
  y uno de ellos está causando **mucho dolor**

4) `Equipo distribuido`: característica basada en la afirmacion de que **el arquitecto técnico esta en Marruecos y gran parte del
   equipo de codificación está en Bélgica**

5) `Comunicación externa`: gestión de las expectativas del cliente

**2. SELECCION DE MODELOS**:
Modelos Candidatos
- Modelo Waterfall
- Scrum

***waterfall***
 1) Se adapta bien porque este modelo es rigido en cuanto a cambios,por lo tanto requiere unos requerimientos claros    y fijos
2) Buena eleccion porque con este modelo tienen una planificaion detallada de cada fase,permitiendo que el rediseño sea claro

3) No es buena elección ya que el modelo en cascada no es tan flexible en cuanto a la adaptacion rapida a algun cambio de un
componente en específico debido a su naturaleza secuencial, es decir, si aparece posteriormente otro componente o modulo problemático,
no podremos retroceder

4) Este modelo no ofrece mecanismos para comunicacion efectiva

5) Este modelo no nos brinda herramientas para una comunicación externa, esto generaría incertidumbre al cliente


***Scrum***

1) Este modelo es agil por lo tanto da igual si los requisitos están bien definidos o no, despues de todo este modelo se adapta a los
   cambios

2) Scrum tiene naturaleza iterativa (sprint), es decir con scrum se puede rediseñar y mejorar en incrementos sucesivos el sistema

3) Scrum es un buen canditado pues si hay un componente problemático,entonces se puede priorizar en ese problema en su mejora
   en un siguiente sprint

4) En scrum hay coordinaciones diarias y/o semanal para el chequeo de sprints, estas reuniones se pueden hacer de manera virutal
    por lo tanto se adecua a esta caracteristica

5) En scrum hay un product Owner que es el intermediario entre el equipo tecnico y el cliente, con esto se permite una
    comunicacion externa y una garantía de que se cumplen con los requisitos del cliente con cada sprint hecho

Por lo tanto la metodoliga ideal sería SCRUM
