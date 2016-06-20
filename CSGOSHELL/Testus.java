public class Testus
{
    SPIEL[] gameList;
    int amountShells;
    int AnzahlSpieler;
    double houseEdge;
    int amountBalls;
    /**
     * Default constructor for test class Testus
     */
    public Testus(int AnzahlSpieler, double houseEdge, int amountShells, int amountBalls)
    {
        gameList= new SPIEL[AnzahlSpieler];
        for(int i=0; i<AnzahlSpieler; i++){
            gameList[i]=new SPIEL(houseEdge, amountShells, amountBalls, 14);
        }
        this.amountShells=amountShells;
        this.AnzahlSpieler=AnzahlSpieler;
        this.houseEdge=houseEdge;
        this.amountBalls=amountBalls;
    }

    
    public double winTest(int anzahl, int maxBet){
         for(int i=0; i<AnzahlSpieler; i++){
            gameList[i]=new SPIEL(houseEdge, amountShells, amountBalls, 14);
        }
        double winAmount=0;
        for(int r=0; r<anzahl; r++){
            for(int e=0; e<gameList.length; e++){
                gameList[e].placeBet((double) ((Math.random()*maxBet)+0.01), (int) ((Math.random()*amountShells)+1));
            }
        }
        for(int e=0; e<gameList.length; e++){
                winAmount=winAmount + gameList[e].moneyBank;
            }
            return winAmount;
    }
}
