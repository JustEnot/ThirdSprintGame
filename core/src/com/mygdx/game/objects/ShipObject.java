package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import static com.mygdx.game.GameSettings.SHIP_FORCE_RATIO;

import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.GameSettings;

public class ShipObject extends GameObject {
    long lastShotTime;
    public int livesLeft;
    public ShipObject(int x, int y, int width, int height, String texturePath, World world) {
        super(texturePath, x, y, width, height, GameSettings.SHIP_BIT, world);
        body.setLinearDamping(10);
        livesLeft = 3;
    }

    public void move(Vector3 vector3) {
        body.applyForceToCenter(new Vector2(
                        (vector3.x - getX()) * GameSettings.SHIP_FORCE_RATIO,
                        (vector3.y - getY()) * GameSettings.SHIP_FORCE_RATIO),
                true
        );
    }

    private void putInFrame() {
        if (getY() > (GameSettings.SCREEN_HEIGHT / 2f - height / 2f)) {
            setY((int) (GameSettings.SCREEN_HEIGHT / 2f - height / 2f));
        }
        if (getY() <= (height / 2f)) {
            setY(height / 2);
        }
        if (getX() < (-width / 2f)) {
            setX(GameSettings.SCREEN_WIDTH);
        }
        if (getX() > (GameSettings.SCREEN_WIDTH + width / 2f)) {
            setX(0);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        putInFrame();
        super.draw(batch);
    }

    @Override
    public void hit() {
        livesLeft -= 1;
    }

    public boolean isAlive() {
        return livesLeft > 0;
    }

    public boolean needToShoot() {
        if (TimeUtils.millis() - lastShotTime >= GameSettings.SHOOTING_COOL_DOWN) {
            lastShotTime = TimeUtils.millis();
            return true;
        }
        return false;
    }

    public int getLiveLeft() {
        return livesLeft;
    }
}
