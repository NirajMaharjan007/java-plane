package plane.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
// import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import plane.game.entities.animation.player.*;
import plane.game.entities.sound.MissileSound;

public class Player {
    MissileSound sound;

    Vector2 position = new Vector2(80, 80);
    SpriteBatch batch;

    private final int x = 10;
    Array<Missile> array = new Array<>(x);
    Missile missile;
    PlayerIdle idle;
    PlayerMove move;

    float speed = 5.8f;

    public static boolean isShoot = false;

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

        if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
            isShoot = true;
            sound.shotPlay();
        }
    }

    public void create() {
        batch = new SpriteBatch();
        move = new PlayerMove(position, batch);
        idle = new PlayerIdle(position, batch);
        missile = new Missile(position);
        sound = new MissileSound();

        missile.create();

        // sound.create();
        idle.create();
        move.create();
    }

    public void render() {
        update();

        // for (Missile missiles : missile)
        missile.update(position);

        batch.begin();
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            move.render();
        } else {
            idle.render();
        }

        if (isShoot) {
            missile.render();
            // sound.shotStop();
        }

        batch.end();

    }

    public void dispose() {
        idle.dispose();
        move.dispose();
        sound.dispose();
        missile.dispose();
        batch.dispose();
    }
}
