package project;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Music;

public class battlestart extends BasicGameState{
	public Image background,left,right;
	public String choosenString;
	int time;
	public int delta = 0;
	private int x1 = -70, x2 = 630;
	Music battle;
	public battlestart(int state) {
		
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		time = 0;
		delta = 0;
		background = new Image("res/battlestart.png");
		choosenString = arg1.getState(5).toString();
		if(choosenString.charAt(0) == '1') {
			left = new Image("res/character1_blue.png");
		}
		else if(choosenString.charAt(0) == '2') {
			left = new Image("res/character2_blue.png");
		}
		else if(choosenString.charAt(0) == '3') {
			left = new Image("res/character3_blue.png");
		}
		else if(choosenString.charAt(0) == '4') {
			left = new Image("res/character4_blue.png");
		}
		if(choosenString.charAt(1) == '1') {
			right = new Image("res/character1_red.png");
		}
		else if(choosenString.charAt(1) == '2') {
			right = new Image("res/character2_red.png");
		}
		else if(choosenString.charAt(1) == '3') {
			right = new Image("res/character3_red.png");
		}
		else if(choosenString.charAt(1) == '4') {
			right = new Image("res/character4_red.png");
		}
		battle = new Music("res/johncena.ogg");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		arg2.drawImage(background,0,0);
		arg2.drawImage(right,x2,175);
		arg2.drawImage(left,x1,175);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		if(delta < 3000)
			delta++;
		else {
			arg1.getState(1).init(arg0, arg1);
			arg1.enterState(1);
			x1 = -70;
			x2 = 630;
		}
		if(delta%30 == 29) {
			x1++;
			x2--;
		}
		time++;
		if(time == 2) {
			battle.play();
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 6;
	}

}