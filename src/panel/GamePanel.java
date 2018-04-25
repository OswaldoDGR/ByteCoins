package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import factory.GameContext;
import observers.KeyListenerSubject;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	private static final long serialVersionUID = 1L;
	private static final int PWIDTH = 810;
	private static final int PHEIGHT = 480;
	private Thread animation;
	private volatile boolean run = true;
	
	private GameContext game;
	public GamePanel(){
		setBackground(Color.BLUE);
		setPreferredSize(new Dimension(PWIDTH,PHEIGHT));
		setFocusable(true);
		requestFocus();
		game = new GameContext();
		listenToKey();
		//addKeyListener(KeyListenerSubject.getInstance());
	}
	
	public void addNotify(){
		super.addNotify();
		startGame();
	}
	
	private void startGame(){
		if(animation == null ){
			animation = new Thread(this);
			animation.start();
		}
	}
	
	public void run(){
		while(run){
			update();
			render();
			screen();

			try{
				Thread.sleep(10);
			}
			catch(InterruptedException ex){}
		}
		System.exit(0);
	}
	
	private void update() {
		game.update();
	}
	
	private Graphics dbg;
	private Image dbImage = null;
	private void render(){
		if(dbImage == null){
			dbImage = createImage(PWIDTH,PHEIGHT);
			if(dbImage == null){
				System.out.println("dbImage is null");
				return;
			}else{
				dbg = dbImage.getGraphics();
			}
		}
			game.draw(dbg);
	}
	
	public void screen(){
		Graphics g;
		try{
			g = this.getGraphics();
			if((g != null) && (dbImage != null))
				g.drawImage(dbImage,0,0,null);
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
		}
		catch(Exception e){
			System.out.println("Graphics context error: "+e);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(dbImage != null)
			g.drawImage(dbImage, 0, 0, null);
	}
	
	private void listenToKey(){
		addKeyListener( new KeyAdapter( ) {
			public void keyPressed(KeyEvent e) {
				KeyListenerSubject.getInstance().setKeyCode(e.getKeyCode());
			}
		});
	}

	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
