package com.bardolog.cp.vista.subPanel;

import com.bardolog.cp.controlador.conexion.ConectorDB;
import com.bardolog.cp.controlador.interfaces.EventoClickeable;
import com.bardolog.cp.modelo.NuevoJuego;
import com.bardolog.cp.modelo.Pregunta;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TableroJuego extends javax.swing.JPanel {

    //variables 
    private EventoClickeable evento;
    private int contadorRonda = 1;
    private NuevoJuego juego = new NuevoJuego();
    private Pregunta p;
    private String[] respuestasDesordenadas;
    private int recompensaAcumulada = 0;

    public TableroJuego() {
    }

    // sobrecarga del constructor para poder obtener el nombre del jugador y mostrarlo en el tablero
    public TableroJuego(String jugador) throws SQLException {
        initComponents();
        jugadorText.setText(jugador);
        iniciarJuego(); //metodo que iniicia las rondas y busquyeda de preguntasxs
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcionesBut = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnValidar = new com.bardolog.cp.vista.componentes.ButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        textpregunta = new javax.swing.JTextArea();
        btnSalir = new com.bardolog.cp.vista.componentes.ButtonCustom();
        panelCustom1 = new com.bardolog.cp.vista.componentes.PanelCustom();
        opcion3 = new javax.swing.JRadioButton();
        opcion2 = new javax.swing.JRadioButton();
        opcion1 = new javax.swing.JRadioButton();
        opcion4 = new javax.swing.JRadioButton();
        recompensaLabel = new javax.swing.JLabel();
        lblRecompensaAcum = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        preguntaText = new javax.swing.JLabel();
        lblRecompensaAcum1 = new javax.swing.JLabel();
        jugadorText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnValidar.setText("Validar");
        btnValidar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValidarMouseClicked(evt);
            }
        });

        textpregunta.setEditable(false);
        textpregunta.setBackground(new java.awt.Color(255, 255, 255));
        textpregunta.setColumns(20);
        textpregunta.setFont(new java.awt.Font("Advent Pro", 0, 30)); // NOI18N
        textpregunta.setForeground(new java.awt.Color(0, 0, 0));
        textpregunta.setRows(3);
        textpregunta.setText("¿Pregunta por defecto?");
        textpregunta.setWrapStyleWord(true);
        textpregunta.setBorder(null);
        jScrollPane1.setViewportView(textpregunta);

        btnSalir.setText("Salir con mi recompensa");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        panelCustom1.setBackground(new java.awt.Color(240, 240, 240));

        opcionesBut.add(opcion3);
        opcion3.setFont(new java.awt.Font("Advent Pro", 1, 24)); // NOI18N
        opcion3.setForeground(new java.awt.Color(0, 0, 0));

        opcionesBut.add(opcion2);
        opcion2.setFont(new java.awt.Font("Advent Pro", 1, 24)); // NOI18N
        opcion2.setForeground(new java.awt.Color(0, 0, 0));

        opcionesBut.add(opcion1);
        opcion1.setFont(new java.awt.Font("Advent Pro", 1, 24)); // NOI18N
        opcion1.setForeground(new java.awt.Color(0, 0, 0));

        opcionesBut.add(opcion4);
        opcion4.setFont(new java.awt.Font("Advent Pro", 1, 24)); // NOI18N
        opcion4.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelCustom1Layout = new javax.swing.GroupLayout(panelCustom1);
        panelCustom1.setLayout(panelCustom1Layout);
        panelCustom1Layout.setHorizontalGroup(
            panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(opcion4, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addComponent(opcion3, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addComponent(opcion2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opcion1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCustom1Layout.setVerticalGroup(
            panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(opcion1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(opcion2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(opcion3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opcion4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        recompensaLabel.setFont(new java.awt.Font("Advent Pro", 1, 18)); // NOI18N
        recompensaLabel.setForeground(new java.awt.Color(0, 204, 51));
        recompensaLabel.setText("0");

        lblRecompensaAcum.setFont(new java.awt.Font("Advent Pro", 1, 18)); // NOI18N
        lblRecompensaAcum.setForeground(new java.awt.Color(255, 255, 255));
        lblRecompensaAcum.setText("Recompensa acumulada ");

        jLabel3.setFont(new java.awt.Font("Advent Pro", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pregunta:");

        preguntaText.setFont(new java.awt.Font("Advent Pro", 1, 15)); // NOI18N
        preguntaText.setText("0");

        lblRecompensaAcum1.setFont(new java.awt.Font("Advent Pro", 1, 18)); // NOI18N
        lblRecompensaAcum1.setForeground(new java.awt.Color(255, 255, 255));
        lblRecompensaAcum1.setText("Participante");

        jugadorText.setFont(new java.awt.Font("Advent Pro", 1, 18)); // NOI18N
        jugadorText.setForeground(new java.awt.Color(255, 255, 255));
        jugadorText.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                    .addComponent(panelCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preguntaText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(757, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRecompensaAcum1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jugadorText, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(lblRecompensaAcum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recompensaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(preguntaText, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecompensaAcum1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jugadorText, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(lblRecompensaAcum, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(recompensaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnValidarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValidarMouseClicked
        String valor = null;

        //obtengo que radiobuton esta seleccionado y su valor en texto
        if (opcion1.isSelected()) {
            valor = opcion1.getText();
        } else if (opcion2.isSelected()) {
            valor = opcion2.getText();
        } else if (opcion3.isSelected()) {
            valor = opcion3.getText();
        } else if (opcion4.isSelected()) {
            valor = opcion4.getText();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una opcion");
        }

        //comparo el valor obtenido con el valor correcto llamando al metodo validarRespuesta
        if (valor != null && juego.validarRespuesta(p, valor)) {
            // el contador de rondas sirve para asignar puntos y para pasar su valor al metodo ronda()
            if (contadorRonda < 5) {
                contadorRonda++;
                try {
                    // cada que la respuesta es correcta  recalculamos la recompensa  con el metodo asignar recompensa que segun el contador  busca el valor de l a ronda
                    recompensaAcumulada += asignarRecompensa(contadorRonda);
                    // se inicia el juego de nuevo
                    opcionesBut.clearSelection();
                    iniciarJuego();

                } catch (SQLException ex) {
                    Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                // esto sucede cuando el jugador pasa topdas las rondas
                recompensaAcumulada += asignarRecompensa(contadorRonda);
                repintarTexto(); // re pintamos los label
                JOptionPane.showMessageDialog(null, " Felicidades, ha ganado el juego", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Su puntaje fue: " + contadorRonda + "/5\n" + "Su premio es: $" + recompensaAcumulada);
                insertarPuntajes(contadorRonda, recompensaAcumulada);  // este metodo permite enviar los datos a la bd
                this.evento.opcion("SalirJuego");

            }
        } else {

            // esto sucede cuando se equivoca
            JOptionPane.showMessageDialog(null, " Se ha equivocado", "Ha fallado", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Su puntaje fue: " + (contadorRonda - 1) + "/5\n" + "Su premio es: $" + recompensaAcumulada);
            insertarPuntajes((contadorRonda - 1), recompensaAcumulada);
            this.evento.opcion("SalirJuego");
        }
    }//GEN-LAST:event_btnValidarMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // retirada voluntaria del juego

        JOptionPane.showMessageDialog(null, " Se ha retirado del Juego", "Retiro voluntario", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Su puntaje fue: " + (contadorRonda - 1) + "/5\n" + "Su premio es: $" + recompensaAcumulada);
        insertarPuntajes(contadorRonda - 1, recompensaAcumulada);
        this.evento.opcion("SalirJuego");
    }//GEN-LAST:event_btnSalirActionPerformed
    public void enviarEvento(EventoClickeable evento) {
        this.evento = evento;
    }

    // metodo para iniciar juego donde paso el numero de ronda y uso el objeto pregunta
    public void iniciarJuego() throws SQLException {
        p = juego.ronda(contadorRonda);
        respuestasDesordenadas = new String[4];
        opcionesAleatorias(p.getRespuestas());
        repintarTexto();
    }

    // metodo para re pintar los label
    public void repintarTexto() {
        textpregunta.setText("\n           "+p.getEnunciado());
        preguntaText.setText("" + contadorRonda + "");
        opcion1.setText(respuestasDesordenadas[0]);
        opcion2.setText(respuestasDesordenadas[1]);
        opcion3.setText(respuestasDesordenadas[2]);
        opcion4.setText(respuestasDesordenadas[3]);
        recompensaLabel.setText(" $ " + recompensaAcumulada + "");
    }

    // metodo para cambiar de orden las opciones de respuesta, uso un hashset 
    //para desordenarlas ya que al agregar los valores en este no se garantiza nunca su orden
    public void opcionesAleatorias(String[] opciones) {
        Set<String> desordenadas = new HashSet<String>();
        for (String opcion : opciones) {
            desordenadas.add(opcion);
        }
        desordenadas.toArray(respuestasDesordenadas);
    }

    // metodo para calcular la reconpensa segun la ronda
    public int asignarRecompensa(int nivel) {
        int recompensa;
        switch (nivel) {
            case 1:
                recompensa = 0;
                break;
            case 2:
                recompensa = juego.getMuyFacil().getRecompensa();
                break;
            case 3:
                recompensa = juego.getFacil().getRecompensa();
                break;
            case 4:
                recompensa = juego.getMedio().getRecompensa();
                break;
            case 5:
                recompensa = juego.getDificil().getRecompensa();
                break;
            case 6:
                recompensa = juego.getLeyenda().getRecompensa();
                break;
            default:
                throw new AssertionError();
        }
        return recompensa;
    }

    // metodo para llamar la conexion a la bd e insertar los valores del jugador
    public void insertarPuntajes(int puntaje, int premio) {

        try {
            ConectorDB con = new ConectorDB();
            Connection cx = con.conectar();

            PreparedStatement ps = cx.prepareStatement("INSERT INTO puntajes(participante,puntaje,premio) VALUES(?,?,?)");

            ps.setString(1, jugadorText.getText());
            ps.setInt(2, puntaje);
            ps.setInt(3, premio);
            ps.executeUpdate();

            con.desconectar();
            JOptionPane.showMessageDialog(this, "Se agrego su puntuacion ", "Actualizado", JOptionPane.NO_OPTION);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Un error ha ocurrido", "Sin Actualizar", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Un error ha ocurrido", "Sin Actualizar", JOptionPane.ERROR_MESSAGE);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bardolog.cp.vista.componentes.ButtonCustom btnSalir;
    private com.bardolog.cp.vista.componentes.ButtonCustom btnValidar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jugadorText;
    private javax.swing.JLabel lblRecompensaAcum;
    private javax.swing.JLabel lblRecompensaAcum1;
    private javax.swing.JRadioButton opcion1;
    private javax.swing.JRadioButton opcion2;
    private javax.swing.JRadioButton opcion3;
    private javax.swing.JRadioButton opcion4;
    private javax.swing.ButtonGroup opcionesBut;
    private com.bardolog.cp.vista.componentes.PanelCustom panelCustom1;
    private javax.swing.JLabel preguntaText;
    private javax.swing.JLabel recompensaLabel;
    private javax.swing.JTextArea textpregunta;
    // End of variables declaration//GEN-END:variables

}
