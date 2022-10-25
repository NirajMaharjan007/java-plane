package plane.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import plane.game.entities.animation.player.*;

public class Player {
    Vector2 position = new Vector2(80, 80);

    PlayerIdle idle;
    PlayerMove move;

    boolean isIdle = true;
    float speed = 5.8f;

    private void move() {
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
    }

    public void create() {
        move = new PlayerMove(position);
        idle = new PlayerIdle(position);

        idle.create();
        move.create();
    }

    public void render() {
        move();
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            // isIdle = false;
            move.render();
        } else {
            idle.render();
        }
    }

    public void dispose() {
        idle.dispose();
        move.dispose();
    }
}
