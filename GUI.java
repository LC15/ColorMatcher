package gui;


import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/** Frame for the ColorMatcher game. */
public class GUI extends JFrame {
	
	//Box mainBox = new Box(BoxLayout.X_AXIS);
	//Box imageBox = new Box(BoxLayout.Y_AXIS);
	
	
	
	JButton browse;
	JLabel label;
	//JButton startbutton;
	
	//browse.addActionListener(this);
	

	/** Constructor */
	public GUI() {
		super("ColorMatcher Game");
	
		addComponents();
		
		//getContentPane().add(mainBox, BorderLayout.WEST);
		//getContentPane().add(imageBox, BorderLayout.EAST);
		setSize(700,400);
		setVisible(true);
		
	}

	/** Add components of the GUI to mainBox */
	private void addComponents(){
		//startbutton = new JButton("Start Game");

		
		browse = new JButton("Browse an Image");
		browse.setBounds(250,300,200,50);
		label=new JLabel();
		label.setSize(200,200);
		add(browse);
		add(label);
		//imageBox.add(label);
		//mainBox.add(browse);
		//add(imageBox);
		//add(mainBox);
		
		//allows user to choose an image once browse button is clicked
		browse.addActionListener(new ActionListener() {
			
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
		BufferedImage bufferedImage = ImageIO.read(file);
		ImageIcon image = new ImageIcon(bufferedImage);
		return image;
	} 
	

	/** Show the GUI  */
	public static void main(String[] pars) {
		GUI gui = new GUI();
	}

	

}
	 