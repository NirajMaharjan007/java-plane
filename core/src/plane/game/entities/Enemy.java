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

    public Enemy(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void create() {
        move = new EnemyMove(position, spriteBatch);

        move.create();
    }

    private void update() {
        if (position.x < Gdx.graphics.getWidth() - 60) {
            position.x += 8.5f;
        }
    }

    public void render() {
        update();

        // spriteBatch.begin();
        move.render();
        // spriteBatch.end();
    }

    public void dispose() {
        move.dispose();
        spriteBatch.dispose();
    }
}
