package dssc.assignment.cribbage;
import java.util.Arrays;
public class PointCalculator {

    public int calculatePoints(Hand hand) {
        int points = fifteen_two_points(hand) + pairs_points(hand) + jack_points(hand) + flush_points(hand)+runs_points(hand);
        return points;
    }

    public int fifteen_two_points(Hand hand) {
        int score = 0;
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                score += countTheseCardsForFiftheenTwo(i, j, hand);
                score += dontCountTheseCardsForFiftheenTwo(i, j, hand);

            }
        }
        score += countAllCardsForFiftheenTwo(hand);
        return score/2;
    }
    private int countTheseCardsForFiftheenTwo(int i, int j, Hand hand) {
        int card1Value = hand.dealCard(i).getRankInt();
        int card2Value = hand.dealCard(j).getRankInt();
        int addPoints = 0;
        if (card1Value + card2Value == 15)
            addPoints = 2;
        return addPoints;
    }
    private int dontCountTheseCardsForFiftheenTwo(int i, int j, Hand hand) {
        int cardValue;
        int sum = 0;
        int addPoints = 0;
        for (int k = 1; k < 6; k++) {
            if (k != i && k != j) {//skip these two cards
                cardValue = hand.dealCard(k).getRankInt();
                sum += cardValue;
            }
        }
        if (sum == 15){
            if(i==j)
                addPoints = 4;
            else
                addPoints = 2;
        }

        return addPoints;
    }
    private int countAllCardsForFiftheenTwo(Hand hand) {
        int cardValue;
        int sum = 0;
        int addPoints = 0;
        for (int k = 1; k < 6; k++) {
            cardValue = hand.dealCard(k).getRankInt();
            sum += cardValue;
        }
        if (sum == 15)
            addPoints = 4;
        return addPoints;
    }

    public int pairs_points(Hand hand) {
        int addPoints = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                addPoints+= countTheseCardsForPairs(i, j, hand);
            }
        }

        return addPoints ;
    }
    public int countTheseCardsForPairs(int i, int j, Hand hand) {

        int score = 0;
        if (i != j) {
            char card1Suite = hand.dealCard(i).getRank();
            char card2Suite = hand.dealCard(j).getRank();

            if (Character.compare(card1Suite,card2Suite)==0){
                score = 1;
            }

        }
        return score;
    }

    public int jack_points(Hand hand) {
        Suite starterSuite = hand.dealCard(5).getSuite();
        Suite compareSuite;
        char compareRank;
        int addPoints = 0;
        for (int i = 1; i < 5; i++) {
            compareSuite = hand.dealCard(i).getSuite();
            compareRank = hand.dealCard(i).getRank();
            if (compareSuite == starterSuite && compareRank == 'J')
                addPoints += 1;
        }
        return addPoints;
    }

    public int flush_points(Hand hand) {

        int addPoints = 0;
        Suite card1Suite = hand.dealCard(1).getSuite();
        Suite cardSuite;
        boolean flag = true;
        Suite starterSuite = hand.dealCard(5).getSuite();
        for (int i = 2; i < 5; i++) {
            cardSuite = hand.dealCard(i).getSuite();
            flag = flag && (card1Suite == cardSuite);
            if (flag == false) break;
        }
        if (flag == true) {
            addPoints += 4;
            if (card1Suite == starterSuite)
                addPoints += 1;
        }
        return addPoints;
    }

    public int runs_points(Hand hand){
        int addPoints=0;
        String ranks = "A234567890JQK";
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
        addPoints = solveRunsPoints(addPoints, flags);
        return addPoints;
    }
    public int solveRunsPoints(int addPoints, int[] flags) {
        int steps;
        int multipliers[] = new int[]{1,1,1,1,1};
        int multPos = 0;
        int mult;
        steps = 0;
        for(int i = 0; i < 14;i++) {
           if (flags[i] == 0 || i == 13) {
                if (steps == 3) { mult = 1;
                    for (int l = 0; l < 3; l++){

                        mult *= multipliers[l];}
                        addPoints += 3 * mult;
                    }else if (steps == 4) { mult =1;
                        for (int l = 0; l < 4; l++){

                            mult *= multipliers[l];}
                            addPoints += 7 * mult;
                            mult = 1;
                        for (int l = 0; l < 3; l++){

                            mult *= multipliers[l];}
                            addPoints += 3 * mult;
                            mult = 1;
                    }else if (steps == 5) { mult =1;
                        for (int l = 0; l < 5; l++){

                            mult *= multipliers[l];}
                            addPoints += 12 * mult;
                            mult = 1;
                        for (int l = 0; l < 4; l++){

                            mult *= multipliers[l];}
                            addPoints += 7 * mult;
                            mult = 1;
                         for (int l = 0; l < 3; l++) {

                             mult *= multipliers[l];
                         }

                            addPoints += 3 * mult;
                            mult = 1;
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