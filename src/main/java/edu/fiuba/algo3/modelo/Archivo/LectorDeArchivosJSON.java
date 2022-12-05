package edu.fiuba.algo3.modelo.Archivo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.vista.layouts.VistaArea;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorDeArchivosJSON {

    public ArrayList<VistaArea> leerPartida() throws FileNotFoundException {
        ArrayList<VistaArea> areas = new ArrayList<>();

        JsonParser parser = new JsonParser();
        Object objeto = parser.parse(new FileReader("src/main/resources/partida.json"));
        JsonElement elementoJSON = (JsonElement) objeto;
        JsonObject objetoJSON = elementoJSON.getAsJsonObject();

        JsonArray arrayJSON = (JsonArray) objetoJSON.get("areas");
        for (Object objetoDeArray: arrayJSON){
            areas.add(generarArea(objetoDeArray));
        }
        return areas;

    }

    private VistaArea generarArea(Object objeto){
        JsonObject objetoJSON = (JsonObject) objeto;
        JsonObject posicionJSON = objetoJSON.get("posicion").getAsJsonObject();
        JsonObject recursoJSON = objetoJSON.get("recurso").getAsJsonObject();
        JsonObject pisoJSON = objetoJSON.get("piso").getAsJsonObject();
        JsonObject entidadJSON = objetoJSON.get("estructura").getAsJsonObject();

        Posicion posicion = generarPosicion(posicionJSON);
        Recurso recurso = generarRecurso(recursoJSON, posicion);
        Piso piso = generarPiso(pisoJSON, posicion);
        //Entidad entidad = generarEntidad(entidadJSON,posicion);

        return new VistaArea();
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

}
