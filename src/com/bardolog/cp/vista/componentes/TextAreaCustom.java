package com.bardolog.cp.vista.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JTextArea;


public class TextAreaCustom extends JTextArea {

    
    //variables
    private final Dimension d;
    private final BorderLineaRedondeada border;
    private String hint = "   Texto por defecto..";

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    
    public TextAreaCustom() {

        this.d = new Dimension(100, 28);
        this.border = new BorderLineaRedondeada(new Color(98, 84, 184), false);

        this.setOpaque(true);
        this.setBorder(this.border);
        this.setSize(this.d);
        this.setPreferredSize(this.d);
        this.setFont(new Font("Advent pro", Font.PLAIN, 14));

    }

    
    //override para repintar el componente
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (getText().isBlank()) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            int c0 = getBackground().getRGB();
            int c1 = getForeground().getRGB();
            int m = 0xfefefefe;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g.setColor(new Color(c2, true));
            g.drawString(hint, ins.left + 1, h / 2 + fm.getAscent() / 2 - 2);
        }
    }

}
