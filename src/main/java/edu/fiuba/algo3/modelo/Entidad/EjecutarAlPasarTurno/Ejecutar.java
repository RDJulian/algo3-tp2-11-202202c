package edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno;

public interface Ejecutar {
    //La idea de estas clases es saber como llamar a la entidad que ejecuta una accion.
    //Como el accionar de una entidad depende de su EstadoEntidad, esta clase se manda como instancia,
    //y ejecuta lo que la estructura o unidad hace.
    void ejecutar();
}
