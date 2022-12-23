package edu.fiuba.algo3.mvc;

import java.util.ArrayList;

public class Observable {
    ArrayList<Observador> observadores;

    public Observable(){
        observadores = new ArrayList<>();
    }
    public void agregar(Observador observador){
        observadores.add(observador);
    }

    public void eliminar(Observador observador){
        observadores.remove(observador);
    }

    public void notificar(){
        for (Observador observador: observadores) {
            observador.update();
        }
    }

}
