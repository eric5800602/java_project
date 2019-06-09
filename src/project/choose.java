package project;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Music;


public class choose extends BasicGameState{
	public Image img,cha1,cha2;
	public Image circle1, circle2;
	public int left_index = 0,right_index = 0,delta = 0;
	public String choosenString;
	Music click,choose;
	public Rectangle ran;
	public choose(int state) {
		
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		left_index = 1;
		right_index = 1;
		choosenString = "11";
		delta = 0;
		img = new Image("res/choose_character.png");
		circle1 = new Image("res/circle.png");
		circle2 = new Image("res/circle.png");
		click = new Music("res/click.ogg");
		choose = new Music("res/choose.ogg");
		cha1 = new Image("res/character_right.png");
		cha2 = new Image("res/character.png");
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		arg2.drawImage(img, 0, 0);
		switch (left_index) {
		case 1:
			arg2.drawImage(circle1, 65, 135);
			cha1 = new Image("res/character_right.png");
			arg2.drawImage(cha1, 100, 450);
			break;
		case 2:
			arg2.drawImage(circle1, 196, 135);
			cha1 = new Image("res/character_2_right.png");
			arg2.drawImage(cha1, 100, 450);
			break;
		case 3:
			arg2.drawImage(circle1, 65, 252);
			cha1 = new Image("res/character_3_right.png");
			arg2.drawImage(cha1, 100, 450);
			break;
		case 4:
			arg2.drawImage(circle1, 196, 252);
			cha1 = new Image("res/character_4_right.png");
			arg2.drawImage(cha1, 100, 450);
			break;
		default:
//			System.out.println("choose error");
			break;
		}
		switch (right_index) {
		case 1:
			arg2.drawImage(circle2, 463, 135);
			cha2 = new Image("res/character.png");
			arg2.drawImage(cha2, 600, 450);
			break;
		case 2:
			arg2.drawImage(circle2, 592, 135);
			cha2 = new Image("res/character_2.png");
			arg2.drawImage(cha2, 600, 450);
			break;
		case 3:
			arg2.drawImage(circle2, 465, 252);
			cha2 = new Image("res/character_3.png");
			arg2.drawImage(cha2, 600, 450);
			break;
		case 4:
			arg2.drawImage(circle2, 592, 252);
			cha2 = new Image("res/character_4.png");
			arg2.drawImage(cha2, 600, 450);
			break;
		default:
//			System.out.println("choose error");
			break;
		}
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		if(delta < 300)
			delta++;
		Input input = arg0.getInput();
		/*
		if(input.isMouseButtonDown(0)) {
			System.out.println(input.getMouseX());
			System.out.println(input.getMouseY());
		}
		*/
		if(input.isMouseButtonDown(0) && delta >= 300) {
			if(input.getMouseX()>= 92 && input.getMouseX() <= 183 && input.getMouseY()>=152&&input.getMouseY()<=248) {
				left_index = 1;
				choose.play();
			}
			if(input.getMouseX()>= 223 && input.getMouseX() <= 317 && input.getMouseY()>=152&&input.getMouseY()<=248) {
				left_index = 2;
				choose.play();
			}
			if(input.getMouseX()>= 92 && input.getMouseX() <= 183 && input.getMouseY()>=269&&input.getMouseY()<=365) {
				left_index = 3;
				choose.play();
			}
			if(input.getMouseX()>= 223 && input.getMouseX() <= 317 && input.getMouseY()>=269&&input.getMouseY()<=365) {
				left_index = 4;
				choose.play();
			}
			if(input.getMouseX()>= 492 && input.getMouseX() <= 585 && input.getMouseY()>=152&&input.getMouseY()<=248) {
				right_index = 1;
				choose.play();
			}
			if(input.getMouseX()>= 621 && input.getMouseX() <= 714 && input.getMouseY()>=152&&input.getMouseY()<=248) {
				right_index = 2;
				choose.play();
			}
			if(input.getMouseX()>= 492 && input.getMouseX() <= 585 && input.getMouseY()>=269&&input.getMouseY()<=365) {
				right_index = 3;
				choose.play();
			}
			if(input.getMouseX()>= 621 && input.getMouseX() <= 714 && input.getMouseY()>=269&&input.getMouseY()<=365) {
				right_index = 4;
				choose.play();
			}
			choosenString = Integer.toString(left_index)+Integer.toString(right_index);
			//System.out.println(choosenString);
			if(input.getMouseX()>= 340 && input.getMouseX() <= 458 && input.getMouseY()>=397&&input.getMouseY()<=508) {
				arg1.getState(6).init(arg0, arg1);
				arg1.enterState(6);
				//click.play();
			}
		}
	}
	
	@Override
	public String toString() {
		return choosenString;
	}
	public int getID() {
		// TODO Auto-generated method stub
		return 5;
	}
}
