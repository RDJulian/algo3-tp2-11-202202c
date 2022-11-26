package edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso;

import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Nada;

public interface ConstruibleRecurso {
    void visitar(GasVespeno recurso);

    void visitar(Mineral recurso);

    void visitar(Nada recurso);
}
