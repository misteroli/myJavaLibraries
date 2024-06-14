package roundedButton;


import java.awt.Color;
import java.awt.GradientPaint;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;









public class ColorUtils
{
  private Map<Integer, GradientPaint> colorMap = new HashMap();
  
  private static ColorUtils colorUtils;
  
  private GradientPaint buttonColor;
  
  private GradientPaint gradientBtnColor;
  
  private GradientPaint glossyTopBtnColor;
  
  private GradientPaint glossyBtnColor;
  
  private GradientPaint[] glossyColors = new GradientPaint[2];
  
  public ColorUtils() {}
  
  public static ColorUtils getInStance()
  {
    if (colorUtils == null) {
      colorUtils = new ColorUtils();
    }
    return colorUtils;
  }
  






  public GradientPaint getStandardColor(int theme, int height, JButton button)
  {
    switch (theme) {
    //Normal Color - Green
    case 1: 
      buttonColor = new GradientPaint(0.0F, 0.0F, new Color(26,188,156), 0.0F, height, new Color(26,188,156));
      
      button.setForeground(Color.WHITE);
      break;
    case 2: 
      buttonColor = new GradientPaint(0.0F, 0.0F, new Color(22,160,133), 0.0F, height, new Color(22,160,133));
      
      button.setForeground(Color.WHITE);
      break;
    case 3: 
      buttonColor = new GradientPaint(0.0F, 0.0F, new Color(22,132,117), 0.0F, height, new Color(22,132,117));
      
      button.setForeground(Color.WHITE);
      break;
    //Warning Button - Red
    case 11: 
      buttonColor = new GradientPaint(0.0F, 0.0F, new Color(153,51,0), 0.0F, height, new Color(153,51,0));
      
      button.setForeground(Color.WHITE);
      break;
    case 12: 
      buttonColor = new GradientPaint(0.0F, 0.0F, new Color(153,27,4), 0.0F, height, new Color(153,27,4));
      
      button.setForeground(Color.WHITE);
      break;
    case 13: 
      buttonColor = new GradientPaint(0.0F, 0.0F, new Color(153,0,2), 0.0F, height, new Color(153,0,2));
      
      button.setForeground(Color.WHITE);
      break; 
    //Disabled Button - Gray
    case 21: 
      buttonColor = new GradientPaint(0.0F, 0.0F, new Color(153,153,153), 0.0F, height, new Color(153,153,153));
      
      button.setForeground(Color.WHITE);
      break;
    case 22: 
      buttonColor = new GradientPaint(0.0F, 0.0F, new Color(153,153,153), 0.0F, height, new Color(153,153,153));
      
      button.setForeground(Color.WHITE);
      break;
    case 23: 
      buttonColor = new GradientPaint(0.0F, 0.0F, new Color(153,153,153), 0.0F, height, new Color(153,153,153));
      
      button.setForeground(Color.WHITE);
      break; 
      
    default: 
      buttonColor = new GradientPaint(0.0F, 0.0F, new Color(26,188,156), 0.0F, height, new Color(26,188,156));
      button.setForeground(Color.WHITE);
    }
    
    

    return buttonColor;
  }
  
}
