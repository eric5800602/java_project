package project;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;

public class main extends BasicGameState{
	public ArrayList<Image> img = new ArrayList<Image>();
	public Image backgroundImage,fire,pause;
	public long delta;
	public player p1,p2;
	public float force,force2,pause_y;
	public String choosenString;
	public boolean force_attack = false,force_up = true;
	public boolean force_attack2 = false,force_up2 = true;
	public ArrayList<food_object> food_index = new ArrayList<food_object>();
	public ArrayList<bullet> bullets_bucket = new ArrayList<bullet>();
	public Random ran = new Random();
	Music click,dead,hit;
	int p1h,p2h;
	public main(int state) {
		
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		backgroundImage = new Image("res/gamebackground.png");
		arg0.resume();
		fire = new Image("res/fire (1).png");
		pause = new Image("res/pause.png");
		pause_y = 600;
		img.add(new Image("res/hamburger.png"));
		img.add(new Image("res/cake.png"));
		img.add(new Image("res/donunt.png"));
		img.add(new Image("res/fried.png"));
		img.add(new Image("res/greenpepper.png"));
		img.add(new Image("res/hotdog.png"));
		img.add(new Image("res/orange.png"));
		img.add(new Image("res/sushi.png"));
		img.add(new Image("res/bubbletea.png"));
		click = new Music("res/click.ogg");
		dead = new Music("res/dead.ogg");
		hit = new Music("res/hit.ogg");
		delta = 3599;
		choosenString = arg1.getState(5).toString();
		if(choosenString.charAt(0) == '1') {
			p1 = new player(new Image("res/character.png"), 10, 600-new Image("res/character.png").getHeight(),1,choosenString);
		}
		else if(choosenString.charAt(0) == '2') {
			p1 = new player(new Image("res/character_2.png"), 10, 600-new Image("res/character_2.png").getHeight(),1,choosenString);
		}
		else if(choosenString.charAt(0) == '3') {
			p1 = new player(new Image("res/character_3.png"), 10, 600-new Image("res/character_3.png").getHeight(),1,choosenString);
		}
		else if(choosenString.charAt(0) == '4') {
			p1 = new player(new Image("res/character_4.png"), 10, 600-new Image("res/character_4.png").getHeight(),1,choosenString);
		}
		if(choosenString.charAt(1) == '1'){
			p2 = new player(new Image("res/character.png"), 740, 600-new Image("res/character.png").getHeight(),2,choosenString);
		}
		else if(choosenString.charAt(1) == '2'){
			p2 = new player(new Image("res/character_2.png"), 740, 600-new Image("res/character_2.png").getHeight(),2,choosenString);
		}
		else if(choosenString.charAt(1) == '3'){
			p2 = new player(new Image("res/character_3.png"), 740, 600-new Image("res/character_3.png").getHeight(),2,choosenString);
		}
		else if(choosenString.charAt(1) == '4'){
			p2 = new player(new Image("res/character_4.png"), 740, 600-new Image("res/character_4.png").getHeight(),2,choosenString);
		}
		p1h =p1.player_health;
		p2h = p2.player_health;
		}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		arg2.drawImage(backgroundImage, 0, 0);
		//arg2.drawString(Float.toString(force), p1.player_x, p1.player_y-20);
		//arg2.drawString(Float.toString(force2), p2.player_x, p2.player_y-20);
		for(int i = 0;i < food_index.size();i++) {
			if(food_index.get(i).draw)
				arg2.drawImage(food_index.get(i).img,food_index.get(i).food_x,food_index.get(i).food_y);
		}
		arg2.drawImage(p1.playerImage,p1.player_x,p1.player_y);
		arg2.drawImage(p2.playerImage,p2.player_x,p2.player_y);
		if(p1.has_weapon == 1) {
			p1.setweapon_location(1);
			arg2.drawImage(p1.weapon,p1.weapon_x,p1.weapon_y);
		}
		if(p2.has_weapon == 1) {
			p2.setweapon_location(2);
			arg2.drawImage(p2.weapon,p2.weapon_x,p2.weapon_y);
		}
		arg2.setColor(Color.blue);
		arg2.fillRoundRect(p1.player_x-27, p1.player_y-20,force,20, 20);
		arg2.setColor(Color.red);
		arg2.fillRoundRect(p2.player_x-27, p2.player_y-20,force2,20, 20);
		for(int i = 0;i < bullets_bucket.size();i++) {
			if(bullets_bucket.get(i).shoot){
				arg2.drawImage(fire, bullets_bucket.get(i).bullet_x -fire.getWidth()/4, bullets_bucket.get(i).bullet_y-fire.getHeight()/4);
				fire.setCenterOfRotation(fire.getWidth()/2,fire.getHeight()/2);
				fire.rotate(0.3f);
				arg2.drawImage(bullets_bucket.get(i).img, bullets_bucket.get(i).bullet_x, bullets_bucket.get(i).bullet_y);
				if(bullets_bucket.get(i).p == p1 && !arg0.isPaused()) {
					bullets_bucket.get(i).render(p1);
				}
				else if(bullets_bucket.get(i).p == p2&& !arg0.isPaused()){
					bullets_bucket.get(i).render(p2);
				}
				if(bullets_bucket.get(i).collision) {
					bullets_bucket.remove(i);
				}
			}
		}
		try {//health1 image
			arg2.drawImage(p1.healthimg[p1.player_health],0,25);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("no img");
		}
		try {//health2 image
			arg2.drawImage(p2.healthimg[p2.player_health],650,25);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("no img");
		}
		arg2.drawImage(pause,(800-pause.getWidth())/2,pause_y);
		if(arg0.isPaused()) {
			if(pause_y >= 400)
				pause_y -= 2f;
		}
		else if(!arg0.isPaused()) {
			if(pause_y <= 600) {
				pause_y += 2f;
			}
		}
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		//System.out.print(arg1.getState(0).toString());
		Input input = arg0.getInput();
		delta++;
		if(p1.player_health != p1h)hit.play();
		if(p2.player_health != p2h)hit.play();
		p1h =p1.player_health;
		p2h = p2.player_health;
		if(p1.player_health >= 10) {
			//end_game and p2 win
			arg1.getState(4).init(arg0,arg1);
			food_index.clear();
			arg1.enterState(4);
			dead.play();
		}
		if(p2.player_health >= 10) {
			//end_game and p1 win
			arg1.getState(3).init(arg0,arg1);
			food_index.clear();
			arg1.enterState(3);
			dead.play();
		}
		if(delta >= 3500 && !arg0.isPaused()) {
			food_object f = new food_object(img.get(ran.nextInt(img.size())),ran.nextFloat()*725,0);
			food_index.add(f);
			delta = 0;
		}
		for(int i = 0;i < food_index.size();i++) {
			if(!arg0.isPaused())
				food_index.get(i).add_y();
			if(p1.has_weapon != 1 && (
				p1.inrange(food_index.get(i).food_x, food_index.get(i).food_y)
				||p1.inrange(food_index.get(i).food_x + food_index.get(i).img.getWidth(), food_index.get(i).food_y)
				||p1.inrange(food_index.get(i).food_x,food_index.get(i).food_y + food_index.get(i).img.getHeight())
				||p1.inrange(food_index.get(i).food_x + food_index.get(i).img.getWidth(), food_index.get(i).food_y + food_index.get(i).img.getHeight()))) {
				food_index.get(i).draw = false;
				p1.setweapon(food_index.get(i).img,food_index.get(i).value);
			}
			if(p2.has_weapon != 1 && (
					p2.inrange(food_index.get(i).food_x, food_index.get(i).food_y)
					||p2.inrange(food_index.get(i).food_x + food_index.get(i).img.getWidth(), food_index.get(i).food_y)
					||p2.inrange(food_index.get(i).food_x,food_index.get(i).food_y + food_index.get(i).img.getHeight())
					||p2.inrange(food_index.get(i).food_x + food_index.get(i).img.getWidth(), food_index.get(i).food_y + food_index.get(i).img.getHeight()))){
				food_index.get(i).draw = false;
				p2.setweapon(food_index.get(i).img,food_index.get(i).value); 
			}
			//System.out.println(food_index.get(0).food_center_y+" "+p1.player_y+" "+(p1.player_y+p1.playerImage.getHeight()));
			if(food_index.get(i).food_y > 600 || food_index.get(i).draw == false)
				food_index.remove(i);
		}
		for(int i=0;i< bullets_bucket.size();i++) {
			if(bullets_bucket.get(i).bullet_y >=600 || bullets_bucket.get(i).bullet_x >= 800 || bullets_bucket.get(i).bullet_x <= -50) {
				bullets_bucket.remove(i);
			}
		}
		if(input.isKeyDown(Input.KEY_O)) {
			System.out.print(food_index.get(0).value);
		}
		//p2 controller
		if(input.isKeyDown(Input.KEY_LEFT)) {
			p2.player_x -= arg2 * .2f;
			p2.right = false;
			p2.change_img();
			if(p2.player_x <= 0) {
				p2.player_x += arg2 * .2f;
			}
		}
		if(input.isKeyDown(Input.KEY_RIGHT)) {
			p2.player_x += arg2 * .2f;
			p2.right = true;
			p2.change_img();
			if(p2.player_x+p2.playerImage.getWidth() >= 800) {
				p2.player_x -= arg2 * .2f;
			}
		}
		if(input.isKeyDown(Input.KEY_UP)) {
			if(p2.jump_state == 0) {
				p2.v = 1.2f;
				p2.jump_state = 1;
			}
		}
		if(p2.jump_state == 1) {
			p2.player_y -= p2.v;
			p2.v-=arg2*.0025f;
			if(p2.player_y >= 600-p2.playerImage.getHeight()) {
				p2.v = 0;
				p2.jump_state = 0;
			}
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {//p2 shoot
			if(p2.has_weapon == 1) {
				force_attack2 = true;
				if(force2 < 100 && force_up2) {
					force2 += 0.15;
				}
				else {
					force_up2 = false;
					force2 -= 0.15;
					if(force2 <= 0) {
						force_up2 = true;
					}
				}
			}
			//System.out.print(p2.has_weapon);
		}else {
			if(p2.has_weapon == 1 && force_attack2) {
				p2.has_weapon = 0;
				bullet b = new bullet(p2.weapon,p2.weapon_x,p2.weapon_y,p2.weapon_x-p2.player_x,p1,p2.damage);
				b.length = force2;
				//b.upperbound = (100-force2)*7.5f - (800-p2.player_y) + p2.playerImage.getHeight();
				p2.weapon = null;
				b.shoot = true;
				bullets_bucket.add(b);
				force_attack2 = false;
				force2 = 0;
			}
		}
		//p1 controller
		if(input.isKeyDown(Input.KEY_A)) {
			p1.player_x -= arg2 * .2f;
			p1.right = false;
			p1.change_img();
			if(p1.player_x <= 0) {
				p1.player_x += arg2 * .2f;
			}
		}
		if(input.isKeyDown(Input.KEY_D)) {
			p1.player_x += arg2 * .2f;
			p1.right = true;
			p1.change_img();
			if(p1.player_x+p1.playerImage.getWidth() >= 800) {
				p1.player_x -= arg2 * .2f;
			}
		}
		if(input.isKeyDown(Input.KEY_W)) {
			if(p1.jump_state == 0) {
				p1.v = 1.2f;
				p1.jump_state = 1;
			}
		}
		if(p1.jump_state == 1) {
			p1.player_y -= p1.v;
			p1.v-=arg2*.0025f;
			if(p1.player_y >= 600-p1.playerImage.getHeight()) {
				p1.v = 0;
				p1.jump_state = 0;
			}
		}
		if (input.isKeyDown(Input.KEY_S)) {//p1 shoot
			if(p1.has_weapon == 1) {
				force_attack = true;
				if(force < 100 && force_up) {
					force += 0.15;
				}
				else {
					force_up = false;
					force -= 0.15;
					if(force <= 0) {
						force_up = true;
					}
				}
			}
			//System.out.print(p2.has_weapon);
		}else {
			if(p1.has_weapon == 1 && force_attack) {
				p1.has_weapon = 0;
				bullet b = new bullet(p1.weapon,p1.weapon_x,p1.weapon_y,p1.weapon_x-p1.player_x,p2,p1.damage);
				b.length = force;
				//b.upperbound = ((100-force)*7.5f - (800-p1.player_y) + p1.playerImage.getHeight());
				p1.weapon = null;
				b.shoot = true;
				bullets_bucket.add(b);
				force_attack = false;
				force = 0;
			}
		}
		if(input.isKeyPressed(Input.KEY_ESCAPE)) {
			if(!arg0.isPaused()) {
				arg0.pause();
			}
			else {
				arg0.resume();
			}
		}
		if(!arg0.isPaused()) {
			arg0.setMouseGrabbed(true);
		}
		else {
			arg0.setMouseGrabbed(false);

			if(Mouse.getX()>=280 && Mouse.getX()<=360 && Mouse.getY()>=75 && Mouse.getY()<=160){//conti
				if(input.isMouseButtonDown(0)) {
					arg0.resume();
					click.play();
				}
			}
			if(Mouse.getX()>=420 && Mouse.getX()<=525 && Mouse.getY()>=75 && Mouse.getY()<=160){//home
				if(input.isMouseButtonDown(0)) {
					food_index.clear();
					arg1.getState(1).init(arg0,arg1);
					arg1.getState(0).init(arg0,arg1);
					arg1.enterState(0);
				}
			}
		}
		
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}
