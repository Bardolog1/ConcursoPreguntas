package com.bardolog.cp.modelo;

import java.util.Arrays;

public class Pregunta {

    //avariables
    protected String enunciado;
    protected String[] respuestas = new String[4];
    protected String correcta;

    //construcxtores 
    public Pregunta() {
    }

    public Pregunta(String enunciado, String[] respuestas, String correcta) {
        this.enunciado = enunciado;
        this.correcta = correcta;
        this.respuestas = respuestas;
    }

    //geters
    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return enunciado + "," + Arrays.toString(respuestas);
    }

}
