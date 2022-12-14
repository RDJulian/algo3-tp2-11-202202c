package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.*;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.EntidadInvisible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Devorador;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Excepciones.RazaZergSinLarvasException;

import java.util.ArrayList;

public class Zerg extends Raza {
    private ArrayList<Extractor> extractores;
    private ArrayList<Criadero> criaderos;
    private ConstructorDevorador constructorDevorador;
    private ConstructorGuardian constructorGuardian;
    private ConstructorAmoSupremo constructorAmoSupremo;
    private ConstructorZangano constructorZangano;
    private ConstructorZerling constructorZerling;
    private ConstructorHidralisco constructorHidralisco;
    private ConstructorMutalisco constructorMutalisco;
    private ConstructorCriadero constructorCriadero;
    private ConstructorReservaDeReproduccion constructorReservaDeReproduccion;
    private ConstructorExtractor constructorExtractor;
    private ConstructorGuarida constructorGuarida;
    private ConstructorEspiral constructorEspiral;
    private Protoss contrincante;

    private void generarConstructores() {
        this.extractores = new ArrayList<>();
        this.criaderos = new ArrayList<>();
        this.constructorDevorador = new ConstructorDevorador(estructuras, this);
        this.constructorGuardian = new ConstructorGuardian(estructuras, this);
        this.constructorDevorador = new ConstructorDevorador(estructuras, this);
        this.constructorGuardian = new ConstructorGuardian(estructuras, this);
        this.constructorAmoSupremo = new ConstructorAmoSupremo(estructuras, this);
        this.constructorZangano = new ConstructorZangano(estructuras, this);
        this.constructorZerling = new ConstructorZerling(estructuras, this);
        this.constructorHidralisco = new ConstructorHidralisco(estructuras, this);
        this.constructorMutalisco = new ConstructorMutalisco(estructuras, this);
        this.constructorCriadero = new ConstructorCriadero(estructuras, this);
        this.constructorReservaDeReproduccion = new ConstructorReservaDeReproduccion(estructuras, this);
        this.constructorExtractor = new ConstructorExtractor(estructuras, this);
        this.constructorGuarida = new ConstructorGuarida(estructuras, this);
        this.constructorEspiral = new ConstructorEspiral(estructuras, this);
    }

    public Zerg() {
        super();
        generarConstructores();
        recolectarMineral(200);
    }

    public Zerg(int mineral, int gas) {
        super(mineral, gas);
        generarConstructores();
    }

    public void asignarContrincante(Protoss protoss) {
        this.contrincante = protoss;
    }

    public Extractor buscarExtractor(Area area) {
        Extractor extractor = null;
        int i = 0;
        while (extractor == null && i < extractores.size()) {
            extractor = extractores.get(i).estaConstruidaEnArea(area);
            i++;
        }
        return extractor;
    }

    public void usarLarva() {
        boolean larvaUsada = false;
        int i = 0;
        while (!larvaUsada && i < criaderos.size()) {
            try {
                criaderos.get(i).usarLarva();
                larvaUsada = true;
            } catch (CriaderoSinLarvasException e) {
                i++;
            }
        }
        if (!larvaUsada) {
            throw new RazaZergSinLarvasException();
        }
    }

    public void registrarEntidad(Extractor extractor) {
        estructuras.add(extractor);
        extractores.add(extractor);
    }

    public void registrarEntidad(Criadero criadero) {
        estructuras.add(criadero);
        criaderos.add(criadero);
        invisibles.add(criadero);
    }

    public void registrarEntidad(AmoSupremo amoSupremo) {
        unidades.add(amoSupremo);
        reveladores.add(amoSupremo);
        invisibles.add(amoSupremo);
    }

    public void registrarEntidad(Devorador devorador) {
        unidades.add(devorador);
        invisibles.add(devorador);
    }

    @Override
    public void destruirEntidad(Entidad entidad) {
        estructuras.remove(entidad);
        unidades.remove(entidad);
        extractores.remove(entidad);
        criaderos.remove(entidad);
        reveladores.remove(entidad);
        invisibles.remove(entidad);
    }

    @Override
    public void revelarUnidad(EntidadInvisible entidad) {
        if (contrincante != null) {
            contrincante.revelar(entidad);
        }
    }

    @Override
    public void revelarContrincante() {
        if (contrincante != null) {
            contrincante.revelar(reveladores);
        }
    }

    //Llamado a constructores
    public void construirGuardian(Area area) {
        constructorGuardian.construir(area);
    }

    public void construirDevorador(Area area) {
        constructorDevorador.construir(area);
    }

    public void construirAmoSupremo(Area area) {
        constructorAmoSupremo.construir(area);
    }

    public void construirZangano(Area area) {
        constructorZangano.construir(area);
    }

    public void construirZerling(Area area) {
        constructorZerling.construir(area);
    }

    public void construirHidralisco(Area area) {
        constructorHidralisco.construir(area);
    }

    public void construirMutalisco(Area area) {
        constructorMutalisco.construir(area);
    }

    public void construirCriadero(Area area) {
        constructorCriadero.construir(area);
    }

    public void construirReservaDeReproduccion(Area area) {
        constructorReservaDeReproduccion.construir(area);
    }

    public void construirExtractor(Area area) {
        constructorExtractor.construir(area);
    }

    public void construirGuarida(Area area) {
        constructorGuarida.construir(area);
    }

    public void construirEspiral(Area area) {
        constructorEspiral.construir(area);
    }
}
