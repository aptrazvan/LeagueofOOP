package main;

public class Pair<P, X> {

    private final P first;
    private final X second;

    public Pair(P first, X second) {
        this.first = first;
        this.second = second;
    }

    public P getKey() { return first; }
    public X getValue() { return second; }
}
