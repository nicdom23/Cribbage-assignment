package dssc.assignment.cribbage;


public class Card extends Object{
    private char rank;
    private int rankAsInt;
    private Suite suite;
    public static String orderedRanks = "A234567890JQK";
    @Override
    public boolean equals(Object o){
        if(o==this) return true;
        if(!(o instanceof Card)) return false;
        Card card = (Card) o;
        return (Character.compare(this.getRank(),card.getRank()) == 0)&&(this.getRankInt()==card.getRankInt())&&(this.suite==card.suite);
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = 31*result+ (int)this.getRank();
        result = 31*result+ this.getRankInt();
        result = 31*result+ this.getSuite().hashCode();
        return result;
    }

    public Card(char rank,int rankAsInt,Suite suite){
        this.rank = rank;
        this.rankAsInt = rankAsInt;
        this.suite = suite;
    }
    public char getRank() {
        return rank;
    }
    public int getRankInt() {
        return rankAsInt;
    }
    public Suite getSuite() {

        return suite;
    }

    public static Card parseCard(String cardAsText) {
        char rank = cardAsText.charAt(0);
        char suiteAsChar = cardAsText.charAt(1);
        for (Suite refSuite : Suite.values()){
            if(refSuite.asChar() == suiteAsChar)
                return new Card(rank,rankAsInt(rank),refSuite);
        }
        return new Card(cardAsText.charAt(0),-1,Suite.INVALID);
    }
    public static int rankAsInt(char rank){
    if (rank == 'A')
            return 1;
        else if (rank == 'J' || rank == 'Q' || rank == 'K')
            return 10;
        else if (rank == '0')
            return 10;
        else return Integer.parseInt(String.valueOf(rank));}
}

