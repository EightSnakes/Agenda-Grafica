package Agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Agregar extends JFrame implements ActionListener{
	
	JPanel panel = new JPanel();
	private JTextField txtNombre, txtApellido, txtTelefono, txtCelular, txtCorreo, txtCum;
	JButton btnGuardar, btnCancelar;
	JRadioButton amigo, trabajo, escuela, conocido;
	ManejoPersona mp = new ManejoPersona();
	
	public Agregar() {
		
		initComponents();
		
	}//agregar
	
	public void initComponents() {
		setSize(500,400);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		panel.setLayout(new GridLayout(9,2));

		JLabel lblNombre = new JLabel("Nombre: ", JLabel.LEFT);
		txtNombre = new JTextField(20);
		panel.add(lblNombre);
		panel.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido: ", JLabel.LEFT);
		txtApellido = new JTextField(30);
		panel.add(lblApellido);
		panel.add(txtApellido);
		
		JLabel lblTelefono = new JLabel("Telefono: ", JLabel.LEFT);
		txtTelefono = new JTextField(20);
		panel.add(lblTelefono);
		panel.add(txtTelefono);
		
		JLabel lblCelular = new JLabel("Celular: ", JLabel.LEFT);
		txtCelular = new JTextField(20);
		panel.add(lblCelular);
		panel.add(txtCelular);
		
		JLabel lblCorreo = new JLabel("Correo: ", JLabel.LEFT);
		txtCorreo = new JTextField(20);
		panel.add(lblCorreo);
		panel.add(txtCorreo);
		
		JLabel lblCum = new JLabel("Fecha de cumpleaños: ", JLabel.LEFT);
		txtCum = new JTextField(20);
		panel.add(lblCum);
		panel.add(txtCum);
		
		ButtonGroup gpoBotones = new ButtonGroup();
		amigo = new JRadioButton("Amigo", true);
		trabajo = new JRadioButton("Trabajo");
		escuela = new JRadioButton("Escuela");
		conocido = new JRadioButton("Conocido");
		
		gpoBotones.add(amigo);
		gpoBotones.add(trabajo);
		gpoBotones.add(escuela);
		gpoBotones.add(conocido);
		
		panel.add(amigo);
		panel.add(trabajo);
		panel.add(escuela);
		panel.add(conocido);
		
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		
		panel.add(btnGuardar);
		panel.add(btnCancelar);
		
		setContentPane(panel);
	}//initComponents
	
	public void actionPerformed(ActionEvent e) {
		String tipo = "Amigo";
		
		if(trabajo.isSelected())
			tipo="Trabajo";
		else if(escuela.isSelected())
			tipo="Escuela";
		else if(conocido.isSelected())
			tipo="Conocido";
		
		if(e.getSource() == btnGuardar) {
			
			if(txtNombre.getText()==null || txtNombre.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Debes de colocar por lo menos el nombre" , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtNombre.requestFocus();
			
			}//if
			
			else if((txtTelefono.getText()==null || txtTelefono.getText().isEmpty()) && (txtCelular.getText()==null || txtCelular.getText().isEmpty())) {
				
				JOptionPane.showMessageDialog(null, "Debes de colocar un numero de telefono o de celular" , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtTelefono.requestFocus();
			
			}//if
			
			else {
				mp.agregar(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText(), txtCelular.getText(), txtCorreo.getText(), txtCum.getText(), tipo);
				JOptionPane.showMessageDialog(null, "Se guardaron los datos" , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				
				txtNombre.setText(null);
				txtApellido.setText(null);
				txtTelefono.setText(null);
				txtCelular.setText(null);
				txtCorreo.setText(null);
				txtCum.setText(null);
				txtNombre.requestFocus();
				
			}//else
							
		}//if
			
		else if(e.getSource()==btnCancelar) {
			MenuSecundario ms = new MenuSecundario();
			this.dispose();
		}
	}//actionPerformed

}//class
