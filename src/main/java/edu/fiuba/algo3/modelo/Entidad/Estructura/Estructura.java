package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Comando.RecibirAtaqueEstructura;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;

public abstract class Estructura extends Entidad {
    @Override
    public void recibirAtaque(Ataque ataque, Unidad atacante) {
        Comando recibirAtaque = new RecibirAtaqueEstructura(this, ataque, area, atacante);
        estadoOperativo.atacable(estadoInvisibilidad.atacable(recibirAtaque));
    }

    @Override
    public int afectarSuministro(int suministro) {
        return estadoOperativo.afectarSuministro(afectaSuministro, suministro);
    }

    public abstract boolean construible(ConstruibleEstructura construibleEstructura);
}