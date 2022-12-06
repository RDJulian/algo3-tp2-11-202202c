package edu.fiuba.algo3.modelo.Entidad.Memento;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;

import java.util.ArrayList;

public interface UsaMementoOperativo {
    //Las estructuras que desean usar un memento deben implementar esta interfaz.
    //Por el momento, las estructuras son sus propias caretakers, porque solamente se guarda un estado.
    MementoOperativo guardarEstado();

    void restaurarEstado(MementoOperativo snapshot);

    void actualizarEstado(ArrayList<Pilon> pilones);
}