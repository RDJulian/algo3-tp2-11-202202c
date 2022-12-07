package edu.fiuba.algo3.modelo.Archivo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.vista.layouts.VistaArea;
import edu.fiuba.algo3.vista.layouts.VistaEntidad;
import edu.fiuba.algo3.vista.layouts.VistaTerreno;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorDeArchivosJSON {

    public ArrayList<VistaArea> leerPartida(Raza razaJugadorUno,Raza razaJugadorDos) throws FileNotFoundException {
        ArrayList<VistaArea> areas = new ArrayList<>();

        JsonParser parser = new JsonParser();
        Object objeto = parser.parse(new FileReader("src/main/resources/partida.json"));
        JsonElement elementoJSON = (JsonElement) objeto;
        JsonObject objetoJSON = elementoJSON.getAsJsonObject();

        JsonArray arrayJSON = (JsonArray) objetoJSON.get("areas");
        for (Object objetoDeArray: arrayJSON){
            areas.add(generarArea(objetoDeArray,razaJugadorUno, razaJugadorDos));
        }
        return areas;

    }

    private VistaArea generarArea(Object objeto,Raza razaJugadorUno,Raza razaJugadorDos){
        JsonObject objetoJSON = (JsonObject) objeto;
        JsonObject posicionJSON = objetoJSON.get("posicion").getAsJsonObject();
        JsonObject recursoJSON = objetoJSON.get("recurso").getAsJsonObject();
        JsonObject pisoJSON = objetoJSON.get("piso").getAsJsonObject();
        JsonObject entidadJSON = objetoJSON.get("estructura").getAsJsonObject();

        Posicion posicion = generarPosicion(posicionJSON);
        Recurso recurso = generarRecurso(recursoJSON, posicion);
        Piso piso = generarPiso(pisoJSON, posicion);
        Estructura estructura = generarEstructura(entidadJSON,posicion,recurso,razaJugadorUno,razaJugadorDos);
        Unidad unidad = generarUnidad(entidadJSON,posicion,razaJugadorUno,razaJugadorDos);

        VistaTerreno vistaTerreno = new VistaTerreno(posicion,recurso,piso);
        VistaEntidad vistaEntidad = new VistaEntidad(posicion,estructura,unidad);
        return new VistaArea(vistaTerreno, vistaEntidad);
    }

    private Posicion generarPosicion(JsonObject posicionJSON) {
        JsonObject objetoJSON = posicionJSON;
        int x = objetoJSON.get("x").getAsInt();
        int y = objetoJSON.get("y").getAsInt();
        Posicion posicion = new Posicion(x,y);

        JsonElement tipoPiso = objetoJSON.get("estadoPosicion");

        if (tipoPiso.equals("ocupada")){ posicion.ocupar(); }

        return posicion;
    }

    private Recurso generarRecurso(JsonObject recursoJSON,Posicion posicion) {
        JsonObject objetoJSON = recursoJSON;
        String tipoRecurso = objetoJSON.get("tipoRecurso").getAsString();
        Recurso recurso = null;

        switch (tipoRecurso) {
            case "gas":
                recurso = new GasVespeno(posicion);
                break;
            case "mineral":
                recurso = new Mineral(posicion);
                break;
            case "nada":
                recurso = new Nada();
                break;
        }
        return recurso;
    }

    private Piso generarPiso(JsonObject pisoJSON, Posicion posicion) {
        JsonObject objetoJSON = pisoJSON;
        String tipoRecurso = objetoJSON.get("tipoPiso").getAsString();
        Piso piso = null;

        switch (tipoRecurso) {
            case "moho":
                piso = new Moho(posicion);
                break;
            case "nada":
                piso = new edu.fiuba.algo3.modelo.Piso.Nada();
                break;
        }
        return piso;
    }

    private Estructura generarEstructura(JsonObject entidadJSON, Posicion posicion, Recurso recurso, Raza razaJugadorUno, Raza razaJugadorDos){
        JsonObject objetoJSON = entidadJSON;
        Raza razaDeLaEstructura = determinarRaza(entidadJSON, razaJugadorUno, razaJugadorDos);
        String tipoEstructura = objetoJSON.get("tipoEstructura").getAsString();
        Estructura estructura = null;

        switch (tipoEstructura) {
            case "criadero":
                estructura = new Criadero(posicion, razaDeLaEstructura);
                break;
            case "extractor":
                estructura = new Extractor(posicion, recurso, razaDeLaEstructura);
                break;
            case "acceso":
                estructura = new Acceso(posicion, razaDeLaEstructura);
                break;
            case "asimilador":
                estructura = new Asimilador(posicion, recurso, razaDeLaEstructura);
                break;
            case "espiral":
                estructura = new Espiral(posicion, razaDeLaEstructura);
                break;
            case "guarida":
                estructura = new Guarida(posicion, razaDeLaEstructura);
                break;
            case "nada":
                estructura = new edu.fiuba.algo3.modelo.Entidad.Estructura.Nada();
                break;
            case "nexo":
                estructura = new NexoMineral(posicion, recurso, razaDeLaEstructura);
                break;
            case "pilon":
                estructura = new Pilon(posicion, razaDeLaEstructura);
                break;
            case "puerto":
                estructura = new PuertoEstelar(posicion, razaDeLaEstructura);
                break;
            case "reserva":
                estructura = new ReservaDeReproduccion(posicion, razaDeLaEstructura);
                break;
        }
        return estructura;
    }

    private Raza determinarRaza(JsonObject entidadJSON, Raza razaJugadorUno, Raza razaJugadorDos) {
        JsonObject objetoJSON = entidadJSON;
        String raza = objetoJSON.get("raza").getAsString();
        Raza razaDeLaEstructura = razaJugadorUno;

        if (raza.equals("jugador2")) {
            razaDeLaEstructura = razaJugadorDos;
        }

        return razaDeLaEstructura;
    }

    private Unidad generarUnidad(JsonObject entidadJSON, Posicion posicion, Raza razaJugadorUno, Raza razaJugadorDos){
        JsonObject objetoJSON = entidadJSON;
        Raza razaDeLaUnidad = determinarRaza(entidadJSON,razaJugadorUno,razaJugadorDos);
        String tipoUnidad = objetoJSON.get("tipoUnidad").getAsString();
        Unidad unidad = null;

        switch (tipoUnidad) {
            case "amo":
                unidad = new AmoSupremo(posicion, razaDeLaUnidad);
                break;
            case "devorador":
                unidad = new Devorador(posicion, razaDeLaUnidad);
                break;
            case "dragon":
                unidad = new Dragon(posicion, razaDeLaUnidad);
                break;
            case "guardian":
                unidad = new Guardian(posicion, razaDeLaUnidad);
                break;
            case "hidralisco":
                unidad = new Hidralisco(posicion, razaDeLaUnidad);
                break;
            case "mutalisco":
                unidad = new Mutalisco(posicion, razaDeLaUnidad);
                break;
            case "scout":
                unidad = new Scout(posicion, razaDeLaUnidad);
                break;
            case "zangano":
                unidad = new Zangano(posicion, razaDeLaUnidad);
                break;
            case "zealot":
                unidad = new Zealot(posicion, razaDeLaUnidad);
                break;
            case "zerling":
                unidad = new Zerling(posicion, razaDeLaUnidad);
                break;
        }
        return unidad;
    }
}
