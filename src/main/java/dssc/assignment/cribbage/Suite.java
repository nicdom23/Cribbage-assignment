package dssc.assignment.cribbage;

public enum Suite {
    CLUB,
    DIAMOND,
    HEART,
    SPADE,
    INVALID;

    public char asChar(){return name().charAt(0);}
}
