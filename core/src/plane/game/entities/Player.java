package plane.game.entities;

// import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import plane.game.entities.animation.player.*;

public class Player {
    Vector2 position = new Vector2(80, 80);

    PlayerIdle idle;
    PlayerMove move;

    public void create() {
        move = new PlayerMove(position);
        idle = new PlayerIdle(position);

        idle.create();
        move.create();
    }

    public void render() {
        // idle.render();
        move.render();
    }

    public void dispose() {
        idle.dispose();
        move.dispose();
    }
}
