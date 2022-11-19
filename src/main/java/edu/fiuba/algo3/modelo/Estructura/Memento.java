package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoEstructura;

public interface Memento {
    void guardarEstado();

    void restaurarEstado();

    void setEstado(EstadoEstructura estadoEstructura);
}
