package GameElements;

public class Wizard extends Player {
    private int damageReceived;

    public Wizard(int positionX, int positionY) {
        super(positionX, positionY);
        heroClass = "Wizard";
        resetHP();
        abilities.add(new Drain());
        abilities.add(new Deflect());
        damageReceived = 0;
    }

    public void accept(Ability ability) {
        ability.target(this);
    }

    public int getMaxHP() {
        return 400 + 30 * level;
    }

    public int getDamageReceived() {
        return damageReceived;
    }

    public void setDamageReceived(int damageReceived) {
        this.damageReceived = damageReceived;
    }

    public void addDamageReceived(int damageReceived) {
        this.damageReceived += damageReceived;
    }
}
