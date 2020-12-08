package dssc.assignment.cribbage;

public class Card extends Object{
    private char rank;
    private Suite suite;

    @Override
    public boolean equals(Object o){
        if(o==this) return true;
        if(!(o instanceof Card)) return false;
        Card card = (Card) o;
        return (Character.compare(this.getRank(),card.getRank()) == 0)&&(this.suite==card.suite);
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = 31*result+ (int)this.getRank();
        result = 31*result+ this.getSuite().hashCode();
        return result;
    }

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
