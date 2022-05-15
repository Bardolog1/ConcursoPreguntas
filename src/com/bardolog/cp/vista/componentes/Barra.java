package com.bardolog.cp.vista.componentes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import com.bardolog.cp.controlador.interfaces.EventoClickeable;

public class Barra extends javax.swing.JPanel {

    private EventoClickeable eve;
    private int cont = 0;  // contador de clicks para minimizar o maximizar
    private boolean estado = false;  // bandera de estado de la ventana

    public Barra() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        minimizar = new com.bardolog.cp.vista.componentes.ButtonCustom();
        maximizar = new com.bardolog.cp.vista.componentes.ButtonCustom();
        cerrar = new com.bardolog.cp.vista.componentes.ButtonCustom();

        setOpaque(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        panelContenedor.setOpaque(false);

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Advent Pro", 0, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titulo.setText("Concurso de Preguntas");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        titulo.setIconTextGap(15);

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bardolog/cp/vista/imagenesiconos/minimize_32.png")));
        minimizar.setText("");
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });

        maximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bardolog/cp/vista/imagenesiconos/maximize_32.png")));
        maximizar.setText("");
        maximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximizarMouseClicked(evt);
            }
        });

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bardolog/cp/vista/imagenesiconos/close_32.png")));
        cerrar.setText("");
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(maximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        this.eve.opcion("cerrar");
     }//GEN-LAST:event_cerrarMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // en este evento cuento cuantos click se dan a la barra superior para maximizar la pantalla
        cont++;
        if (cont == 2) {
            if (!estado) {
                this.eve.opcion("maximizar");
                estado = true;
                cont = 0;
            } else {
                this.eve.opcion("normal");
                estado = false;
                cont = 0;
            }
        }
    }//GEN-LAST:event_formMouseClicked

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        minimizar.setPresionado(false);
        this.eve.opcion("minimizar");
    }//GEN-LAST:event_minimizarMouseClicked

    private void maximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximizarMouseClicked
        if (!estado) {
            this.eve.opcion("maximizar");
            estado = true;
        } else {
            this.eve.opcion("normal");
            estado = false;
        }
    }//GEN-LAST:event_maximizarMouseClicked

    // pintar el componente 
    @Override
    protected void paintChildren(Graphics g) {

        Graphics2D gra2 = (Graphics2D) g;
        gra2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint grad = new GradientPaint(0, 0, new Color(40, 22, 84), getWidth(), getHeight(), new Color(81, 64, 175));
        Path2D.Float f = new Path2D.Float();

        f.moveTo(0, 0);
        f.curveTo(0, 0, 0, 15, 60, 15);
        f.curveTo(60, 15, 100, 15, 110, getHeight());

        f.lineTo(getWidth(), getHeight());
        f.lineTo(getWidth(), 7);
        f.curveTo(getWidth(), 7, getWidth(), 0, getWidth() - 7, 0);
        f.lineTo(0, 0);

        gra2.setColor(new Color(49, 100, 121));
        gra2.setPaint(grad);
        gra2.fill(f);
        super.paintChildren(g);
    }

    private int x;
    private int y;

    // metodo con evento de mouse para capturar el movimiento del mouse al mantener presionada la barra y mover el panel por la pantalla
    public void iniciarMovimiento(JFrame frame) {
        this.addMouseListener(new MouseAdapter() {  // capturo la posicion
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        });
    }

    //metodo para la interface de eventos
    public void pasarEvento(EventoClickeable eve) {
        this.eve = eve;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bardolog.cp.vista.componentes.ButtonCustom cerrar;
    private com.bardolog.cp.vista.componentes.ButtonCustom maximizar;
    private com.bardolog.cp.vista.componentes.ButtonCustom minimizar;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
