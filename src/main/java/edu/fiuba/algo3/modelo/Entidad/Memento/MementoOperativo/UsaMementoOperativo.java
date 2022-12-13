package edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo;

public interface UsaMementoOperativo {
    //Las estructuras que desean usar un memento deben implementar esta interfaz.
    MementoOperativo guardarEstado();

    void restaurarEstado(MementoOperativo snapshot);

    void actualizarEstado();
}