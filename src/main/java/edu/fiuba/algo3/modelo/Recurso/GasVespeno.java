package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorIncorrectoException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacioException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class GasVespeno extends Recurso {
    public GasVespeno() {
        this.unidades = 5000;
    }

    public GasVespeno(Posicion posicion) {
        super(posicion);
        this.unidades = 5000;
    }

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
    public void construible(Construible sobreRecurso) {
        sobreRecurso.manejar(GasVespeno.class);
    }
}
