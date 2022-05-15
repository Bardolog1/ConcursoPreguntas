package com.bardolog.cp.vista.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class TextFieldCustom extends JTextField {

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

    public TextFieldCustom() {

        this.d = new Dimension(250, 28);
        this.border = new BorderLineaRedondeada(new Color(98, 84, 184), true);

        this.setOpaque(true);
        this.setBorder(this.border);
        this.setSize(this.d);
        this.setPreferredSize(this.d);
        this.setHorizontalAlignment(0);
        this.setFont(new Font("Advent pro", Font.PLAIN, 14));

        addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                TextFieldCustom.this.txtFocusGained(e);
            }

            public void focusLost(FocusEvent e) {
                TextFieldCustom.this.txtFocusLost(e);
            }
        });

    }

    private void txtFocusGained(FocusEvent evt) {
        setBorder(new BorderLineaRedondeada(Color.lightGray, true));
    }

    private void txtFocusLost(FocusEvent evt) {
        setBorder(this.border);

    }

    //repinto el componentes
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (getText().length() == 0) {
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
