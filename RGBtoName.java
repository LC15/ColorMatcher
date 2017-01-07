
import java.util.ArrayList;
import java.util.Arrays;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class RGBtoName {
	
	public String RGBtoN(RGB rgb){
		System.out.println("testing...");
		
		
		String colorName="Color Name Unknown";
		//file to arraylist
		ArrayList <String> colorArrayL  = new ArrayList <String>();
		ArrayList <String> colorAL =new ArrayList <String>();
		ArrayList <String> colorNameAL = new ArrayList <String>();
		ArrayList <Integer> redAL =  new ArrayList <Integer>();
		ArrayList <Integer> greenAL = new ArrayList <Integer>();
		ArrayList <Integer> blueAL=  new ArrayList <Integer>();
		
		File colors = new File("colors.txt");
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(colors);	
			scanner.useDelimiter(", *");
			
			while(scanner.hasNext()){
				colorArrayL.add(scanner.next());
		}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	for (int i=0;i<554;i=i+4){
			colorNameAL.add(colorArrayL.get(i));
			redAL.add(Integer.parseInt((colorArrayL.get(i+1)).trim()));
			greenAL.add(Integer.parseInt((colorArrayL.get(i+2)).trim()));
			blueAL.add(Integer.parseInt((colorArrayL.get(i+3)).trim()));
		}
		

		 	int low = 0;
	        int hi = redAL.size()-1;
	        int mid=0;
	        //this while loop will enact a binary search to find a matching red value to RGB input
	        while (low <= hi) { 
	            
	            mid = low + (hi - low) / 2;
	            if      (rgb.getRed() < redAL.get(mid)) {
	            	hi = mid - 1;
	            }
	            
	            else if (rgb.getRed() > redAL.get(mid)){
	            	low = mid + 1;
	            }
	            else if(rgb.getRed()==redAL.get(mid)){break;}
	        }
	        
	        
	        System.out.println(low +" value of low after binary while loop");
	        System.out.println(hi +" value of hi after binary while loop");
	        System.out.println(rgb.getRed()+" RED " + rgb.getGreen()+ " GREEN " +rgb.getBlue()+ " BLUE ");
	        
	        int n=mid;
	        int save =0;
	        int diffg =0;
	        int diffb=0;
	        if(rgb.getRed()==redAL.get(mid) || Math.abs(rgb.getRed()-redAL.get(mid)) < 30 ){
	        	while(rgb.getRed() == redAL.get(n)){
	        		n=n-5;
	        		
	        	}
	        	while((rgb.getGreen()!= greenAL.get(n) && rgb.getBlue() != blueAL.get(n))&& n<60){
	        		n++;
	        		if (Math.abs(rgb.getGreen()-greenAL.get(n))<30 && Math.abs(rgb.getBlue() - blueAL.get(n)) < 10 ){
	        			save=n;
	        			diffg=Math.abs(rgb.getGreen()-greenAL.get(n));
	        			diffb=Math.abs(rgb.getBlue() - blueAL.get(n));
	        		}
	        		
	        	}
	        	
	        }
	        else{}
	        //replace with a for
		
		if(rgb.getRed() == redAL.get(n) && rgb.getGreen()== greenAL.get(n) && rgb.getBlue() == blueAL.get(n)){
			colorName = colorNameAL.get(n);
		}
		else{
			colorName = colorNameAL.get(n);
		}
		//add ArrayList to similar color if not on file
		
		return colorName;
	}
	}

