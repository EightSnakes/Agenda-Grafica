package Agenda;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;

public class ManejoPersona {

	static ArrayList<Persona> Arrperson = new ArrayList<Persona>();
	private Persona objPersona;
	
	public ManejoPersona() {
		
		
	}//ManejoPersona
	
	public void agregar(String nom, String ap, String tel, String cel, String cor, String cum, String tipo) {
	
		objPersona = new Persona();
		objPersona.setApellidos(ap);
		objPersona.setCelular(cel);
		objPersona.setCorreo(cor);
		objPersona.setFecha(cum);
		objPersona.setNombre(nom);
		objPersona.setTelefono(tel);
		objPersona.setTipo(tipo);
		Arrperson.add(objPersona);
		
	}//agregar
	
	public ArrayList datos() {
		return Arrperson;
	}//ArrayList
	
	public Persona buscarContacto(String nom) {
		Optional<Persona> persona = Arrperson.stream().filter(p -> p.getNombre().equals(nom)).findFirst();
		    return persona.isPresent() ? persona.get() : null;
	}	
	
	public int buscarIndice(String nom) {
		int indice=0;
		for(Persona per : Arrperson) {
			if(per.getNombre().equals(nom)) {
				indice= Arrperson.indexOf(per);
			}
		}
		return indice;
	}	
	
	public void modificar(String nombreA, String nom, String ap, String tel, String cel, String cor, String cum, String tipo) {
		int indice=0;
		Persona per = new Persona();
		per = buscarContacto(nombreA);
		if(per!=null) {
			indice = buscarIndice(nombreA);
			for(Persona per2 : Arrperson) {
				if(per2.getNombre().equals(nombreA)) {
					per2.setNombre(nom);
					per2.setApellidos(ap);
					per2.setTelefono(tel);
					per2.setCelular(cel);
					per2.setCorreo(cor);
					per2.setFecha(cum);
					per2.setTipo(tipo);
					
				}//if
			}//for

		}//if
	}//buscar
	
	public void eliminar(String nom) {
		Persona per = new Persona();
		per = buscarContacto(nom);
		if(per!=null) {
			int indice = buscarIndice(nom);
			Arrperson.remove(indice);
		}
	}//buscar
	
}//class
