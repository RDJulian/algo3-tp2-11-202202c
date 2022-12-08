package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Comando.RecibirAtaqueEstructura;
import edu.fiuba.algo3.modelo.Entidad.Comando.RecibirAtaqueUnidad;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class Estructura extends Entidad {
    @Override
    public void recibirAtaque(Ataque ataque, Unidad atacante) {
        Comando recibirAtaque = new RecibirAtaqueEstructura(this, ataque, posicion, atacante);
        estadoOperativo.atacable(estadoInvisibilidad.atacable(recibirAtaque));
    }

    @Override
    public int afectarSuministro(int suministro) {
        return estadoOperativo.afectarSuministro(afectaSuministro, suministro);
    }
}