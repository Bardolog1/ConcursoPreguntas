package com.bardolog.cp.vista.componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import com.bardolog.cp.controlador.interfaces.EventoClickeable;

public class ButtonCustom extends JButton implements MouseListener {

    //Variables
    private static final long serialVersionUID = 1L;
    private boolean over = false;
    private boolean presionado = false;
    private String nombreEvento = "vacio";
    private EventoClickeable evento;

    public ButtonCustom() {
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        this.setFont(new Font("Advent Pro", Font.PLAIN, 16));
        this.setBackground(new Color(49, 100, 121));
        this.setForeground(new Color(249, 249, 249));
        this.setPreferredSize(new Dimension(200, 40));
        this.setSize(200, 40);
        this.setCursor(new Cursor(12));
        this.setText("Button Custom");
        addMouseListener(this);
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    public boolean isPresionado() {
        return presionado;
    }

    public void setPresionado(boolean presionado) {
        this.presionado = presionado;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        over = true;
        presionado = false;
        repaint();
    }

    // re pinto el componente con un estilo propio
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D lapizsD = (Graphics2D) g;
        lapizsD.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint grad = new GradientPaint(0, 0, new Color(40, 22, 84), getWidth(), getHeight(), new Color(81, 64, 175));
        lapizsD.setPaint(grad);
        lapizsD.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

        if (over || presionado || !isEnabled()) {
            lapizsD.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            lapizsD.setColor(new Color(255, 255, 255, 20));
            lapizsD.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            if (presionado) {
                lapizsD.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                lapizsD.setColor(new Color(255, 255, 255, 80));
                lapizsD.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            }
            if (!isEnabled()) {
                lapizsD.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                lapizsD.setColor(new Color(0, 0, 0, 150));
                lapizsD.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            }
        } else {
            lapizsD.setColor(getBackground());
        }

        super.paintComponent(g);
    }

    // hago override de los metodos de evento de mouse
    @Override
    public void mouseClicked(MouseEvent e) {

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        over = true;
        presionado = true;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        over = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        over = false;
        repaint();
    }

}
