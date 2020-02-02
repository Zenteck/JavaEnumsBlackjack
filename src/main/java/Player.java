import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;
    private String name;

    public Player(String name){

        hand = new ArrayList<>();
        this.name = name;
    }

    public void addCard(Card card){
        hand.add(card);
    }

    public String getName() {
        return this.name;
    }

    public int getHandTotal(){
        int total = 0;

        for(Card card : this.hand){
            total += card.getRank().getValue();
        }

        return total;
    }
}
