package game.elements;

public class SmallAngel extends Angel {
    public SmallAngel(int round, int positionX, int positionY) {
        super(round, positionX, positionY);
    }

    @Override
    public void interact(Player player) {
        float modifier = 0;
        int healthModifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = 0.1f;
                healthModifier = 10;
                break;
            case "Pyromancer":
                modifier = 0.15f;
                healthModifier = 15;
                break;
            case "Rogue":
                modifier = 0.05f;
                healthModifier = 20;
                break;
            case "Wizard":
                modifier = 0.1f;
                healthModifier = 25;
                break;
            default:
                break;
        }

        player.addDamageModifier(modifier);
        player.gainHP(healthModifier);
    }
}