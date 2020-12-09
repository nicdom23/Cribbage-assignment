package dssc.assignment.cribbage;

public class FifteenTwoCalculator {
    public int countTheseCardsForFiftheenTwo(int i, int j, Hand hand) {
        int card1Value = hand.dealCardRankInt(i);
        int card2Value = hand.dealCardRankInt(j);
        int addPoints = 0;
        if (card1Value + card2Value == 15)
            addPoints = 2;
        return addPoints;
    }
    public int dontCountTheseCardsForFiftheenTwo(int i, int j, Hand hand) {
        int cardValue;
        int sum = 0;
        int addPoints = 0;
        for (int k = 1; k < 6; k++) {
            if (k != i && k != j) {//skip these two cards
                cardValue = hand.dealCardRankInt(k);
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
    public int countAllCardsForFiftheenTwo(Hand hand) {
        int cardValue;
        int sum = 0;
        int addPoints = 0;
        for (int k = 1; k < 6; k++) {
            cardValue = hand.dealCardRankInt(k);
            sum += cardValue;
        }
        if (sum == 15)
            addPoints = 4;
        return addPoints;
    }

}
