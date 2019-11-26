package game.elements;

import java.util.HashMap;

import static game.elements.Constants.KNIGHT_LEVEL_HP_BONUS;
import static game.elements.Constants.KNIGHT_MAX_HP;
import static game.elements.Constants.PYROMANCER_LEVEL_HP_BONUS;
import static game.elements.Constants.PYROMANCER_MAX_HP;
import static game.elements.Constants.ROGUE_LEVEL_HP_BONUS;
import static game.elements.Constants.ROGUE_MAX_HP;
import static game.elements.Constants.WIZARD_LEVEL_HP_BONUS;
import static game.elements.Constants.WIZARD_MAX_HP;

public final class HPTable {
    private static HPTable instance = null;
    private HashMap<String, Integer> table;

    private HPTable() {
        table = new HashMap<>();
        table.put("PyromancerStart", PYROMANCER_MAX_HP);
        table.put("PyromancerLevel", PYROMANCER_LEVEL_HP_BONUS);
        table.put("KnightStart", KNIGHT_MAX_HP);
        table.put("KnightLevel", KNIGHT_LEVEL_HP_BONUS);
        table.put("WizardStart", WIZARD_MAX_HP);
        table.put("WizardLevel", WIZARD_LEVEL_HP_BONUS);
        table.put("RogueStart", ROGUE_MAX_HP);
        table.put("RogueLevel", ROGUE_LEVEL_HP_BONUS);
    }

    public static HPTable getInstance() {
        if (instance == null) {
            instance = new HPTable();
        }

        return instance;
    }

    public HashMap<String, Integer> getTable() {
        return table;
    }
}
