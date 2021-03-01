package Agenda;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

public class Buscar extends JFrame implements ActionListener{
	JPanel panel = new JPanel();
	private JTextField txtNombre, txtApellido, txtTelefono, txtCelular, txtCorreo, txtCum;
	JButton btnBuscar, btnCancelar, eliminar, modificar, guardar;
	JRadioButton amigo, trabajo, escuela, conocido;
	ManejoPersona mp = new ManejoPersona();
	Persona per = new Persona();
	
	public Buscar() {
		
		initComponents();
		
	}//agregar
	
	public void initComponents() {
		setSize(500,400);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		panel.setLayout(new GridLayout(11,2));

		JLabel lblNombre = new JLabel("Nombre: ", JLabel.LEFT);
		txtNombre = new JTextField(20);
		panel.add(lblNombre);
		panel.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido: ", JLabel.LEFT);
		txtApellido = new JTextField(30);
		txtApellido.setEditable(false);
		panel.add(lblApellido);
		panel.add(txtApellido);
		
		JLabel lblTelefono = new JLabel("Telefono: ", JLabel.LEFT);
		txtTelefono = new JTextField(20);
		txtTelefono.setEditable(false);
		panel.add(lblTelefono);
		panel.add(txtTelefono);
		
		JLabel lblCelular = new JLabel("Celular: ", JLabel.LEFT);
		txtCelular = new JTextField(20);
		txtCelular.setEditable(false);
		panel.add(lblCelular);
		panel.add(txtCelular);
		
		JLabel lblCorreo = new JLabel("Correo: ", JLabel.LEFT);
		txtCorreo = new JTextField(20);
		txtCorreo.setEditable(false);
		panel.add(lblCorreo);
		panel.add(txtCorreo);
		
		JLabel lblCum = new JLabel("Fecha de cumpleaños: ", JLabel.LEFT);
		txtCum = new JTextField(20);
		txtCum.setEditable(false);
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
		
		amigo.setEnabled(false);
		trabajo.setEnabled(false);
		escuela.setEnabled(false);
		conocido.setEnabled(false);
		
		panel.add(amigo);
		panel.add(trabajo);
		panel.add(escuela);
		panel.add(conocido);
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		
		eliminar = new JButton("Eliminar");
		eliminar.addActionListener(this);
		eliminar.setVisible(false);
		
		modificar = new JButton("Modificar");
		modificar.addActionListener(this);
		modificar.setVisible(false);
		
		guardar = new JButton("Guardar");
		guardar.addActionListener(this);
		guardar.setVisible(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		
		panel.add(btnBuscar);
		panel.add(modificar);
		panel.add(eliminar);
		panel.add(btnCancelar);
		panel.add(guardar);
		
		setContentPane(panel);
	}//initComponents

	public void actionPerformed(ActionEvent e) {
		String nombre = txtNombre.getText();
		String tipo =null;
		if(e.getSource() == btnBuscar) {
			
			if(txtNombre.getText()==null || txtNombre.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Debes de colocar el nombre del contacto buscado" , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtNombre.requestFocus();
			
			}//if
			else {
				per = mp.buscarContacto(nombre);
				if(per != null) {
					txtApellido.setText(per.getApellidos());
					txtTelefono.setText(per.getTelefono());
					txtCelular.setText(per.getCelular());
					txtCorreo.setText(per.getCorreo());
					txtCum.setText(per.getFecha());
					tipo = per.getTipo();
					if(tipo.equals("Amigo"))
						amigo.setEnabled(true);
					else if(tipo.equals("Conocido"))
						conocido.setEnabled(true);

					else if(tipo.equals("Escuela"))
						escuela.setEnabled(true);
					else
						trabajo.setEnabled(true);
					eliminar.setVisible(true);
					modificar.setVisible(true);
					btnBuscar.setVisible(false);
					txtNombre.setEditable(false);
				}//if	
					
				else {
					JOptionPane.showMessageDialog(null, "No existe el contacto" , "Aviso", JOptionPane.INFORMATION_MESSAGE);
					txtNombre.setText(null);
					txtNombre.requestFocus();
				}
			}//else
		}//if
		else if(e.getSource() == eliminar) {
			mp.eliminar(nombre);
			JOptionPane.showMessageDialog(null, "Contacto eliminado con exito" , "Aviso", JOptionPane.INFORMATION_MESSAGE);
			MenuSecundario ma = new MenuSecundario();
			this.dispose();
			
		}
		else if(e.getSource() == modificar) {
			
			txtNombre.setEditable(true);
			txtApellido.setEditable(true);
			txtTelefono.setEditable(true);
			txtCelular.setEditable(true);
			txtCorreo.setEditable(true);
			txtCum.setEditable(true);
			conocido.setEnabled(true);
			amigo.setEnabled(true);
			trabajo.setEnabled(true);
			escuela.setEnabled(true);
			guardar.setVisible(true);
			eliminar.setVisible(false);
			modificar.setVisible(false);
		}
		else if(e.getSource() == guardar) {
			tipo = "Amigo";
			if(trabajo.isSelected())
				tipo="Trabajo";
			else if(escuela.isSelected())
				tipo="Escuela";
			else if(conocido.isSelected())
				tipo="Conocido";
			else if(amigo.isSelected())
				tipo="Amigo";
			if(txtNombre.getText()==null || txtNombre.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Debes de colocar por lo menos el nombre" , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtNombre.requestFocus();
			
			}//if
			
			else if((txtTelefono.getText()==null || txtTelefono.getText().isEmpty()) && (txtCelular.getText()==null || txtCelular.getText().isEmpty())) {
				
				JOptionPane.showMessageDialog(null, "Debes de colocar un numero de telefono o de celular" , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtTelefono.requestFocus();
			
			}//if
			
			else {
				mp.modificar(nombre,txtNombre.getText(), txtApellido.getText(), txtTelefono.getText(), txtCelular.getText(), txtCorreo.getText(), txtCum.getText(), tipo);
				JOptionPane.showMessageDialog(null, "Se guardaron los datos" , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				MenuSecundario zx = new MenuSecundario();
				this.dispose();
			}//else
			
		}
		else if (e.getSource() == btnCancelar) {
			MenuSecundario ms = new MenuSecundario();
			this.dispose();
		}
	}//action
	
	
}//class
