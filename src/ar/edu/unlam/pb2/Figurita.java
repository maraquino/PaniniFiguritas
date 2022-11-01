package ar.edu.unlam.pb2;

import java.util.Objects;

public class Figurita implements Comparable<Figurita>{
	private Integer nroFigurita;
	private String grupo;
	private Seleccion seleccion;
	private String nombre;
	private Double precioMercado;
	
	public Figurita(Integer nroFigurita, String grupo, Seleccion seleccion, String nombre, Double precioMercado) {
		this.nroFigurita=nroFigurita;
		this.grupo=grupo;
		this.seleccion=seleccion;
		this.nombre=nombre;
		this.precioMercado=precioMercado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nroFigurita);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figurita other = (Figurita) obj;
		return Objects.equals(nroFigurita, other.nroFigurita);
	}

	@Override
	public int compareTo(Figurita o) {
		if(this.grupo.equals(o.grupo)) {
			if(this.seleccion.equals(o.seleccion)) {
				return this.nroFigurita.compareTo(o.nroFigurita);
			}return this.seleccion.compareTo(o.seleccion);
		} return this.grupo.compareTo(o.grupo);
	}

	public Integer getNroFigurita() {
		return this.nroFigurita;
	}
	 
}
