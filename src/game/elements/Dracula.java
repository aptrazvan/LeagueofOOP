package game.elements;

public class Dracula extends Angel {
    public Dracula(int round, int positionX, int positionY) {
        super(round, positionX, positionY);
    }

    @Override
    public void interact(Player player) {
        float modifier = 0;
        int healthModifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = -0.2f;
                healthModifier = 60;
                break;
            case "Pyromancer":
                modifier = -0.3f;
                healthModifier = 40;
                break;
            case "Rogue":
                modifier = -0.1f;
                healthModifier = 35;
                break;
            case "Wizard":
                modifier = -0.4f;
                healthModifier = 20;
                break;
            default:
                break;
        }

        player.addDamageModifier(modifier);
        player.takeDamage(healthModifier);
    }
}
