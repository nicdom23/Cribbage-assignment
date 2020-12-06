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
    public int getRankInt() {

        if (rank == 'A')
            return 1;
        else if (rank == 'J' || rank == 'Q' || rank == 'K')
            return 10;
        else if (rank == '0')
            return 10;
        else return Integer.parseInt(String.valueOf(rank));
    }
    public Suite getSuite() {

        return suite;
    }
}
