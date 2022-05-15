package com.bardolog.cp.vista.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

public class BorderLineaRedondeada extends AbstractBorder {

    // variables
    private Color colorLinea = null;
    private boolean esquinasRedondeadas;
    private RenderingHints antiliasing;

    public BorderLineaRedondeada(Color lineColor, boolean roundedCorners) {

        this.esquinasRedondeadas = false;
        this.antiliasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.colorLinea = lineColor;
        this.esquinasRedondeadas = roundedCorners;
    }

    // pinto borde personalizado
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

        Graphics2D lapiz2D = (Graphics2D) g;

        if (this.esquinasRedondeadas) {

            int i = 1;
            int j = i + i;
            float f = 0.2F * i;

            lapiz2D.setColor(this.colorLinea);

            Shape shape1 = new RoundRectangle2D.Float((x + 1), (y + 1), (width - 2), (height - 2), (i * 30), (i * height));
            Shape shape2 = new RoundRectangle2D.Float((x + i - 2), (y + i - 2), (width - j + 4), (height - j + 4), f, f);

            Path2D puntero = new Path2D.Float(0);

            lapiz2D.addRenderingHints(this.antiliasing);
            puntero.append(shape1, false);
            puntero.append(shape2, false);

            lapiz2D.fill(puntero);

        }

        Color anterioColor = c.getParent().getBackground();

        lapiz2D.setColor(anterioColor);

        int offs = 1;
        int size = offs + offs;
        float arc = 0.2F * offs;

        Shape outer = new RoundRectangle2D.Float(x, y, width, height, (offs * 30), (offs * height));
        Shape inner = new RoundRectangle2D.Float((x + offs - 2), (y + offs - 2), (width - size + 4), (height - size + 4), arc, arc);

        Path2D puntero2 = new Path2D.Float(0);

        lapiz2D.addRenderingHints(this.antiliasing);
        puntero2.append(outer, false);
        puntero2.append(inner, false);

        lapiz2D.fill(puntero2);
    }
}
