package edu.fiuba.algo3.modelo.RolEnSuministro;

public class Proveedor extends RolEnSuministro {
    //Se podria pedir el suministro que aporta.

    public int afectarSuministro(int suministroActual) {
        int nuevoSuministro = suministroActual + 5;
        if (nuevoSuministro > 200) {
            nuevoSuministro = 200;

        }
        return nuevoSuministro;
    }
}
