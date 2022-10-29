package plane.game.env;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.*;

import plane.game.entities.*;

public class WorldEnvironment {
    SpriteBatch spriteBatch;

    Player player;
    Enemy enemy;

    BitmapFont font;

    public void create() {
        spriteBatch = new SpriteBatch();
        player = new Player(spriteBatch);
        enemy = new Enemy(spriteBatch);

        font = new BitmapFont();

        player.create();
        enemy.create();
    }

    public void render() {
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Rectangle player_rect = new Rectangle(player.getX(), player.getY(), 80, 50);
        Rectangle enemy_rect = new Rectangle(enemy.getX(), enemy.getY(), 60, 20);

        boolean isOverplayed = enemy_rect.overlaps(player_rect);

        spriteBatch.begin();

        if (!isOverplayed) {
            player.render();
            enemy.render();
        } else {
            if (player.getStateTime() < 2.8f) {
                player.renderExplosion();
            } else {
                float width = Gdx.graphics.getWidth();
                float height = Gdx.graphics.getHeight();

                font.setColor(1.0f, 0.0f, 0.0f, 1.0f);
                font.draw(spriteBatch, "GAME OVER!", width / 2.2f, height / 2.0f);
            }
        }

        spriteBatch.end();

        // System.out.println(isOverplayed);
    }

    public void dispose() {
        // player.dispose();
        // enemy.dispose();
        spriteBatch.dispose();
    }

}
