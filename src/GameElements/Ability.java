package GameElements;

public interface Ability {
    public void target(Player player);
    public void target(Pyromancer pyromancer);
    public void target(Knight knight);
    public void target(Wizard wizard);
    public void target(Rogue rogue);
}
