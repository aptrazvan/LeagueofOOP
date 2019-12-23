package game.elements;

public abstract class Angel {
    private int[] position;
    private int round;

    public Angel(final int round, final int positionX, final int positionY) {
        this.round = round;
        position = new int[2];
        position[0] = positionX;
        position[1] = positionY;
    }

    public final int[] getPosition() {
        return position;
    }

    final boolean equalsPosition(final int[] playerPosition) {
        return position[0] == playerPosition[0] && position[1] == playerPosition[1];
    }

    public void interact(Player player) {

    }
}
