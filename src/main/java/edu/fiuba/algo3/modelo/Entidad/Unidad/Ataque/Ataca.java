package edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Ataca extends Ataque {
    public Ataca(Unidad unidadAtacante, int danioTierra, int danioAire, int rangoAtaque) {
        this.unidadAtacante = unidadAtacante;
        this.danioTierra = danioTierra;
        this.danioAire = danioAire;
        this.rangoAtaque = rangoAtaque;
    }

    @Override
    public int calcularDanio(TipoUnidad tipoUnidad, Posicion posicionObjetivo) {
        if (!posicionObjetivo.enRango(posicionAtacante, rangoAtaque)) {
            throw new AtaqueNoValidoException();
        }
        int danioARecibir = tipoUnidad.recibirDanio(danioAire, danioTierra);
        return danioARecibir;
    }

    @Override
    public void atacar(Entidad entidad, Posicion posicionAtacante) {
        this.posicionAtacante = posicionAtacante;
        entidad.recibirAtaque(this, unidadAtacante);
    }
}
