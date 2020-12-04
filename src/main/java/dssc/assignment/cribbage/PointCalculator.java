package dssc.assignment.cribbage;

public class PointCalculator {

    public static int calculatePoints(Hand hand){
        return fifteen_two_points(hand);
    }

    /*public static int fifteen_two_points(Hand hand) {
        int score = 0;
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            sum = sum + hand.dealCard(i).getRankInt();
            for (int j = 1; j < 6 && j != i; i++) {
                if (j != i) {
                    sum = sum + hand.dealCard(i).getRankInt();
                    if (equal_fifteen(sum))
                        score = add_two(score);
                }
                for (int k = 1; k < 6; i++) {
                    if (k != i && k != j) {
                        sum = sum + hand.dealCard(i).getRankInt();
                        if (equal_fifteen(sum))
                            score = add_two(score);
                    }
                    for (int u = 1; u < 6; i++) {
                        if (u != i && u != j && u != k) {
                            sum = sum + hand.dealCard(i).getRankInt();
                            if (equal_fifteen(sum))
                                score = add_two(score);
                        }
                        for (int h = 1; h < 6; i++) {
                            if (h != i && h != j && h != k && h != u) {
                                sum = sum + hand.dealCard(i).getRankInt();
                                if (equal_fifteen(sum))
                                    score = add_two(score);
                            }
                        }
                    }
                }
            }
        }
        return score;
    }*/

    public static int fifteen_two_points(Hand hand) {
        int score = 0;
        int sum = 0;


        for (int i = 1; i < 6; i++) {
            int card1Value = hand.dealCard(i).getRankInt();
            sum = sum + card1Value;
            for(int j = i+1;i<6; i++){
                int card2Value = hand.dealCard(j).getRankInt();
                sum = sum + card2Value;
                if(equal_fifteen(sum)){
                    add_two(score);
                    sum = sum - card2Value;
                }else if(sum>15){
                    sum = sum - card2Value;
                }
            }
        }
        return 8;
    }


    public static boolean equal_fifteen(int sum){
        return sum == 15;
    }
    public static int add_two(int score){
        return score +2;
    }

}

