
/**
 * Does all the calculations
 * 
 * @author (Matekoa) 
 * @version (April 2020)
 */
import java.lang.Math;

public class Calculations
{
    
    private double pips, riskAmt, lotsize, baseUnit, balance, riskPercentage, riskPerLot;
    
    public Calculations()
    {
        pips = 0;
        riskAmt = 0;
        balance = 0;
        riskPercentage = 0;
        baseUnit = 100000;
        lotsize = 0;
        riskPercentage = 0;
        riskPerLot = 0;
    }
    
    //Risk To Reward
    
    //Pips Between Entry and Stop Level to determine number of pips
    public void setRiskPips(double entry, double exit)
    {
        pips = Math.abs(entry - exit);
    }
    
    public double getRiskPips()
    {
        return pips;
    }
    
    //Amount to risk in trade
    public void setRiskAmt(double riskPercentage, double balance){
        this.riskPercentage = riskPercentage;
        this.balance = balance;
        riskAmt = riskPercentage * balance;   
    }
    
    
    //Return Risk amount
    public double getRiskAmt(){
        return riskAmt;
    }
    
    
    //Risk for every lot traded
    public void setRiskPerLot(double riskpips){
        riskPerLot = baseUnit * riskpips;   
    }
    
    //Return Risk PerLot
    public double getRiskPerLot(){
        return riskPerLot;
    }
    
    
    //Calculate position of Lot Size
    public void setLotSize(double riskAmt, double riskPerLot ){
        
        this.riskAmt = riskAmt;
        this.riskPerLot = riskPerLot;
        
        lotsize = riskAmt/riskPerLot;
    }
    
    public double getLotSize(){
        return lotsize;
    }
    
}
