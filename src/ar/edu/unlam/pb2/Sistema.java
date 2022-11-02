package ar.edu.unlam.pb2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sistema {
	private String nombre;
	private Set<UsuarioRegistrado> usuarios;
	private Set<Figurita> figuritas;
	
	public Sistema(String nombre) {
		this.nombre=nombre;
		this.usuarios=new HashSet<>();
		this.figuritas=new TreeSet<>();
	}

	public void agregarUsuario(UsuarioRegistrado usuario) {
		usuarios.add(usuario);
	}

	public Integer cantidadDeUsuarios() {
		return usuarios.size();
	}

	public Boolean agregarFiguritaAlSistema(Figurita figurita) throws CodigoExistente {
		if(this.figuritas.add(figurita)) {
			return true;
		} else throw new CodigoExistente();
	}

	public Integer getCantidadDeFiguritas() {
		return this.figuritas.size();
	}

	public void intercambiarFiguritas(UsuarioRegistrado remitente, Figurita figuritaRemitente,
			UsuarioRegistrado destinatario, Figurita figuritaDestinatario) throws CodigoExistente, FiguritaNoDisponible {
		if(esUnUsuarioFinal(remitente)&&esUnUsuarioFinal(destinatario)) {
			if(((UsuarioFinal)remitente).buscarFiguritaEnElStock(figuritaRemitente)&&
					((UsuarioFinal)destinatario).buscarFiguritaEnElStock(figuritaDestinatario)) {
				
				Figurita figurita1=((UsuarioFinal)remitente).getFigurita(figuritaRemitente);
				Figurita figurita2=((UsuarioFinal)destinatario).getFigurita(figuritaDestinatario);
				
				((UsuarioFinal)remitente).agregarFigurita(figurita2, this);
				((UsuarioFinal)remitente).sacarFiguritaDelStcok(figurita1);
				
				((UsuarioFinal)destinatario).agregarFigurita(figurita1, this);
				((UsuarioFinal)destinatario).sacarFiguritaDelStcok(figurita2);
			}
		} else throw new FiguritaNoDisponible(); 
		
	}
	private Boolean esUnUsuarioFinal(UsuarioRegistrado usuario) {
		for (UsuarioRegistrado user : usuarios) {
			if(usuario.equals(user)) {
				return true;
			} 
		} return false;
	}

	public Set<Figurita> getFiguritas() {
		return figuritas;
	}

}
