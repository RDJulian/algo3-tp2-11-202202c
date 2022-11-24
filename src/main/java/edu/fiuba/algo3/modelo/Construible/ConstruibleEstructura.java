package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Entidad.Estructura.*;

public interface ConstruibleEstructura {
    void visitar(Estructura estructura);
    void visitar(Acceso estructura);
    void visitar(Asimilador estructura);
    void visitar(Criadero estructura);
    void visitar(Espiral estructura);
    void visitar(Extractor estructura);
    void visitar(Guarida estructura);
    void visitar(NexoMineral estructura);
    void visitar(Pilon estructura);
    void visitar(ReservaDeReproduccion estructura);
    void visitar(PuertoEstelar estructura);
}