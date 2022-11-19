package edu.fiuba.algo3.modelo.Excepciones;

public class ExtractorIncorrectoException extends RuntimeException {

    public ExtractorIncorrectoException() {
        super("El extractor que quiere usar no es el correcto.");
    }

}
