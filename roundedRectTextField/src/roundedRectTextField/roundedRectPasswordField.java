package roundedRectTextField;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import static roundedRectTextField.roundedColor.L_BLUE;

public class roundedRectPasswordField
        extends JPasswordField {

    public Color textfieldColor = L_BLUE;
    
    public roundedRectPasswordField() {
        setText("Password");
        setFont(new Font("Segoe UI", 0, 14));
        setPreferredSize(new Dimension(130, 35));
    }
    
    public roundedRectPasswordField(Color color)
    {
        setText("Password");
        setFont(new Font("Segoe UI", 0, 14));
        setPreferredSize(new Dimension(130, 35));
        this.textfieldColor = textfieldColor;
    }

    protected void paintComponent(Graphics g) {
        if (!isOpaque()) {
            int w = getWidth() - 1;
            int h = getHeight() - 1;
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(UIManager.getColor("TextField.background"));
            RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0, w - 1, h - 1, 8, 8);
            Shape clip = g2.getClip();
            g2.clip(r2d);
            //g2.setPaint(color);
            g2.fillRoundRect(0, 0, w, h, 8, 8);
            g2.setClip(clip);
            //g2.setColor(new Color(51,51,51));
            //g2.drawRoundRect(0, 0, w - 1, h - 1, 8, 8);
            g2.setColor(textfieldColor);
            //g2.drawRoundRect(1, 1, w - 3, h - 3, 8, 8);
            g2.drawRoundRect(0,0,w-1,h-1,8,8);
            
            //g2.fillRoundRect(0, 0, w, h, h, h);
            //g2.setPaint(Color.GRAY);
            //g2.drawRoundRect(0, 0, w, h, h, h);
            g2.dispose();
        }
        super.paintComponent(g);
    }

    public void updateUI() {
        super.updateUI();
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
    }
    
    public void setColor(Color textfieldColor)
    {
        this.textfieldColor = textfieldColor;
    }
    
    public Color getColor()
    {
        return textfieldColor;
    }
}
