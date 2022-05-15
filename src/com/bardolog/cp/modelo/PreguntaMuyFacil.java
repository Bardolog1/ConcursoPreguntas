package com.bardolog.cp.modelo;

public class PreguntaMuyFacil extends Pregunta {
//valor de recompensa para esta clase hija de pregunta

    private final int RECOMPENSA = 100000;

    public PreguntaMuyFacil() {
    }

    public PreguntaMuyFacil(String enunciado, String[] respuestas, String correcta) {
        super(enunciado, respuestas, correcta);
    }

    public int getRecompensa() {
        return RECOMPENSA;
    }

    @Override
    public String toString() {
        return super.toString() + " Recompensa: " + RECOMPENSA;
    }

}
