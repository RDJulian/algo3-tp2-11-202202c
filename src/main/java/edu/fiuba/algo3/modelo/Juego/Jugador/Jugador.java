package edu.fiuba.algo3.modelo.Juego.Jugador;

public class Jugador {
    //Ver que responsabilidad tendria esta clase. Sino, los datos deberian estar en otro lado.
    //Por el momento es una clase anemica.
    private String nombre;
    private String color;

    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }
}
