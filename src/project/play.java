package project;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;


public class play extends StateBasedGame{
	public static final String name = "Food Fight";
	public static final int battlestart = 6;
	public static final int choose = 5;
	public static final int endGameRed = 4;
	public static final int endGameBlue = 3;
	public static final int help = 2;
	public static final int main = 1;
	public static final int start = 0;
	public play(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.addState(new battlestart(battlestart));
		this.addState(new choose(choose));
		this.addState(new endGameRed(endGameRed));
		this.addState(new endGameBlue(endGameBlue));
		this.addState(new help(help));
		this.addState(new start(start));
		this.addState(new main(main));
	}
	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		this.getState(choose).init(arg0, this);
		this.getState(battlestart).init(arg0, this);
		this.getState(endGameRed).init(arg0, this);
		this.getState(endGameBlue).init(arg0, this);
		this.getState(help).init(arg0, this);
		this.getState(start).init(arg0, this);
		this.getState(main).init(arg0, this);
		this.enterState(start);
	}
	public static void main(String[] args) throws SlickException {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new play(name));
			app.setDisplayMode(800, 600, false);
			app.start();
		}catch (SlickException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
