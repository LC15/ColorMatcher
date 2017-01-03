package gui;


import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import game.RGB;


/** Frame for the ColorMatcher game. */
public class GUI extends JFrame {
	
	//Box mainBox = new Box(BoxLayout.X_AXIS);
	//Box imageBox = new Box(BoxLayout.Y_AXIS);
	private BufferedImage chosenb;
	private ImageIcon chosenimage;
	//int level=1;
	private int count=1;	
	//private int level=1;//to keep track of what screen we're on
	//private int count=0; //to keep track of #ofclicks when user specifies the points
	private JButton browse;
	private JLabel label;
	private JLabel message;
	private RGB one;
	private RGB two;
	private RGB three; 
	private RGB avgRGB;

	

	/** Constructor */
	public GUI() {
		super("ColorMatcher Game");
		addHomeSComponents();
		setSize(700,400);
		setVisible(true);
		
	}
	
	
	/** Add components of the GUI to mainBox */
	private void addHomeSComponents(){
		
		browse = new JButton("Browse an Image");
		browse.setBounds(250,300,200,50);
		message=new JLabel();
		message.setText("You're on click number " + count );
		message.setBounds(275,335,200,50);
		label=new JLabel();
		MouseHandler handler = new MouseHandler();
		label.addMouseListener(handler);
		//label.setSize(400,400);
		add(message);
		add(browse);
		add(label);
		
		browse.addActionListener(new ActionListener() {
			/** allows user to choose an image once browse button is clicked */
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","gif","png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result ==JFileChooser.APPROVE_OPTION){
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					try {
						label.setIcon(showImage(path));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (result==JFileChooser.CANCEL_OPTION){
					System.out.println("No File Selected");
				}
					
			}
		});
	
	}
	
	/**Show the chosen image as a BufferedImage
	 * @throws IOException */
	public ImageIcon showImage (String imagepath) throws IOException{
		File file = new File(imagepath);
		BufferedImage chosenb = ImageIO.read(file);
		
		chosenimage = new ImageIcon(chosenb);
		return chosenimage;
	} 
	
	/** When the image is clicked, count increases, and an RGB is assigned to each pixel clicked*/
	private class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if (count==1){
				int x=e.getX();
				int y=e.getY();
				one=RGB.Colors(chosenb, x,y);
				count++;
			}
			
			else if (count ==2){
				int x=e.getX();
				int y=e.getY();
				two=RGB.Colors(chosenb, x,y);
				count++;
			}
			else if (count==3){
				int x=e.getX();
				int y=e.getY();
				three=RGB.Colors(chosenb, x,y);
				JOptionPane.showMessageDialog(message, "The average color of your three clicks is: " + avgRGB);
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
	//public void addPointComponents(){
	//JTextField jt=new JTextField("With your mouse click on 3 points in the image "
		//	+ "that fall in the area with the color you want identify");
	//add(jt);
	//}
	
	
	/** Show the GUI  */
	public static void main(String[] pars) {
		GUI gui = new GUI();
	}
}
	 

