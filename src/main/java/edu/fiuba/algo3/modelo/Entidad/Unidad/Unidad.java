package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.Atacar;
import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Comando.ComandoNull;
import edu.fiuba.algo3.modelo.Entidad.Comando.RecibirAtaqueUnidad;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;

public abstract class Unidad extends Entidad {
    protected TipoUnidad tipoUnidad;
    protected Ataque ataque;
    protected int contadorDeBajas;

    @Override
    public void pasarTurno() {
        this.estadoOperativo = estadoOperativo.pasarTurno(vida, escudo, new ComandoNull());
        this.ataque.pasarTurno();
    }

    public void atacar(Entidad entidad) {
        estadoOperativo.operable(new Atacar(ataque, entidad, area, raza));
    }

    public void moverse(Area area) {
        if (area.es(this.area)) {
            throw new MovimientoNoValidoException();
        }
        Area areaAnterior = this.area;
        this.area = area.moverse(this, tipoUnidad);
        areaAnterior.desocupar();
    }

    public void sumarBaja() {
        contadorDeBajas += 1;
    }

    @Override
    public int afectarSuministro(int suministro) {
        return afectaSuministro.afectarSuministro(suministro);
    }

    @Override
    public void recibirAtaque(Ataque ataque, Unidad atacante) {
        if (!ataque.ataqueValido(area, raza)) {
            throw new AtaqueNoValidoException();
        }
        Comando recibirAtaque = new RecibirAtaqueUnidad(this, ataque, tipoUnidad, atacante);
        estadoOperativo.atacable(estadoInvisibilidad.atacable(recibirAtaque));
    }

    public boolean movible(Recurso recurso) {
        return recurso.visitar(this);
    }
}
