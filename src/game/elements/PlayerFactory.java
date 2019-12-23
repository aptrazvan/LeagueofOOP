package game.elements;

import main.Triplet;

public class PlayerFactory {

    public Player getPlayer(Triplet<String, Integer, Integer> stringIntegerIntegerTriplet) {
        switch (stringIntegerIntegerTriplet.getFirst()) {
            case "P":
                return new Pyromancer(stringIntegerIntegerTriplet.getSecond(),
                        stringIntegerIntegerTriplet.getThird());
            case "K":
                return new Knight(stringIntegerIntegerTriplet.getSecond(),
                        stringIntegerIntegerTriplet.getThird());
            case "W":
                return new Wizard(stringIntegerIntegerTriplet.getSecond(),
                        stringIntegerIntegerTriplet.getThird());
            case "R":
                return new Rogue(stringIntegerIntegerTriplet.getSecond(),
                        stringIntegerIntegerTriplet.getThird());
            default:
                break;
        }

        return null;
    }
}
