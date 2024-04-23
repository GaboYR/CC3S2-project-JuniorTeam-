
let movimientosPosibless = [];

function main() {
  const casillerosOscuros = crearCasilleros();
  const piezasOscuras = colocarPiezasIniciales("oscura",casillerosOscuros);
  const piezasClaras = colocarPiezasIniciales("clara",casillerosOscuros);
  
  const cantidadPiezasClaras = Object.keys(piezasClaras).length;
  const cantidadPiezasOscuras = Object.keys(piezasOscuras).length;


  const juego = new Juego(
    Object.assign(piezasOscuras,piezasClaras), //Agarra las propiedades de un objeto y se las copia a otro objeto
    casillerosOscuros,
    cantidadPiezasClaras,
    cantidadPiezasOscuras
  ); 
}

main();

//FUNCIONES AUXILIARES
function colocarPieza(tipo,posicion,contador,fichas,casillero){
  
  //Crear piezaDOM
  let clasePieza = "ficha";
  let id = "";

  switch(tipo){
    case "oscura":
      clasePieza = clasePieza + " ficha-oscura";
      id = "oscura" + "-" + contador;
      break;

    case "clara":
      clasePieza = clasePieza + " ficha-clara";
      id = "clara" + "-" + contador;
      break;

    case "oscura-reina":
      clasePieza = clasePieza + " ficha-oscura ficha-reina";
      break;

    case "clara-reina":
      clasePieza = clasePieza + " ficha-clara ficha-reina";
      break;
  }

  const fichaDOM = document.createElement("div");
  fichaDOM.className = clasePieza;
  fichaDOM.id = id;
  fichaDOM.style = "cursor: pointer";

  //-----------------------------------------------------------
  //Colocar pieza en el DOM:
  const selectorFila = ".fila-" + posicion[0];
  const selectorCasillero = ".casillero-" + posicion[1];
  const casilleroDOM = document.querySelector(selectorFila).querySelector(selectorCasillero);
  casilleroDOM.appendChild(fichaDOM);

  //-----------------------------------------------------------
  //Crear ficha Objeto:
  const ficha = new Ficha(id,posicion,tipo,fichaDOM);
  casillero[posicion].agregarFicha(ficha);

  //-----------------------------------------------------------
  //Agregar ficha a la colección:
  fichas[id] = ficha;
}

function colocarPiezasIniciales(tipoFicha,casilleros){
  //Devolver un objeto con las 12 fichas
  const fichas = {};
  let contador = 1;
  const indiceFilaInicial = tipoFicha === "oscura"? 1 : 6;
  const indiceFilaFinal = indiceFilaInicial + 2;
   
  for(let i=indiceFilaInicial; i<= indiceFilaFinal; i++){
    for(let j = 1; j<=4; j++){
      let restar = i % 2 === 1 ? 0 : 1 ;
      colocarPieza(tipoFicha, "" + i + (j*2 - restar) , contador, fichas,casilleros);
      contador++;
    }   
  }

  return fichas;
}

function posCasillerosPosibles(){
  const ladoTablero = 8;
  const casilleros = [];
  for(let nroFila = 1; nroFila<= ladoTablero; nroFila++){
    for(let nroColumna=1; nroColumna<=ladoTablero; nroColumna++){
      if(!esPar(nroFila) && esPar(nroColumna)){
        casilleros.push("" + nroFila + nroColumna);
      }

      if(esPar(nroFila) && !esPar(nroColumna)){
        casilleros.push("" + nroFila + nroColumna);
      }
    }
  }

  return casilleros;
}

function crearCasilleros() {
  const casilleros = {};

  posCasillerosPosibles().forEach((posicion) => {
    const selectorFila = ".fila-" + posicion[0];
    const selectorCasillero = ".casillero-" + posicion[1];
    const casilleroDOM = document.querySelector(selectorFila).querySelector(selectorCasillero);
    casilleros[posicion] = new Casillero(posicion,casilleroDOM); 
  });

  return casilleros;
}

/**
 * devuelve true si n es par, false si es impar
 * @param {number} n
 */

function esPar(n){
  return n % 2 === 0;
}


