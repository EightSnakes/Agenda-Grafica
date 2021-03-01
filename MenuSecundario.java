package Agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuSecundario extends JFrame implements ActionListener{
	
	private JButton mostrar, cancelar, agregar, buscar;
	private JPanel panel = new JPanel();
	
	public MenuSecundario() {
		initComponents();
	}//menuSecundario
	
	public void initComponents() {
		
		setSize(500,400);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		panel.setLayout(new GridLayout(5,1));
		
		JLabel bien = new JLabel("BIENVENIDO", JLabel.CENTER);
		panel.add(bien);
		
		mostrar = new JButton("Mostrar contactos");
		mostrar.addActionListener(this);
		
		agregar = new JButton("Agregar contacto");
		agregar.addActionListener(this);
		
		buscar = new JButton("Buscar/Eliminar/Modificar contacto");
		buscar.addActionListener(this);
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		
		panel.add(mostrar);
		panel.add(agregar);
		panel.add(buscar);
		panel.add(cancelar);
		
		setContentPane(panel);
	}//initComponents
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelar) {
			MenuPrincipal mp = new MenuPrincipal();
			this.dispose();
		}
		else if(e.getSource() == agregar) {
			Agregar a = new Agregar();
			this.dispose();
		}
		else if(e.getSource() == mostrar) {
			Mostrar m = new Mostrar();
			this.dispose();
		}
		else if(e.getSource() == buscar) {
			Buscar b = new Buscar();
			this.dispose();
		}
	}//actionPerformed

}//class
