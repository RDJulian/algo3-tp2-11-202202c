package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class Nada extends Recurso {

    public Nada(){
        this.nombre = "nada";
        this.unidades = 0;
    }
    @Override
    public void construible(ConstruibleRecurso sobreRecurso, Posicion posicion) {
        sobreRecurso.visitar(this);
    }

    @Override
    public void extraerRecurso(int unidades, Raza raza, ExtraeRecurso extraeRecurso) {
    }
}
