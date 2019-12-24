package game.elements;

public abstract class Observer {
    public abstract void update(int state, String firstName, String secondName,
                                int firstPosition, int secondPosition);
}
