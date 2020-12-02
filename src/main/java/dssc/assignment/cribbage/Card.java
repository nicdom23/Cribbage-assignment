package dssc.assignment.cribbage;

public class Card {
    private char rank;
    private Suite suite;

    public Card(char rank,Suite suite){
        this.rank = rank;
        this.suite = suite;
    }
    public char getRank() {
        return rank;
    }

    public Suite getSuite() {
        return suite;
    }
}
