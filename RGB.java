package game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import gui.GUI;


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
	public RGB(Color color){
		this.red=  color.getRed();
		this.green = color.getGreen();
		this.blue =  color.getBlue();
	}

	
	/**Calculates average red, green, and blue values */
	public RGB(RGB first, RGB second, RGB third){	
		this.red=(first.red + second.red + third.red)/3;
		this.green=(first.green + second.green + third.green)/3;
		this.blue=(first.blue + second.blue + third.blue)/3;
	}
	
	public int getRed(){
		return red;
	}
	
	public int getGreen(){
		return green;
	}
	
	public int getBlue(){
		return blue;
	}
	
	}





		

	
	
