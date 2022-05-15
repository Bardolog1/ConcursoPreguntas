package com.bardolog.cp.vista;

import com.bardolog.cp.controlador.conexion.ConectorDB;
import com.bardolog.cp.vista.subPanel.*;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.Color;
import static java.awt.Frame.NORMAL;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComponent;
import com.bardolog.cp.controlador.interfaces.EventoClickeable;
import java.sql.SQLException;

public class Principal extends javax.swing.JFrame {

    private String nuevoJugador;
    private EventoClickeable eve;

    //hago instancia de los paneles que voy a usar
    TableroJuego tj = new TableroJuego();
    ConfiguracionJuego cj = new ConfiguracionJuego();
    Puntajes pun = new Puntajes();

    // instancio al conector de la base de dats
    ConectorDB conector;

    public Principal() throws IOException {

        this.setUndecorated(true);
        initComponents();
        this.setTitle("Concurso de preguntas");
        this.setBackground(new Color(255, 255, 255, 0));
        this.setLocationRelativeTo(null);
        barra1.iniciarMovimiento(Principal.this); // çllamada de evento que permnite mover la ventana por la pantalla
        validarEventos(); // metodo que contiene las implementaciones de l interface de EventosClickeables
        setPanel(new PanelHome(contenedorPaneles.getWidth(), contenedorPaneles.getHeight()));  // metodo que limpia el panel contenedor y pasa uno nuevo
        conector = new ConectorDB();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPrincipal = new com.bardolog.cp.vista.componentes.PanelCustom();
        contenedorPaneles = new com.bardolog.cp.vista.componentes.PanelCustom();
        contenedorBotones = new com.bardolog.cp.vista.componentes.PanelCustom();
        btnConfigurarJuego = new com.bardolog.cp.vista.componentes.ButtonCustom();
        btnNuevoJuego = new com.bardolog.cp.vista.componentes.ButtonCustom();
        btnPuntajes = new com.bardolog.cp.vista.componentes.ButtonCustom();
        barra1 = new com.bardolog.cp.vista.componentes.Barra();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        contenedorPaneles.setBackground(new java.awt.Color(255, 255, 255));
        contenedorPaneles.setLayout(new java.awt.BorderLayout());

        btnConfigurarJuego.setText("Configurar Juego");
        btnConfigurarJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfigurarJuegoMouseClicked(evt);
            }
        });

        btnNuevoJuego.setText("Nuevo Juego");
        btnNuevoJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoJuegoMouseClicked(evt);
            }
        });

        btnPuntajes.setText("Puntajes");
        btnPuntajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPuntajesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout contenedorBotonesLayout = new javax.swing.GroupLayout(contenedorBotones);
        contenedorBotones.setLayout(contenedorBotonesLayout);
        contenedorBotonesLayout.setHorizontalGroup(
            contenedorBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorBotonesLayout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addComponent(btnNuevoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnPuntajes, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnConfigurarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );
        contenedorBotonesLayout.setVerticalGroup(
            contenedorBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBotonesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(contenedorBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfigurarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPuntajes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contenedorPrincipalLayout = new javax.swing.GroupLayout(contenedorPrincipal);
        contenedorPrincipal.setLayout(contenedorPrincipalLayout);
        contenedorPrincipalLayout.setHorizontalGroup(
            contenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barra1, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(contenedorPrincipalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(contenedorPaneles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        contenedorPrincipalLayout.setVerticalGroup(
            contenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorPrincipalLayout.createSequentialGroup()
                .addComponent(barra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(contenedorBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedorPaneles, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        getContentPane().add(contenedorPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoJuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoJuegoMouseClicked

        // valido boton inhabilitado
        if (btnNuevoJuego.isEnabled()) {
            //obtengo el jugador
            nuevoJugador = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador", "Nuevo Jugador", JOptionPane.PLAIN_MESSAGE);
            if (nuevoJugador != null) {
                habilitarBotones(false); // metodo para inhabilitar botones
                try {
                    tj = new TableroJuego(nuevoJugador);  // inicializo el tablero de juego y le paso el nombre del jugador
                    validarEventos();
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                setPanel(tj);
            }
        }
    }//GEN-LAST:event_btnNuevoJuegoMouseClicked

    private void btnConfigurarJuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigurarJuegoMouseClicked

        if (btnConfigurarJuego.isEnabled()) {

            // creo un "usuario " y lo valido para acceder a la config
            String admin = JOptionPane.showInputDialog(this, "Ingrese el nombre", "Validar", JOptionPane.PLAIN_MESSAGE);
            String pass = JOptionPane.showInputDialog(this, "Ingrese el clave", "Validar", JOptionPane.PLAIN_MESSAGE);

            if (admin != null && pass != null && admin.equals("admin") && pass.equals("1234")) {
                habilitarBotones(false);
                setPanel(cj);
            } else {
                JOptionPane.showMessageDialog(this, "Datos de acceso erroneos", "Error al validar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnConfigurarJuegoMouseClicked

    private void btnPuntajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPuntajesMouseClicked
        //abro panel de puntajes y  actualizo la tabla
        if (btnPuntajes.isEnabled()) {

            habilitarBotones(true);
            setPanel(pun);
            pun.listar();

        }
    }//GEN-LAST:event_btnPuntajesMouseClicked
    // dentro del main le asigne un nuevbo look and feel

    public static void main(String args[]) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bardolog.cp.vista.componentes.Barra barra1;
    private com.bardolog.cp.vista.componentes.ButtonCustom btnConfigurarJuego;
    private com.bardolog.cp.vista.componentes.ButtonCustom btnNuevoJuego;
    private com.bardolog.cp.vista.componentes.ButtonCustom btnPuntajes;
    private com.bardolog.cp.vista.componentes.PanelCustom contenedorBotones;
    private com.bardolog.cp.vista.componentes.PanelCustom contenedorPaneles;
    private com.bardolog.cp.vista.componentes.PanelCustom contenedorPrincipal;
    // End of variables declaration//GEN-END:variables

    // metodo para cambiar paneles
    private void setPanel(JComponent ventana) {
        contenedorPaneles.removeAll();
        contenedorPaneles.add(ventana);
        contenedorPaneles.repaint();
        contenedorPaneles.revalidate();
    }

    // metodo para escuhar eventos de los paneles o componentes
    public void validarEventos() {

        tj.enviarEvento(new EventoClickeable() {
            @Override
            public void opcion(String opcion) {

                if (opcion != null) {
                    switch (opcion) {
                        case "SalirJuego":
                            setPanel(new PanelHome(contenedorPaneles.getWidth(), contenedorPaneles.getHeight()));
                            habilitarBotones(true);
                            break;
                        case "ganador":
                        default:
                            break;
                    }
                }
            }
        });

        barra1.pasarEvento(new EventoClickeable() {
            @Override
            @SuppressWarnings("fallthrough")
            public void opcion(String opcion) {
                if (opcion != null) {
                    switch (opcion) {
                        case "normal":
                            setExtendedState(NORMAL);
                            break;
                        case "cerrar":
                            System.exit(0);
                        case "maximizar":
                            setExtendedState(6);
                            break;
                        case "minimizar":
                            setExtendedState(1);
                            break;
                        default:
                            break;
                    }
                    repaint();
                }

            }
        });

        cj.pasarEvento(new EventoClickeable() {
            @Override
            public void opcion(String opcion) {
                if (opcion != null) {
                    switch (opcion) {
                        case "salir":
                            setPanel(new PanelHome(contenedorPaneles.getWidth(), contenedorPaneles.getHeight()));
                            habilitarBotones(true);
                            break;
                        default:
                            break;
                    }

                }
            }
        });
        pun.enviarEvento(new EventoClickeable() {
            @Override
            public void opcion(String opcion) {
                if (opcion != null) {
                    switch (opcion) {
                        case "salir":
                            setPanel(new PanelHome(contenedorPaneles.getWidth(), contenedorPaneles.getHeight()));
                            habilitarBotones(true);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        );

    }

    // habilitaçr botones mientras un panel esta abierto o en ejecucion el juego
    public void habilitarBotones(boolean estado) {
        btnConfigurarJuego.setEnabled(estado);
        btnPuntajes.setEnabled(estado);
        btnNuevoJuego.setEnabled(estado);
    }

    public void datos(EventoClickeable eve) {
        this.eve = eve;
    }

}
