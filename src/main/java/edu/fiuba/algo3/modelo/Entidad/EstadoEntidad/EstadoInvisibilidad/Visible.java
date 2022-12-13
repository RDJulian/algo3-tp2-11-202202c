package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;

public class Visible implements EstadoInvisibilidad {
    @Override
    public Comando atacable(Comando comandoAtaque) {
        return comandoAtaque;
    }
}
