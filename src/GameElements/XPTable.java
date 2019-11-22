package GameElements;

import java.util.HashMap;

public class XPTable {
    private static XPTable instance = null;
    private HashMap<String, Integer> table;

    private XPTable() {
        table.put("nivel1", 250);
        table.put("nivel2", 300);
        table.put("nivel3", 350);
        table.put("nivel4", 400);
    }

    public XPTable getInstance() {
        if (instance == null) {
            instance = new XPTable();
        }

        return instance;
    }

    private HashMap<String, Integer> getTable() {
        return table;
    }
}
