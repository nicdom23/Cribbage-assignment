package dssc.assignment.cribbage;

public class CardParser {
    public static Card parseCard(String cardAsText) {
        for (Suite refSuite : Suite.values()){
            if(Character.compare(refSuite.toString().charAt(0),cardAsText.charAt(1))==0)
                return new Card(cardAsText.charAt(0),refSuite);
        }
        return new Card(cardAsText.charAt(0),Suite.INVALID);
    }
}
