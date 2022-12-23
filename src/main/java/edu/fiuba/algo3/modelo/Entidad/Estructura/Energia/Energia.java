package edu.fiuba.algo3.modelo.Entidad.Estructura.Energia;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.EstadoEnergia.Energizado;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.EstadoEnergia.EstadoEnergia;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo.UsaMementoOperativo;
import edu.fiuba.algo3.modelo.Area.Area;

public class Energia {
    private UsaMementoOperativo originador;
    private EstadoEnergia energizado;

    public Energia(UsaMementoOperativo originador) {
        this.originador = originador;
        energizado = new Energizado();
    }

    public void actualizarEstado(Area area) {
        EstadoEnergia estadoAnterior = energizado;
        energizado = area.energizar(energizado);
        if (estadoAnterior != energizado) {
            energizado.actualizarEstado(originador);
        }
    }
}
