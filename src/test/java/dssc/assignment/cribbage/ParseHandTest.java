package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParseHandTest {
    @Test
    void parseOneCard_five_of_hearts() {
        Card parsedCard = Card.parseCard("5H");
        Card cardToTest = new Card('5',5,Suite.HEART);
               assertEquals(cardToTest, parsedCard);
    }

    @Test
    void parseOneCard_queen_of_clubs() {
        Card parsedCard = Card.parseCard("QC");
        Card cardToTest = new Card('Q',10,Suite.CLUB);
        assertEquals(cardToTest, parsedCard);
    }

    @Test
    void parseHand_QC_AC_1H_8S_JD() {
        Hand parsedHand = Hand.parseHand("QCAC1H8SJD");
        Card cardToTest1 = new Card('Q',10,Suite.CLUB);
        Card cardToTest2 = new Card('A',1,Suite.CLUB);
        Card cardToTest3 = new Card('1',1,Suite.HEART);
        Card cardToTest4 = new Card('8',8,Suite.SPADE);
        Card cardToTestStarter = new Card('J',10,Suite.DIAMOND);
        Hand handToTest = new Hand(cardToTest1,cardToTest2,cardToTest3,cardToTest4,cardToTestStarter);
        assertEquals(handToTest, parsedHand);

    }

    @Test
    void parseHand_QC_AC_1H_8S_JD_CarD_comparison() {
        Hand parsedHand = Hand.parseHand("QCAC2H8SJD");
        Card cardToTest1 = new Card('Q',10,Suite.CLUB);
        Card cardToTest2 = new Card('A',1,Suite.CLUB);
        Card cardToTest3 = new Card('2',2,Suite.HEART);
        Card cardToTest4 = new Card('8',8,Suite.SPADE);
        Card cardToTestStarter = new Card('J',10,Suite.DIAMOND);
        Hand handToTest = new Hand(cardToTest1,cardToTest2,cardToTest3,cardToTest4,cardToTestStarter);
        assertAll(
                () -> assertEquals(handToTest.dealCard(1), parsedHand.dealCard(1)),
                () -> assertEquals(handToTest.dealCard(2), parsedHand.dealCard(2)),
                () -> assertEquals(handToTest.dealCard(3), parsedHand.dealCard(3)),
                () -> assertEquals(handToTest.dealCard(4), parsedHand.dealCard(4)),
                () -> assertEquals(handToTest.dealCard(5), parsedHand.dealCard(5))
                );

    }


}
