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

public class start extends BasicGameState{
	Image image, help, background;
	public int  delta = 0;
	Music music,click; 
	public start(int state) {
		
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		arg0.setMouseCursor("res/mouse.png", 5, 5);
		background = new Image("res/background.png");
		image = new Image("res/start.png");
		help  = new Image("res/help.png");
		music = new Music("res/music.ogg");
		click = new Music("res/click.ogg");
		System.out.println("start");
		delta = 0;
		music.loop();
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		//arg0.setMouseCursor("res/mouse.png", 5, 5);
		arg2.drawImage(background,0,0);
		arg2.drawImage(image,220,450);
		arg2.drawImage(help,430,450);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		Input input = arg0.getInput();
		delta++;
		//arg0.setMouseCursor("res/mouse.png", 5, 5);
		if(220<=Mouse.getX()&&Mouse.getX() <= 220+image.getWidth() && 50<= Mouse.getY() && Mouse.getY() <= 50+image.getHeight()) {
			if(input.isMouseButtonDown(0)) {
				arg1.getState(5).init(arg0, arg1);
				arg1.enterState(5);
				click.play();
			}
		}
		if(430<=Mouse.getX()&&Mouse.getX() <= 430+help.getWidth() && 50<= Mouse.getY() && Mouse.getY() <= 50+help.getHeight()) {
			if(input.isMouseButtonDown(0) && delta >= 300) {
				music.pause();
				arg1.getState(2).init(arg0,arg1);
				arg1.enterState(2);
				click.play();
				delta = 0;
				
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
