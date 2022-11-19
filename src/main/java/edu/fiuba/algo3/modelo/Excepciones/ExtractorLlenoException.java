package edu.fiuba.algo3.modelo.Excepciones;

public class ExtractorLlenoException extends RuntimeException {

    public ExtractorLlenoException() {
        super("No se puede agregar mas Zanganos a este extractor.");
    }
}
