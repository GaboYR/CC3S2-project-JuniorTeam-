/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
class Casillero {
  posicion;
  tipo = "";
  casilleroDOM;
  ficha = {};
  activado = false;

  constructor(posicion,casilleroDOM){
    this.posicion = posicion;
    this.casilleroDOM = casilleroDOM;
    this.tipo = this.#calcularTipo();
  }

  #calcularTipo(){
    let nroFila = parseInt(this.posicion[0]);
    let nroColumna = parseInt(this.posicion[1]);

    if(nroFila % 2 === 1 && nroColumna % 2 === 0){
      return "oscura";
    }

    if(nroFila % 2 === 0 && nroColumna % 2 === 1){
      return "oscura";
    }

    if(nroFila % 2 === 1 && nroColumna % 2 === 1){
      return "clara";
    }

    if(nroFila % 2 === 0 && nroColumna % 2 === 0){
      return "clara";
    }
  }

  agregarFicha(ficha) {
    this.ficha = ficha;
    this.casilleroDOM.appendChild(ficha.fichaDOM);
  }

  removerFicha(){
    this.ficha = {};
    this.casilleroDOM.removeChild(this.casilleroDOM.firstChild);
  }

  casilleroSeleccionado() {
    this.casilleroDOM.classList.add("pintado");
    this.activado = true;

  }

  casilleroDeseleccionado() {
    this.casilleroDOM.classList.remove("pintado");
    this.activado = false;
  }

  obtenerTipoFicha(){
    return this.ficha.tipo;
  }

}

