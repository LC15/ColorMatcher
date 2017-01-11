
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
	
	for (int i=0;i<2213;i=i+4){
			colorNameAL.add(colorArrayL.get(i));
			redAL.add(Integer.parseInt((colorArrayL.get(i+1)).trim()));
			greenAL.add(Integer.parseInt((colorArrayL.get(i+2)).trim()));
			blueAL.add(Integer.parseInt((colorArrayL.get(i+3)).trim()));
		}
		

		 	int low = 0;
	        int hi = redAL.size()-1;
	        int mid= redAL.size()/2;
	        int countWhile=0;
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
	            countWhile++;
	        }
	        System.out.println(countWhile + "number of while loops");
	        System.out.println(colorArrayL.size()+"size of CAL "+ colorNameAL.size()+ "color name AL "+ redAL.size()+" red AL "+ greenAL.size()+ " green AL "+ blueAL.size()+ " blue AL" );
	        System.out.println(low +" value of low after binary while loop");
	        System.out.println(hi +" value of hi after binary while loop");
	        System.out.println(mid+" mid ");
	        System.out.println(rgb.getRed()+" RED " + rgb.getGreen()+ " GREEN " +rgb.getBlue()+ " BLUE ");
	        
	        int n=mid;
	        int save =0;
	        int diffg =0;
	        int diffb=0;
	        
	        while(Math.abs(rgb.getRed()- redAL.get(n))<30){
	        		n=n-5;
	        	}
	        System.out.println(n+ " first while n");
	       
	        while((Math.abs(rgb.getGreen()-greenAL.get(n))>20) || (Math.abs(rgb.getBlue() - blueAL.get(n)) > 20) ){
	        		n++;
	        		save=n;
	        			//diffg=Math.abs(rgb.getGreen()-greenAL.get(n));
	        			//diffb=Math.abs(rgb.getBlue() - blueAL.get(n));	
	        	}
	        	
	        
	        //replace with a for
	        System.out.println(n+ " final n");
	        System.out.println(save+ " save ");
		
		
		
			colorName = colorNameAL.get(n);
		
		//add ArrayList to similar color if not on file
		
		return colorName;
	}
	}

