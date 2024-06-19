package com.mygdx.game;

public class GameSettings {

    public static final int SCREEN_WIDTH = 720;
    public static final int SCREEN_HEIGHT = 1280;
    public static final float SCALE = 0.05f;

    public static float SHIP_FORCE_RATIO = 10;
    public static final int SHIP_WIDTH = 150;
    public static final int SHIP_HEIGHT = 150;

    public static final int TRASH_WIDTH = 140;
    public static final int TRASH_HEIGHT = 100;
    public static float TRASH_VELOCITY = 20;
    public static long STARTING_TRASH_APPEARANCE_COOL_DOWN = 2000;


    public static final float STEP_TIME = 1f / 60;
    public static final int VELOCITY_ITERATIONS = 6;
    public static final int POSITION_ITERATIONS = 6;

    public static final int BULLET_WIDTH = 15;
    public static final int BULLET_HEIGHT = 45;
    public static int BULLET_VELOCITY = 200;
    public static int SHOOTING_COOL_DOWN = 1000;

    public static final short TRASH_BIT = 2;
    public static final short HEAL_BIT = 2;
    public static final short SHIP_BIT = 4;
    public static final short BULLET_BIT = 8;
}