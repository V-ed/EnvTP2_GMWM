package objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private BufferedImage imageArtiste = null;
	
	private Image imageNoImage;
	
	public ImagePanel(Image imageNoImage){
		
		super();
		
		this.imageNoImage = imageNoImage;
		
	}
	
	@Override
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		if(imageArtiste == null){
			g.drawImage(imageNoImage, 0, 0, getWidth(), getHeight(), this);
		}
		else{
			g.drawImage(imageArtiste, 0, 0, getWidth(), getHeight(), this);
		}
		
	}
	
	public BufferedImage getImageArtiste(){
		return imageArtiste;
	}
	
	public void setImageArtiste(BufferedImage imageArtiste){
		this.imageArtiste = imageArtiste;
	}
	
}
