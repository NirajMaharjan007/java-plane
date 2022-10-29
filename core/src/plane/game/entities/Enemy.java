package plane.game.entities;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;

import plane.game.entities.animation.enemy.*;

public class Enemy {
    Vector2 position = new Vector2(20, 20);
    SpriteBatch spriteBatch;

    Random random = new Random();

    EnemyMove move;
    EnemyInvertMove invertMove;

    private float speed = 8.68f;
    private boolean isRight = true;

    public Enemy(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void create() {
        move = new EnemyMove(position, spriteBatch);
        invertMove = new EnemyInvertMove(position, spriteBatch);

        move.create();
        invertMove.create();
    }

    private void update() {
        position.x += speed;
        if (position.x > Gdx.graphics.getWidth() || position.x < -180) {
            position.y += 20.5f;
            speed = -speed;
        }

        if (position.x > Gdx.graphics.getWidth())
            isRight = false;

        else if (position.x < -180)
            isRight = true;
    }

    public void render() {
        update();

        // spriteBatch.begin();
        if (isRight)
            move.render();

        else
            invertMove.render();
        // spriteBatch.end();
    }

    public void dispose() {
        move.dispose();
        invertMove.dispose();
        spriteBatch.dispose();
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }
}
