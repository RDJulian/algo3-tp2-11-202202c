package edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Area.Area;

public class Ataca extends Ataque {
    public Ataca(Unidad unidadAtacante, int danioTierra, int danioAire, int rangoAtaque) {
        this.unidadAtacante = unidadAtacante;
        this.danioTierra = danioTierra;
        this.danioAire = danioAire;
        this.rangoAtaque = rangoAtaque;
    }

    @Override
    public int calcularDanio(TipoUnidad tipoUnidad) {
        return tipoUnidad.recibirDanio(danioAire, danioTierra);
    }

    @Override
    public int calcularDanio() {
        if (danioTierra == 0) {
            throw new AtaqueNoValidoException();
        }
        return danioTierra;
    }

    @Override
    public void atacar(Entidad entidad, Area areaAtacante) {
        this.areaAtacante = areaAtacante;
        entidad.recibirAtaque(this, unidadAtacante);
    }
}
