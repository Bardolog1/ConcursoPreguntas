package com.bardolog.cp.modelo;

public class PreguntaFacil extends Pregunta {
    //valor de recompensa para esta clase hija de preguntas
    private final int RECOMPENSA = 200000;

    public PreguntaFacil() {
    }

    public PreguntaFacil(String enunciado, String[] respuestas, String correcta) {
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
