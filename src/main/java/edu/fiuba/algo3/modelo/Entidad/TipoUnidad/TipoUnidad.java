package edu.fiuba.algo3.modelo.Entidad.TipoUnidad;

public interface TipoUnidad {
    void manejar(Class<?> clase);

    int recibirDanio(int danioAire, int danioTierra);
}
