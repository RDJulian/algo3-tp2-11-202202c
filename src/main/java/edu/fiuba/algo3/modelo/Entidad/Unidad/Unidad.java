package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.Atacar;
import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Comando.RecibirAtaqueUnidad;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Area.Area;

public abstract class Unidad extends Entidad {
    protected TipoUnidad tipoUnidad;
    protected Ataque ataque;
    protected int contadorDeBajas;

    public void atacar(Entidad entidad) {
        estadoOperativo.operable(new Atacar(ataque, entidad, area));
    }

    public void moverse(Area area) {
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
        ataque.ataqueEnRango(area);
        Comando recibirAtaque = new RecibirAtaqueUnidad(this, ataque, tipoUnidad, atacante);
        estadoOperativo.atacable(estadoInvisibilidad.atacable(recibirAtaque));
    }

    public boolean movible(Recurso recurso) {
        return recurso.visitar(this);
    }
}
