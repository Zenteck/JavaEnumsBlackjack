import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    public static void welcome(){
        System.out.println("Let's play Blackjack!");
    }

    public static int getNumPlayers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the number of players: ");
        return sc.nextInt();
    }

    public static String getPlayerName(){
        Scanner sc = new Scanner(System.in);
//        Scanner takes an input from the system, this is our .puts
        System.out.println("\n Please enter your name: ");
        String name = sc.nextLine();
        return name;
    }


    public static void dealCards(){
        System.out.println("\nPress Enter to deal the cards");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static void printCard(Card card, String name) {
        System.out.println(name + " has been dealt a " + card.getRank() + " of " + card.getSuit());
    }



    public static void startTurn(String name){
        System.out.println("\n" + name + " press Enter to start your turn");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static boolean twistStick(String name, int total){
        System.out.println(name + "! Your total is " + total + " Will you twist (press y) or stick (any other button)?");
        Scanner scan = new Scanner(System.in);
        String twist = "y";
//        String stick = "n";
        if (scan.next().equalsIgnoreCase(twist)){
            return true;
        }
        else {
            return false;
        }
    }

    public static void playerBust(String name, int total){
        System.out.println(name + " has gone bust with a total of " + total);
    }

    public static void declareBlackjack(String name) {
        System.out.println(name + " has blackjack!");
    }

    //dealer

    public static void printDealerCard(Card card){
        System.out.println("Dealer draws a " + card.getRank() + " of " + card.getSuit());
    }

    public static void repeatDealerCard(Card card){
        System.out.println("Dealer has a " + card.getRank() + " of " + card.getSuit());
    }

    public static void turnHoleCard(Card card){
        System.out.println("Dealer turns over a " + card.getRank() + " of " + card.getSuit());
    }

    public static void dealerSticks(int dealerTotal){
        System.out.println("Dealer sticks on " + dealerTotal);
    }

    public static void dealerBust(int dealerTotal){
        System.out.println("Dealer is bust with " + dealerTotal + "!");
    }


    public static void declareWinner(ArrayList<Player> players, boolean dealerWins) {
        if (dealerWins == true) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println(players.get(0).getName() + " wins");
        }
    }

    public static void displayDraw(ArrayList<Player> players){
        //for
    }



}
