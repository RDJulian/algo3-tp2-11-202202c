package edu.fiuba.algo3.modelo.EjecutarAlPasarTurno;

public interface Ejecutar {
    //La idea de estas clases es saber como llamar a la entidad que ejecuta una accion, sin que otras
    //clases se enteren. Como el accionar de una entidad depende de su EstadoEntidad, lo mas optimo
    //en pos a la escalabilidad del codigo es que esta clase se mande como instancia, y en base al
    //estado, se llame a ejecutar(). Esto requiere una interfaz por accion de entidad y una subclase de Ejecutar.
    void ejecutar();
}
