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
	public RGB Colors(BufferedImage im, int x, int y){
		int color = im.getRGB(x,y);
		int r=  (color & 0x00ff0000) >> 16;
		int g = (color & 0x0000ff00) >> 8;
		int b=  color & 0x000000ff;
		RGB a = new RGB(r,g,b);
		return a;
	}
	
	/**Calculates average red, green, and blue values */
	public static  RGB average(RGB first, RGB second, RGB third){
		
		int r=(first.red + second.red + third.red)/3;
		int g=(first.green + second.green + third.green)/3;
		int b=(first.blue + second.blue + third.blue)/3;
		RGB a=new RGB(r,g,b);
		return a;
	}
	public static void main(String[] args){
		RGB rgb1= new RGB(1,2,3);
		RGB rgb2= new RGB(3,2,1);
		RGB rgb3= new RGB(2,2,3);
		RGB a = average(rgb1, rgb2,rgb3);
		System.out.println(a.red);
		
	}

}





		

	
	
