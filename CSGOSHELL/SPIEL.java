
/**
 * Write a description of class SPIEL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SPIEL
{
    double houseEdge;
    int amountShells;
    int amountBalls;
    double multiShell;
    double multiBlack;
    double probabilityBlack;
    
    double moneyBank=0;
    
    /**
     * Profit: Affects the House Edge, Enter a value <1
     * 
     */
    public SPIEL(double profit, int amountShells, int amountBalls, double multiBlack)
    {
      this.houseEdge=1-profit;
      this.amountShells=amountShells;
      this.amountBalls=amountBalls;
      this.multiShell=houseEdge/((double)amountBalls/(double)amountShells);
      this.multiBlack=multiBlack;
      this.probabilityBlack=(double)houseEdge/(double)multiBlack;
    }
    public void showSettings(){
        System.out.println("");
        System.out.println("House Edge: "+ houseEdge);
        System.out.println("Shell Amount: "+ amountShells);
        System.out.println("Ball Amount: " + amountBalls);
        System.out.println("Shell Multiplicator: "+ multiShell);
        System.out.println("Black Multiplicator: "+ multiBlack);
        System.out.println("Black Probability: "+ probabilityBlack);
    }
    
    public void playerEditSettings(int newAmountBalls, int newAmountShells){
        System.out.println("");
        amountBalls=newAmountBalls;
        System.out.println("The new Amount of Balls is: "+ amountBalls);
        amountShells=newAmountShells;
        System.out.println("The new Amount of Shells is: "+ amountShells);
    }
    
    public double placeBet(double betAmount, int betPosition){
        double payback=0;
        boolean win=false;
        int[] winPositions=placeRandomBalls();
        for(int k=0; k<winPositions.length; k++){
                if(betPosition ==winPositions[k])
                {win=true;}
        }
        if(win==true){
            payback=betAmount*(double)multiShell;
            moneyBank=moneyBank-(double)(betAmount*multiShell);
        }
        else{
            moneyBank=moneyBank+(double)betAmount;
        }
        System.out.println("");
        System.out.println("The Balls were on ");
        for(int s=0; s<winPositions.length; s++){
            System.out.print(winPositions[s]+ ", ");
        }
        System.out.println("Your Bet: "+betPosition);
        System.out.println("Your Payback: "+payback);
        return payback;
    }
    
    public int[] placeRandomBalls(){
        int[] positions= new int[amountBalls];
        for(int i=0; i<amountBalls; i++){
            int rand=(int)((Math.random()*amountShells)+1);
            boolean fit =false;
            while(fit==false){
                rand=(int)((Math.random()*amountShells)+1);
                fit=true;
                for(int l=0; l<positions.length; l++){
                    if(positions[l]==rand)
                    {fit=false;}
                }
                
            }
            positions[i]=rand;
        }
        return positions;
        
    }
}
