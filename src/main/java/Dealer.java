import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> hand;
    private Card holeCard;

    public Dealer() {
        hand = new ArrayList<>();

    }
    public void addCard(Card card){
        hand.add(card);
        UI.printDealerCard(card);
    }

    public void printDealerCard(){
        UI.repeatDealerCard(this.hand.get(0));
    }

    public int getHandTotal(){
        int total = 0;

        for(Card card : this.hand){
            total += card.getRank().getValue();
        }

        return total;
    }

    public void getHoleCard(Card card){
        this.holeCard = card;
    }

    public void turnHoleCard(){
        this.hand.add(holeCard);
        UI.turnHoleCard(holeCard);
    }

    public boolean checkBust(){
        return (this.getHandTotal() > 21);
    }

    public void dealerBust() {
        UI.dealerBust(this.getHandTotal());
        this.hand.clear();
    }
}



