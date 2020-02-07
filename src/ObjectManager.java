import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {

	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien>aliens = new ArrayList<Alien>();
	int score = 0;
	
	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}
	
	
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	
	void addAlien() {
		Random rand = new Random();
		aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void update() {
		for(Projectile proj: projectiles) {
			proj.update();
		}
		for(Alien alien: aliens) {
			alien.update();
			if(alien.y > LeagueInvaders.HEIGHT || alien.y < 0) {
				alien.isActive = false;
			}
		}
		rocket.update();
		checkCollision();
		purgeObjects();
	}
	
	void draw(Graphics g) {
		rocket.draw(g);
		for(Projectile proj: projectiles) {
			proj.draw(g);
		}
		for(Alien alien: aliens) {
			alien.draw(g);
		}
	}
	
	void purgeObjects() {
		for(int i = 0; i < projectiles.size(); i++) {
			if(!projectiles.get(i).isActive) {
				projectiles.remove(i);
			}
		}
		for(int i = 0; i < aliens.size(); i++) {
			if(!aliens.get(i).isActive) {
				aliens.remove(i);
			}
		}
	}
	
	void checkCollision() {
		for(Alien alien: aliens) {
			
			if(rocket.collisionBox.intersects(alien.collisionBox)){
				rocket.isActive = false;
			}
			for(Projectile proj: projectiles) {
				if(alien.collisionBox.intersects(proj.collisionBox)){
					score++;
					alien.isActive = false;
					proj.isActive = false;
				}
			}
		}

	}

	
	int getScore() {
		return score;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	
	
}
