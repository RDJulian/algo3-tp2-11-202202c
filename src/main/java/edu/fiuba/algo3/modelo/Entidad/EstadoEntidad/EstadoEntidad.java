package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.RolEnSuministro.RolEnSuministro;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public interface EstadoEntidad {
    //El estado de una entidad determina como pasa el turno, si puede hacer
    //lo que hace, si regenera o no su vida/escudo, y si es atacable.
    void operable();

    EstadoEntidad pasarTurno(Ejecutar accionAlPasarTurno, Vida vida, Defensa defensa);

    void atacable();

    //Ver si esta solucion es la mejor. Double dispatch para cumplir con comportamiento esperado:
    //Una entidad solamente puede aportar al suministro de la raza si esta operativa. No aporta
    //en ninguno de los otros casos.
    boolean visitar(RolEnSuministro rol);
}
