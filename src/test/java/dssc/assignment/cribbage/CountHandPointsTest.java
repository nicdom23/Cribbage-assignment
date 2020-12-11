package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountHandPointsTest {
    private final PointCalculator pointCalculator = new PointCalculator();

    @Test
    void handPoints_ex_1_from_readme_5H_5D_5S_JC_5C() {
        Hand handToCalculate = HandParser.parseHand("5H5D5SJC5C");
        assertEquals(29, pointCalculator.calculateTotalPoints(handToCalculate));

    }
    @Test
    void handPoints_ex_2_from_readme_0D_JH_QS_AC_9D() {
        Hand handToCalculate = HandParser.parseHand("0DJHQSAC9D");
        assertEquals(4, pointCalculator.calculateTotalPoints(handToCalculate));

    }
   @Test
    void fifteen_two_Points_KH_plus_5C_as_initials() {
        Hand handToCalculate = HandParser.parseHand("KH5CADACAS");
        assertEquals(2, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void fifteen_two_Points_KH_plus_5C_as_middle() {
        Hand handToCalculate= HandParser.parseHand("ADACKH5CAS");
        assertEquals(2, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void fifteen_two_Points_KH_plus_4C_plus_AD_as_initials() {
        Hand handToCalculate = HandParser.parseHand("KH4CAD9C9S");
        assertEquals(2, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void fifteen_two_Points_KH_plus_AC_plus_AD_plus_AS_plus_2S_whole_hand() {
        Hand handToCalculate = HandParser.parseHand("KHACADAS2S");
       assertEquals(2, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void fifteen_two_Points_K_times_2_plus_5C() {
        Hand handToCalculate = HandParser.parseHand("KH5CKDASAH");
        assertEquals(4, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void fifteen_two_Points_K_times_3_plus_5C() {
        Hand handToCalculate = HandParser.parseHand("KH5CKDKSAH");
        assertEquals(6, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void fifteen_two_Points_KH_plus_4C_plus_AD_as_middle() {
        Hand handToCalculate = HandParser.parseHand("8S8HKH4CAD");
        assertEquals(2, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void fifteen_two_Points_K_times_2_plus_4C_plus_AD_as_sparse_in_hand() {
        Hand handToCalculate = HandParser.parseHand("KS8HKH4CAD");
        assertEquals(4, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void fifteen_two_Points_K_times_3_plus_4C_plus_AD_as_whole_hand() {
        Hand handToCalculate = HandParser.parseHand("KSKDKH4CAD");
        assertEquals(6, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void fifteen_two_Points_KH_plus_4C_plus_A_times_3_as_whole_hand() {
        Hand handToCalculate = HandParser.parseHand("KH4CADASAH");
        assertEquals(6, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void fifteen_two_Points_KH_plus_5_times_4_and_5_times_4_as_whole_hand() {
        Hand handToCalculate = HandParser.parseHand("KH5C5D5S5H");
        assertEquals(8+4*2, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void fifteen_two_Points_KS_plus_2H_plus_2D_plus_A_times_2_as_whole_hand() {
        Hand handToCalculate = HandParser.parseHand("KS2H2DADAH");
        assertEquals(2+2, pointCalculator.calculate_fifteen_two_points(handToCalculate));

    }
    @Test
    void single_pair_points_AD_and_AC() {
        Hand handToCalculate = HandParser.parseHand("KHADAC2S5C");
        assertEquals(2, pointCalculator.calculate_pairs_points(handToCalculate));

    }
    @Test
    void triple_pair_points_0H_and_0C_and_0D() {
        Hand handToCalculate = HandParser.parseHand("0H0C0D5D4D");
       assertEquals(6, pointCalculator.calculate_pairs_points(handToCalculate));

    }
    @Test
    void quadruple_pair_points_0H_and_0C_and_0D_and_0S() {
        Hand handToCalculate = HandParser.parseHand("0H0C0D0S4D");
       assertEquals(12, pointCalculator.calculate_pairs_points(handToCalculate));

    }
    @Test
    void jack_points_JH_in_hand_QH_as_starter() {
        Hand handToCalculate = HandParser.parseHand("JHACAHADQH");
        assertEquals(1, pointCalculator.calculate_jack_points(handToCalculate));

    }
    @Test
    void jack_points_JH_in_hand_AH_as_starter() {
        Hand handToCalculate = HandParser.parseHand("ACASADJHAH");
       assertEquals(1, pointCalculator.calculate_jack_points(handToCalculate));

    }
    @Test
    void flush_of_four_of_hearts_AH_2H_4H_6H() {
        Hand handToCalculate = HandParser.parseHand("AH2H4H6H8C");
        assertEquals(4, pointCalculator.calculate_flush_points(handToCalculate));

    }
    @Test
    void complete_flush_of_hearts_AH_2H_4H_6H_8H() {
        Hand handToCalculate = HandParser.parseHand("AH2H4H6H8H");
         assertEquals(5, pointCalculator.calculate_flush_points(handToCalculate));

    }
    @Test
    void points_triple_run_AH_2D_3C() {
        Hand handToCalculate = HandParser.parseHand("AH2D3C6H8H");
        assertEquals(3, pointCalculator.calculate_runs_points(handToCalculate));

    }
    @Test
    void points_triple_run_5H_6C_7D() {
        Hand handToCalculate = HandParser.parseHand("5H6C7DKDQC");
       assertEquals(3, pointCalculator.calculate_runs_points(handToCalculate));

    }
    @Test
    void points_quadruple_run_AH_2C_3D_4S() {
        Hand handToCalculate = HandParser.parseHand("AH2C3D4S8H");
       assertEquals(4, pointCalculator.calculate_runs_points(handToCalculate));

    }
    @Test
    void points_quadruple_run_5H_6C_7D_8_times_2() {
        Hand handToCalculate = HandParser.parseHand("5H6C7D8S8H");
        assertEquals(8, pointCalculator.calculate_runs_points(handToCalculate));

    }
    @Test
    void points_penta_run_AH_2C_3D_4H_5H_as_whole_hand() {
        Hand handToCalculate = HandParser.parseHand("AH2C3D4H5H");
         assertEquals(5, pointCalculator.calculate_runs_points(handToCalculate));

    }
    @Test
    void points_penta_run_9H_0C_JD_QH_KH() {
        Hand handToCalculate = HandParser.parseHand("9H0CJDQHKH");
        assertEquals(5, pointCalculator.calculate_runs_points(handToCalculate));

    }
}