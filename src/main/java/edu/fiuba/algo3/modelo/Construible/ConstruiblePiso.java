package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Nada;

public interface ConstruiblePiso {
    void visitar(Pilon piso);
    void visitar(Moho piso);

    void visitar(Nada piso);
}
