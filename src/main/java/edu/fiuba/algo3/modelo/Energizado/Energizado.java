package edu.fiuba.algo3.modelo.Energizado;

import edu.fiuba.algo3.modelo.MementoEstructura.UsaMemento;

public interface Energizado {
    //Segregacion de interfaz, esta solo aplica a dos estructuras: Acceso y Puerto Estelar.
    void cambiarEnergia(UsaMemento estructura, Boolean energizado);
}
