
/**
 * 
 * 
 * @author (Matekoa) 
 * @version (April 2020)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class RiskCalculator extends JPanel
{
    private static double b= 0;//balance
    private static double t= 0;//risk percentage
    private static double riskAmt= 0;//Risk Amount
    private static double pips= 0;//stop loss in pips
    private static double lotsize = 0;//lot size
    private static double entry = 0;//entry
    private static double sl = 0;//stop loss
    
    private Calculations calc;

    private JLabel currency, bal, tol, risk, entryLbl, stop, lots;
    private JTextField entBal, entTol, entStop, entryPrice;//ent stands for entry
    private JLabel disRisk,  disLotSize;//dis stands for display
    public RiskCalculator()
    {
        setPreferredSize(new Dimension(300, 320));
        setLayout(new GridLayout(6, 2));
        
        calc = new Calculations();

        bal = new JLabel("Balance: ");
        bal.setFont(new Font("Courier", Font.PLAIN, 20));
        
        tol = new JLabel("Risk %: ");
        tol.setFont(new Font("Courier", Font.PLAIN, 14));
        
        risk = new JLabel("Risk Amount: ");
        risk.setFont(new Font("Courier", Font.PLAIN, 19));
        
        entryLbl = new JLabel("Entry Price: ");
        entryLbl.setFont(new Font("Courier", Font.PLAIN, 13));
        
        stop = new JLabel("SL Price: ");
        stop.setFont(new Font("Courier", Font.PLAIN, 13));
        
        lots = new JLabel("Lot Size: ");
        lots.setFont(new Font("Courier", Font.PLAIN, 17));

        entBal = new JTextField(15);
        entBal.setFont(new Font("Courier", Font.PLAIN, 20));
        
        entTol = new JTextField(15);
        entTol.setFont(new Font("Courier", Font.PLAIN, 20));
        entTol.addActionListener(new RiskCalc());
        
        entryPrice = new JTextField(15);
        entryPrice.setFont(new Font("Courier", Font.PLAIN, 20));
        entryPrice.setText("");
        
        entStop = new JTextField(15);
        entStop.setFont(new Font("Courier", Font.PLAIN, 20));
        entStop.setText("");
        entStop.addActionListener(new LotSizeCalc());

        disRisk = new JLabel("--" );
        disLotSize = new JLabel("--");
        add(bal);
        add(entBal);
        add(tol);
        add(entTol);
        add(risk);
        add(disRisk);
        add(entryLbl);
        add(entryPrice);
        add(stop);
        add(entStop);
        add(lots);
        add(disLotSize);
    }

    public void getBalandTol()
    {
        try
        {
            b = Double.parseDouble(entBal.getText());
            t = Double.parseDouble(entTol.getText())/100;
        }catch(Exception e){}

    }
    
    
     public void getEntryandStop()
    {
        try
        {
            entry = Double.parseDouble(entryPrice.getText());
            sl = Double.parseDouble(entStop.getText());
        }catch(Exception e){}

    }

    private class RiskCalc implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            DecimalFormat df = new DecimalFormat("#.##");
            getBalandTol();
            
            //Sets The Risk Per Trade
            calc.setRiskAmt(t, b);
            
            //Risk Per Trade;
            riskAmt = calc.getRiskAmt();
            
            disRisk.setText("  "+ df.format(riskAmt) + "  ");
        }
    }
        
        
         private class LotSizeCalc implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            DecimalFormat df = new DecimalFormat("#.##");
            getEntryandStop();
            
            //Pips Between Entry and Stop Loss Level
            calc.setRiskPips(sl,entry);
            
            //Set Risk Per Lot
            calc.setRiskPerLot(calc.getRiskPips());
            
            //Calculate Position Size
            calc.setLotSize(riskAmt, calc.getRiskPerLot());
            lotsize = calc.getLotSize();
            disLotSize.setText("  "+ df.format(lotsize) + "  ");
        }

    }


}
