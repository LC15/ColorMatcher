package game;

import java.awt.image.BufferedImage;

public class RGB {
	
	private int red;
	private int green;
	private int blue;

	/**Constructor: An instance of RGB w/ red value r, blue value b, and green value g */
	public RGB(int r, int g, int b){
		red=r;
		green=g;
		blue=b;
		
	}
	
	/** Finds red, green, and blue color values at a specific pixel */
	public void Colors(BufferedImage im, int x, int y){
		int color = im.getRGB(x,y);
		red=  (color & 0x00ff0000) >> 16;
		green = (color & 0x0000ff00) >> 8;
		blue =  color & 0x000000ff;
		
	}
	
	/**Calculates average red, green, and blue values */
	public void averge(RGB first, RGB second, RGB third){
		red=(first.red + second.red + third.red)/3;
		green=(first.green + second.green + third.green)/3;
		blue=(first.blue + second.blue + third.blue)/3;
		
	}
}



		

	
	
