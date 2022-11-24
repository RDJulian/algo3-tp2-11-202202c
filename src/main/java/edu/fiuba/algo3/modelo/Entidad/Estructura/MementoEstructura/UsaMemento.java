package edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura;

public interface UsaMemento {
    //Las estructuras que desean usar un memento deben implementar esta interfaz.
    //Por el momento, las estructuras son sus propias caretakers, porque solamente se guarda un estado.
    void guardarEstado();

    void restaurarEstado();
}