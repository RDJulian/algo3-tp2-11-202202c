package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;

public class Protoss extends Raza {
    private Protoss() {
        super();
    }

    private static class Holder {
        private static Protoss INSTANCE = new Protoss();
    }

    static public Protoss obtenerInstancia() {
        return Holder.INSTANCE;
    }

    public void registrarEntidad(Scout scout) {
        unidades.add(scout);
        reveladores.add(scout);
    }

    //Metodo unicamente para testear
    public void reiniciar() {
        Holder.INSTANCE = new Protoss();
    }
}
