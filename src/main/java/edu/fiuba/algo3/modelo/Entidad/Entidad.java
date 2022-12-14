package edu.fiuba.algo3.modelo.Entidad;

import edu.fiuba.algo3.modelo.Entidad.Comando.ComandoNull;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.Destruido;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.EstadoInvisibilidadEntidad;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EstadoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.UnidadNull;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.Escudo;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Vida;
import edu.fiuba.algo3.mvc.Observable;

public abstract class Entidad extends Observable {
    protected Raza raza;
    protected Area area;
    protected Vida vida;
    protected Escudo escudo;

    protected EstadoOperativo estadoOperativo;
    protected EstadoInvisibilidadEntidad estadoInvisibilidadEntidad;
    protected AfectaSuministro afectaSuministro;

    protected String nombre;

    public void pasarTurno() {
        this.estadoOperativo = estadoOperativo.pasarTurno(vida, escudo, new ComandoNull());
    }

    public void daniar(int danio, Unidad atacante) {
        escudo.proteger(danio, atacante);
    }

    //Metodo para simplificar pruebas.
    public void daniar(int danio) {
        escudo.proteger(danio, new UnidadNull());
    }

    public abstract void recibirAtaque(Ataque ataque, Unidad unidadAtacante);

    public abstract int afectarSuministro(int suministroActual);

    //Metodo para probar el estadoOperativo.
    public void operable() {
        estadoOperativo.operable(new ComandoNull());
    }

    public void destruir() {
        this.estadoOperativo = new Destruido();
        this.afectaSuministro = new NoAfecta();
        if (area != null) {
            area.desocupar();
        }
        if (raza != null) {
            raza.destruirEntidad(this);
        }
    }

    public String getNombre() {
        return this.nombre;
    }
}
