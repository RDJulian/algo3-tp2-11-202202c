package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.Comando.Atacar;
import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Comando.RecibirAtaqueUnidad;
import edu.fiuba.algo3.modelo.Posicion.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class Unidad extends Entidad {
    protected int contadorDeBajas;
    protected TipoUnidad tipoUnidad;
    protected Ataque ataque;

    public void atacar(Entidad entidad) {
        estadoOperativo.operable(new Atacar(ataque, entidad, posicion));
    }

    @Override
    public void recibirAtaque(Ataque ataque, Unidad atacante) {
        Comando recibirAtaque = new RecibirAtaqueUnidad(this, ataque, tipoUnidad, posicion, atacante);
        estadoOperativo.atacable(estadoInvisibilidad.atacable(recibirAtaque));
    }

    //Cambiar.
    public void moverse(Posicion posicion) {
        this.posicion = posicion.movible(tipoUnidad);
    }

    @Override
    public int afectarSuministro(int suministro) {
        return afectaSuministro.afectarSuministro(suministro);
    }

    public void sumarBaja() {
        contadorDeBajas += 1;
    }
}
