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
    @Override
    public boolean equals(Object o){
        if(o==this) return true;
        if(!(o instanceof Hand)) return false;
        Hand hand = (Hand) o;

        return (this.first.equals(hand.first))&&(this.second.equals(hand.second))&&(this.third.equals(hand.third))&&(this.fourth.equals(hand.fourth))&&(this.starter.equals(hand.starter));
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = result+ this.first.hashCode();
        result = result+ this.second.hashCode();
        result = result+ this.third.hashCode();
        result = result+ this.fourth.hashCode();
        result = result+ this.starter.hashCode();
        return result;
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
