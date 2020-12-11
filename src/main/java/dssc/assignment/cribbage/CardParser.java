package dssc.assignment.cribbage;

public class CardParser {

    public static Card parseCard(String cardAsText) {
        Rank invalid;
        Rank rank;
        char rankAsChar = cardAsText.charAt(0);
        char suiteAsChar = cardAsText.charAt(1);
        rank = new Rank(rankAsChar,Rank.rankAsInt(rankAsChar));
        for (Suite refSuite : Suite.values()){
            if(refSuite.asChar() == suiteAsChar)
                return new Card(rank,refSuite);
        }
        invalid = new Rank('t',-1);
        return new Card(invalid,Suite.INVALID);
    }
}
