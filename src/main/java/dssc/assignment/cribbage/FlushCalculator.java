package dssc.assignment.cribbage;

public class FlushCalculator {
    public int flushCalculator(Hand hand) {

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

}
