package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Main implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 32;
	public static final int HEIGHT = 24;
	public static final int SCALE = 25;
	
	
	private Thread thread;
	private boolean running = false;
//	public static Handler handler;
	
	private void init(){
//		handler = new Handler();
//		addKeyListener(new KeyInput());
//		handler.addEntity(new Player(200,200,64,64,true,Id.player,handler));
		
	}
	
	public synchronized void start(){
		if(running) return;
		running = true;
		thread = new Thread(this,"Thread");
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)return;
		running = false;
		try{
			thread.join();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		init();
//		requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0.0;
		double ns = 1000000000.0/60.0;
		int frames = 0;
		int ticks = 0;
		while(running){
			long now = System.nanoTime();
			delta+= (now - lastTime)/ns;
			lastTime = now;
			while(delta>=1){
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis()-timer>1000){
				timer+=1000;
				frames = 0;
				ticks =0;
			}
		}
		stop();
	}
	
	public void render(){
//		BufferStrategy bs = getBufferStrategy();
//		if(bs == null){
//			createBufferStrategy(3);
//			return; 
//		}
//		Graphics g = bs.getDrawGraphics();
//		g.setColor(Color.BLACK);	
//		g.fillRect(0, 0, getWidth(),getHeight());
//		handler.render(g);
//		g.dispose();
//		bs.show();
	}
	
	public void tick(){
//		handler.tick();
	}


	public Main(){
//		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
//		this.setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
//		this.setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		
	}
	
	
	public static void main(String[] args){
//		Game game = new Game();
		JFrame frame = new JFrame("Zombie");
//		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
//		game.start();
		
	}
}
