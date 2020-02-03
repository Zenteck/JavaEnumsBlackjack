import java.util.ArrayList;

public class Game {

    private Deck deck;
    private Dealer dealer;
    private ArrayList<Player> players;
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
    }

    public void dealHoleCard(){
        Card holeCard = this.deck.dealCard();
        this.dealer.getHoleCard(holeCard);
    }

    public void playerTurns(){
        for(int i = 0; i < players.size(); i++){
            Player currentPlayer = this.players.get(i);
            UI.startTurn(currentPlayer.getName());
            boolean stillPlaying = true;
            while (stillPlaying == true){
                this.dealer.printDealerCard();
                currentPlayer.checkForAce();
            if (currentPlayer.twistStick()) {
                currentPlayer.addCard(this.deck.dealCard());
            } else {
                stillPlaying = false;
            }
            if (currentPlayer.checkBust()) {
                currentPlayer.playerBust();
                this.players.remove(currentPlayer);
                stillPlaying = false;
                }
            }
        }
    }

    public void dealerTurn(){
        dealer.printDealerCard();
        dealer.turnHoleCard();
        if (players.size() > 0) {
            dealer.checkForAce();
            int dealerTotal = dealer.getHandTotal();
            while (dealerTotal < 16) {
                dealer.checkForAce();
                dealer.addCard(this.deck.dealCard());
                dealerTotal = dealer.getHandTotal();
            }
            if (dealer.checkBust()) {
                dealer.dealerBust();
            } else {
                UI.dealerSticks(dealerTotal);
            }
        }
    }
    

    public void findWinners(){

        boolean dealerBust = dealer.checkBust();
        int dealerTotal = dealer.getHandTotal();

        if(dealerBust){
            for(int i = 0; i < players.size(); i++) {
                Player currentPlayer = this.players.get(i);
                UI.declareWinner(currentPlayer.getName(), currentPlayer.getHandTotal());
            }
        } else {
            for (int i = 0; i < players.size(); i++) {
                Player currentPlayer = this.players.get(i);
                if (currentPlayer.getHandTotal() > dealerTotal) {
                    UI.declareWinner(currentPlayer.getName(), currentPlayer.getHandTotal());
                } else {
                    if (currentPlayer.getHandTotal() == dealerTotal) {
                        UI.declareDraw(currentPlayer.getName(), currentPlayer.getHandTotal());
                    } else {
                        UI.declareLoss(currentPlayer.getName(), currentPlayer.getHandTotal());
                    }
                }
            }
        }
    }

    public void run(){

            dealCards();
            playerTurns();
            dealerTurn();
            findWinners();
        }


}
