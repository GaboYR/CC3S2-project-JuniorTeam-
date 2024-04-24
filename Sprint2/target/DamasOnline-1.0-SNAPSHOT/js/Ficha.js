class Ficha {
  //Clase mayor que contenga la coleccion de fichas y la coleccion de casilleros?
  //Se encarga de mover las fichas
  id;
  posicion;
  tipo;
  esReina = false;
  fichaDOM;

  constructor(id,posicion,tipo,fichaDOM){
    this.id = id;
    this.posicion = posicion;
    this.tipo = tipo;
    this.fichaDOM = fichaDOM;
  }

  getMovimientosPosibles() {
     //Si es oscura, se mueve en fila+
     //Si es clara, se mueve en fila-
     //Ambos se mueven en columna+,columna-
     let result = [];
     let columnaActual = parseInt(this.posicion[1]);
     let filaActual = parseInt(this.posicion[0]);

      if(this.esReina){
        result.push("" + (filaActual + 1) + (columnaActual - 1));
        result.push("" + (filaActual + 1) + (columnaActual + 1));
        result.push("" + (filaActual - 1) + (columnaActual - 1));
        result.push("" + (filaActual - 1) + (columnaActual + 1));


      }else{ 
        let filaNueva = filaActual + 1;
        
        if(this.tipo === "clara"){
          filaNueva = filaActual - 1;
        }
        result.push("" + filaNueva + (columnaActual - 1));
        result.push("" + filaNueva + (columnaActual + 1));
      }
    
     return result;
  }
  
  promoverFicha(){
    this.esReina = true;
    this.fichaDOM.classList.add('ficha-reina');
  }
}
