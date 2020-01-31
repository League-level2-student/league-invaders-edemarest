import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{

	public Projectile(int x, int y, int width, int height) {
		super(x,y,width,height);
		speed = 1;
	}
	
	public void update() {
		y-=speed;
		super.update();
	}
	
	public void draw(Graphics g) {
		  g.setColor(Color.RED);
	      g.fillRect(x, y, width, height);
	      g.setColor(Color.BLUE);
	      g.drawRect(x, y, width, height);
	}
	
	
	
}
