package plane.game.entities.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class MySound {
    // Music music;
    Sound hit;
    Music explode;
    Music background_music;

    public MySound() {
        // music =
        // Gdx.audio.newMusic(Gdx.files.internal("./sounds/background_music.mp3"));
        hit = Gdx.audio.newSound(Gdx.files.internal("./sound/laserShoot.wav"));
        explode = Gdx.audio.newMusic(Gdx.files.internal("./sound/Boom.mp3"));
        background_music = Gdx.audio.newMusic(Gdx.files.internal("./sound/bg_music.mp3"));
    }

    // public void play(boolean loop) {
    // music.play();
    // }
    public void exploded() {
        explode.play();
        explode.setLooping(false);
    }

    public void stopExplode() {
        explode.stop();
    }

    public void backgroundMusicPlay(boolean loop) {
        background_music.setLooping(loop);
        background_music.setVolume(0.8f);
        background_music.play();
    }

    public void backgroundMusicStop() {
        background_music.stop();
    }

    public void shotPlay() {
        hit.play();
    }

    public void shotStop() {
        hit.stop();
    }

    public void dispose() {
        background_music.dispose();
        hit.dispose();
    }
}
