package game.elements;

public class AngelFactory {

    public Angel getAngel(String angel, int round, int positionX, int positionY) {
        switch (angel) {
            case "DamageAngel":
                return new DamageAngel(round, positionX, positionY);
            case "DarkAngel":
                return new DarkAngel(round, positionX, positionY);
            case "Dracula":
                return new Dracula(round, positionX, positionY);
            case "GoodBoy":
                return new GoodBoy(round, positionX, positionY);
            case "LevelUpAngel":
                return new LevelUpAngel(round, positionX, positionY);
            case "LifeGiver":
                return new LifeGiver(round, positionX, positionY);
            case "SmallAngel":
                return new SmallAngel(round, positionX, positionY);
            case "Spawner":
                return new Spawner(round, positionX, positionY);
            case "TheDoomer":
                return new TheDoomer(round, positionX, positionY);
            case "XPAngel":
                return new XPAngel(round, positionX, positionY);
            default:
                break;
        }

        return null;
    }

}
