package edu.fiuba.algo3.modelo.Entidad;

import edu.fiuba.algo3.modelo.Entidad.Comando.Nada;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.Destruido;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.EstadoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EstadoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.UnidadNull;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Entidad.Vida.Defensa;
import edu.fiuba.algo3.modelo.Entidad.Vida.Vida;

public abstract class Entidad {
    protected Raza raza;
    protected Area area;
    protected Vida vida;
    protected Defensa defensa;

    protected EstadoOperativo estadoOperativo;
    protected EstadoInvisibilidad estadoInvisibilidad;
    protected AfectaSuministro afectaSuministro;


    public void pasarTurno() {
        this.estadoOperativo = estadoOperativo.pasarTurno(vida, defensa, new Nada());
    }

    public void daniar(int danio) {
        defensa.proteger(this, vida, danio, new UnidadNull());
    }

    public void daniar(int danio, Unidad atacante) {
        defensa.proteger(this, vida, danio, atacante);
    }

    public abstract void recibirAtaque(Ataque ataque, Unidad unidadAtacante);

    public abstract int afectarSuministro(int suministroActual);

    //Metodo para probar el estadoOperativo.
    public void operable() {
        estadoOperativo.operable(new Nada());
    }

    public void destruir() {
        this.estadoOperativo = new Destruido();
        area.desocupar();
        raza.destruirEntidad(this);
    }
}
