package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;

public class Protoss extends Raza {
    public Protoss() {
        super();
        recolectarMineral(200);
    }

    public Protoss(int mineral, int gas) {
        super(mineral, gas);
    }

    public void registrarEntidad(Scout scout) {
        unidades.add(scout);
        reveladores.add(scout);
    }
}
