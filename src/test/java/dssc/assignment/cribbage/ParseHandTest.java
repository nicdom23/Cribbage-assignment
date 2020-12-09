package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParseHandTest {

    @Test
    void parseOneCard_five_of_hearts() {
        Card card = Card.parseCard("5H");
        Card cardToTest = new Card('5',Suite.HEART);
               assertEquals(cardToTest, card);
    }

    @Test
    void parseOneCard_queen_of_clubs() {
        Card card = Card.parseCard("QC");
        Card cardToTest = new Card('Q',Suite.CLUB);
        assertEquals(cardToTest, card);
    }
    @Test
    void parseHand_QC_AC_1H_8S_JD() {
        Hand hand = Hand.parseHand("QCAC1H8SJD");
        Card cardToTest1 = new Card('Q',Suite.CLUB);
        Card cardToTest2 = new Card('A',Suite.CLUB);
        Card cardToTest3 = new Card('1',Suite.HEART);
        Card cardToTest4 = new Card('8',Suite.SPADE);
        Card cardToTestStarter = new Card('J',Suite.DIAMOND);
        Hand handToTest = new Hand(cardToTest1,cardToTest2,cardToTest3,cardToTest4,cardToTestStarter);
        assertEquals(handToTest, hand);

    }

    @Test
    void parseHand_QC_AC_1H_8S_JD_CarD_comparison() {
        Hand hand = Hand.parseHand("QCAC1H8SJD");
        Card cardToTest1 = new Card('Q',Suite.CLUB);
        Card cardToTest2 = new Card('A',Suite.CLUB);
        Card cardToTest3 = new Card('1',Suite.HEART);
        Card cardToTest4 = new Card('8',Suite.SPADE);
        Card cardToTestStarter = new Card('J',Suite.DIAMOND);
        Hand handToTest = new Hand(cardToTest1,cardToTest2,cardToTest3,cardToTest4,cardToTestStarter);
        assertAll(
                () -> assertEquals(handToTest.dealCard(1), hand.dealCard(1)),
                () -> assertEquals(handToTest.dealCard(2), hand.dealCard(2)),
                () -> assertEquals(handToTest.dealCard(3), hand.dealCard(3)),
                () -> assertEquals(handToTest.dealCard(4), hand.dealCard(4)),
                () -> assertEquals(handToTest.dealCard(5), hand.dealCard(5))
                );

    }


}
