package game.elements;

public interface Ability {
    void target(Player player);
    void target(Pyromancer pyromancer);
    void target(Knight knight);
    void target(Wizard wizard);
    void target(Rogue rogue);
    void levelUp();
    void setBoostTerrain(Player player);
}
