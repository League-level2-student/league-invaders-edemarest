import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    
    static Font titleFont;
    static Font titleFont2;
    int currentState = MENU;
    Timer frameDraw;
    
    //constructor
    public GamePanel() {
    	titleFont = new Font("Arial", Font.PLAIN, 48);
    	titleFont2 = new Font("Arial", Font.PLAIN, 20);
    	
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
    }
    
    
    
    
    //Methods for updating the game in each state
    public static void updateMenuState() {
    	
    }
    
    public static void updateGameState() {
    	
    }
    
    public static void updateEndState() {
    	
    }
    
    //Methods for drawing the game in each state
    public static void drawMenuState(Graphics g) {
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("LEAGUE INVADERS", 25, 150);
    	g.setFont(titleFont2);
    	g.drawString("Press ENTER to start", 150, 400);
    	g.drawString("Press SPACE for instructions", 120, 700);
    }
    
    public static void drawGameState(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    }
    
    public static void drawEndState(Graphics g) {
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	
    	g.setFont(titleFont);
    	g.setColor(Color.WHITE);
    	g.drawString("GAME OVER", 25, 150);
    	g.setFont(titleFont2);
    	g.drawString("Press ENTER to start", 150, 400);
    	g.drawString("Press SPACE for instructions", 150, 400);
    }
    
    //Paint Component method
    @Override
    public void paintComponent(Graphics g){
    	if(currentState == MENU){
    	    drawMenuState(g);
    	}else if(currentState == GAME){
    	    drawGameState(g);
    	}else if(currentState == END){
    	    drawEndState(g);
    	}
    }




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (currentState == END) {
	        currentState = MENU;
	    } else {
	        currentState++;
	    }
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		}
	}




	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    
}
