package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;

public class Protoss extends Raza {
    static Protoss instancia;

    private Protoss() {
        super();
    }

    static public Protoss obtenerInstancia() {
        if (instancia == null) {
            instancia = new Protoss();
        }
        return instancia;
    }

    public void registrarEntidad(Scout scout) {
        unidades.add(scout);
        reveladores.add(scout);
    }

    //Metodo unicamente para testear
    public void reiniciar() {
        instancia = new Protoss();
    }
}
