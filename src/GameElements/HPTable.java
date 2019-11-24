package GameElements;

import java.util.HashMap;

public class HPTable {
    private static HPTable instance = null;
    private HashMap<String, Integer> table;

    private HPTable() {
        table = new HashMap<>();
        table.put("PyromancerStart", 500);
        table.put("PyromancerLevel", 50);
        table.put("KnightStart", 900);
        table.put("KnightLevel", 80);
        table.put("WizardStart", 400);
        table.put("WizardLevel", 30);
        table.put("RogueStart", 600);
        table.put("RogueLevel", 40);
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
