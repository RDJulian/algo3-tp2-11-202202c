package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Comando.PermitirCorrelatividad;
import edu.fiuba.algo3.modelo.Entidad.Comando.RecibirAtaqueEstructura;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;

public abstract class Estructura extends Entidad {
    @Override
    public void recibirAtaque(Ataque ataque, Unidad atacante) {
        ataque.ataqueEnRango(area);
        Comando recibirAtaque = new RecibirAtaqueEstructura(this, ataque, atacante);
        estadoOperativo.atacable(estadoInvisibilidad.atacable(recibirAtaque));
    }

    @Override
    public int afectarSuministro(int suministro) {
        return estadoOperativo.afectarSuministro(afectaSuministro, suministro);
    }

    public boolean construible(ConstruibleEstructura construibleEstructura) {
        try {
            return estadoOperativo.operable(new PermitirCorrelatividad(this, construibleEstructura));
        } catch (EntidadNoOperativaException e) {
            return false;
        }
    }

    public abstract boolean permitirCorrelatividad(ConstruibleEstructura construibleEstructura);

    public Estructura estaConstruidaEnArea(Area area) {
        if (area == this.area) {
            return this;
        }
        return null;
    }
}