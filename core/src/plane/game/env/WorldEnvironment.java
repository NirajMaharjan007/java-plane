package plane.game.env;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import plane.game.entities.Player;
import plane.game.entities.Enemy;

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

        spriteBatch.begin();
        player.render();
        enemy.render();
        spriteBatch.end();

    }

    public void dispose() {
        // player.dispose();
        // enemy.dispose();
        spriteBatch.dispose();
    }

}
