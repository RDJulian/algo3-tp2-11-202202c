package edu.fiuba.algo3.modelo.Excepciones;

public class FueraDeRangoDelPilon extends RuntimeException{

    public FueraDeRangoDelPilon(){
        super("El edificio no se puede construir porque no esta al alcanc del Pilon");
    }

}
