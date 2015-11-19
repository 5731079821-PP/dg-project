package render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Resource {
	public static final Font font = new Font("Tahoma", Font.BOLD, 30);
	public static BufferedImage appleSprite;
	public static AudioClip coinSound;

	static {
		try {
			ClassLoader loader = RenderableHolder.class.getClassLoader();
			appleSprite = ImageIO.read(loader.getResource("Apple.png"));
			coinSound = Applet.newAudioClip((loader.getResource("coin.wav")).toURI().toURL());
		} catch (Exception e) {
			appleSprite = null;
			coinSound = null;
		}
	}
}
