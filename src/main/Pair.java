package main;

public final class Pair<P, X> {

    private final P first;
    private final X second;

    public Pair(final P first, final X second) {
        this.first = first;
        this.second = second;
    }

    public P getKey() {
        return first;
    }
    public X getValue() {
        return second;
    }
}
