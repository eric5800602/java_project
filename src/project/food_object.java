package project;

import org.newdawn.slick.Image;

public class food_object {
	public Image img;
	public float food_x,food_y,food_center_x,food_center_y;
	public int value;
	public boolean draw = true;
	public food_object(Image i,float x,float y) {
		// TODO Auto-generated constructor stub
		img = i;
		food_x =x;
		food_y = y;
		food_center_x = (food_x + i.getWidth()/2);
		food_center_y = (food_y + i.getHeight()/2);
		switch(img.getResourceReference()) {
		case"res/hamburger.png":
			value = 4;
			break;
		case"res/cake.png":
			value = 2;
			break;
		case"res/donunt.png":
			value = 1;
			break;
		case"res/fried.png":
			value = 3;
			break;
		case"res/greenpepper.png":
			value = -1;
			break;
		case"res/hotdog.png":
			value = 2;
			break;
		case"res/orange.png":
			value = -2;
			break;
		case"res/sushi.png":
			value = 1;
			break;
		case"res/bubbletea.png":
			value = 4;
			break;
		}
	}
	public void add_y() {
		food_y = food_y + 0.15f;
		food_center_y = (food_y + img.getHeight()/2);
	}
}
