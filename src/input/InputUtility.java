package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class InputUtility implements KeyListener,MouseListener{

	private static int mouseX=0, mouseY=0;
	private static boolean up=false,left=false,right=false,spacePress=false,spaceTrigger=false,click=false;
	private static boolean[] keyPressed = new boolean[256];
	private static boolean[] keyTriggered = new boolean[256];

	public static void update() {
		InputUtility.up=keyPressed[KeyEvent.VK_UP];
		InputUtility.left=keyPressed[KeyEvent.VK_LEFT];
		InputUtility.right=keyPressed[KeyEvent.VK_RIGHT];
		InputUtility.spacePress=keyPressed[KeyEvent.VK_SPACE];
		InputUtility.spaceTrigger=keyTriggered[KeyEvent.VK_SPACE];
	}

	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton()==1){
			click=true;
			mouseX=e.getX();
			mouseY=e.getY();
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		left=false;
		mouseX=0;
		mouseY=0;
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keyPressed[e.getKeyCode()]=true;
		if (e.getKeyCode()==KeyEvent.VK_SPACE){
			if (!keyPressed[KeyEvent.VK_SPACE]){
				keyTriggered[KeyEvent.VK_SPACE]=true;
			}
			else{
			keyTriggered[KeyEvent.VK_SPACE]=false;
			}
			keyPressed[KeyEvent.VK_SPACE]=true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keyPressed[e.getKeyCode()]=false;
	}
	@Override
	public void keyTyped(KeyEvent e) {}
}
