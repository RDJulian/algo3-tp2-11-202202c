package edu.fiuba.algo3.modelo.Construible;

public interface Construible {
    //Esta clase parece un mediator, por eso el metodo se llama manejar().
    void manejar(Class<?> clase);
}
