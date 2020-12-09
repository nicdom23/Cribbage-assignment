package dssc.assignment.cribbage;

public class Hand {

    private Card first;
    private Card second;
    private Card third;
    private Card fourth;
    private Card starter;

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

        return (this.dealCard(1).equals(hand.dealCard(1)))&&(this.dealCard(2).equals(hand.dealCard(2)))&&(this.dealCard(3).equals(hand.dealCard(3)))&&(this.dealCard(4).equals(hand.dealCard(4)))&&(this.dealCard(5).equals(hand.dealCard(5)));
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = result+ this.dealCard(1).hashCode();
        result = result+ this.dealCard(2).hashCode();
        result = result+ this.dealCard(3).hashCode();
        result = result+ this.dealCard(4).hashCode();
        result = result+ this.dealCard(5).hashCode();
        return result;
    }
    public Card dealCard(int numOfCard){  ///////METHOD STILL NEEDED(see hand class and this class too)
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
    public Rank dealCardRank(int numOfCard){
        return dealCard(numOfCard).getRank();
    }
    public char dealCardRankChar(int numOfCard){
        return dealCardRank(numOfCard).getRankChar();
    }


    public int dealCardRankInt(int numOfCard)
    {
        return dealCardRank(numOfCard).getRankInt();
    }
    public Suite dealCardSuite(int numOfCard)
    {
        return dealCard(numOfCard).getSuite();
    }

    public static Hand parseHand(String handAsText) {
        Card card1 = Card.parseCard(handAsText.substring(0,2));
        Card card2 = Card.parseCard(handAsText.substring(2,4));
        Card card3 = Card.parseCard(handAsText.substring(4,6));
        Card card4 = Card.parseCard(handAsText.substring(6,8));
        Card starter = Card.parseCard(handAsText.substring(8,10));

        return new Hand(card1,card2,card3,card4,starter);
    }


}
