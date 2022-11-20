package edu.fiuba.algo3.modelo.MementoEstructura;

import edu.fiuba.algo3.modelo.Energizado.Energizado;
import edu.fiuba.algo3.modelo.EstadoEntidad.EstadoEntidad;

public interface UsaMemento {
    //Las estructuras que desean usar un memento deben implementar esta interfaz.
    //Por el momento, las estructuras son sus propias caretakers, porque solamente se guarda un estado.
    //Como el memento restaura un estado, es necesario que la estructura defina por esta interfaz
    //setEstado(), tanto para el EstadoEntidad como para Energizado.
    void guardarEstado();

    void restaurarEstado();

    //Revisar.
    void setEstado(EstadoEntidad estadoEstructura);

    void setEstado(Energizado energizado);
}