package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.*;
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
    protected boolean seMovioEsteTurno;

    @Override
    public void pasarTurno() {
        super.pasarTurno();
        this.ataque.pasarTurno();
        seMovioEsteTurno = false;
    }

    public void atacar(Entidad entidad) {
        estadoOperativo.operable(new Atacar(ataque, entidad, area, raza));
    }

    public void moverse(Area area) {
        if (area.es(this.area) || !area.enRango(this.area, 3) || seMovioEsteTurno) {
            throw new MovimientoNoValidoException();
        }
        Area areaAnterior = this.area;
        estadoOperativo.operable(new Moverse(this, tipoUnidad, area));
        this.area = area;
        areaAnterior.desocupar();
        seMovioEsteTurno = true;
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
