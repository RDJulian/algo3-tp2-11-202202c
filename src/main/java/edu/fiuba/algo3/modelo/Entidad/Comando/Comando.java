package edu.fiuba.algo3.modelo.Entidad.Comando;

public interface Comando {
    //Patron Comando, las entidades mandan comandos a su EstadoOperativo, quien determina si ejecutar o no.
    void ejecutar();
}
