package edu.fiuba.algo3.modelo.Excepciones;

public class ExtractorIncorrecto extends RuntimeException {

    public ExtractorIncorrecto() {
        super("El extractor que quiere usar no es el correcto.");
    }

}
