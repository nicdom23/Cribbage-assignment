package dssc.assignment.cribbage;

public class HandParser {
    public static Hand parseHand(String handAsText) {
            Card card1 = CardParser.parseCard(handAsText.substring(0,2));
            Card card2 = CardParser.parseCard(handAsText.substring(2,4));
            Card card3 = CardParser.parseCard(handAsText.substring(4,6));
            Card card4 = CardParser.parseCard(handAsText.substring(6,8));
            Card starter = CardParser.parseCard(handAsText.substring(8,10));

        return new Hand(card1,card2,card3,card4,starter);
    }
}
