package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Zanganos;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;

public class AgregarZangano implements Comando {
    private Zanganos zanganos;
    private Zangano zangano;

    public AgregarZangano(Zanganos zanganos, Zangano zangano) {
        this.zanganos = zanganos;
        this.zangano = zangano;
    }

    @Override
    public void ejecutar() {
        zanganos.agregarZangano(zangano);
    }
}
