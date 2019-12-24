package game.elements;

public class Subject {
    private static Subject instance = null;
    private int state;
    private String firstName;
    private String secondName;
    private int firstPosition;
    private int secondPosition;

    public static Subject getInstance() {
        if (instance == null) {
            instance = new Subject();
        }

        return instance;
    }

    public int getState() {
        return state;
    }

    public void setState(int state, String firstName, String secondName,
                         int firstPosition, int secondPosition) {
        this.state = state;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        notifyObserver(state, firstName, secondName, firstPosition, secondPosition);
    }

    public void notifyObserver(int state, String firstName, String secondName,
                               int firstPosition, int secondPosition) {
        TheGreatWizard.getInstance().update(state, firstName, secondName, firstPosition, secondPosition);
    }
}
