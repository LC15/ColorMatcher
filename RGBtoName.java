
import java.util.ArrayList;

import java.io.*;
import java.util.Scanner;

public class RGBtoName {
	
	public String RGBtoN(RGB rgb){
		//convert file to string
		//String colorS = new String(Files.readAllBytes(Paths.get("colors.txt")));
		String colorName="Color Name Unknown";
		//file to arraylist
		ArrayList <String> colorAL  = new ArrayList <String>();
		ArrayList <String> colorNameAL = new ArrayList <String>();
		ArrayList <Integer> redAL =  new ArrayList <Integer>();
		ArrayList <Integer> greenAL = new ArrayList <Integer>();
		ArrayList <Integer> blueAL=  new ArrayList <Integer>();
		
		Scanner scanner = null;
		try {
			scanner = new Scanner( new File("colors.txt") );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		colorAL.add(scanner.useDelimiter("(").next());
		scanner.close(); 
		for (int i=0;i<554;i=i+4){
			colorNameAL.add(colorAL.get(i));
			redAL.add(Integer.parseInt(colorAL.get(i+1)));
			greenAL.add(Integer.parseInt(colorAL.get(i+2)));
			blueAL.add(Integer.parseInt(colorAL.get(i+3)));
		}
		
		//ArrayList <String> colorAL  = new ArrayList <String> (Arrays.asList(colorS.split("(")));
		//ArrayList <RGB> colorRGB =new ArrayList <RGB>();
		
		//ArrayList to name if on file
		 	int low = 0;
	        int hi = redAL.size()-1;
	        int mid=0;
	        while (low <= hi) { //add how to break this if the number is never matched
	            
	            mid = low + (hi - low) / 2;
	            if      (rgb.getRed() < redAL.get(mid)) {
	            	hi = mid - 1;
	            }
	            
	            else if (rgb.getRed() > redAL.get(mid)){
	            	low = mid + 1;
	            }
	            else {break;}
	        }
	        int n=mid;
	        if(rgb.getRed()==redAL.get(mid)){
	        	while(rgb.getRed() == redAL.get(n)){
	        		n=n-5;
	        	}
	        	while((rgb.getGreen()!= greenAL.get(n) && rgb.getBlue() != blueAL.get(n))&& n<60){
	        		n++;
	        	}
	        }
	        else{
	        	
	        }
	        //replace with a for
		
		if(rgb.getRed() == redAL.get(n) && rgb.getGreen()== greenAL.get(n) && rgb.getBlue() == blueAL.get(n)){
			colorName = colorNameAL.get(n);
		}
		//add ArrayList to similar color if not on file
		
		return colorName;
	}
	}

/*
binary search
start at middle 
if m>r, go back
middle of second half
int n= 554;
lists for each variable instead
while(n>0){
if(red.n/2 check)
	n
if m<r, go fwd

compare red value
issue: several have the same red value. how to decide where to start?

*/