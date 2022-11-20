package edu.fiuba.algo3.modelo.Entidad;

public interface ExtraeRecurso {
    //Las que implementen esta clase no deben recibir nada por parametro,
    //de esta forma se puede separar en estructuras que extraen o no.
    //(Es decir, de las que hacen realmente algo al pasar el turno, ademas de regenerar vida)
    void extraerRecurso();
}
