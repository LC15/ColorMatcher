package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import game.RGB;


/** Frame for the ColorMatcher game. */
public class GUI extends JFrame {

	private BufferedImage chosenb;
	private ImageIcon chosenimage;
	private int count=1;	

	private JButton browse;
	//private JButton click;
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
		//click = new JButton("click me");
		//click.setBounds(10,10,10,10);
		browse = new JButton("Browse an Image");
		browse.setBounds(250,300,200,50);
		
		label=new JLabel();
		//When the image is clicked, count increases, and an RGB is assigned to each pixel clicked
		label.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//count =1;
				if (count==1){
				
					int x=e.getX();
					int y=e.getY();
					//System.out.println(chosenb.getRGB(x,y));
					int col = chosenb.getRGB(x, y);
					Color c = new Color(col,true);
					one=new RGB(c);
					count++;
					message.setText("You're on click number " + count );
				}
				
				else if (count ==2){
					int x=e.getX();
					int y=e.getY();
					int col = chosenb.getRGB(x, y);
					Color c = new Color(col,true);
					two=new RGB(c);
					count++;
					message.setText("You're on click number " + count );
				}
				else if (count==3){
					int x=e.getX();
					int y=e.getY();
					int col = chosenb.getRGB(x, y);
					Color c = new Color(col,true);
					three=new RGB(c);
					avgRGB=new RGB(one,two,three);
					JOptionPane.showMessageDialog(message, "The average color of your three clicks is: " + avgRGB);
				}
				
			}
		});
		
		message=new JLabel();
		message.setText("You're on click number " + count );
		message.setBounds(275,335,200,50);
		
		
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
		
		add(message);
		add(browse);
		add(label);
		//add(click);
	}
	
	/**Show the chosen image as a BufferedImage
	 * @throws IOException */
	public ImageIcon showImage (String imagepath) throws IOException{
		File file = new File(imagepath);
		chosenb = ImageIO.read(file);
		chosenimage = new ImageIcon(chosenb);
		return chosenimage;
	} 

	
	/** Show the GUI  */
	public static void main(String[] pars) {
		GUI gui = new GUI();
	}
}
	 

