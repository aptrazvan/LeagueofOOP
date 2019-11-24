package GameElements;

import java.util.Vector;

public abstract class Player implements Target{
    protected String heroClass;
    protected int level;
    protected int xp;
    protected int health;
    protected int[] position;
    Vector<Ability> abilities;
    protected boolean incapacitated;

    public Player(int positionX, int positionY) {
        level = 0;
        xp = 0;
        position = new int[2];
        position[0] = positionX;
        position[1] = positionY;
        abilities = new Vector<>();
        incapacitated = false;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public int getLevel() {
        return level;
    }

    public int getXP () { return xp; }

    public void gainXP(int xp) {
        this.xp += xp;
    }

    public void levelUp() {
        if (xp > XPTable.getInstance().getTable().get(level + 1)) {
            level++;
            resetHP();

            for (int i = 0; i < abilities.size(); i++) {
                abilities.get(i).levelUp();
            }
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int getHP() {
        return health;
    }

    public void resetHP() {
        health = HPTable.getInstance().getTable().get(heroClass + "Start") + level * HPTable.getInstance().getTable().get(heroClass + "Level");
    }

    public void move(String direction) {
        if (direction.equals("U")) {
            position[0]++;
        }
        else if (direction.equals("D")) {
            position[0]--;
        }
        else if (direction.equals("L")) {
            position[1]--;
        }
        else if (direction.equals("R")) {
            position[1]++;
        }
    }

    public int[] getPosition() {
        return position;
    }

    public boolean equalsPosition(int[] position) {
        if(this.position[0] == position[0] && this.position[1] == position[1]) {
            return true;
        }

        return false;
    }

    public Vector<Ability> getAbilities() {
        return abilities;
    }

    public void accept(Ability ability) {
        ability.target(this);
    }

    public void setIncapacitated(boolean incapacitated) {
        this.incapacitated = incapacitated;
    }

    public boolean getIncapacitated() {
        return incapacitated;
    }
}
