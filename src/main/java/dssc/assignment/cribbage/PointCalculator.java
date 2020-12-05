package dssc.assignment.cribbage;

public class PointCalculator {

    public int calculatePoints(Hand hand) {
        return fifteen_two_points(hand) + pairs_points(hand)+jack_points(hand);
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
        return score / 2;
    }


    private int countTheseCardsForFiftheenTwo(int i, int j, Hand hand) {
        int card1Value = hand.dealCard(i).getRankInt();
        int card2Value = hand.dealCard(j).getRankInt();
        int addPoints = 0;
        if (card1Value + card2Value == 15)
            addPoints += 2;
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
        if (sum == 15)
            addPoints += 2;

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
            addPoints += 2;

        return addPoints;
    }

    private int pairs_points(Hand hand) {
        int score = 0;
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                score += countTheseCardsForPairs(i, j, hand);
            }
        }

        return score / 2;
}

    public int countTheseCardsForPairs(int i, int j,Hand hand){
        int addPoints = 0;
        if(i!=j){
             Suite card1Suite = hand.dealCard(i).getSuite();
             Suite card2Suite = hand.dealCard(j).getSuite();

            if (card1Suite == card2Suite)
                 addPoints += 2;
        }
    return addPoints;
    }
    public int jack_points(Hand hand){
        Suite starterSuite=hand.dealCard(5).getSuite();
        Suite compareSuite;
        char compareRank;
        int addPoints = 0;
        for (int i = 1;i<5;i++){
        compareSuite = hand.dealCard(i).getSuite();
        compareRank = hand.dealCard(i).getRank();
        if (compareSuite == starterSuite && compareRank == 'J')
            addPoints += 1;
        }
        return addPoints;
    }
}