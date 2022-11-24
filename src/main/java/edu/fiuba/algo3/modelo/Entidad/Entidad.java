package edu.fiuba.algo3.modelo.Entidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Destruido;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoEntidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Entidad {
    protected Posicion posicion;
    protected EstadoEntidad estadoEntidad;
    protected Ejecutar accionAlPasarTurno;
    protected Vida vida;
    protected Defensa defensa;

    public void operable() {
        this.estadoEntidad.operable();
    }

    public void pasarTurno() {
        this.estadoEntidad = estadoEntidad.pasarTurno(accionAlPasarTurno, vida, defensa);
    }

    public abstract void daniar(int danioTierra, int danioAire, Posicion posicionAtacante, int rangoAtaque);

    public void destruir() {
        this.estadoEntidad = new Destruido();
    }
}
