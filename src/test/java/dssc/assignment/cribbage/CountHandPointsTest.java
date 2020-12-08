package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountHandPointsTest {
    private final PointCalculator pointCalculator = new PointCalculator();

    @Test
    void handPoints_ex_1_from_readme_5H_5D_5S_JC_5C() {
        Hand hand = HandParser.parseHand("5H5D5SJC5C");
        assertEquals(29, pointCalculator.calculateTotalPoints(hand));

    }
    @Test
    void handPoints_ex_2_from_readme_0D_JH_QS_AC_9D() {
        Hand hand = HandParser.parseHand("0DJHQSAC9D");
        assertEquals(10, pointCalculator.calculateTotalPoints(hand));

    }
   @Test
    void fifteen_two_Points_KH_plus_5C_as_initials() {
        Hand hand = HandParser.parseHand("KH5CADACAS");
        assertEquals(2, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void fifteen_two_Points_KH_plus_5C_as_middle() {
        Hand hand = HandParser.parseHand("ADACKH5CAS");
        assertEquals(2, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void fifteen_two_Points_KH_plus_4C_plus_AD_as_initials() {
        Hand hand = HandParser.parseHand("KH4CAD9C9S");
        assertEquals(2, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void fifteen_two_Points_KH_plus_AC_plus_AD_plus_AS_plus_2S_whole_hand() {
        Hand hand = HandParser.parseHand("KHACADAS2S");
       assertEquals(2, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void fifteen_two_Points_K_times_2_plus_5C() {
        Hand hand = HandParser.parseHand("KH5CKDASAH");
        assertEquals(4, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void fifteen_two_Points_K_times_3_plus_5C() {
        Hand hand = HandParser.parseHand("KH5CKDKSAH");
        assertEquals(6, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void fifteen_two_Points_KH_plus_4C_plus_AD_as_middle() {
        Hand hand = HandParser.parseHand("8S8HKH4CAD");
        assertEquals(2, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void fifteen_two_Points_K_times_2_plus_4C_plus_AD_as_sparse_in_hand() {
        Hand hand = HandParser.parseHand("KS8HKH4CAD");
        assertEquals(4, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void fifteen_two_Points_K_times_3_plus_4C_plus_AD_as_whole_hand() {
        Hand hand = HandParser.parseHand("KSKDKH4CAD");
        assertEquals(6, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void fifteen_two_Points_KH_plus_4C_plus_A_times_3_as_whole_hand() {
        Hand hand = HandParser.parseHand("KH4CADASAH");
        assertEquals(6, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void fifteen_two_Points_KH_plus_5_times_4_and_5_times_4_as_whole_hand() {
        Hand hand = HandParser.parseHand("KH5C5D5S5H");
        assertEquals(8+4*2, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void fifteen_two_Points_KS_plus_2H_plus_2D_plus_A_times_2_as_whole_hand() {
        Hand hand = HandParser.parseHand("KS2H2DADAH");
        assertEquals(2+2, pointCalculator.calculate_fifteen_two_points(hand));

    }
    @Test
    void single_pair_points_AD_and_AC() {
        Hand hand = HandParser.parseHand("KHADAC2S5C");
        assertEquals(2, pointCalculator.calculate_pairs_points(hand));

    }
    @Test
    void triple_pair_points_0H_and_0C_and_0D() {
        Hand hand = HandParser.parseHand("0H0C0D5D4D");
       assertEquals(6, pointCalculator.calculate_pairs_points(hand));

    }
    @Test
    void quadruple_pair_points_0H_and_0C_and_0D_and_0S() {
        Hand hand = HandParser.parseHand("0H0C0D0S4D");
       assertEquals(12, pointCalculator.calculate_pairs_points(hand));

    }
    @Test
    void jack_points_JH_in_hand_QH_as_starter() {
        Hand hand = HandParser.parseHand("JHACAHADQH");
        assertEquals(1, pointCalculator.calculate_jack_points(hand));

    }
    @Test
    void jack_points_JH_in_hand_AH_as_starter() {
        Hand hand = HandParser.parseHand("ACASADJHAH");
       assertEquals(1, pointCalculator.calculate_jack_points(hand));

    }
    @Test
    void flush_of_four_of_hearts_AH_2H_4H_6H() {
        Hand hand = HandParser.parseHand("AH2H4H6H8C");
        assertEquals(4, pointCalculator.calculate_flush_points(hand));

    }
    @Test
    void complete_flush_of_hearts_AH_2H_4H_6H_8H() {
        Hand hand = HandParser.parseHand("AH2H4H6H8H");
         assertEquals(5, pointCalculator.calculate_flush_points(hand));

    }
    @Test
    void points_triple_run_AH_2D_3C() {
        Hand hand = HandParser.parseHand("AH2D3C6H8H");
        assertEquals(3, pointCalculator.calculate_runs_points(hand));

    }
    @Test
    void points_triple_run_5H_6C_7D() {
        Hand hand = HandParser.parseHand("5H6C7DKDQC");
       assertEquals(3, pointCalculator.calculate_runs_points(hand));

    }
    @Test
    void points_quadruple_run_AH_2C_3D_4S() {
        Hand hand = HandParser.parseHand("AH2C3D4S8H");
       assertEquals(10, pointCalculator.calculate_runs_points(hand));

    }
    @Test
    void points_quadruple_run_5H_6C_7D_8_times_2() {
        Hand hand = HandParser.parseHand("5H6C7D8S8H");
        assertEquals(17, pointCalculator.calculate_runs_points(hand));

    }
    @Test
    void points_penta_run_AH_2C_3D_4H_5H_as_whole_hand() {
        Hand hand = HandParser.parseHand("AH2C3D4H5H");
         assertEquals(22, pointCalculator.calculate_runs_points(hand));

    }
    @Test
    void points_penta_run_9H_0C_JD_QH_KH() {
        Hand hand = HandParser.parseHand("9H0CJDQHKH");
        assertEquals(22, pointCalculator.calculate_runs_points(hand));

    }
}