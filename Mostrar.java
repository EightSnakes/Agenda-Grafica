package Agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Mostrar extends JFrame implements ActionListener{
	
	JTable	tabla;
	JScrollPane scroll = new JScrollPane();
	ManejoPersona mp = new ManejoPersona();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	ArrayList<Persona> datosPer = new ArrayList<Persona>();
	JButton regresar;
	
	public Mostrar() {
		
		initComponents();
		
	}//mostrarDatos
	
	public void initComponents() {
		setSize(700,600);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		datosPer = mp.datos();
		String titulos [] = {"Nombre", "Apellidos", "Telefono", "Celular", "Correo", "Cumpleaños", "Tipo"};
		String info[][] = obtenerDatos();
		panel2.setLayout(new GridLayout(2,1));
		tabla = new JTable(info, titulos);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scroll.setViewportView(tabla);
		panel.add(scroll);
		
		regresar = new JButton("Volver");
		regresar.addActionListener(this);
		panel2.add(regresar);
		panel3.add(panel, BorderLayout.NORTH);
		panel3.add(panel2,BorderLayout.SOUTH);
		setContentPane(panel3);
		
	}//initComponents
	
	private String[][] obtenerDatos(){
		int x = 0;
		String informacion [][] = new String[datosPer.size()][7];
		Iterator<Persona> itrPersona = datosPer.iterator();
		while(itrPersona.hasNext()) {
			
			Persona persona = itrPersona.next();
			informacion[x][0] = persona.getNombre();
			informacion[x][1] = persona.getApellidos();
			informacion[x][2] = persona.getTelefono();
			informacion[x][3] = persona.getCelular();
			informacion[x][4] = persona.getCorreo();
			informacion[x][5] = persona.getFecha();
			informacion[x][6] = persona.getTipo();
			x++;
			
		}//while
		return informacion;
	}//obtenerDatos

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == regresar) {
			MenuSecundario ms = new MenuSecundario();
			this.dispose();
		}
	}//actionPerformed

}//class
