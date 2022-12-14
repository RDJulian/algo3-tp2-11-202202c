package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorDragon;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorScout;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorZealot;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zealot;

public class Protoss extends Raza {
    private ConstructorNexoMineral constructorNexoMineral;
    private ConstructorPilon constructorPilon;
    private ConstructorAsimilador constructorAsimilador;
    private ConstructorPuertoEstelar constructorPuertoEstelar;
    private ConstructorAcceso constructorAcceso;
    private ConstructorZealot constructorZealot;
    private ConstructorScout constructorScout;
    private ConstructorDragon constructorDragon;

    private void generarConstructores() {
        this.constructorNexoMineral = new ConstructorNexoMineral(this.estructuras, this);
        this.constructorPilon = new ConstructorPilon(this.estructuras, this);
        this.constructorAsimilador = new ConstructorAsimilador(this.estructuras, this);
        this.constructorAcceso = new ConstructorAcceso(this.estructuras, this);
        this.constructorPuertoEstelar = new ConstructorPuertoEstelar(this.estructuras, this);
        this.constructorZealot = new ConstructorZealot(this.estructuras, this);
        this.constructorScout = new ConstructorScout(this.estructuras, this);
        this.constructorDragon = new ConstructorDragon(this.estructuras, this);
    }

    public Protoss() {
        super();
        generarConstructores();
        recolectarMineral(200);
    }

    public Protoss(int mineral, int gas) {
        super(mineral, gas);
        generarConstructores();
    }

    public void registrarEntidad(Zealot zealot) {
        unidades.add(zealot);
        invisibles.add(zealot);
    }

    public void registrarEntidad(Scout scout) {
        unidades.add(scout);
        reveladores.add(scout);
    }

    //Llamado a constructores.
    public void construirNexoMineral(Area area) {
        constructorNexoMineral.construir(area);
    }

    public void construirPilon(Area area) {
        constructorPilon.construir(area);
    }

    public void construirAsimilador(Area area) {
        constructorAsimilador.construir(area);
    }

    public void construirAcceso(Area area) {
        constructorAcceso.construir(area);
    }

    public void construirPuertoEstelar(Area area) {
        constructorPuertoEstelar.construir(area);
    }

    public void construirZealot(Area area) {
        constructorZealot.construir(area);
    }

    public void construirScout(Area area) {
        constructorScout.construir(area);
    }

    public void construirDragon(Area area) {
        constructorDragon.construir(area);
    }
}
