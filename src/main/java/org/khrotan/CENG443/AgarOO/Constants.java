package org.khrotan.CENG443.AgarOO;

/**
 * Created by Arda Guney on 27.11.2015 21:35.
 * ---
 */
public class Constants
{
    //BASIC CELL
    public static final double BASIC_CELL_INITIAL_SPEED = 5;
    public static final double BASIC_CELL_INITIAL_MASS = 60;
    //WINDOW
    public static final int WINDOWS_WIDTH = 1024;
    public static final int WINDOWS_HEIGHT = 768;
    public static final int LEFT_PANEL_WIDTH = 256;
    //THREAD SLEEP RATE
    public static final long THREAD_SLEEP_RATE = 50;
    //SCREEN
    public static final int SUGARS_ON_SCREEN = 15;
    public static final int ORGANISMS_ON_SCREEN = 15;
    public static final int INITIAL_CELLS_ON_SCREEN = 5;
    public static final int FOOD_ON_SCREEN = SUGARS_ON_SCREEN + ORGANISMS_ON_SCREEN;
    //ORGANISM
    public static final double ORGANISM_INITIAL_SPEED = 1;
    public static final int ORGANISM_RADIUS_LOW = 8;
    public static final int ORGANISM_RADIUS_HIGH = 12;

    //SUGAR
    public static final int SUGAR_MASS_LOW = 4;
    public static final int SUGAR_MASS_HIGH = 4;

    //RANDOM
    public static final float TRANSPARENCY = 0.3f;
    public static final int STEP_NUMBER_MAX = 90;

    //EVOLVE
    public static final int BASICCELL_TO_ROAMER_MASS = 85;
    public static final int ROAMER_TO_EVADER_MASS = 120;
    public static final int EVADER_TO_HUNTER_MASS = 160;
}
