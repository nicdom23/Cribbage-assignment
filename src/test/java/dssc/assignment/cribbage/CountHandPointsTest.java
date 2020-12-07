package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountHandPointsTest {
    private final PointCalculator pointCalculator = new PointCalculator();

    /*@Test
    void handPoints1() {
        Hand hand = HandParser.parseHand("5H5D5SJC5C");
        assertAll(
                () -> assertEquals(29, pointCalculator.calculatePoints(hand))
        );
    }
    @Test
    void handPoints2() {
        Hand hand = HandParser.parseHand("0DJHQSAC9D");
        assertAll(
                () -> assertEquals(10, pointCalculator.calculatePoints(hand))
        );
    }*/
   @Test
    void fifteen_two_Points() {
        Hand hand = HandParser.parseHand("KH5CADACAS");
        assertAll(
                () -> assertEquals(2, pointCalculator.fifteen_two_points(hand))
        );

    }
    @Test
    void fifteen_two_Points2() {
        Hand hand = HandParser.parseHand("ADACKH5CAS");
        assertAll(
                () -> assertEquals(2, pointCalculator.fifteen_two_points(hand))
        );

    }
    @Test
    void fifteen_two_Points3() {
        Hand hand = HandParser.parseHand("KH4CAD9C9S");
        assertAll(
                () -> assertEquals(2, pointCalculator.fifteen_two_points(hand))
        );

    }
    @Test
    void fifteen_two_Points4() {
        Hand hand = HandParser.parseHand("KHACADAS2S");
        assertAll(
                () -> assertEquals(2, pointCalculator.fifteen_two_points(hand))
        );

    }
    @Test
    void fifteen_two_Points5() {
        Hand hand = HandParser.parseHand("KH5CKDASAH");
        assertAll(
                () -> assertEquals(4, pointCalculator.fifteen_two_points(hand))
        );

    }
    @Test
    void fifteen_two_Points6() {
        Hand hand = HandParser.parseHand("KH5CKDKSAH");
        assertAll(
                () -> assertEquals(6, pointCalculator.fifteen_two_points(hand))
        );

    }
    @Test
    void single_pair_points() {
        Hand hand = HandParser.parseHand("KHADAC2S5C");
        assertAll(
                () -> assertEquals(2, pointCalculator.pairs_points(hand))
        );

    }
    @Test
    void triple_pair_points() {
        Hand hand = HandParser.parseHand("0H0C0D5D4D");
        assertAll(
                () -> assertEquals(6, pointCalculator.pairs_points(hand))
        );

    }
    @Test
    void quadruple_pair_points() {
        Hand hand = HandParser.parseHand("0H0C0D0S4D");
        assertAll(
                () -> assertEquals(12, pointCalculator.pairs_points(hand))


        );

    }
    @Test
    void jack_points() {
        Hand hand = HandParser.parseHand("JHACAHADQH");
        assertAll(
                () -> assertEquals(1, pointCalculator.jack_points(hand))


        );

    }
    @Test
    void jack_points2() {
        Hand hand = HandParser.parseHand("JHACASADAH");
        assertAll(
                () -> assertEquals(1, pointCalculator.jack_points(hand))


        );

    }
    @Test
    void flush_of_four() {
        Hand hand = HandParser.parseHand("AH2H4H6H8C");
        assertAll(
                () -> assertEquals(4, pointCalculator.flush_points(hand))


        );

    }
    @Test
    void complete_flush_of_5() {
        Hand hand = HandParser.parseHand("AH2H4H6H8H");
        assertAll(
                () -> assertEquals(5, pointCalculator.flush_points(hand))


        );

    }
    @Test
    void points_triple_run() {
        Hand hand = HandParser.parseHand("AH2D3C6H8H");
        assertAll(
                () -> assertEquals(3, pointCalculator.runs_points(hand))


        );

    }
    @Test
    void points_triple_run2() {
        Hand hand = HandParser.parseHand("5H6C7DKDQC");
        assertAll(
                () -> assertEquals(3, pointCalculator.runs_points(hand))


        );

    }
    @Test
    void points_quadruple_run() {
        Hand hand = HandParser.parseHand("AH2C3D4S8H");
        assertAll(
                () -> assertEquals(10, pointCalculator.runs_points(hand))


        );

    }
    @Test
    void points_quadruple_run2() {
        Hand hand = HandParser.parseHand("5H6C7D8S8H");
        assertAll(
                () -> assertEquals(17, pointCalculator.runs_points(hand))


        );

    }
    @Test
    void points_penta_run() {
        Hand hand = HandParser.parseHand("AH2C3D4H5H");
        assertAll(
                () -> assertEquals(22, pointCalculator.runs_points(hand))


        );

    }
    @Test
    void points_penta_run2() {
        Hand hand = HandParser.parseHand("9H0CJDQHKH");
        assertAll(
                () -> assertEquals(22, pointCalculator.runs_points(hand))


        );

    }
}