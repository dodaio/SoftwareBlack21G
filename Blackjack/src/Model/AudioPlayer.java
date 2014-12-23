package Model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.media.AudioClip;

public class AudioPlayer {
	public static enum Effects {
		HIT("hit"),
		DEAL("deal"),
		SHUFFLE("shuffle");
		private final String effect;
		
	    private Effects(final String effect) {
	        this.effect = effect;
	    }
	    
	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return effect;
	    }
	}
	private boolean soundEffectsEnabled;
	/**
	 * Map that facilitates AudioClip instances for the game sounds
	 */
    private static final Map<String, AudioClip> effectClips;
    static {
    	Map<String, AudioClip> tmpClips = new HashMap<String, AudioClip>();
    	tmpClips.put(Effects.DEAL.toString(), new AudioClip(AudioPlayer.class.getResource("deal.wav").toString()));
    	tmpClips.put(Effects.HIT.toString(), new AudioClip(AudioPlayer.class.getResource("hit.wav").toString()));
    	tmpClips.put(Effects.SHUFFLE.toString(), new AudioClip(AudioPlayer.class.getResource("shuffle.mp3").toString()));
    	effectClips = Collections.unmodifiableMap(tmpClips);
    }
    
	public static enum Musics {
		GAME_MUSIC("game_music");
		
		private final String music;
		
	    private Musics(final String music) {
	        this.music = music;
	    }
	    
	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return music;
	    }
	}
	private boolean musicEnabled;
	/**
	 * Map that facilitates AudioClip instances for the game sounds
	 */
    private static final Map<String, AudioClip> musicClips;
    static {
    	Map<String, AudioClip> tmpClips = new HashMap<String, AudioClip>();
    	tmpClips.put(Musics.GAME_MUSIC.toString(), new AudioClip(AudioPlayer.class.getResource("mariotheme.mp3").toString()));
    	musicClips = Collections.unmodifiableMap(tmpClips);
    }

    /**
     * Default constructor - sounds enabled by default
     */
	public AudioPlayer() {
		this(true, true);
	}
	
	/**
	 * Constructor
	 * @param soundEffectsEnabled - true to enable sound effects
	 * @param musicEnabled - true to enable music
	 */
	public AudioPlayer(boolean soundEffectsEnabled, boolean musicEnabled) {
		this.soundEffectsEnabled = soundEffectsEnabled;
		this.musicEnabled = musicEnabled;
	}	
	
	/**
	 * Play sound effect
	 * @param effect - Effects Enum that represent the effect to play
	 */
	protected void playEffect(Effects effect) {
		if (soundEffectsEnabled) {
			effectClips.get(effect.toString()).play();
		}
	}
	
	/**
	 * Play music
	 * @param music - Musics Enum that represent the music to play
	 */
	protected void playMusic(Musics music) {
		if (musicEnabled) {
			// Play music on 60% volume
			musicClips.get(music.toString()).play(0.6);
		}
	}
	
	/**
	 * Disable music and turn off currently playing music
	 */
	protected void turnOffMusic() {
		musicEnabled = false;
		for (AudioClip music: musicClips.values()) {
			music.stop();
		}
	}
	
	
}
