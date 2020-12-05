package dssc.assignment.cribbage;

public class PointCalculator {

    public static int calculatePoints(Hand hand) {
        return fifteen_two_points(hand) + pairs_points(hand);
    }

    /*public static int fifteen_two_points(Hand hand) {
        int score = 0;
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            sum = sum + hand.dealCard(i).getRankInt();
            for (int j = 1; j < 6 && j != i; i++) {
                if (j != i) {
                    sum = sum + hand.dealCard(i).getRankInt();
                    if (equal_fifteen(sum))
                        score = add_two(score);
                }
                for (int k = 1; k < 6; i++) {
                    if (k != i && k != j) {
                        sum = sum + hand.dealCard(i).getRankInt();
                        if (equal_fifteen(sum))
                            score = add_two(score);
                    }
                    for (int u = 1; u < 6; i++) {
                        if (u != i && u != j && u != k) {
                            sum = sum + hand.dealCard(i).getRankInt();
                            if (equal_fifteen(sum))
                                score = add_two(score);
                        }
                        for (int h = 1; h < 6; i++) {
                            if (h != i && h != j && h != k && h != u) {
                                sum = sum + hand.dealCard(i).getRankInt();
                                if (equal_fifteen(sum))
                                    score = add_two(score);
                            }
                        }
                    }
                }
            }
        }
        return score;
    }*/

    /*public static int fifteen_two_points(Hand hand) {
        int score = 0;
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            sum = hand.dealCard(i).getRankInt();
            //for (int k = i+1; k<6;k++)
            for(int j = i +1; j<6; j++) {
                int card2Value = hand.dealCard(j).getRankInt();
                sum = sum + card2Value;
                if (sum == 15) {
                    score = score + 2;
                    sum = sum - card2Value;
                } else if (sum > 15) {
                    sum = sum - card2Value;
                }
            }
        }
        return score;
    }*/
    public static int fifteen_two_points(Hand hand) {
        int score = 0;
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                score += countTheseCards(i, j, hand);
                score += dontCountTheseCards(i, j, hand);

            }
        }
        score += countAllCards(hand);
        return score / 2;
    }


    private static int countTheseCards(int i, int j, Hand hand) {
        int card1Value = hand.dealCard(i).getRankInt();
        int card2Value = hand.dealCard(j).getRankInt();
        int addPoints = 0;
        if (card1Value + card2Value == 15)
            addPoints += 2;
        return addPoints;
    }

    private static int dontCountTheseCards(int i, int j, Hand hand) {
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

    private static int countAllCards(Hand hand) {
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

    private static int pairs_points(Hand hand) {
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
    }
}