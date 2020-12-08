package dssc.assignment.cribbage;

public class PairsCalculator {
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
}
