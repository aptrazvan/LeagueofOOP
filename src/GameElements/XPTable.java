package GameElements;

import java.util.HashMap;

public class XPTable {
    private static XPTable instance = null;
    private HashMap<Integer, Integer> table;

    private XPTable() {
        table = new HashMap<>();
        table.put(1, 250);
        table.put(2, 300);
        table.put(3, 350);
        table.put(4, 400);
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
