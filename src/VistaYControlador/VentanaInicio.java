package VistaYControlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import modelo.Modelo;

public class VentanaInicio extends JFrame{
	JLabel fondo;
	JButton btComenzar, btSalir;
	JLabel cantidad;
	private JSpinner spinnerNroDiscos;
	Sonido sonido;
	
	public VentanaInicio(){
		
		fondo=new JLabel();
		fondo.setIcon(new ImageIcon(new ImageIcon("discos/inicio.jpg").getImage().getScaledInstance(800,700,5)));
	    fondo.setSize(800,700);
	    this.setContentPane(fondo);
		setTitle("Torres de Hanoi");
		setSize(800,700);
		sonido = new Sonido("discos/apparatus.wav");
		sonido.tocarContinuo();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
			SwingUtilities. updateComponentTreeUI(null) ;
		} catch (Exception eX) {}
		
		cantidad = new JLabel("Nº de discos:");
		cantidad.setBounds(340,300,180,30);
		//cantidad.setForeground (Color.white);
		cantidad.setFont(new Font("Arial",Font.BOLD,22));
		getContentPane().add(cantidad);
		
		spinnerNroDiscos = new JSpinner(new SpinnerNumberModel(3, 1, 10, 1));
        spinnerNroDiscos.setBounds(382, 330, 55, 30);
        spinnerNroDiscos.setFont(new Font("Arial",Font.BOLD,22));
        getContentPane().add(spinnerNroDiscos);
		btSalir = new JButton("Salir");
		btSalir.setBounds(335,410,130,30);
		btSalir.setForeground (Color.white);
		btSalir.setBackground (Color.black);
		btSalir.setFont(new Font("Arial",Font.BOLD,22));
		getContentPane().add(btSalir);
		btSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				sonido.parar();
				System.exit(0);
			}
		});
		
		/*aqui donde se inicia el MVC*/
		btComenzar = new JButton("Iniciar");
		btComenzar.setBounds(335,370,130,30);
		btComenzar.setForeground (Color.white);
		btComenzar.setBackground (Color.black);
		btComenzar.setFont(new Font("Arial",Font.BOLD,22));	
		getContentPane().add(btComenzar);
		btComenzar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		    	int tam= Integer.parseInt(spinnerNroDiscos.getValue().toString());
				Modelo modelo = new Modelo(tam);
				HanoiGUI vistaYControl = new HanoiGUI(modelo);
				vistaYControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				VentanaInicio.this.dispose();
				/*try {s.stop();}
				catch(Exception e1){   
				}*/
			}
		});
		btComenzar.setVisible(true);
	}
	
	public static void main(String[] args) {
        VentanaInicio  vista      = new VentanaInicio();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);//centra la ventana
        vista.setResizable(false);	//no deja maximizar
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
