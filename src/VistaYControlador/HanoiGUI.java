package VistaYControlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javax.swing.*;
import javax.swing.event.ChangeEvent;


//import vistaYcontrolador.BatallaNaval;
//import vistaYcontrolador.TableroVision;

import modelo.Modelo;

public class HanoiGUI extends JFrame implements ActionListener{
	JLabel fondo;
	private Modelo modelo;
	private Visor vis;
	private Timer t;
	private int h, m, s, ms;
	
	boolean torreA,torreB,torreC;
	
	private JButton btAaB, btAaC, btBaA, btBaC, btCaA, btCaB;
	JLabel cant, cantOp, gano, cronometro; 
	
	private String presionado="";
	private int cont=0;
	
	public HanoiGUI(Modelo mod){
		modelo=mod;
		crearComponentes();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
			SwingUtilities. updateComponentTreeUI(null) ;
		} catch (Exception eX) {}
		vis = new Visor(HanoiGUI.this);
		vis.setBounds(60,10,680,500);//680,500
		getContentPane().add(vis);
		vis.setVisible(true);
		pintarDiscos();
		setFocusable(true);
		
		this.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int tecla;
				tecla = e.getKeyCode();
				/*if(tecla==KeyEvent.VK_1){
					presionado = presionado+"1";
				}else if(tecla==KeyEvent.VK_2){
					presionado = presionado+"2";
				}else if(tecla==KeyEvent.VK_3){
					presionado = presionado+"3";
				}*/
				if(tecla== KeyEvent.VK_Q){
					modelo.moverDeA(modelo.getPA(), modelo.getPB());
					pintarDiscos();
				}else if(tecla== KeyEvent.VK_A){
					modelo.moverDeA(modelo.getPA(), modelo.getPC());
					pintarDiscos();
				}else if(tecla== KeyEvent.VK_W){
					modelo.moverDeA(modelo.getPB(), modelo.getPA());
					pintarDiscos();
				}else if(tecla== KeyEvent.VK_S){
					modelo.moverDeA(modelo.getPB(), modelo.getPC());
					pintarDiscos();
				}else if(tecla== KeyEvent.VK_E){
					modelo.moverDeA(modelo.getPC(), modelo.getPB());
					pintarDiscos();
				}else if(tecla== KeyEvent.VK_D){
					modelo.moverDeA(modelo.getPC(), modelo.getPA());
					pintarDiscos();
				}
				cant.setText("Cantidad de movimientos realizados: "+modelo.getCantMovimientos());
				gano();
			}
		});
		setFocusable(true);//esto era lo q me faltaba para poder mover con teclado, q asco!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
        t=new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++ms; 
                if(ms==60){
                    ms = 0;
                    ++s;
                }
                if(s==60){
                    s = 0;
                    ++m;
                }
                if(m==60){
                    m = 0;
                    ++h;
                }
                actualizarLabel();	
            }
            
        });
        t.start();
        /*
        t2=new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	++cont;
            	if(cont==5){
            		presionado="";
            		moverDisco();
            		cont=0;
            	}
            }
            
        });
        t2.start();*/
	}
	public void moverDisco(){
		if(presionado.equals("12")){
			modelo.moverDeA(modelo.getPA(), modelo.getPB());
			pintarDiscos();
		}else if(presionado.equals("13")){
			modelo.moverDeA(modelo.getPA(), modelo.getPC());
			pintarDiscos();
		}else if(presionado.equals("21")){
			modelo.moverDeA(modelo.getPB(), modelo.getPA());
			pintarDiscos();
		}else if(presionado.equals("23")){
			modelo.moverDeA(modelo.getPB(), modelo.getPC());
			pintarDiscos();
		}else if(presionado.equals("31")){
			modelo.moverDeA(modelo.getPC(), modelo.getPA());
			pintarDiscos();
		}else if(presionado.equals("32")){
			modelo.moverDeA(modelo.getPC(), modelo.getPB());
			pintarDiscos();
		}
	}
	public void pintarDiscos(){
		vis.borrarDiscos();
		vis.addDiscos(modelo.getA(),1);
		vis.addDiscos(modelo.getB(),2);
		vis.addDiscos(modelo.getC(),3);
		vis.repaint();
	}
	
	public void crearComponentes(){
		fondo=new JLabel();
		fondo.setIcon(new ImageIcon(new ImageIcon("discos/inicio.jpg").getImage().getScaledInstance(800,700,5)));
	    fondo.setSize(800,700);
	    this.setContentPane(fondo);
	    setTitle("Torres de Hanoi");
		setSize(800,700);
	
        cant = new JLabel();
        cant.setBounds(40, 625, 350, 38);
        cant.setForeground(Color.white);
        cant.setFont(new Font("Arial",Font.BOLD,17));
        cant.setText("Cantidad de movimientos realizado: 0");
        getContentPane().add(cant);
        
        cantOp = new JLabel();
        cantOp.setBounds(420, 625, 350, 38);
        cantOp.setForeground(Color.white);
        cantOp.setFont(new Font("Arial",Font.BOLD,17));
        cantOp.setText("Cantidad de movimientos optimo: "+modelo.getCantMovOptimo());
        getContentPane().add(cantOp);
        
        gano = new JLabel();
        gano.setBounds(100, 555, 320, 38);
        gano.setForeground(Color.red);
        gano.setFont(new Font("Arial",Font.BOLD,20));
        gano.setText("Juego terminado... Lo lograste!!");
        getContentPane().add(gano);
        gano.setVisible(false);
        
        cronometro = new JLabel();
        cronometro.setBounds(350, 500, 150, 38);
        cronometro.setForeground(Color.white);
        cronometro.setFont(new Font("Arial",Font.BOLD,20));
        cronometro.setText("00:00:00:00");
        getContentPane().add(cronometro);

        //los botones
        btAaB = new JButton("A => B");
        btAaB.setBounds(120, 530, 120, 38);
        btAaB.setBackground(Color.yellow);
        btAaB.setFont(new Font("Arial",Font.BOLD,19));
        btAaB.addActionListener(this);
        getContentPane().add(btAaB);
        
        btAaC = new JButton("A => C");
        btAaC.setBounds(120, 580, 120, 38);
        btAaC.setBackground(Color.green);
        btAaC.setFont(new Font("Arial",Font.BOLD,19));
        btAaC.addActionListener(this);
        getContentPane().add(btAaC);
        
        btBaA = new JButton("B => A");
        btBaA.setBounds(340, 530, 120, 38);
        btBaA.setBackground(Color.red);
        btBaA.setFont(new Font("Arial",Font.BOLD,19));
        btBaA.addActionListener(this);
        getContentPane().add(btBaA);
        
        btBaC = new JButton("B => C");
        btBaC.setBounds(340, 580, 120, 38);
        btBaC.setBackground(Color.green);
        btBaC.setFont(new Font("Arial",Font.BOLD,19));
        btBaC.addActionListener(this);
        getContentPane().add(btBaC);
        
        btCaA = new JButton("C => A");
        btCaA.setBounds(560, 580, 120, 38);
        btCaA.setBackground(Color.red);
        btCaA.setFont(new Font("Arial",Font.BOLD,19));
        btCaA.addActionListener(this);
        getContentPane().add(btCaA);
        
        btCaB = new JButton("C => B");
        btCaB.setBounds(560, 530, 120, 38);
        btCaB.setBackground(Color.yellow);
        btCaB.setFont(new Font("Arial",Font.BOLD,19));
        btCaB.addActionListener(this);
        getContentPane().add(btCaB);
	}

    public void actionPerformed(ActionEvent e) {
    	Object obj = e.getSource();
    	if(obj == btAaB){
    		modelo.moverDeA(modelo.getPA(), modelo.getPB());
    		pintarDiscos();
    		
    	}
    	else if(obj == btAaC){
    		modelo.moverDeA(modelo.getPA(), modelo.getPC());
    		pintarDiscos();
    		
    	}
    	else if(obj == btBaA){
    		modelo.moverDeA(modelo.getPB(), modelo.getPA());
    		pintarDiscos();
    	}
    	else if(obj == btBaC){
    		modelo.moverDeA(modelo.getPB(), modelo.getPC());
    		pintarDiscos();
    	}
    	else if(obj == btCaA){
    		modelo.moverDeA(modelo.getPC(), modelo.getPA());
    		pintarDiscos();
    	}
    	else if(obj == btCaB){
    		modelo.moverDeA(modelo.getPC(), modelo.getPB());
    		pintarDiscos();
    	}
    	cant.setText("Cantidad de movimientos realizados: "+modelo.getCantMovimientos());
    	gano();
    }
    private void actualizarLabel() {
        String tiempo = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s+":"+(ms<=9?"0":"")+ms;
        cronometro.setText(tiempo);
    }
    public void gano(){
    	if(modelo.getC().size()==modelo.getCantDicos()){
    		btAaB.setVisible(false);
    		btAaC.setVisible(false);
    		btBaA.setVisible(false);
    		btBaC.setVisible(false);
    		btCaA.setVisible(false);
    		btCaB.setVisible(false);
    		gano.setVisible(true);
    		t.stop();
    		setFocusable(false);
    		//t2.stop();
    	}
    }
}

