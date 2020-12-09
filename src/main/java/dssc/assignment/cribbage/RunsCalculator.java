package dssc.assignment.cribbage;

import java.util.Arrays;

public class RunsCalculator {

    public int[] find_cards_composition(Hand hand) {
        String ranks = Card.orderedRanks;
        int flags[] = new int[14];
        //Arrays.fill(flags, 0);

        int maxRankSequence = 0;
        char firstCardRank;
        char sequenceRank;
        for(int i = 0; i < 13;i++)
            for(int j = 1; j < 6;j++) {
                sequenceRank = ranks.charAt(i);
                firstCardRank = hand.dealCard(j).getRank();
                if (Character.compare(firstCardRank, sequenceRank) == 0) {
                    flags[i] += 1;
                }
            }
        return flags;
    }

    public int solveRunsPoints(int[] flags) {
        int addPoints=0;
        int steps;
        int multipliers[] = new int[]{1,1,1,1,1};
        int multPos = 0;
        int mult;
        steps = 0;
        for(int i = 0; i < 14;i++) {
            if (flags[i] == 0 || i == 13) {
                if (steps == 3) {
                    mult = 1;
                    for (int l = 0; l < 3; l++){
                        mult *= multipliers[l];}
                    addPoints += 3 * mult;
                }else if (steps == 4) {
                    mult =1;
                    for (int l = 0; l < 4; l++){

                        mult *= multipliers[l];}
                    addPoints += 4 * mult;
                }else if (steps == 5) {
                    mult =1;
                    for (int l = 0; l < 5; l++){

                        mult *= multipliers[l];}
                    addPoints += 5 * mult;
                }
                Arrays.fill(multipliers,1);
                multPos=0;
                steps = 0;
            }else{steps += 1;
                if(flags[i] > 1 ){
                    multipliers[multPos] = flags[i];
                }
                multPos += 1;
            }
        }
        return addPoints;
    }
}
