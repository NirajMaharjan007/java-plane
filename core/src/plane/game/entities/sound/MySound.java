package plane.game.entities.sound;

import com.badlogic.gdx.Gdx;
// import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class MySound {
    // Music music;
    Sound hit;

    public MySound() {
        // music =
        // Gdx.audio.newMusic(Gdx.files.internal("./sounds/background_music.mp3"));
        hit = Gdx.audio.newSound(Gdx.files.internal("./sound/laserShoot.wav"));
    }

    // public void play(boolean loop) {
    // music.play();
    // }

    public void shotPlay() {
        hit.play();
    }

    public void shotStop() {
        hit.stop();
    }

    public void dispose() {
        hit.dispose();
    }
}
