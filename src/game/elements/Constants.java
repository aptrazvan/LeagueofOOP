package game.elements;

public final class Constants {
    public static final int BACKSTAB_BASE_DAMAGE = 200;
    public static final int BACKSTAB_BOOST_DAMAGE = 20;
    public static final float BACKSTAB_PYROMANCER_MODIFIER = 125.0f / 100;
    public static final float BACKSTAB_KNIGHT_MODIFIER = 90.0f / 100;
    public static final float BACKSTAB_WIZARD_MODIFIER = 125.0f / 100;
    public static final float BACKSTAB_ROGUE_MODIFIER = 120.0f / 100;
    public static final float WOODS_BOOST = 1.15f;
    public static final float CRITICAL_BOOST = 1.5f;
    public static final int MULTIPLIER = 1000;
    public static final float CRITICAL_HIT_NUMBER = 3;
    public static final int PERCENT = 100;
    public static final float DEFLECT_BASE_DAMAGE = 35.0f;
    public static final float DEFLECT_PYROMANCER_MODIFIER = 1.3f;
    public static final float DEFLECT_KNIGHT_MODIFIER = 140.0f / 100;
    public static final float DEFLECT_ROGUE_MODIFIER = 120.0f / 100;
    public static final float MAX_DEFLECT = 70.0f;
    public static final float DESERT_BOOST = 110.0f / 100;
    public static final float DRAIN_BASE_DAMAGE = 20.0f;
    public static final float COEFFICIENT1 = 0.3f;
    public static final int DRAIN_BOOST_DAMAGE = 5;
    public static final float DRAIN_PYROMANCER_MODIFIER = 90.0f / 100;
    public static final float DRAIN_KNIGHT_MODIFIER = 120.0f / 100;
    public static final float DRAIN_WIZARD_MODIFIER = 105.0f / 100;
    public static final float DRAIN_ROGUE_MODIFIER = 80.0f / 100;
    public static final float EXECUTE_BASE_DAMAGE1 = 20.0f;
    public static final float EXECUTE_BASE_DAMAGE2 = 200;
    public static final int EXECUTE_BOOST_DAMAGE = 30;
    public static final float MAX_EXECUTE = 40.0f;
    public static final float EXECUTE_PYROMANCER_MODIFIER = 110.0f / 100;
    public static final float EXECUTE_KNIGHT_MODIFIER = 100.0f / 100;
    public static final float EXECUTE_WIZARD_MODIFIER = 80.0f / 100;
    public static final float EXECUTE_ROGUE_MODIFIER = 115.0f / 100;
    public static final float LAND_BOOST = 115.0f / 100;
    public static final float FIREBLAST_BASE_DAMAGE = 350;
    public static final int FIREBLAST_BOOST_DAMAGE = 50;
    public static final float FIREBLAST_PYROMANCER_MODIFIER = 90.0f / 100;
    public static final float FIREBLAST_KNIGHT_MODIFIER = 120.0f / 100;
    public static final float FIREBLAST_WIZARD_MODIFIER = 105.0f / 100;
    public static final float FIREBLAST_ROGUE_MODIFIER = 80.0f / 100;
    public static final float VOLCANO_BOOST = 125.0f / 100;
    public static final float IGNITE_BASE_DAMAGE = 150;
    public static final int IGNITE_BOOST_DAMAGE = 20;
    public static final float IGNITE_EFFECT_DAMAGE = 50;
    public static final float IGNITE_EFFECT_BOOST = 30;
    public static final int IGNITE_DURATION = 2;
    public static final float IGNITE_PYROMANCER_MODIFIER = 90.0f / 100;
    public static final float IGNITE_KNIGHT_MODIFIER = 120.0f / 100;
    public static final float IGNITE_WIZARD_MODIFIER = 105.0f / 100;
    public static final float IGNITE_ROGUE_MODIFIER = 80.0f / 100;
    public static final float PARALYSIS_BASE_DAMAGE = 40;
    public static final int PARALYSIS_BOOST_DAMAGE = 10;
    public static final int PARALYSIS_DURATION = 3;
    public static final int PARALYSIS_DURATION_WOODS = 6;
    public static final float PARALYSIS_PYROMANCER_MODIFIER = 120.0f / 100;
    public static final float PARALYSIS_KNIGHT_MODIFIER = 80.0f / 100;
    public static final float PARALYSIS_WIZARD_MODIFIER = 125.0f / 100;
    public static final float PARALYSIS_ROGUE_MODIFIER = 90.0f / 100;
    public static final float SLAM_BASE_DAMAGE = 100;
    public static final int SLAM_BOOST_DAMAGE = 40;
    public static final float SLAM_PYROMANCER_MODIFIER = 90.0f / 100;
    public static final float SLAM_KNIGHT_MODIFIER = 120.0f / 100;
    public static final float SLAM_WIZARD_MODIFIER = 105.0f / 100;
    public static final float SLAM_ROGUE_MODIFIER = 80.0f / 100;
    public static final int PYROMANCER_MAX_HP = 500;
    public static final int KNIGHT_MAX_HP = 900;
    public static final int WIZARD_MAX_HP = 400;
    public static final int ROGUE_MAX_HP = 600;
    public static final int PYROMANCER_LEVEL_HP_BONUS = 50;
    public static final int KNIGHT_LEVEL_HP_BONUS = 80;
    public static final int WIZARD_LEVEL_HP_BONUS = 30;
    public static final int ROGUE_LEVEL_HP_BONUS = 40;
    public static final int FIRST_LEVEL_XP = 200;
    public static final int NEXT_LEVEL_XP = 50;
    public static final int MAX_LEVEL = 21;
    public static final int COEFFICIENT2 = 40;
    public static final int BASE_XP = 200;
    public static final float PYROMANCER_FIRST_DAMAGE_MODIFIER = (float) 1 / 4;
    public static final float PYROMANCER_SECOND_DAMAGE_MODIFIER = (float) 1 / 3;
    public static final float PYROMANCER_FIRST_HEALTH_MODIFIER = 0.7f;
    public static final float PYROMANCER_SECOND_HEALTH_MODIFIER = -0.3f;
    public static final float KNIGHT_FIRST_DAMAGE_MODIFIER = (float) 1 / 5;
    public static final float KNIGHT_SECOND_DAMAGE_MODIFIER = (float) 1 / 4;
    public static final float KNIGHT_FIRST_HEALTH_MODIFIER = 0.5f;
    public static final float KNIGHT_SECOND_HEALTH_MODIFIER = -0.2f;
    public static final float WIZARD_FIRST_DAMAGE_MODIFIER = (float) 1 / 10;
    public static final float WIZARD_SECOND_DAMAGE_MODIFIER = (float) 1 / 5;
    public static final float WIZARD_FIRST_HEALTH_MODIFIER = 0.6f;
    public static final float WIZARD_SECOND_HEALTH_MODIFIER = -0.2f;
    public static final float ROGUE_FIRST_DAMAGE_MODIFIER = (float) 1 / 7;
    public static final float ROGUE_SECOND_DAMAGE_MODIFIER = (float) 1 / 2;
    public static final float ROGUE_FIRST_HEALTH_MODIFIER = 0.4f;
    public static final float ROGUE_SECOND_HEALTH_MODIFIER = -0.1f;


    private Constants() {

    }


}
