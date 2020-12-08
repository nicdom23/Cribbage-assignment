package dssc.assignment.cribbage;
import java.util.Arrays;
public class PointCalculator {


    public int calculateTotalPoints(Hand hand) {
        return calculate_fifteen_two_points(hand) + calculate_pairs_points(hand) + calculate_jack_points(hand) + calculate_flush_points(hand)+calculate_runs_points(hand);
    }


    public int calculate_fifteen_two_points(Hand hand) {
        FifteenTwoCalculator fifteenTwoCalculator = new FifteenTwoCalculator();
        int score = 0;
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                score += fifteenTwoCalculator.countTheseCardsForFiftheenTwo(i, j, hand);
                score += fifteenTwoCalculator.dontCountTheseCardsForFiftheenTwo(i, j, hand);

            }
        }
        score += fifteenTwoCalculator.countAllCardsForFiftheenTwo(hand);
        return score/2;
    }
    public int calculate_pairs_points(Hand hand) {
        PairsCalculator pairsCalculator = new PairsCalculator();
        int addPoints = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                addPoints+= pairsCalculator.countTheseCardsForPairs(i, j, hand);
            }
        }
        return addPoints ;
    }
    public int calculate_jack_points(Hand hand) {
        JackCalculator jackCalc = new JackCalculator();
        return jackCalc.jackCalculator(hand);
    }
    public int calculate_flush_points(Hand hand) {

        FlushCalculator flushCalc= new FlushCalculator();
        return flushCalc.flushCalculator(hand);
    }
    public int calculate_runs_points(Hand hand){
        RunsCalculator runsCalc =new RunsCalculator();
        int[] flags = runsCalc.find_cards_composition(hand);
        return runsCalc.solveRunsPoints(flags);
    }



}