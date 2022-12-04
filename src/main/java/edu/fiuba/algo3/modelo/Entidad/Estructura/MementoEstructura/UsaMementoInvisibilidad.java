package edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura;

public interface UsaMementoInvisibilidad {
    //Las estructuras que desean usar un memento deben implementar esta interfaz.
    //Por el momento, las estructuras son sus propias caretakers, porque solamente se guarda un estado.
    MementoInvisibilidad guardarEstado();

    void restaurarEstado(MementoInvisibilidad snapshot);
}