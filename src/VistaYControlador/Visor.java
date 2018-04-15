package VistaYControlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Visor extends JPanel{

	Image imagen;
	MediaTracker tracker;
	private HanoiGUI vyc;
	private int posY=430;
	private ArrayList<ImagenDisco> imagenDisco = new ArrayList<ImagenDisco>();
	
	public Visor(HanoiGUI vyc){
		this.vyc=vyc;
		imagen= Toolkit.getDefaultToolkit().getImage("discos/bien.jpg");
			
	}
	
	
	/**ESTO ERSTAS TRABAJANDO*/
	public void addDiscos(ArrayList<Integer> a,int torre){
		
		int posY=386;
			for(int i=a.size()-2;i>=0;i--){
				int referencia=a.get(i);
				if(referencia>0&&referencia<=10){
				imagenDisco.add (new ImagenDisco(posY,referencia,torre));
				}
				posY=posY-34;
			}
	}
	public void borrarDiscos(){
		imagenDisco.clear();
	}
	/***aqui cambiaste**/
	
	public void paint(Graphics g){
		
		g.drawImage(imagen,0,0,getSize().width,getSize().height,this);
		dibujarDiscos(g);
	    //g.setColor(Color.white);
	    g.setFont(new Font("Arial",Font.BOLD,20));
	    g.setColor(Color.red);
	    g.drawString("Torre A", 85, 458);
	    g.setColor(Color.yellow);
	    g.drawString("Torre B", 305, 458);
	    g.setColor(Color.green);
	    g.drawString("Torre C", 525, 458);
	}

	public void dibujarDiscos(Graphics g){
		for(int i=0;i< imagenDisco.size();i++){
		       imagenDisco.get(i).paint(g,this);
		       }
	}
}
