import java.util.ArrayList;

public class Game {

    private Deck deck;
    private Dealer dealer;
    private ArrayList<Player> players;
    private boolean isRunning;
    private int numPlayers;
    private boolean dealerWins;

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
        UI.dealCards();
        for(int i = 0; i < players.size(); i++){
            Card dealtCard = this.deck.dealCard();
            this.players.get(i).addCard(dealtCard);
        }
        this.dealersCard();
        for(int i = 0; i < players.size(); i++){
            Card dealtCard = this.deck.dealCard();
            this.players.get(i).addCard(dealtCard);
        }
        this.dealHoleCard();
    }

    public void dealersCard(){
        Card card = this.deck.dealCard();
        this.dealer.addCard(card);
        UI.printDealerCard(card);
    }

    public void dealHoleCard(){
        Card holeCard = this.deck.dealCard();
        this.dealer.getHoleCard(holeCard);
    }

    public void playerTurn(){
        for(int i = 0; i < players.size(); i++){
            Player currentPlayer = this.players.get(i);
            UI.startTurn(currentPlayer.getName());
            boolean stillPlaying = true;
            while (stillPlaying == true){
            if (currentPlayer.twistStick()) {
                currentPlayer.addCard(this.deck.dealCard());
                if (currentPlayer.checkBust()){
                    currentPlayer.playerBust();
                    stillPlaying = false;
                }
                }
            else {
               stillPlaying = false;
                }
            }
        }
//        this.dealer.dealerTurn();
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
        } else {
            UI.declareWinner(winningPlayers, this.dealerWins);
        }

    }

    public void run(){

//        while(this.isRunning){

            dealCards();
            playerTurn();
            findWinners();
//        }

    }
}
