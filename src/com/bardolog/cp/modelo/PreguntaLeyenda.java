package com.bardolog.cp.modelo;

public class PreguntaLeyenda extends Pregunta {

    //valor de recompensa para esta clase hija de pregunta
    private final int RECOMPENSA = 2000000;

    public PreguntaLeyenda() {
    }

    public PreguntaLeyenda(String enunciado, String[] respuestas, String correcta) {
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
