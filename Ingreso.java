package Agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ingreso extends JFrame implements ActionListener{
	
	private JButton btnIngresar, btnCancelar;
	private JTextField txtUser;
	private JPasswordField cont;
	private JPanel panel = new JPanel();
	
	public Ingreso() {
		
		initComponents();
		
	}//ingreso
	
	public void initComponents() {
		setSize(500,400);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		panel.setLayout(new GridLayout(3,2));
		JLabel lblUser = new JLabel("Usuario", JLabel.LEFT);
		txtUser = new JTextField(20);
		panel.add(lblUser);
		panel.add(txtUser);
		
		JLabel lblCont = new JLabel("Contraseña", JLabel.LEFT);
		cont = new JPasswordField(20);
		panel.add(lblCont);
		panel.add(cont);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		
		panel.add(btnIngresar);
		panel.add(btnCancelar);
		
		setContentPane(panel);
	}//initComponents
	
	public void actionPerformed(ActionEvent e) {
		String usuario = txtUser.getText();
		String password = new String(cont.getPassword());
		
		if(e.getSource() == btnIngresar) {
			
			if(usuario.isEmpty() && password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ingrese su nombre de usurio y contraseña" , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtUser.requestFocus();
			}//if
			
			else {
				if((usuario.equals("Carlos") && password.equals("123")) || (usuario.equals("Balam") && password.equals("456"))) {
					JOptionPane.showMessageDialog(null, "Bienvenido a la Agenda");
					MenuSecundario ds = new MenuSecundario();
					this.dispose();
					
				}//if
				else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Warning", JOptionPane.WARNING_MESSAGE);
					cont.setText(null);
					txtUser.setText(null);
					txtUser.requestFocus();
				}//else
			}//else		
		}//if
		
		if(e.getSource()==btnCancelar) {
			MenuPrincipal w = new MenuPrincipal();
			this.dispose();
		}//if
	}//actionPerformed

}//class
