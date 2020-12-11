package dssc.assignment.cribbage;


public class Card{

    private Rank rank;
    private Suite suite;

    @Override
    public boolean equals(Object o){
        if(o==this) return true;
        if(!(o instanceof Card)) return false;
        Card card = (Card) o;
        return (this.getRank().equals(card.getRank()))&&(this.getSuite()==card.getSuite());
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = 31*result+ this.getRank().hashCode();
        result = 31*result+ this.getSuite().hashCode();
        return result;
    }

    public Card(Rank rank,Suite suite){
        this.rank = rank;
        this.suite = suite;
    }
    public Rank getRank() {

        return rank;

    }
    public int getRankInt() {
        return rank.getRankInt();
    }
    public Suite getSuite() {
        return suite;
    }



}

