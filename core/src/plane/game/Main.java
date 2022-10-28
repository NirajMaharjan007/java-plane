package plane.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ScreenUtils;

import plane.game.env.WorldEnvironment;

public class Main extends ApplicationAdapter {
	WorldEnvironment env = new WorldEnvironment();

	@Override
	public void create() {
		env.create();
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		env.render();
	}

	@Override
	public void dispose() {
		env.dispose();
	}
}
