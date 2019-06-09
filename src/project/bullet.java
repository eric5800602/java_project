package project;

import org.newdawn.slick.Image;
import java.math.*;
public class bullet {
	public Image img = null;
	public float bullet_x,bullet_y,rate,upperbound = 300,length = 0,t = 0;
	public int damage;
	public boolean shoot = false,collision = false,down = false;
	public player p;
	public bullet(Image i,float x,float y,float r,player pt,int d) {
		// TODO Auto-generated constructor stub
		img = i;
		bullet_x = x;
		bullet_y = y;
		rate = r;
		p = pt;
		damage = d;
	}
	public void render(player pt) {
		p = pt;
		if(shoot) {			
			bullet_x += rate*0.02*0.3f;
			bullet_y -= Math.sin((Math.toRadians(45)))*length*0.007f-0.98*t;
			System.out.println(bullet_x);
			System.out.println(bullet_y);
			t+=0.0005f;
			/*
			if(!down) {
				bullet_y -= 0.2f;
			}
			else {
				bullet_y += 0.2f;
			}
			if(bullet_y<=upperbound) {
				down = true;
			}
			*/
		}
		//System.out.println(p.player_index);
		if(p.player_index == 1) {//p1 collision
			if(p.inrange(bullet_x, bullet_y)
			   ||p.inrange(bullet_x + img.getWidth(), bullet_y)
			   ||p.inrange(bullet_x, bullet_y+img.getHeight())
			   ||p.inrange(bullet_x + img.getWidth(), bullet_y + img.getHeight())) {
				collision = true;
				if(damage == -1 && p.player_health <= 1) {
					p.player_health = 0;
				}
				else if(damage == -2 && p.player_health <= 2) {
					p.player_health = 0;
				}
				else if(p.player_health<10)
					p.player_health+=damage;
				//System.out.print("collision");
			}
		}
		else if(p.player_index == 2){//p2 collision
			if(p.inrange(bullet_x, bullet_y)
					   ||p.inrange(bullet_x + img.getWidth(), bullet_y)
					   ||p.inrange(bullet_x, bullet_y+img.getHeight())
					   ||p.inrange(bullet_x + img.getWidth(), bullet_y + img.getHeight())){
				collision = true;
				if(damage == -1 && p.player_health <= 1) {
					p.player_health = 0;
				}
				else if(damage == -2 && p.player_health <= 2) {
					p.player_health = 0;
				}
				else if(p.player_health<10)
					p.player_health+=damage;
				//System.out.print("collision");
			}
		}
	}
}
