package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountHandPointsTest {

    /*@Test
    void handPoints() {
        Hand hand = HandParser.parseHand("5H5D5SJC5C");
        assertAll(
                () -> assertEquals(29, PointCalculator.calculatePoints(hand))
        //() -> assertEquals(29,29)

        );
    }*/
    @Test
    void fifteen_two_Points() {
        Hand hand = HandParser.parseHand("KHQC4DAC4S");
        assertAll(
                () -> assertEquals(10, PointCalculator.calculatePoints(hand))
                //() -> assertEquals(29,29)

        );

    }

    @Test
    void fifteen_two_Points2() {
        Hand hand = HandParser.parseHand("KHADACAS5C");
        assertAll(
                () -> assertEquals(4, PointCalculator.calculatePoints(hand))
                //() -> assertEquals(29,29)

        );

    }
}