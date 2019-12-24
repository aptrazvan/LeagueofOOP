package game.elements;

public class Subject {
    private static Subject instance = null;
    private int state;

    public static Subject getInstance() {
        if (instance == null) {
            instance = new Subject();
        }

        return instance;
    }

    public final int getState() {
        return state;
    }

    public final void setState(final int state, final String firstName, final String secondName,
                         final int firstPosition, final int secondPosition) {
        this.state = state;

        notifyObserver(state, firstName, secondName, firstPosition, secondPosition);
    }

    public final void notifyObserver(final int state, final String firstName,
                                     final String secondName, final int firstPosition,
                                     final int secondPosition) {
        TheGreatWizard.getInstance().update(state, firstName,
                secondName, firstPosition, secondPosition);
    }
}
