package plane.game.entities;

// import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import plane.game.entities.animation.player.*;

public class Player {
    Vector2 position = new Vector2(80, 80);

    PlayerIdle idle;

    public void create() {
        idle = new PlayerIdle(position);
        idle.create();
    }

    public void render() {
        idle.render();
    }

    public void dispose() {
        idle.dispose();
    }
}
