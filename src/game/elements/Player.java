package game.elements;

import java.util.Vector;

import static game.elements.Constants.PLAYER_LEVEL_UP_STATE;

public abstract class Player implements Target {
    protected String heroClass;
    private int id;
    protected int level;
    private int xp;
    private int health;
    private int[] position;
    protected Vector<Ability> abilities;
    private Vector<Integer[]> effects;
    private boolean incapacitated;
    private float damageModifier;

    public Player(final int positionX, final int positionY) {
        level = 0;
        xp = 0;
        position = new int[2];
        position[0] = positionX;
        position[1] = positionY;
        abilities = new Vector<>();
        effects = new Vector<>();
        incapacitated = false;
        damageModifier = 1;
    }

    final String getHeroClass() {
        return heroClass;
    }

    final int getLevel() {
        return level;
    }

    final int getXP() {
        return xp;
    }

    final void gainXP(final int exp) {
        xp += exp;
    }

    public final void levelUp() {

        while (xp >= XPTable.getInstance().getTable().get(level + 1)) {
            level++;
            resetHP();

            Subject.getInstance().setState(PLAYER_LEVEL_UP_STATE, heroClass, null, id, level);

            for (Ability ability : abilities) {
                ability.levelUp();
            }
        }

    }

    public final void takeDamage(final int damage) {
        health -= damage;
    }

    final int getHP() {
        return health;
    }

    final void setHP(final int HP) {
        health = HP;
    }

    final void gainHP(final int HP) {
        health += HP;
    }

    final void resetHP() {
        health = HPTable.getInstance().getTable().get(heroClass + "Start")
                + level * HPTable.getInstance().getTable().get(heroClass + "Level");
    }

    final void move(final String direction) {
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

    public final int[] getPosition() {
        return position;
    }

    final boolean equalsPosition(final int[] playerPosition) {
        return position[0] == playerPosition[0] && position[1] == playerPosition[1];
    }

    final Vector<Ability> getAbilities() {
        return abilities;
    }

    public void accept(final Ability ability) {
        ability.target(this);
    }

    final void addEffect(final int effect, final int duration, final int damage) {

        for (Integer[] integers : effects) {
            if (integers[0] == effect && integers[1] < duration) {
                integers[1] = duration;
                integers[2] = damage;
                return;
            }
        }

        effects.add(new Integer[]{effect, duration, damage});
    }

    final void resolveEffects() {
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

    final void setIncapacitated(final boolean capacity) {
        incapacitated = capacity;
    }

    final boolean getIncapacitated() {
        return incapacitated;
    }

    public final void setDamageModifier(final float damageModifier) {
        this.damageModifier = damageModifier;
    }

    public final void addDamageModifier(final float damageModifier) {
        this.damageModifier += damageModifier;
    }

    public Context getContext() {
        return null;
    }

    public final void setAbilityModifier() {
        for (Ability ability: abilities) {
            ability.setDamageModifier(damageModifier);
        }
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }
}
