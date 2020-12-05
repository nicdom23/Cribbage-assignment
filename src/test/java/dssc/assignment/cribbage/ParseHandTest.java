package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParseHandTest {

    @Test
    void parseOneCard1() {
        Card card = CardParser.parseCard("5H");
        assertAll(
                () -> assertEquals('5', card.getRank()),
                () -> assertEquals(Suite.HEART, card.getSuite())
        );
    }

    @Test
    void parseOneCard2() {
        Card card = CardParser.parseCard("QC");
        assertAll(
                () -> assertEquals('Q', card.getRank()),
                () -> assertEquals(Suite.CLUB, card.getSuite())
        );
    }
    @Test
    void parseFourCards() {
        Hand hand = HandParser.parseHand("QCAC1H8SJD");
        assertAll(
                () -> assertEquals('Q', hand.dealCard(1).getRank()),
                () -> assertEquals(Suite.CLUB, hand.dealCard(1).getSuite()),
                () -> assertEquals('A', hand.dealCard(2).getRank()),
                () -> assertEquals(Suite.CLUB, hand.dealCard(2).getSuite()),
                () -> assertEquals('1', hand.dealCard(3).getRank()),
                () -> assertEquals(Suite.HEART, hand.dealCard(3).getSuite()),
                () -> assertEquals('8', hand.dealCard(4).getRank()),
                () -> assertEquals(Suite.SPADE, hand.dealCard(4).getSuite())
        );
    }


}
