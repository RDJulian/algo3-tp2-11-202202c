package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.NoRequiereEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoNada;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.SobreGasVespeno;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Asimilador;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class ConstructorAsimilador extends ConstructorEstructuras {
    public ConstructorAsimilador(){
        this.construibleRecurso = new SobreGasVespeno();
        this.construiblePiso = new RangoNada();
        this.construibleEstructura = new NoRequiereEstructura();
        this.costoMineral = 100;
        this.costoGas = 0;
        this.costoSuministro = 0;
    }

    @Override
    public Estructura construir(Posicion posicion, Recurso recurso, Piso piso, Raza raza, Estructura estructuraCorrelativa) {
        posicion.ocupable();
        recurso.construible(construibleRecurso);
        piso.construible(construiblePiso, posicion);
        raza.construible(costoMineral, costoGas, costoSuministro);
        construibleEstructura.visitar(estructuraCorrelativa);

        raza.gastarRecursos(costoMineral, costoGas);
        Estructura construccion = new Asimilador(posicion, recurso, raza);
        raza.registarEstructura(construccion);
        return construccion;
    }
}