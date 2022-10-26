package plane.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;

public class Missile implements ApplicationListener {
    private static final int FRAME_COLS = 2, FRAME_ROWS = 1;

    Vector2 position;

    // Objects used
    Animation<TextureRegion> missileAnimation; // Must declare frame type (TextureRegion)
    Texture missileSheet;
    SpriteBatch spriteBatch;

    // A variable for tracking elapsed time for the animation
    float stateTime;

    float x, y;

    public Missile(Vector2 position) {
        this.position = position;
        x = position.x;
        y = position.y;
    }

    @Override
    public void create() { // Load the sprite sheet as a Texture
        missileSheet = new Texture(Gdx.files.internal("./image/player/missile_shoot.png"));

        // Use the split utility method to create a 2D array of TextureRegions. This is
        // possible because this sprite sheet contains frames of equal size and they are
        // all aligned.
        TextureRegion[][] tmp = TextureRegion.split(missileSheet,
                missileSheet.getWidth() / FRAME_COLS,
                missileSheet.getHeight() / FRAME_ROWS);

        // Place the regions into a 1D array in the correct order, starting from the top
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] missileFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                missileFrames[index++] = tmp[i][j];
            }
        }

        // Initialize the Animation with the frame interval and array of frames
        missileAnimation = new Animation<TextureRegion>(0.05f, missileFrames);

        // Instantiate a SpriteBatch for drawing and reset the elapsed animation
        // time to 0
        spriteBatch = new SpriteBatch();
        stateTime = 0f;
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = missileAnimation.getKeyFrame(stateTime, true);
        spriteBatch.begin();

        spriteBatch.draw(currentFrame, x, y);

        spriteBatch.end();

    }

    public void update(Vector2 pos) {
        if (Player.isShoot) {
            x += 7.55f;
            if (x > Gdx.graphics.getWidth() - 60) {
                Player.isShoot = false;
            }
        } else {
            x = pos.x + 50.5f;
            y = pos.y + 25.5f;
        }
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        missileSheet.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

}
