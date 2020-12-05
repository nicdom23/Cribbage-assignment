package dssc.assignment.cribbage;

public class PointCalculator {

    public static int calculatePoints(Hand hand) {
        return fifteen_two_points(hand) + pairs_points(hand);
    }

    public static int fifteen_two_points(Hand hand) {
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


    private static int countTheseCardsForFiftheenTwo(int i, int j, Hand hand) {
        int card1Value = hand.dealCard(i).getRankInt();
        int card2Value = hand.dealCard(j).getRankInt();
        int addPoints = 0;
        if (card1Value + card2Value == 15)
            addPoints += 2;
        return addPoints;
    }

    private static int dontCountTheseCardsForFiftheenTwo(int i, int j, Hand hand) {
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

    private static int countAllCardsForFiftheenTwo(Hand hand) {
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

  /*  private static int pairs_points(Hand hand) {
        Suite card1Suit;
        Suite card2Suit;
        int addPoints = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; i < 6; i++) {
                card1Suit = hand.dealCard(i).getSuite();
                card2Suit = hand.dealCard(j).getSuite();
                if (card1Suit == card2Suit)
                    addPoints += 2;
            }
        }
        return addPoints;
    }*/


    private static int pairs_points(Hand hand) {
        int score = 0;
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                score += countTheseCardsForPairs(i, j, hand);
            }
        }

        return score / 2;
}

    public static int countTheseCardsForPairs(int i, int j,Hand hand){
        int addPoints = 0;
        if(i!=j){
             Suite card1Suite = hand.dealCard(i).getSuite();
             Suite card2Suite = hand.dealCard(j).getSuite();

            if (card1Suite == card2Suite)
                 addPoints += 2;
        }
    return addPoints;
    }

}