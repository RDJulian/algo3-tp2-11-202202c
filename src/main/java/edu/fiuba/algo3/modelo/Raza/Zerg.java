package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorDevorador;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorGuardian;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Excepciones.RazaZergSinLarvasException;

import java.util.ArrayList;

public class Zerg extends Raza {
    private ArrayList<Extractor> extractores;
    private ArrayList<Criadero> criaderos;
    private ConstructorDevorador constructorDevorador;
    private ConstructorGuardian constructorGuardian;

    public Zerg() {
        super();
        this.extractores = new ArrayList<>();
        this.criaderos = new ArrayList<>();
        this.constructorDevorador = new ConstructorDevorador(estructuras, this);
        this.constructorGuardian = new ConstructorGuardian(estructuras, this);

        recolectarMineral(200);
    }

    public Zerg(int mineral, int gas) {
        super(mineral, gas);
        this.extractores = new ArrayList<>();
        this.criaderos = new ArrayList<>();
        this.constructorDevorador = new ConstructorDevorador(estructuras, this);
        this.constructorGuardian = new ConstructorGuardian(estructuras, this);
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
    }

    public void registrarEntidad(AmoSupremo amoSupremo) {
        unidades.add(amoSupremo);
        reveladores.add(amoSupremo);
    }

    @Override
    public void destruirEntidad(Entidad entidad) {
        estructuras.remove(entidad);
        unidades.remove(entidad);
        extractores.remove(entidad);
        criaderos.remove(entidad);
        reveladores.remove(entidad);
    }

    //Llamado a constructores
    public void construirGuardian(Area area) {
        constructorGuardian.construir(area);
    }

    public void construirDevorador(Area area) {
        constructorDevorador.construir(area);
    }
}
