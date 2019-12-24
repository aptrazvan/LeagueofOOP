package game.elements;

public class Context {
    private Strategy strategy;

    public Context(final Strategy strategy) {
        this.strategy = strategy;
    }

    public final void executeStrategy(final Player player) {
        strategy.setStats(player);
    }
}
