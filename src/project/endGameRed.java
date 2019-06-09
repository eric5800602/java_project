package project;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class endGameRed extends BasicGameState{
	Image end,home, exit;
	Image left,right;
	public String choosenString;
	public endGameRed(int state) {
		
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		end = new Image("res/endRed.png");
		home = new Image("res/home.png");
		exit = new Image("res/exit.png");
		choosenString = arg1.getState(5).toString();
		if(choosenString.charAt(0) == '1') {
			left = new Image("res/character_right.png");
		}
		else if(choosenString.charAt(0) == '2') {
			left = new Image("res/character_2_right.png");
		}
		else if(choosenString.charAt(0) == '3') {
			left= new Image("res/character_3_right.png");
		}
		else if(choosenString.charAt(0) == '4') {
			left = new Image("res/character_4_right.png");
		}
		if(choosenString.charAt(1) == '1') {
			right = new Image("res/character.png");
		}
		else if(choosenString.charAt(1) == '2') {
			right = new Image("res/character_2.png");
		}
		else if(choosenString.charAt(1) == '3') {
			right= new Image("res/character_3.png");
		}
		else if(choosenString.charAt(1) == '4') {
			right = new Image("res/character_4.png");
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		arg2.drawImage(end,0,0);
		arg2.drawImage(home,50,430);
		arg2.drawImage(exit,600,430);
		arg2.drawImage(left, 170, 220);
		arg2.drawImage(right, 570, 220);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		arg0.setMouseGrabbed(false);
		Input input = arg0.getInput();
		if(50<=Mouse.getX()&&Mouse.getX() <= 50+home.getWidth() && 20<= Mouse.getY() && Mouse.getY() <= 20+home.getHeight()) {
			if(input.isMouseButtonDown(0)) {
				arg1.getState(1).init(arg0,arg1);
				arg1.getState(0).init(arg0,arg1);
				arg1.enterState(0);
			}
		}
		if(600<=Mouse.getX()&&Mouse.getX() <= 600+home.getWidth() && 20<= Mouse.getY() && Mouse.getY() <= 20+home.getHeight()) {
			if(input.isMouseButtonDown(0)) {
				arg0.exit();
			}
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 4;
	}
}
