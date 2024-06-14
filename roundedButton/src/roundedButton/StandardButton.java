package roundedButton;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ButtonModel;
import javax.swing.JButton;


public class StandardButton
  extends JButton
{
  private int buttonTheme = 1;
  private int selectedButtonTheme = 3;
  private int rolloverButtonTheme = 2;
  private String buttonType = "Rounded";
  private Color foregroundColor = Foreground.BLACK;
  
  public StandardButton()
  {
    setText("Button");
    setContentAreaFilled(false);
    setBorderPainted(false);
    setFont(new Font("Segoe UI", 0, 14));
    setFocusable(false);
    setPreferredSize(new Dimension(130, 35));
    foregroundColor = foregroundColor;
  }
  


  public StandardButton(String text)
  {
    setText(text);
    setContentAreaFilled(false);
    setBorderPainted(false);
    setFont(new Font("Segoe UI", 0, 14));
    setFocusable(false);
    setPreferredSize(new Dimension(130, 35));
  }
  
  public StandardButton(String text, Color color)
  {
    super(text);
    foregroundColor = foregroundColor;
    init();
  }
  

  public StandardButton(String text, int buttonTheme)
  {
    super(text);
    this.buttonTheme = buttonTheme;
    init();
  }
  
  public StandardButton(String text, int buttonTheme, String buttonType)
  {
    super(text);
    this.buttonTheme = buttonTheme;
    this.buttonType = buttonType;
    init();
  }
  

  public StandardButton(String text, String buttonType, int buttonTheme, int selectedButtonTheme)
  {
    super(text);
    this.buttonType = buttonType;
    this.buttonTheme = buttonTheme;
    init();
  }
  

  public StandardButton(String text, String buttonType, int buttonTheme, int selectedButtonTheme, int rolloverButtonTheme)
  {
    super(text);
    this.buttonType = buttonType;
    this.buttonTheme = buttonTheme;
    this.selectedButtonTheme = selectedButtonTheme;
    this.rolloverButtonTheme = rolloverButtonTheme;
    init();
  }
  
  private void init() {
    setFont(new Font("Thoma", 1, 12));
    setFocusable(false);
    setContentAreaFilled(false);
    setBorderPainted(false);
  }
  
  public void paintComponent(Graphics g)
  {
    Graphics2D g2d = (Graphics2D)g.create();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    
    int h = getHeight();
    int w = getWidth();
    Paint color = null;
    ButtonModel model = getModel();
    if (model.isRollover()) {
      color = ColorUtils.getInStance().getStandardColor(rolloverButtonTheme, 
        getHeight(), this);
    } else {
      color = ColorUtils.getInStance().getStandardColor(buttonTheme, 
        getHeight(), this);
    }
    
    if (model.isPressed()) {
      color = ColorUtils.getInStance().getStandardColor(selectedButtonTheme, 
        getHeight(), this);
    }
    drawShape(g2d, w, h, color);
    super.paintComponent(g);
  }
  


  private void drawShape(Graphics2D g2d, int w, int h, Paint color)
  {
    if (buttonType == "Rounded Rectangle") {
      RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0.0F, 0.0F, w - 1, h - 1, 8.0F, 8.0F);
      
      Shape clip = g2d.getClip();
      g2d.clip(r2d);
      g2d.setPaint(color);
      g2d.fillRoundRect(0, 0, w, h, 8, 8);
      g2d.setClip(clip);
      
      g2d.drawRoundRect(0, 0, w - 1, h - 1, 8, 8);
      
      g2d.drawRoundRect(1, 1, w - 3, h - 3, 8, 8);
    } else if (buttonType == "Rectangle") {
      Rectangle2D.Float r2d = new Rectangle2D.Float(0.0F, 0.0F, w - 1, h - 1);
      Shape clip = g2d.getClip();
      g2d.clip(r2d);
      g2d.setPaint(color);
      g2d.fillRect(0, 0, w, h);
      g2d.setClip(clip);
      g2d.setColor(new Color(100, 100, 100));
      g2d.drawRect(0, 0, w - 1, h - 1);
      g2d.setColor(new Color(255, 255, 255, 50));
      g2d.drawRect(1, 1, w - 3, h - 3);
    }
    else if (buttonType == "Rounded") {
      g2d.setPaint(color);
      g2d.fillRoundRect(1, 1, w - 2, h - 2, h - 5, h - 5);
      
      g2d.drawRoundRect(0, 0, w - 1, h - 1, h - 3, h - 3);
      
      g2d.drawRoundRect(1, 1, w - 3, h - 3, h - 3, h - 3);
    } else if (buttonType == "Oval") {
      g2d.setPaint(color);
      g2d.fillOval(1, 1, w - 20, h - 2);
      g2d.setPaint(new Color(100, 100, 100));
      g2d.drawOval(0, 0, w - 20, h - 1);
    } else if (buttonType == "Ellipse") {
      g2d.setPaint(color);
      Shape shape = new Ellipse2D.Double(1.0D, 1.0D, w - 2, h - 2);
      g2d.fill(shape);
      g2d.setPaint(new Color(100, 100, 100));
      shape = new Ellipse2D.Double(0.0D, 0.0D, w - 1, h - 1);
      g2d.draw(shape);
    } else if (buttonType == "Circle") {
      int size = Math.min(getWidth(), getHeight() - 2); 
      g2d.setPaint(color);
      g2d.fillOval(2, 2, size - 4, size - 4);
      g2d.setStroke(new BasicStroke(2.0F));
      g2d.setColor(new Color(100, 100, 100, 100));
      g2d.drawOval(2, 2, size - 4, size - 4);
    }
  }
  





  public int getButtonTheme()
  {
    return buttonTheme;
  }
  




  public void setButtonTheme(int buttonTheme)
  {
    this.buttonTheme = buttonTheme;
  }
  




  public int getSelectButtonTheme()
  {
    return selectedButtonTheme;
  }
  




  public void setSelectButtonTheme(int selectButtonTheme)
  {
    selectedButtonTheme = selectButtonTheme;
  }
  




  public int getRolloverButtonTheme()
  {
    return rolloverButtonTheme;
  }
  




  public void setRolloverButtonTheme(int rolloverButtonTheme)
  {
    this.rolloverButtonTheme = rolloverButtonTheme;
  }
  




  public String getButtonType()
  {
    return buttonType;
  }
  




  public void setButtonType(String buttonType)
  {
    this.buttonType = buttonType;
  }
  





  public void setForegroundColor(Color foregroundColor)
  {
    this.foregroundColor = foregroundColor;
  }
  





  public Color getForegroundColor()
  {
    return foregroundColor;
  }
}
