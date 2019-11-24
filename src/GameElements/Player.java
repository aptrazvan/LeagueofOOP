package GameElements;

import java.util.Vector;

public abstract class Player implements Target{
    protected String heroClass;
    protected int level;
    protected int xp;
    protected int health;
    protected int[] position;

    public Player(int positionX, int positionY) {
        level = 0;
        xp = 0;
        resetHP();
        position = new int[2];
        position[0] = positionX;
        position[1] = positionY;
    }

    public int getLevel() {
        return level;
    }

    public void gainXP(int xp) {
        this.xp += xp;
    }

    public void levelUp() {
        if (xp > XPTable.getInstance().getTable().get(level + 1)) {
            level++;
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void resetHP() {
        health = HPTable.getInstance().getTable().get(heroClass + "Start") + level * HPTable.getInstance().getTable().get(heroClass + "Level");
    }

    public void move(String direction) {
        if (direction == "U") {
            position[1]++;
        }
        else if (direction == "D") {
            position[1]--;
        }
        else if (direction == "L") {
            position[0]--;
        }
        else if (direction == "R") {
            position[0]++;
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

    public void accept(Ability ability) {
        ability.target(this);
    }
}
