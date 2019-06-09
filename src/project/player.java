package project;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class player {
	public Image playerImage,playerImage_left,playerImage_right;
	public Image[] healthimg = new Image[11];
	public String choosenString;
	public float player_x,player_y,weapon_x,weapon_y;
	public float xc1,xc2,xc3,xc4,yc1,yc2,yc3,yc4;
	public boolean right;
	public float v =0;
	public int jump_state = 0,has_weapon=0,player_index,player_health = 0,damage = 1;
	public Image weapon;
	public player(Image img,float x,float y,int index,String co) throws SlickException {
		// TODO Auto-generated constructor stub
		playerImage = img;
		playerImage_left = playerImage;
		player_x = x;
		player_y = y;
		player_index = index;
		choosenString = co;
		if(player_index == 1) {
			if(choosenString.charAt(0) == '1') {
				playerImage_right = new Image("res/character_right.png");
			}
			else if(choosenString.charAt(0) == '2') {
				playerImage_right = new Image("res/character_2_right.png");
			}
			else if(choosenString.charAt(0) == '3') {
				playerImage_right = new Image("res/character_3_right.png");
			}
			else if(choosenString.charAt(0) == '4') {
				playerImage_right = new Image("res/character_4_right.png");
			}
		}
		else if(player_index == 2) {
			if(choosenString.charAt(1) == '1'){
				playerImage_right = new Image("res/character_right.png");
			}
			else if(choosenString.charAt(1) == '2'){
				playerImage_right = new Image("res/character_2_right.png");
			}
			else if(choosenString.charAt(1) == '3'){
				playerImage_right = new Image("res/character_3_right.png");
			}
			else if(choosenString.charAt(1) == '4'){
				playerImage_right = new Image("res/character_4_right.png");
			}
		}
		if(player_index == 1) {
			right = true;
			healthimg[0] = new Image("res/health/blue_0.png");
			healthimg[1] = new Image("res/health/blue_1.png");
			healthimg[2] = new Image("res/health/blue_2.png");
			healthimg[3] = new Image("res/health/blue_3.png");
			healthimg[4] = new Image("res/health/blue_4.png");
			healthimg[5] = new Image("res/health/blue_5.png");
			healthimg[6] = new Image("res/health/blue_6.png");
			healthimg[7] = new Image("res/health/blue_7.png");
			healthimg[8] = new Image("res/health/blue_8.png");
			healthimg[9] = new Image("res/health/blue_9.png");
			healthimg[10] = new Image("res/health/blue_10.png");
		}
		else if(player_index == 2){
			right = false;
			healthimg[0] = new Image("res/health/red_0.png");
			healthimg[1] = new Image("res/health/red_1.png");
			healthimg[2] = new Image("res/health/red_2.png");
			healthimg[3] = new Image("res/health/red_3.png");
			healthimg[4] = new Image("res/health/red_4.png");
			healthimg[5] = new Image("res/health/red_5.png");
			healthimg[6] = new Image("res/health/red_6.png");
			healthimg[7] = new Image("res/health/red_7.png");
			healthimg[8] = new Image("res/health/red_8.png");
			healthimg[9] = new Image("res/health/red_9.png");
			healthimg[10] = new Image("res/health/red_10.png");

		}
	}
	public void setweapon(Image i,int value) {
		has_weapon = 1;
		weapon = i;
		damage = value;
		//System.out.print("123");
	}
	public void setweapon_location(int i) {
		if(i == 1) {
			if(right) {
				weapon_x = (float) (player_x +playerImage.getWidth()/1.25);
				weapon_y = player_y - weapon.getHeight()/4;
			}else {
				weapon_x = (float) (player_x - weapon.getWidth()/1.25);
				weapon_y = player_y - weapon.getHeight()/4;
			}
			//weapon.rotate(0.1f);
		}
		else if(i == 2) {
			if(!right) {
				weapon_x = (float) (player_x - weapon.getWidth()/1.25);
				weapon_y = player_y - weapon.getHeight()/4;
			}
			else {
				weapon_x = (float) (player_x +playerImage.getWidth()/1.25);
				weapon_y = player_y - weapon.getHeight()/4;
			}
			//weapon.rotate(-0.1f);
		}
	}
	public boolean inrange(float x, float y) {
		xc1 = player_x;yc1 = player_y;
		xc2 = player_x+playerImage.getWidth();yc2 = player_y;
		xc3 = player_x;yc3 = player_y + playerImage.getHeight();
		xc4 = player_x+playerImage.getWidth();yc4 = player_y + playerImage.getHeight();
		if((xc1 < x && x < xc2)&&(yc2 < y && yc4 > y)) {
			return true;
		}
		else {
			return false;
		}
	}
	public void change_img() {
		if(right) {
			playerImage = playerImage_right;
		}else {
			playerImage = playerImage_left;
		}
	}
}
