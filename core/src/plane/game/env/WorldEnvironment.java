package plane.game.env;

import plane.game.entities.Player;

public class WorldEnvironment {
    Player player = new Player();

    public void create() {
        player.create();
    }

    public void render() {
        player.render();
    }

    public void dispose() {
        player.dispose();
    }

}
