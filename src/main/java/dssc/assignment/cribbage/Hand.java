package dssc.assignment.cribbage;

public class Hand {

    Card first;
    Card second;
    Card third;
    Card fourth;
    Card starter;

    public Hand(Card one, Card two, Card three, Card four, Card starter){
        this.first = one;
        this.second = two;
        this.third = three;
        this.fourth = four;
        this.starter = starter;
    }

    public Card dealCard(int numOfCard)
    {
        if(numOfCard == 1)
            return first;
        else if(numOfCard == 2)
            return second;
        else if(numOfCard == 3)
            return third;
        else if(numOfCard == 4)
            return fourth;
        else return starter;
    }
}
