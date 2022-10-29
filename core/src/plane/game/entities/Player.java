package plane.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
// import com.badlogic.gdx.audio.Sound;

import plane.game.entities.animation.player.*;
import plane.game.entities.sound.MissileSound;

public class Player {
    Vector2 position = new Vector2(80, 80);

    SpriteBatch batch;

    MissileSound sound;

    PlayerIdle idle;
    PlayerMove move;

    Explosion explosion;

    float speed = 5.8f;

    public static boolean isShoot = false;
    // public static boolean isExploded = false;

    public Player(SpriteBatch batch) {
        this.batch = batch;
    }

    private void borderCheck() {
        if (position.x > Gdx.graphics.getWidth() - 150) {
            position.x = Gdx.graphics.getWidth() - 150;
        } else if (position.x < -50) {
            position.x = -50;
        } else if (position.y > Gdx.graphics.getHeight() - 80) {
            position.y = Gdx.graphics.getHeight() - 80;
        } else if (position.y < 0) {
            position.y = 0;
        }
    }

    private void update() {
        borderCheck();

        if (Gdx.input.isKeyPressed(Keys.UP)) {
            position.y += speed;
        }

        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            position.y -= speed;
        }

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            position.x -= speed;
        }

        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            position.x += (speed + 7.5f);
        }

        if (Gdx.input.isKeyPressed(Keys.RIGHT) && Gdx.input.isKeyPressed(Keys.UP)) {
            position.y += (speed + 7.5f);
        }

        if (Gdx.input.isKeyPressed(Keys.RIGHT) && Gdx.input.isKeyPressed(Keys.UP)) {
            position.y -= (speed + 7.5f);
        }

        // if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
        // }
    }

    public void create() {
        move = new PlayerMove(position, batch);
        idle = new PlayerIdle(position, batch);
        explosion = new Explosion(position, batch);

        sound = new MissileSound();

        // sound.create();
        idle.create();
        move.create();
        explosion.create();
    }

    public void render() {
        update();

        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            move.render();
        } else {
            idle.render();
        }

    }

    public void renderExplosion() {
        explosion.render();
    }

    public void dispose() {
        idle.dispose();
        move.dispose();
        sound.dispose();
        batch.dispose();
        explosion.dispose();
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }
}
