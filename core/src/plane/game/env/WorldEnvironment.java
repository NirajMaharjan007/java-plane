package plane.game.env;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import plane.game.entities.*;

public class WorldEnvironment {
    SpriteBatch spriteBatch;

    Player player;
    Enemy enemy;

    public void create() {
        spriteBatch = new SpriteBatch();
        player = new Player(spriteBatch);
        enemy = new Enemy(spriteBatch);

        player.create();
        enemy.create();
    }

    public void render() {
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Rectangle player_rect = new Rectangle(player.getX(), player.getY(), 60, 30);
        Rectangle enemy_rect = new Rectangle(enemy.getX(), enemy.getY(), 60, 20);

        boolean isOverplayed = enemy_rect.overlaps(player_rect);

        spriteBatch.begin();

        if (!isOverplayed) {
            player.render();
            enemy.render();
        } else {
            player.renderExplosion();
        }

        spriteBatch.end();

        System.out.println(isOverplayed);
    }

    public void dispose() {
        // player.dispose();
        // enemy.dispose();
        spriteBatch.dispose();
    }

}
