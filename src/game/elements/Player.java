package game.elements;

import java.util.Vector;

public abstract class Player implements Target {
    protected String heroClass;
    protected int level;
    private int xp;
    private int health;
    private int[] position;
    protected Vector<Ability> abilities;
    private Vector<Integer[]> effects;
    private boolean incapacitated;

    public Player(final int positionX, final int positionY) {
        level = 0;
        xp = 0;
        position = new int[2];
        position[0] = positionX;
        position[1] = positionY;
        abilities = new Vector<>();
        effects = new Vector<>();
        incapacitated = false;
    }

    /**
     *
     * @return
     */
    String getHeroClass() {
        return heroClass;
    }

    int getLevel() {
        return level;
    }

    int getXP() {
        return xp;
    }

    void gainXP(final int exp) {
        xp += exp;
    }

    public void levelUp() {
        while (xp >= XPTable.getInstance().getTable().get(level + 1)) {
            level++;
            resetHP();

            for (Ability ability : abilities) {
                ability.levelUp();
            }
        }
    }

    public void takeDamage(final int damage) {
        health -= damage;
    }

    int getHP() {
        return health;
    }

    void resetHP() {
        health = HPTable.getInstance().getTable().get(heroClass + "Start")
                + level * HPTable.getInstance().getTable().get(heroClass + "Level");
    }

    void move(final String direction) {
        switch (direction) {
            case "U":
                position[0]--;
                break;
            case "D":
                position[0]++;
                break;
            case "L":
                position[1]--;
                break;
            case "R":
                position[1]++;
                break;
            default:
                break;
        }
    }

    public int[] getPosition() {
        return position;
    }

    boolean equalsPosition(final int[] playerPosition) {
        return position[0] == playerPosition[0] && position[1] == playerPosition[1];
    }

    Vector<Ability> getAbilities() {
        return abilities;
    }

    public void accept(Ability ability) {
        ability.target(this);
    }

    void addEffect(final int effect, final int duration, final int damage) {

        for (Integer[] integers : effects) {
            if (integers[0] == effect && integers[1] < duration) {
                integers[1] = duration;
                integers[2] = damage;
                return;
            }
        }

        effects.add(new Integer[]{effect, duration, damage});
    }

    void resolveEffects() {
        for (int i = 0; i < effects.size(); i++) {
            effects.get(i)[1]--;

            if (effects.get(i)[0] == 0 || effects.get(i)[0] == 2) {
                health -= effects.get(i)[2];

                if (health <= 0) {
                    incapacitated = true;
                }
            } else {
                incapacitated = true;
            }

            if (effects.get(i)[1] == 0) {
                effects.remove(i);
                i--;
            }
        }
    }

    void setIncapacitated(final boolean capacity) {
        incapacitated = capacity;
    }

    boolean getIncapacitated() {
        return incapacitated;
    }
}
