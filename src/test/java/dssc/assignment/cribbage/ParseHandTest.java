package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParseHandTest {
    @Test
    void parseOneCard_five_of_hearts() {
        Card parsedCard = CardParser.parseCard("5H");
        Rank rank = new Rank('5',5);
        Card cardToTest = new Card(rank,Suite.HEART);
               assertEquals(cardToTest, parsedCard);
    }

    @Test
    void parseOneCard_queen_of_clubs() {
        Card parsedCard = CardParser.parseCard("QC");
        Rank rank = new Rank('Q',10);
        Card cardToTest = new Card(rank,Suite.CLUB);
        assertEquals(cardToTest, parsedCard);
    }

    @Test
    void parseHand_QC_AC_1H_8S_JD() {
        Hand parsedHand = HandParser.parseHand("QCAC1H8SJD");
        Rank rank = new Rank('Q',10);
        Card cardToTest1 = new Card(rank,Suite.CLUB);
        rank = new Rank('A',1);
        Card cardToTest2 = new Card(rank,Suite.CLUB);
        rank = new Rank('1',1);
        Card cardToTest3 = new Card(rank,Suite.HEART);
        rank = new Rank('8',8);
        Card cardToTest4 = new Card(rank,Suite.SPADE);
        rank = new Rank('J',10);
        Card cardToTestStarter = new Card(rank,Suite.DIAMOND);
        Hand handToTest = new Hand(cardToTest1,cardToTest2,cardToTest3,cardToTest4,cardToTestStarter);
        assertEquals(handToTest, parsedHand);

    }

    @Test
    void parseHand_QC_AC_1H_8S_JD_CarD_comparison() {
        Hand parsedHand = HandParser.parseHand("QCAC2H8SJD");
        Rank rank = new Rank('Q',10);
        Card cardToTest1 = new Card(rank,Suite.CLUB);
        rank = new Rank('A',1);
        Card cardToTest2 = new Card(rank,Suite.CLUB);
        rank = new Rank('2',2);
        Card cardToTest3 = new Card(rank,Suite.HEART);
        rank = new Rank('8',8);
        Card cardToTest4 = new Card(rank,Suite.SPADE);
        rank = new Rank('J',10);
        Card cardToTestStarter = new Card(rank,Suite.DIAMOND);
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
