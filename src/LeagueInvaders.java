import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	
	//member variables
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel panel;
	
	public LeagueInvaders() {
		frame =  new JFrame();
		panel = new GamePanel();
	}
	
	public void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		LeagueInvaders invaders = new LeagueInvaders();
		invaders.setup();
		
	}
}

