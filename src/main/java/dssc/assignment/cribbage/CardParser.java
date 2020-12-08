package dssc.assignment.cribbage;

public class CardParser {
    public static Card parseCard(String cardAsText) {
        for (Suite refSuite : Suite.values()){
            if(refSuite.asChar() == cardAsText.charAt(1))
                return new Card(cardAsText.charAt(0),refSuite);
        }
        return new Card(cardAsText.charAt(0),Suite.INVALID);
    }
}
