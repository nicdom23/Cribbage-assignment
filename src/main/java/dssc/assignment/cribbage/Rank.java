package dssc.assignment.cribbage;

public class Rank {
    public static String orderedRanks = "A234567890JQK";
    private char rankChar;
    private int rankInt;
    public Rank(char rankChar,int rankInt){
        this.rankChar = rankChar;
        this.rankInt = rankInt;
    }
    @Override
    public boolean equals(Object o){
        if(o==this) return true;
        if(!(o instanceof Rank)) return false;
        Rank rank = (Rank) o;

        return (Character.compare(this.getRankChar(),rank.getRankChar())==0)&&(this.getRankInt()==rank.getRankInt());
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = 31*result+ (int)this.getRankChar();
        result = 31*result+ this.getRankInt();
        return result;
    }
    public char getRankChar(){
        return rankChar;
    }
    public int getRankInt(){
        return rankInt;
    }
    public static int rankAsInt(char rankChar){
        if (rankChar == 'A')
            return 1;
        else if (rankChar == 'J' || rankChar == 'Q' || rankChar == 'K')
            return 10;
        else if (rankChar == '0')
            return 10;
        else return Integer.parseInt(String.valueOf(rankChar));}
}
