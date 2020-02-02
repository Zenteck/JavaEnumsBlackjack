import java.util.ArrayList;

public class Game {

    private Deck deck;
    private Dealer dealer;
    private ArrayList<Player> players;
    private boolean isRunning;
    private int numPlayers;
    public boolean dealerWins;

    public Game(){

        UI.welcome();

        this.numPlayers = UI.getNumPlayers();
        this.players = new ArrayList<>();

        //Creating players
        for(int i = 0; i < numPlayers; i++){
            players.add(new Player(UI.getPlayerName()));
        }

        dealer = new Dealer();
        dealerWins = false;
        deck = new Deck();
        deck.shuffleDeck();
        this.isRunning = true;
    }

    public void dealCards(){

        for(int i = 0; i < players.size(); i++){
            UI.dealCard();
            Card dealtCard = this.deck.dealCard();
            this.players.get(i).addCard(dealtCard);
            UI.printCard(dealtCard, this.players.get(i).getName());
            this.dealersCards();
        }
    }

    public void dealersCards(){
        Card firstCard = this.deck.dealCard();
        this.dealer.addCard(firstCard);
        Card holeCard = this.deck.dealCard();
        this.dealer.getHoleCard(holeCard);
        UI.printDealerCard(firstCard);
    }


    public int calculateHighestHand(){

        int highestHand = 0;

        for (Player player: this.players){
            if(player.getHandTotal() > highestHand){
                highestHand = player.getHandTotal();
            }
        }
        if(dealer.getHandTotal() > highestHand){
            highestHand = dealer.getHandTotal();
            this.dealerWins = true;
        }
        return highestHand;
    }

    public void findWinners(){

        ArrayList<Player> winningPlayers = new ArrayList<Player>();

        int winningHand = calculateHighestHand();

        for (Player player: this.players){
            if(player.getHandTotal() == winningHand){
                winningPlayers.add(player);
            }
        }

        if(winningPlayers.size() > 1){
            UI.displayDraw(winningPlayers);
        }else{
            UI.declareWinner(winningPlayers, this.dealerWins);
        }

    }

    public void run(){

        while(this.isRunning){

            dealCards();
            findWinners();

        }
    }
}
