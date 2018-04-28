import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private static final int PWIDTH = 800;
	private static final int PHEIGHT = 600;
	
	private volatile boolean running = false;
	private volatile boolean gameOver = false;
	private volatile boolean pause = false;
	private volatile boolean isShop = false;
	private volatile boolean start = false;
	
	public GamePanel(){
		setBackground(Color.blue);
		setPreferredSize(new Dimension(PWIDTH,PHEIGHT));
		setFocusable(true);
		requestFocus();
		readyForTermination();
		
		addMouseListener( new MouseAdapter() { 
			public void mousePressed(MouseEvent e) { 
				testPress(e.getX(), e.getY()); }
		});
	}
	
	public void addNotify()
	{
		super.addNotify();
		startGame();
	}//Se quedará mientras lo probamos
	
	private void startGame()
	{
		/*if(animator == null || !running){
			animator = new Thread(this);
			animator.start();
		}*/
		 ExecutorService application = Executors.newCachedThreadPool();
		 application.execute(this);
		 application.shutdown();
		
	}
	
	public void stopGame(){
		running = false;
	}
	
	public void run(){
		running = true;
		while(running){
			gameUpdate();
			gameRender();
			paintScreen();
			
			try{
				Thread.sleep(20);
			}catch(InterruptedException ex){}
		}
		System.exit(0);
	}
	
	private void gameUpdate(){
		
	}
	private Graphics dbg;
	private Image dbImage = null;
	
	private void gameRender(){
		if(dbImage == null){
			dbImage = createImage(PWIDTH,PHEIGHT);
			if(dbImage == null){
				System.out.println("dbImage is null");
				return;
			}else{
				dbg = dbImage.getGraphics();
			}
		}
			dbg.setColor(Color.white);
			dbg.fillRect(0,0,PWIDTH,PHEIGHT);
	}
	
	private void readyForTermination() {
		addKeyListener( new KeyAdapter() { // listen for esc, q, end, ctrl-c
			public void keyPressed(KeyEvent e) { 
				int keyCode = e.getKeyCode();
				if ((keyCode == KeyEvent.VK_ESCAPE) ||
					(keyCode == KeyEvent.VK_Q) ||
					(keyCode == KeyEvent.VK_END) ||
					((keyCode == KeyEvent.VK_C) && (keyCode == KeyEvent.VK_V)) ) {
					running = false;
				}
			} 
			});
	}
	
	private void testPress(int x, int y)
	   
    {
      if (!gameOver && !pause) {
    	  addKeyListener( new KeyAdapter() { // listen for esc, q, end, ctrl-c
  			public void keyPressed(KeyEvent e) { 
  				int keyCode = e.getKeyCode();
  			} 
  			});
		} 
	}
	
	private void paintScreen(){
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
	
	public void pauseGame(){
		pause = true;
	}
	
	public void runningGame(){
		pause = false;
	}
	
	public static void main(String args[]){
		 JFrame app = new JFrame("Test");
	     app.getContentPane().add(new GamePanel(), BorderLayout.CENTER);
	     app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	     app.pack();
	     app.setResizable(false);  
	     app.setVisible(true);
		}
}
