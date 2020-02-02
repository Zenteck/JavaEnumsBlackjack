import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;
    private String name;
    private int aceHigh;

    public Player(String name){

        hand = new ArrayList<>();
        this.name = name;
        this.aceHigh = 0;
    }

    public void addCard(Card card){
        hand.add(card);
        UI.printCard(card, this.name);
    }

    public String getName() {
        return this.name;
    }

    public int getHandTotal(){
        int total = 0;
        for(Card card : this.hand){
            total += card.getValueFromEnum();
        }
        total += aceHigh;
        return total;
    }

    public boolean twistStick(){
        return UI.twistStick(this.name, this.getHandTotal());
    }

    public boolean checkBust(){
        return (this.getHandTotal() > 21);
    }

    public void playerBust(){
        UI.playerBust(this.name, this.getHandTotal());
    }

    public void checkForAce() {
        if (aceHigh == 0) {
            for (Card card : this.hand) {
                if (card.getRank() == Rank.ACE) {
                    if (UI.changeAce(this.name, this.getHandTotal())) {
                        this.aceHigh += 10;
                    }
                }
            }
        }
    }

}
