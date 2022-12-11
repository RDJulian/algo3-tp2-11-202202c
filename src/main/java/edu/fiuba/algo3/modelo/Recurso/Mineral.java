package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorIncorrectoException;
import edu.fiuba.algo3.modelo.Excepciones.PosicionIncorrectaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacioException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class Mineral extends Recurso {
    public Mineral(Posicion posicion) {
        this.posicion = posicion;
        this.unidades = 2000;
        this.nombre = "mineral";
    }

    //Codigo muy similar.
    public void extraerRecurso(int unidades, Raza raza, ExtraeRecurso extraeRecurso) {
        if (this.extraeRecurso != extraeRecurso) {
            throw new ExtractorIncorrectoException();
        }
        int nuevasUnidades = this.unidades - unidades;
        if (nuevasUnidades < 0) {
            throw new RecursoVacioException();
        }
        this.unidades = nuevasUnidades;
        raza.recolectarMineral(unidades);
    }

    @Override
    public void construible(ConstruibleRecurso sobreRecurso, Posicion posicion) {
        if (!this.posicion.es(posicion)) {
            throw new PosicionIncorrectaException();
        }
        sobreRecurso.visitar(this);
    }

}
