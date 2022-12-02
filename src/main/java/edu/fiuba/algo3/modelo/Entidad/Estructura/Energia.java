package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.SinEnergia;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

import java.util.ArrayList;

public class Energia {
    private boolean energizado;

    public Energia() {
        energizado = true;
    }

    private boolean energizado(ArrayList<Pilon> pilones, Posicion posicion) {
        for (Pilon pilon : pilones) {
            if (!pilon.fueraDeRango(posicion)) {
                return true;
            }
        }
        return false;
    }

    public void actualizarEstado(ArrayList<Pilon> pilones, Posicion posicion, EstructuraEnergizada estructura) {
        if (!energizado(pilones, posicion) && energizado) {
            estructura.guardarEstado();
            this.energizado = false;
        } else if (energizado(pilones, posicion) && !energizado) {
            estructura.restaurarEstado();
            this.energizado = true;
        }
    }
}
