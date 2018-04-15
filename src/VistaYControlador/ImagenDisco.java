package VistaYControlador;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class ImagenDisco extends JLabel implements MouseMotionListener{

	private int posX;
	private int posY;
	private int tamX;
	Image imagenDisco;
	public ImagenDisco(int posY, int ref, int torre){
		this.posY = posY;
		crearDisco(ref);
		switch (ref){
		case 1:  tamX=74; break;
		case 2:  tamX=88; break;
		case 3:  tamX=102; break;
		case 4:  tamX=116; break;
		case 5:  tamX=130; break;
		case 6:  tamX=144; break;
		case 7:  tamX=158; break;
		case 8:  tamX=172; break;
		case 9:  tamX=186; break;
		case 10: tamX=200; break;
		}
		switch (ref){
		case 1:  posX=83; break;
		case 2:  posX=76; break;
		case 3:  posX=69; break;
		case 4:  posX=62; break;
		case 5:  posX=55; break;
		case 6:  posX=48; break;
		case 7:  posX=41; break;
		case 8:  posX=34; break;
		case 9:  posX=27; break;
		case 10: posX=20; break;
		}
		switch (torre){
		case 2:  posX=posX+220; break;
		case 3:  posX=posX+440;break;
		}
		addMouseMotionListener(this);
	}
	public void crearDisco(int ref){
		imagenDisco = Toolkit.getDefaultToolkit().getImage("discos/"+ref+".png");
	}
	
	public void paint(Graphics g,JPanel j){
		g.drawImage(imagenDisco,posX,posY,tamX,50,j);
							
	}
	
	public void mouseDragged(MouseEvent mme) {
		setLocation(
				//this.getX() + mme.getX() - this.getWidth() / 2,
				//this.getY() + mme.getY() - this.getHeight() / 2
				posX=posX + mme.getX()- this.getWidth() / 2,
				posY=posY + mme.getY()- this.getHeight() / 2
				);
		repaint();
	}
	public void mouseMoved(MouseEvent mme) {}
	
	
}
