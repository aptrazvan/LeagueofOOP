package game.elements;

import java.util.HashMap;

import static game.elements.Constants.FIRST_LEVEL_XP;
import static game.elements.Constants.MAX_LEVEL;
import static game.elements.Constants.NEXT_LEVEL_XP;

public final class XPTable {
    private static XPTable instance = null;
    private HashMap<Integer, Integer> table;

    private XPTable() {
        table = new HashMap<>();

        for (int i = 1; i < MAX_LEVEL; i++) {
            table.put(i, FIRST_LEVEL_XP + NEXT_LEVEL_XP * i);
        }

    }

    public static XPTable getInstance() {
        if (instance == null) {
            instance = new XPTable();
        }

        return instance;
    }

    public HashMap<Integer, Integer> getTable() {
        return table;
    }
}
