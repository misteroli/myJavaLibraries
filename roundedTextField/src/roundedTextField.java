/*
Copyright 2017 Technoberians

This file is part of Technoberians - Airline System.

Airline System is a capstone project of BSIT Decemberian Batch 2017.
 */
package Classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;


public class roundedTextField extends JTextField
{
    public roundedTextField()
    {
        setText("Airline Textfield");
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setPreferredSize(new Dimension(130, 35));
    }
        
    @Override 
    protected void paintComponent(Graphics g) 
    {
        if (!isOpaque()) 
        {
            int w = getWidth() - 1;
            int h = getHeight() - 1;
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(UIManager.getColor("TextField.background"));
            g2.fillRoundRect(0, 0, w, h, h, h);
            g2.setPaint(Color.GRAY);
            g2.drawRoundRect(0, 0, w, h, h, h);
            g2.dispose();
        }
        super.paintComponent(g);
    }
    @Override 
    public void updateUI() 
    {
        super.updateUI();
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
    }
    
    
}

class RoundedCornerBorder extends AbstractBorder {
    private static final Color ALPHA_ZERO = new Color(0x0, true);
    @Override public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape border = getBorderShape(x, y, width - 1, height - 1);

//         Container parent = c.getParent();
//         if (Objects.nonNull(parent)) {
//             //g2.setPaint(parent.getBackground());
//             g2.setPaint(new Color(0x0, true));
//             Area corner = new Area(new Rectangle2D.Double(x, y, width, height));
//             corner.subtract(new Area(border));
//             g2.fill(corner);
//         }

        g2.setPaint(ALPHA_ZERO);
        //Area corner = new Area(border.getBounds2D());
        Area corner = new Area(new Rectangle2D.Double(x, y, width, height));
        corner.subtract(new Area(border));
        g2.fill(corner);

        g2.setPaint(Color.GRAY);
        g2.draw(border);
        g2.dispose();
    }
    public Shape getBorderShape(int x, int y, int w, int h) {
        int r = h; //h / 2;
        return new RoundRectangle2D.Double(x, y, w, h, r, r);
    }
    @Override public Insets getBorderInsets(Component c) {
        return new Insets(4, 8, 4, 8);
    }
    @Override public Insets getBorderInsets(Component c, Insets insets) {
        insets.set(4, 8, 4, 8);
        return insets;
    }
}
