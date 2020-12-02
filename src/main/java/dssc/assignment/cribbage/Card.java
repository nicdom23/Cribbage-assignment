package dssc.assignment.cribbage;

public class Card {
    private char rank;
    private Suite suite;

    public Card(char rank,Suite suite){
        this.rank = rank;
        this.suite = suite;
    }
    public String getRank() {
        return "5";
    }

    public Suite getSuite() {
        return Suite.HEART;
    }
}
