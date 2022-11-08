package edu.fiuba.algo3.modelo.Excepciones;

public class ExtractorLleno extends RuntimeException{

    public ExtractorLleno(){
        super("No se puede agregar mas Zanganos a este extractor.");
    }
}
