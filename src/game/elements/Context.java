package game.elements;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Player player) {
        strategy.setStats(player);
    }
}
