package main;

public class Triplet<P, X, Y> {

    private final P first;
    private final X second;
    private final Y third;

    public Triplet(P first, X second, Y third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public P getFirst() { return first; }
    public X getSecond() { return second; }
    public Y getThird() { return third; }
}
