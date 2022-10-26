package plane.game.env;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import plane.game.entities.Player;

public class WorldEnvironment {
    Player player = new Player();

    public void create() {
        player.create();
    }

    public void render() {
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        player.render();
    }

    public void dispose() {
        player.dispose();
    }

}
