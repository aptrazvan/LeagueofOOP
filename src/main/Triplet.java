package main;

public final class Triplet<P, X, Y> {

    private final P first;
    private final X second;
    private final Y third;

    public Triplet(final P first, final X second, final Y third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public P getFirst() {
        return first;
    }

    public X getSecond() {
        return second;
    }

    public Y getThird() {
        return third;
    }
}
