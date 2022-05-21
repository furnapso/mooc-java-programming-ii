import java.util.*;
import java.util.stream.*;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        for (Card card: this.cards) {
            System.out.println(card);
        }
    }
    
    public void sort() {
        this.cards = this.cards.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    
    public int getHandValue() {
        int total = 0;
        for (Card i: this.cards) {
            total += i.getValue();
        }
        
        return total;
    }
    
    public int compareTo(Hand hand) {
        return this.getHandValue() - hand.getHandValue();
    }
    
    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());
    }
}
