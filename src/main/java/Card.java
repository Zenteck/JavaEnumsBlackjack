public class Card {

    private SuitType suit;
    private Rank rank;

    public Card(SuitType suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public SuitType getSuit(){
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public int getValueFromEnum() {
        return this.rank.getValue();
    }
}
