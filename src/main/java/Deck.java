import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){

        this.cards = new ArrayList<>();
        for(Rank rank : Rank.values()){
            for(SuitType suit : SuitType.values()){
                cards.add(new Card(suit, rank));
            }
        }
    }

    public int cardCount() {
        return this.cards.size();
    }

    public void swapCard(Card cardA, Card cardB){
        Card tempCard = cardA;
        cardA = cardB;
        cardB = tempCard;
    }

    public void shuffleDeck(){
        Random rand = new Random();
        for (int i=0 ; i < this.cards.size(); i++){
            int number = rand.nextInt(52);
            Collections.swap(this.cards, i, number);
        }
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public Card dealCard() {
        return this.cards.remove(0);
    }
}
