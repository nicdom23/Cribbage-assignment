package dssc.assignment.cribbage;

public class PairsCalculator {
    public int countTheseCardsForPairs(int i, int j, Hand hand) {

        int score = 0;
        if (i != j) {
            char card1Suite = hand.dealCardRankChar(i);
            char card2Suite = hand.dealCardRankChar(j);

            if (Character.compare(card1Suite,card2Suite)==0){
                score = 1;
            }

        }
        return score;
    }
}
