//Esta clase conoce las fichas y es la que mueve las fichas
class Juego {
  fichas = {};
  casilleros = {};
  idFichaSelecionada = "";
  turno = {
    turnoClara: true,
    fichaTurnoDOM: null
  };
  ganador = {
    cantidadClaras: 0,
    cantidadOscuras: 0,
    ganadorDOM: null,
    contGanadorDOM: null
  }

  constructor(fichas, casilleros, cantidadPiezasClaras, cantidadPiezasOscuras) {
    this.fichas = fichas;
    this.casilleros = casilleros;
    this.#activarFichas();
    this.#activarCasilleros();
    this.turno.fichaTurnoDOM = document.getElementById("ficha-turno");
    this.turno.fichaTurnoDOM.className = this.turno.turnoClara ? "ficha ficha-clara" : " ficha ficha-oscura";
    this.ganador.cantidadClaras = cantidadPiezasClaras;
    this.ganador.cantidadOscuras = cantidadPiezasOscuras;
    this.ganador.ganadorDOM = document.getElementById("info-ganador");
    this.ganador.contGanadorDOM = document.getElementById("info-ganador-contenedor");
  }

  #activarFichas() {
    //Recorrer las fichas y Agregar evento de click en las fichas en cada ficha
    Object.values(this.fichas).forEach((ficha) => {
      ficha.fichaDOM.addEventListener("click", () => {
        this.limpiarCasilleros();

        if ((this.turno.turnoClara && ficha.tipo == "clara") || (!this.turno.turnoClara && ficha.tipo == "oscura")) {
          let movimientosPosibles = ficha.getMovimientosPosibles();
          movimientosPosibles.forEach((movimientoPosible) => {
            if (this.posicionPosible(movimientoPosible)) {
              const casilleroPosible = this.casilleros[movimientoPosible];

              if (!casilleroPosible.ficha.id) {
                //Si entra es porque no hay una ficha en el casillero posible
                casilleroPosible.casilleroSeleccionado();
              } else {
                // Chekear si la ficha es enemiga, si lo es, pintar el casillero de atras
                if (ficha.tipo !== casilleroPosible.ficha.tipo) {
                  const columnaPosible = parseInt(casilleroPosible.posicion[1]);
                  const filaPosible = parseInt(casilleroPosible.posicion[0]);

                  const columnaActual = parseInt(ficha.posicion[1]);
                  const filaActual = parseInt(ficha.posicion[0]);

                  let deltaFila = filaPosible - filaActual;
                  let deltaColumna = columnaPosible - columnaActual;

                  if (deltaFila > 0) deltaFila++;
                  else deltaFila--;
                  if (deltaColumna > 0) deltaColumna++;
                  else deltaColumna--;


                  let capturaPosible = "" + (filaActual + deltaFila) + (columnaActual + deltaColumna);

                  //Si no existe el casillero, no va a buscarlo
                  if (this.posicionPosible(capturaPosible)) {
                    const casilleroCapturaPosible = this.casilleros[capturaPosible];
                    if (!casilleroCapturaPosible.ficha.id) {
                      casilleroCapturaPosible.casilleroSeleccionado();
                    }
                  }
                }
              }
              this.idFichaSelecionada = ficha.id;
            }
          });
        }
      });
    });


  }

  #activarCasilleros() {
    Object.values(this.casilleros).forEach((casillero) => {
      casillero.casilleroDOM.addEventListener("click", () => {
      
        if (casillero.activado) {
          // Sacar la ficha del casillero viejo
          const fichaSelecionada = this.fichas[this.idFichaSelecionada];
          const casilleroViejo = this.casilleros[fichaSelecionada.posicion];
          casilleroViejo.removerFicha();

          //Logica de capturar fichas
          const posicionNueva = casillero.posicion;
          const posicionVieja = fichaSelecionada.posicion;
          let deltaFila = parseInt(posicionNueva[0]) - parseInt(posicionVieja[0]); // fila nueva - fila vieja
          let deltaColumna = parseInt(posicionNueva[1]) - parseInt(posicionVieja[1]);
          //console.log(deltaFila,deltaColumna)

          if (Math.abs(deltaColumna) > 1 || Math.abs(deltaFila) > 1) {
            //hubo captura de pieza
            if (deltaFila > 0) deltaFila--;
            else deltaFila++;
            if (deltaColumna > 0) deltaColumna--;
            else deltaColumna++;

            const posicionIntermedia = "" + (parseInt(posicionVieja[0]) + deltaFila) + (parseInt(posicionVieja[1]) + deltaColumna);


            if (this.casilleros[posicionIntermedia].obtenerTipoFicha() === "clara") {
              this.ganador.cantidadClaras--;
            } else if (this.casilleros[posicionIntermedia].obtenerTipoFicha() === "oscura") {
              this.ganador.cantidadOscuras--;
            }

            this.casilleros[posicionIntermedia].removerFicha();

            //Mostrar ganador
            if (this.ganador.cantidadClaras === 0 || this.ganador.cantidadOscuras === 0) {
              this.ganador.ganadorDOM.innerText = fichaSelecionada.tipo === "clara" ? "Piezas Claras" : "Piezas Oscuras";
              this.ganador.contGanadorDOM.style.display = "flex";
            }

          }
          //Cambiar posicion de la ficha Seleccionada
          fichaSelecionada.posicion = casillero.posicion;


          //promover ficha
          if ((fichaSelecionada.tipo == "clara" && fichaSelecionada.posicion[0] == "1") || (fichaSelecionada.tipo == "oscura" && fichaSelecionada.posicion[0] == "8")) {
            fichaSelecionada.promoverFicha();
          }


          //Colocarla en el casillero nuevo
          casillero.agregarFicha(fichaSelecionada);

          this.turno.turnoClara = !this.turno.turnoClara;
          this.turno.fichaTurnoDOM.className = this.turno.turnoClara ? "ficha ficha-clara" : "ficha ficha-oscura";

          //Limpiar casillero
          this.limpiarCasilleros();
        }
      });
    });
  }

  limpiarCasilleros() {
    Object.values(this.casilleros).forEach((casillero) => {
      this.idFichaSelecionada = "";
      casillero.casilleroDeseleccionado();
    });
  }

  posicionPosible(pos) {
    const fila = parseInt(pos[0]);
    const columna = parseInt(pos[1]);
    return (fila <= 8 && fila >= 1) && (columna <= 8 && columna >= 1);
  }

}
