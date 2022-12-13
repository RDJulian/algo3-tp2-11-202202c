package edu.fiuba.algo3.modelo.Entidad.Suministro;

public class Proveedor implements AfectaSuministro {
    //Se podria pedir el suministro que aporta.

    public int afectarSuministro(int suministroActual) {
        int nuevoSuministro = suministroActual + 5;
        if (nuevoSuministro > 200) {
            nuevoSuministro = 200;

        }
        return nuevoSuministro;
    }
}
