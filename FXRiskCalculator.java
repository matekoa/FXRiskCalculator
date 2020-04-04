
/**
 * A simple risk tolerance Calculator for Forex Traders
 * 
 * @author (Matekoa) 
 * @version (April 2020)
 */

import javax.swing.JFrame;

public class FXRiskCalculator
{
   public static void main (String [] args)
   {
       JFrame frame = new JFrame("Calculate Position Size");
       RiskCalculator panel = new RiskCalculator();
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(panel);
       frame.pack();
       frame.setVisible(true);
       frame.setResizable(false);
    }
}
