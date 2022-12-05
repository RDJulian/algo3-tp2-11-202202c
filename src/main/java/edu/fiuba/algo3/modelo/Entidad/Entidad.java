package edu.fiuba.algo3.modelo.Entidad;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Destruido;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Entidad {
    //Resolver la posicion inicial de una Unidad. Puede ser la posicion de la estructura que habilita.
    protected Posicion posicion;
    protected EstadoOperativo estadoOperativo;
    protected EstadoInvisibilidad estadoInvisibilidad;
    protected AfectaSuministro afectaSuministro;
    protected Vida vida;
    protected Defensa defensa;
    protected Raza raza;

    public void operable() {
        this.estadoOperativo.operable();
    }

    public void pasarTurno() {
        this.estadoOperativo = estadoOperativo.pasarTurno(vida, defensa);
    }

    //Para testear.
    public void daniar(int danio, Unidad unidadAtacante) {
        defensa.proteger(this, vida, danio, unidadAtacante);
    }

    public abstract void recibirAtaque(Ataque ataque, Unidad unidadAtacante);

    public abstract int afectarSuministro(int suministroActual);

    public void destruir() {
        this.estadoOperativo = new Destruido();
        raza.destruirEntidad(this);
    }
}
