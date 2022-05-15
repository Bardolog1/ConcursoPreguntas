package com.bardolog.cp.vista.subPanel;

import com.bardolog.cp.controlador.conexion.ConectorDB;
import com.bardolog.cp.controlador.interfaces.EventoClickeable;
import com.bardolog.cp.vista.componentes.BorderLineaRedondeada;
import com.bardolog.cp.vista.componentes.ScrollBar;
import java.sql.*;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class ConfiguracionJuego extends javax.swing.JPanel {

    //Variables
    private EventoClickeable eve;
    private Map<Integer, String> preguntas = new HashMap<>();
    private Map<Integer, String> respuestas = new HashMap<>();
    private Map<Integer, String> correctas = new HashMap<>();
    private String nivel;

    //constructor
    public ConfiguracionJuego() {
        this.setBackground(new Color(255, 255, 255, 0));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new com.bardolog.cp.vista.componentes.PanelCustom();
        scrollPreguntas = new javax.swing.JScrollPane();
        setPreguntas1 = new com.bardolog.cp.vista.subPanel.SetPreguntas();
        btnSalir = new com.bardolog.cp.vista.componentes.ButtonCustom();
        btnActualizar = new com.bardolog.cp.vista.componentes.ButtonCustom();
        lblNivel = new javax.swing.JLabel();
        nivelCombo = new javax.swing.JComboBox<>();

        setLayout(new java.awt.CardLayout());

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setPreferredSize(new java.awt.Dimension(930, 560));

        scrollPreguntas.setBackground(new java.awt.Color(242, 242, 242));
        scrollPreguntas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPreguntas.setToolTipText("");
        scrollPreguntas.setHorizontalScrollBar(null);
        scrollPreguntas.setPreferredSize(new java.awt.Dimension(964, 1750));
        scrollPreguntas.setVerticalScrollBar(new ScrollBar());
        scrollPreguntas.setViewportView(setPreguntas1);

        setPreguntas1.setAutoscrolls(true);
        setPreguntas1.setMinimumSize(new java.awt.Dimension(956, 1823));
        setPreguntas1.setPreferredSize(new java.awt.Dimension(956, 1823));
        scrollPreguntas.setViewportView(setPreguntas1);

        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        btnActualizar.setText("Cargar Nivel");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        lblNivel.setFont(new java.awt.Font("Advent Pro", 1, 24)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(0, 0, 0));
        lblNivel.setText("Nivel:");

        nivelCombo.setBackground(new java.awt.Color(255, 255, 255));
        nivelCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Muy Facil", "Facil", "Medio", "Dificil", "Leyenda" }));
        nivelCombo.setBorder(new BorderLineaRedondeada(new Color(98,84,184), true)
        );

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addComponent(lblNivel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nivelCombo, 0, 330, Short.MAX_VALUE)
                .addContainerGap(283, Short.MAX_VALUE))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivel)
                    .addComponent(nivelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(contenedor, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        valorNivel(); //obtengo el valor del combobox y lo recibo como el nombre de la tabla en la bd
        llenarMaps(); // lleno las colecciones  hashamap con los valores de los textfield y text area y les asigno llaves que los relacionan entre si

        //conecto la bd 
        try {
            ConectorDB con = new ConectorDB();
            Connection cx = con.conectar();

            // itero los mapas mediante las llaves para agregarlos a la bd
            for (int i = 1; i <= 5; i++) {

                PreparedStatement ps = cx.prepareStatement(
                        "UPDATE " + nivel + " SET pregunta='" + preguntas.get(i)
                        + "', respuestas='" + respuestas.get(i) + "', correcta='" + correctas.get(i) + "' WHERE numPregunta='" + i + "' ");
                ps.executeUpdate();
            }
            // deswconecto la bd
            con.desconectar();

            JOptionPane.showMessageDialog(this, "Se actualizaron las preguntas del nivel " + nivelCombo.getSelectedItem().toString(), "Actualización Exitosa", JOptionPane.NO_OPTION);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Un error ha ocurrido", "Sin Actualizar", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Un error ha ocurrido", "Sin Actualizar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // paso el valor de metodo de la interfacwe para cambiar de panel
        this.eve.opcion("salir");
    }//GEN-LAST:event_btnSalirMouseClicked

    //paso el valor del combobox a el nombre de la tabla en la bd
    public void valorNivel() {
        switch (nivelCombo.getSelectedItem().toString()) {
            case "Muy Facil":
                nivel = "muyfacil";
                break;
            case "Facil":
                nivel = "facil";
                break;
            case "Medio":
                nivel = "medio";
                break;
            case "Dificil":
                nivel = "dificil";
                break;
            case "Leyenda":
                nivel = "leyenda";
                break;
            default:
                throw new AssertionError();
        }
    }

    //  metodo para llenar los maps con lo campos el los textfield
    public void llenarMaps() {
        preguntas.put(1, setPreguntas1.getPregunta1Text().getText());
        preguntas.put(2, setPreguntas1.getPregunta2Text().getText());
        preguntas.put(3, setPreguntas1.getPregunta3Text().getText());
        preguntas.put(4, setPreguntas1.getPregunta4Text().getText());
        preguntas.put(5, setPreguntas1.getPregunta5Text().getText());

        respuestas.put(1, setPreguntas1.getResp11Text().getText() + ","
                + setPreguntas1.getResp12Text().getText() + ","
                + setPreguntas1.getResp13Text().getText() + ","
                + setPreguntas1.getResp14Text().getText());

        respuestas.put(2, setPreguntas1.getResp21Text().getText() + ","
                + setPreguntas1.getResp22Text().getText() + ","
                + setPreguntas1.getResp23Text().getText() + ","
                + setPreguntas1.getResp24Text().getText());

        respuestas.put(3, setPreguntas1.getResp31Text().getText() + ","
                + setPreguntas1.getResp32Text().getText() + ","
                + setPreguntas1.getResp33Text().getText() + ","
                + setPreguntas1.getResp34Text().getText());

        respuestas.put(4, setPreguntas1.getResp41Text().getText() + ","
                + setPreguntas1.getResp42Text().getText() + ","
                + setPreguntas1.getResp43Text().getText() + ","
                + setPreguntas1.getResp44Text().getText());

        respuestas.put(5, setPreguntas1.getResp51Text().getText() + ","
                + setPreguntas1.getResp52Text().getText() + ","
                + setPreguntas1.getResp53Text().getText() + ","
                + setPreguntas1.getResp54Text().getText());

        correctas.put(1, setPreguntas1.getResp11Text().getText());
        correctas.put(2, setPreguntas1.getResp21Text().getText());
        correctas.put(3, setPreguntas1.getResp31Text().getText());
        correctas.put(4, setPreguntas1.getResp41Text().getText());
        correctas.put(5, setPreguntas1.getResp51Text().getText());
    }

    // metodo para implementar el metodo de la interface
    public void pasarEvento(EventoClickeable eve) {
        this.eve = eve;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bardolog.cp.vista.componentes.ButtonCustom btnActualizar;
    private com.bardolog.cp.vista.componentes.ButtonCustom btnSalir;
    private com.bardolog.cp.vista.componentes.PanelCustom contenedor;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JComboBox<String> nivelCombo;
    private javax.swing.JScrollPane scrollPreguntas;
    private com.bardolog.cp.vista.subPanel.SetPreguntas setPreguntas1;
    // End of variables declaration//GEN-END:variables
}
