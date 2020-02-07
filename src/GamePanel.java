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
    Rocketship rocket = new Rocketship(LeagueInvaders.WIDTH/2, LeagueInvaders.HEIGHT-75, 50, 50);
	ObjectManager manager = new ObjectManager(rocket);
	Timer alienSpawn;
	 
    //constructor
    public GamePanel() {
    	titleFont = new Font("Arial", Font.PLAIN, 48);
    	titleFont2 = new Font("Arial", Font.PLAIN, 20);
    	
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
    }
    
    
    
    
    //Methods for updating the game in each state
    public void updateMenuState() {
    	
    }
    
    public void updateGameState() {
    	manager.update();
    	
    	
    	if(!rocket.isActive) {
    		currentState = END;
    	}
    }
    
    public void updateEndState() {
    	
    }
    
    //Methods for drawing the game in each state
    public void drawMenuState(Graphics g) {
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("LEAGUE INVADERS", 25, 150);
    	g.setFont(titleFont2);
    	g.drawString("Press ENTER to start", 150, 400);
    	g.drawString("Press SPACE for instructions", 120, 700);
    }
    
    public void drawGameState(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setColor(Color.WHITE);
    	g.drawString("Score: "+manager.getScore(), 120, 700);
    	manager.draw(g);
    	
    }
    
    public void drawEndState(Graphics g) {
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	
    	g.setFont(titleFont);
    	g.setColor(Color.WHITE);
    	g.drawString("GAME OVER", 100, 150);
    	g.setFont(titleFont2);
    	g.drawString("Press ENTER to try again", 150, 400);
    }
    
    
    
    public void startGame() {
        alienSpawn = new Timer(1000 , manager);
        alienSpawn.start();
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
		repaint();
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    if(rocket.y > 0) {
		    	rocket.up();
		    }
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
		    if(rocket.y < LeagueInvaders.HEIGHT-rocket.height-25) {
		    	rocket.down();
		    }
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    if(rocket.x < LeagueInvaders.WIDTH-rocket.width) {
		    	rocket.right();
		    }
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		    if(rocket.x > 0) {
		    	rocket.left();
		    }
		}
		
		else if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			System.out.println(currentState);

			if(currentState == MENU) {
				currentState = GAME;
				startGame();
			}
			else if(currentState == GAME) {
				alienSpawn.stop();
				currentState = END;
			}
			else if (currentState == END) {
				manager = new ObjectManager(rocket);
				rocket = new Rocketship(LeagueInvaders.WIDTH/2, LeagueInvaders.HEIGHT-75, 50, 50);
		        currentState = MENU;
		    } 
		    
		}
		
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			manager.addProjectile(rocket.getProjectile());
		}
		
	}




	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    
}
