import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    private Deck deck;

    Card card1;
    Card card2;


    @Before
    public void before(){
        deck = new Deck();
        card1 = new Card(SuitType.HEARTS, Rank.QUEEN);
        card2 = new Card(SuitType.DIAMONDS, Rank.KING);
    }

    @Test
    public void deckHas52Cards(){
        assertEquals(52, deck.cardCount());
    }

    @Test
    public void deckIsShuffled(){
        deck.shuffleDeck();
        for (Card card : deck.getCards()){
            System.out.println(card.getRank());
            System.out.println(card.getSuit());
            System.out.println("\n");
        }
    }

    @Test
    public void canDealCardFromDeck(){
        deck.dealCard();
        deck.dealCard();
        deck.dealCard();
        assertEquals(49, deck.cardCount());
    }





}
