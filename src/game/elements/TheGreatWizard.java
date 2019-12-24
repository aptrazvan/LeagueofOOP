package game.elements;

public class TheGreatWizard extends Observer {
    private static TheGreatWizard instance = null;

    public static TheGreatWizard getInstance() {
        if (instance == null) {
            instance = new TheGreatWizard();
        }

        return instance;
    }

    @Override
    public void update(int state, String firstName, String secondName,
                       int firstPosition, int secondPosition) {
        switch(state) {
            case 0:
                System.out.println("~~ Round " + firstPosition + " ~~");
                break;
            case 1:
                System.out.println("~~ Results ~~");
                break;
            case 2:
                System.out.println("Angel " + firstName + " was spawned at "
                        + firstPosition + " " + secondPosition);
                break;
            case 3:
                System.out.println(firstName + " helped " + secondName + " " + secondPosition);
                break;
            case 4:
                System.out.println(firstName + " hit " + secondName + " " + secondPosition);
                break;
            case 5:
                System.out.println("Player " + firstName + " " + firstPosition +
                        " was killed by " + secondName + " " + secondPosition);
                break;
            case 6:
                System.out.println(firstName + " " + firstPosition + " reached level " + secondPosition);
                break;
            default:
                break;
        }
    }
}
