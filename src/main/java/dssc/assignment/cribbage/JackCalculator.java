package dssc.assignment.cribbage;

public class JackCalculator {

    public int jackCalculator(Hand hand) {
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
}
