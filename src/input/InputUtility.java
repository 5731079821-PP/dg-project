package input;

public class InputUtility {
	private static boolean keyPressed[] = new boolean[256];
	
	public static boolean getKeyPressed(int key) {
		if (key < 0 || key >= 256)
			return false;
		return keyPressed[key];
	}

	public static void setKeyPressed(int key, boolean pressed) {
		if (key < 0 || key >= 256)
			return;
		InputUtility.keyPressed[key] = pressed;
	}
}
