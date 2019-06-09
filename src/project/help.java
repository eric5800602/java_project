package project;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class help extends BasicGameState{
	
	Image returnMain,back,next,back2;
	Music click;
	
	int sta = 1,count = 0;
	
	public help(int state) {
		
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		sta = 1;
		next       = new Image("res/next.png");
		returnMain = new Image("res/returnMain.png");
		back       = new Image("res/helpbackground.png");
		back2       = new Image("res/helpbackground2.png");
		click      =  new Music("res/click.ogg");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		if(sta == 1) {
			arg2.drawImage(back,0,0);
			arg2.drawImage(returnMain,0,500);
			arg2.drawImage(next,650,500);
		}
		if(sta == 2) {
			arg2.drawImage(back2,0,0);
			arg2.drawImage(returnMain,0,500);
			arg2.drawImage(next,650,500);
		}
		
		//arg2.drawImage(back2,0,0);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		Input input = arg0.getInput();
		count = count + 1;
		if(sta == 1 && count > 100) {
			if(0<=Mouse.getX()&&Mouse.getX() <= 0+returnMain.getWidth() && 0<= Mouse.getY() && Mouse.getY() <= 0+returnMain.getHeight()) {
				if(input.isMouseButtonDown(0)) {
					arg1.enterState(0);
					arg1.getState(0).init(arg0, arg1);
					
				}
			}
			if(650<=Mouse.getX()&&Mouse.getX() <= 650+next.getWidth() && 0<= Mouse.getY() && Mouse.getY() <= 0+next.getHeight()) {
				if(input.isMouseButtonDown(0)) {
					sta = 2;
					click.play();
				}
			}
			count = 0;
		}
		if(sta == 2 && count > 100) {
			if(0<=Mouse.getX()&&Mouse.getX() <= 0+returnMain.getWidth() && 0<= Mouse.getY() && Mouse.getY() <= 0+returnMain.getHeight()) {
				if(input.isMouseButtonDown(0)) {
					sta = 1;
					click.play();
				}
			}
			if(650<=Mouse.getX()&&Mouse.getX() <= 650+next.getWidth() && 0<= Mouse.getY() && Mouse.getY() <= 0+next.getHeight()) {
				if(input.isMouseButtonDown(0)) {
					arg1.enterState(0);

					arg1.getState(0).init(arg0, arg1);
					
				}
			}
			count = 0;
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
}
