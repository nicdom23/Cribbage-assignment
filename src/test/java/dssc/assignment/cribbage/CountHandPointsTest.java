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
    private final PointCalculator pointCalculator = new PointCalculator();
    @Test
    void fifteen_two_Points_and_single_pair_points() {
        Hand hand = HandParser.parseHand("KHQC4DAC4S");
        assertAll(
                () -> assertEquals(10, pointCalculator.calculatePoints(hand))
                //() -> assertEquals(29,29)

        );

    }

    @Test
    void fifteen_two_Points_and_single_pair_points2() {
        Hand hand = HandParser.parseHand("KHADACAS5C");
        assertAll(
                () -> assertEquals(4, pointCalculator.calculatePoints(hand))
                //() -> assertEquals(29,29)

        );

    }
    @Test
    void triple_pair_points() {
        Hand hand = HandParser.parseHand("AH1C1H2H3D");
        assertAll(
                () -> assertEquals(6, pointCalculator.calculatePoints(hand))
                //() -> assertEquals(29,29)

        );

    }
    @Test
    void quadruple_pair_points() {
        Hand hand = HandParser.parseHand("AH1C1H2H3H");
        assertAll(
                () -> assertEquals(12, pointCalculator.calculatePoints(hand))


        );

    }
    @Test
    void jack_points_plus_triple_pair() {
        Hand hand = HandParser.parseHand("JHACAHADAH");
        assertAll(
                () -> assertEquals(7, pointCalculator.calculatePoints(hand))


        );

    }
    @Test
    void jack_points_plus_single_pair() {
        Hand hand = HandParser.parseHand("JHACASADAH");
        assertAll(
                () -> assertEquals(3, pointCalculator.calculatePoints(hand))


        );

    }
}