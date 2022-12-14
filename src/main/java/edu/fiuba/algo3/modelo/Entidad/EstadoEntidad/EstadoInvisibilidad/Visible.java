package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;

public class Visible implements EstadoInvisibilidadEntidad {
    @Override
    public Comando atacable(Comando comandoAtaque) {
        return comandoAtaque;
    }
}
