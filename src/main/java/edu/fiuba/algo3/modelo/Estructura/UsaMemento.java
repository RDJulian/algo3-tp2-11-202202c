package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Energizado.Energizado;
import edu.fiuba.algo3.modelo.EstadoEntidad.EstadoEntidad;

public interface UsaMemento {
    //Las estructuras que desean usar un memento deben implementar esta interfaz.
    //Por el momento, las propias estructuras que implementan esta interfaz
    //son sus propias caretakers, porque solamente se guarda un estado.
    void guardarEstado();

    void restaurarEstado();

    //Revisar.
    void setEstado(EstadoEntidad estadoEstructura);

    void setEstado(Energizado energizado);
}