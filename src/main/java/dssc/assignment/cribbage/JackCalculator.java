package dssc.assignment.cribbage;

public class JackCalculator {

    public int jackCalculator(Hand hand) {
        Suite starterSuite = hand.dealCardSuite(5);
        Suite compareSuite;
        char compareRankChar;
        int addPoints = 0;
        for (int i = 1; i < 5; i++) {
            compareSuite = hand.dealCardSuite(i);
            compareRankChar = hand.dealCardRankChar(i);
            if (compareSuite == starterSuite && Character.compare(compareRankChar, 'J')==0)
                addPoints += 1;
        }
        return addPoints;
    }
}
