package com.bardolog.cp.vista.subPanel;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PanelHome extends javax.swing.JPanel {

    public PanelHome(int wiInt, int heInt) {

        initComponents();
        setSize(wiInt, heInt);
        ImageIcon wallpaper = new ImageIcon("src/com/bardolog/cp/vista/imagenesiconos/wallpaper.jpg");  // imagen de fondo
        wallpaperLabel.setSize(this.getWidth(), this.getHeight());
        //redimensionos
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(wallpaperLabel.getWidth(), wallpaperLabel.getHeight(), Image.SCALE_DEFAULT));
        wallpaperLabel.setIcon(icon);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wallpaperLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(949, 541));
        setLayout(new java.awt.BorderLayout());

        wallpaperLabel.setMaximumSize(new java.awt.Dimension(949, 541));
        wallpaperLabel.setMinimumSize(new java.awt.Dimension(949, 541));
        wallpaperLabel.setPreferredSize(new java.awt.Dimension(949, 541));
        add(wallpaperLabel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel wallpaperLabel;
    // End of variables declaration//GEN-END:variables
}
