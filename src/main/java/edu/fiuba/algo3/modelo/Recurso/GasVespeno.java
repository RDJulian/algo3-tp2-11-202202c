package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorIncorrectoException;
import edu.fiuba.algo3.modelo.Excepciones.PosicionIncorrectaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacioException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class GasVespeno extends Recurso {
    public GasVespeno(Posicion posicion) {
        this.posicion = posicion;
        this.unidades = 5000;
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
        raza.recolectarGas(unidades);
    }

    @Override
    public boolean construible(ConstruibleRecurso construibleRecurso, Posicion posicion) {
        return construibleRecurso.visitar(this) && posicion.es(this.posicion);
    }
}
