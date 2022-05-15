package com.bardolog.cp.vista.subPanel;

import com.bardolog.cp.controlador.conexion.ConectorDB;
import com.bardolog.cp.controlador.interfaces.EventoClickeable;
import com.bardolog.cp.vista.componentes.ScrollBar;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Puntajes extends javax.swing.JPanel {

    //variables
    private EventoClickeable evento;
    private String idU;

    public Puntajes() {
        initComponents();

        // le asigno caracteristicas a la tabla
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);

        // implementacion de un listener que permite estar al tanto de la seleccion de alguna fiula
        tablaPuntajes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaPuntajes.getSelectedRow() != -1) {
                    int fila = tablaPuntajes.getSelectedRow();
                    idU = tablaPuntajes.getValueAt(fila, 4).toString();
                }
            }
        });
      
        // metodo que actualiza los datos de la tabla
        listar();
    }

    public void listar() {

        DefaultTableModel model = new DefaultTableModel();
        tablaPuntajes.setModel(model);
        model.addColumn("N°");
        model.addColumn("Participante");
        model.addColumn("Puntaje");
        model.addColumn("Premio");

        //anchos de las columnas
        int ancho[] = {50, 50, 100, 100};

        for (int i = 0; i <= ancho.length - 1; i++) {  //establece anchos a las columnas 
            tablaPuntajes.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
        }

        //conexion a bd y obtengo de los registros en la tabla puntajes
        try {

            ConectorDB con = new ConectorDB();
            Connection connection = con.conectar();
            PreparedStatement seleccion = connection.prepareStatement("SELECT * FROM  puntajes");
            ResultSet consulta = seleccion.executeQuery();
            //ResultSetMetaData data = consulta.getMetaData();

            while (consulta.next()) {
                Object[] registro = new Object[5];
                registro[0] = consulta.getInt("idPuntaje");
                registro[1] = consulta.getString("participante");
                registro[2] = consulta.getInt("puntaje");
                registro[3] = consulta.getInt("premio");

                model.addRow(registro);

            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new com.bardolog.cp.vista.componentes.PanelCustom();
        spTable = new javax.swing.JScrollPane();
        tablaPuntajes = new javax.swing.JTable();
        salirBtn = new com.bardolog.cp.vista.componentes.ButtonCustom();
        actualizarBtn = new com.bardolog.cp.vista.componentes.ButtonCustom();

        setBackground(new java.awt.Color(255, 255, 255));

        tablaPuntajes.setBackground(new java.awt.Color(255, 255, 255));
        tablaPuntajes.setFont(new java.awt.Font("Advent Pro", 0, 18)); // NOI18N
        tablaPuntajes.setForeground(new java.awt.Color(0, 0, 0));
        tablaPuntajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        spTable.setViewportView(tablaPuntajes);

        salirBtn.setText("Salir");
        salirBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirBtnMouseClicked(evt);
            }
        });

        actualizarBtn.setText("Actualizar");
        actualizarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addComponent(actualizarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addGap(83, 83, 83))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(spTable)
                .addGap(27, 27, 27)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salirBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirBtnMouseClicked
        this.evento.opcion("salir");
    }//GEN-LAST:event_salirBtnMouseClicked

    private void actualizarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarBtnMouseClicked

        listar();
    }//GEN-LAST:event_actualizarBtnMouseClicked

    public void enviarEvento(EventoClickeable eve) {
        this.evento = eve;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bardolog.cp.vista.componentes.ButtonCustom actualizarBtn;
    private com.bardolog.cp.vista.componentes.PanelCustom contenedor;
    private com.bardolog.cp.vista.componentes.ButtonCustom salirBtn;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JTable tablaPuntajes;
    // End of variables declaration//GEN-END:variables

}
