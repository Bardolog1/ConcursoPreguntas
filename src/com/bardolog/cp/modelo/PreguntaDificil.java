

package com.bardolog.cp.modelo;


public class PreguntaDificil extends Pregunta {
    
    //valor de recompensa para esta clase hija de pregunta
    private final int RECOMPENSA = 1000000;

    public PreguntaDificil() {
    }
    
    public PreguntaDificil(String enunciado, String[] respuestas, String correcta) {
        super(enunciado, respuestas, correcta);
    }
   
    public int getRecompensa() {
        return RECOMPENSA;
    }

    @Override
    public String toString() {
        return super.toString()+" Recompensa: " + RECOMPENSA;
    }
    
    
    
    
    
    
    

}
