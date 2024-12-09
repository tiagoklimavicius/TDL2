package Vista;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import DAO.*;
import Entidad.*;
import Comparadores.*;
import Interfaces.*;


public class pruebasLogin {

	public static void main(String[] args) {
	//	UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		//Usuario usuario = new Usuario(1, "klimaviciustiago2@gmail.com", "hola", true);
		//usuarioDAO.crear(usuario);
		
/*		List<Usuario> usuarios = usuarioDAO.listar(); 
		for (Usuario usuario2 : usuarios) {
		   		System.out.println(usuario2.toString());
		}
	
		
		Scanner in = new Scanner(System.in);
		System.out.println("Bienvenido a la billetera virtual: ");
		System.out.println("Ingrese su email: ");
		String email = in.next();
		System.out.println("Ingrese su contraseña: ");
		String contraseña = in.next();
		
		usuarioDAO.actualizar(new Usuario(1, 1, email, contraseña, false));
		
		List<Usuario> usuarios2 = usuarioDAO.listar(); 
		for (Usuario usuario2 : usuarios2) {
		   		System.out.println(usuario2.toString());
		}  */
	
		
		PersonaDAO personaDAO = new PersonaDAOImpl();
		Persona persona = new Persona("Tiago", "Klimavicius");
		personaDAO.crear(persona);
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		Usuario usuario = new Usuario(persona.getID(),"klimat@gmail.com", "aaa", true);
		usuarioDAO.crear(usuario);
		
		

	}
}