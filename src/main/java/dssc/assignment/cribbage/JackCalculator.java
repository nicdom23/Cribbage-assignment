package dssc.assignment.cribbage;

public class JackCalculator {

    public int jackCalculator(Hand hand) {
        Suite starterSuite = hand.dealCardSuite(5);
        Suite compareSuite;
        char compareRank;
        int addPoints = 0;
        for (int i = 1; i < 5; i++) {
            compareSuite = hand.dealCardSuite(i);
            compareRank = hand.dealCardRank(i);
            if (compareSuite == starterSuite && compareRank == 'J')
                addPoints += 1;
        }
        return addPoints;
    }
}
