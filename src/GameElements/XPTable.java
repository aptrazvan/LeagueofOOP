package GameElements;

import java.util.HashMap;

public class XPTable {
    private static XPTable instance = null;
    private HashMap<Integer, Integer> table;

    private XPTable() {
        table = new HashMap<>();

        for (int i = 1; i < 21; i++) {
            table.put(i, 200 + 50 * i);
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
