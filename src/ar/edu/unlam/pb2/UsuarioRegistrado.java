package ar.edu.unlam.pb2;

import java.util.Objects;

public abstract class UsuarioRegistrado {
	private Integer id;
	private String nombre;
	
	public UsuarioRegistrado(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	
	public abstract void agregarFigurita(Figurita figurita, Sistema sistema)throws CodigoExistente;
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		UsuarioRegistrado other = (UsuarioRegistrado) obj;
		return Objects.equals(id, other.id);
	}

	
}
