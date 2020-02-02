import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> hand;
    private Card holeCard;

    public Dealer() {
        hand = new ArrayList<>();

    }
    public void addCard(Card card){
        hand.add(card);
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


}



