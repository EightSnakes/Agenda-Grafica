package Agenda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuPrincipal extends JFrame implements ActionListener{
	
	private JPanel panel = new JPanel();
	private JLabel bien;
	private JButton ingresar = new JButton("Ingresar");
	private JButton salir = new JButton("Salir");
	
	public MenuPrincipal() {
		initComponents();
	}//MenuPrincipal
	
	public void initComponents() {
		
		setSize(500,400);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		panel.setLayout(new GridLayout(3,1));
		
		bien = new JLabel("Bienvenido a Mi agenda", JLabel.CENTER);
		panel.add(bien);
		
		ingresar.addActionListener(this);
		salir.addActionListener(this);
		panel.add(ingresar);
		panel.add(salir);
		
		setContentPane(panel);
	}//initComponents
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ingresar) {
			Ingreso i = new Ingreso();
			this.dispose();
		}
		if(e.getSource() == salir) {
			JOptionPane.showMessageDialog(null, "Gracias por utilizar Mi agenda simple", "Salir", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}//else if
		
	}//actionPerformed
	
}//class
