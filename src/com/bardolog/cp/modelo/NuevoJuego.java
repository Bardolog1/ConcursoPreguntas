package com.bardolog.cp.modelo;

import com.bardolog.cp.controlador.conexion.ConectorDB;
import java.io.IOException;
import java.sql.*;

public class NuevoJuego {

    //variables
    private PreguntaFacil facil;
    private PreguntaMuyFacil muyFacil;
    private PreguntaMedio medio;
    private PreguntaDificil dificil;
    private PreguntaLeyenda leyenda;

    public NuevoJuego() {

    }
    // metodo para buscar una pregunta al azar de la bd,  
    //recibe como argumentos el nombre de la tabla del nivel y un objeto del tipo abstracto Pregunta

    public void buscarPreguntasAzar(String nivel, Pregunta p) throws SQLException {

        int numPregunta;
        String pregunta = null;
        String correcta = null;
        String respuestas = null;
        int random = 0;

        // ciclo para obtener un numero aleatorio entre 1 y 5 que es el numero de preguntas por catgoria
        do {
            random = (int) (Math.random() * 5 + 1);
        } while (random == 0);

        //traigo la pregunta de la bd
        try {
            ConectorDB cn = new ConectorDB();
            Connection cx = cn.conectar();

            PreparedStatement ps = cx.prepareStatement("SELECT numPregunta, pregunta, respuestas, correcta FROM " + nivel + " WHERE numpregunta='" + random + "' ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                numPregunta = rs.getInt(1);
                pregunta = rs.getString(2);
                respuestas = rs.getString(3);
                correcta = rs.getString(4);
            }

        } catch (IOException ex) {
            System.out.println("Error al buscar\n" + ex);
        }

        // las respuestas llegan en un string separado por comas 
        //y aqui las paso a un array y uso el metodo split para cortar la cadena
        String[] resStrings = respuestas.split(",");

        // paso los valores al objeto Pregunta
        p.setEnunciado(pregunta);
        p.setRespuestas(resStrings);
        p.setCorrecta(correcta);

    }

    //metodo para validar si la respuesta del usuario corresponde a la corecta
    public boolean validarRespuesta(Pregunta p, String respuesta) {
        return (p.getCorrecta().equals(respuesta));
    }

    //metodo para asignar el nombre de la tabla del nivel
    public String nivel(int nivel) {
        String niv;

        switch (nivel) {
            case 1:
                niv = "muyfacil";
                break;
            case 2:
                niv = "facil";
                break;
            case 3:
                niv = "medio";
                break;
            case 4:
                niv = "dificil";
                break;
            case 5:
                niv = "leyenda";
                break;
            default:
                throw new AssertionError();
        }
        return niv;

    }

    //metodo para crear una ronda del juego con un switch que recibe el numero de la ronda actual y lo compara con las opciones
    //retorna un objeto del tipo Pregunta
    public Pregunta ronda(int numeroRonda) throws SQLException {
        Pregunta p;

        switch (numeroRonda) {
            case 1:
                muyFacil = new PreguntaMuyFacil();
                buscarPreguntasAzar(nivel(1), muyFacil);
                p = muyFacil;
                break;
            case 2:
                facil = new PreguntaFacil();
                buscarPreguntasAzar(nivel(2), facil);
                p = facil;
                break;
            case 3:
                medio = new PreguntaMedio();
                buscarPreguntasAzar(nivel(3), medio);
                p = medio;
                break;

            case 4:
                dificil = new PreguntaDificil();
                buscarPreguntasAzar(nivel(4), dificil);
                p = dificil;
                break;

            case 5:
                leyenda = new PreguntaLeyenda();
                buscarPreguntasAzar(nivel(5), leyenda);
                p = leyenda;
                break;
            default:
                p = null;
        }

        return p;
    }
    //metodos geters de las variabless

    public PreguntaFacil getFacil() {
        return facil;
    }

    public void setFacil(PreguntaFacil facil) {
        this.facil = facil;
    }

    public PreguntaMuyFacil getMuyFacil() {
        return muyFacil;
    }

    public void setMuyFacil(PreguntaMuyFacil muyFacil) {
        this.muyFacil = muyFacil;
    }

    public PreguntaMedio getMedio() {
        return medio;
    }

    public void setMedio(PreguntaMedio medio) {
        this.medio = medio;
    }

    public PreguntaDificil getDificil() {
        return dificil;
    }

    public void setDificil(PreguntaDificil dificil) {
        this.dificil = dificil;
    }

    public PreguntaLeyenda getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(PreguntaLeyenda leyenda) {
        this.leyenda = leyenda;
    }

}
