package edu.fiuba.algo3.modelo.Juego.Jugador;

import edu.fiuba.algo3.modelo.Raza.Raza;

public class Jugador {
    //Ver que responsabilidad tendria esta clase. Sino, los datos deberian estar en otro lado.
    private String nombre;
    private String color;
    private Raza raza;

    public Jugador(String nombre, String color, Raza raza) {
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
    }
}
