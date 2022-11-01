package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UsuarioFinal extends UsuarioRegistrado {
	private List<Figurita> stockDisponible;
	private Set<Figurita> album;
	
	public UsuarioFinal(Integer id, String nombre) {
		super(id, nombre);
		this.stockDisponible=new ArrayList<>();
		this.album=new HashSet<>();
	}

	@Override
	public void agregarFigurita(Figurita figurita, Sistema sistema)throws CodigoExistente {
		stockDisponible.add(figurita);
		Collections.sort(stockDisponible);
	}

	public Integer getCantidadDeFiguritas() {
		return stockDisponible.size();
	}

	public List<Figurita> getStock() {
		return stockDisponible;
	}

	public void pegarFigurita(Figurita figurita) throws FiguritaRepetida, FiguritaNoDisponible {
		if(buscarFiguritaEnElStock(figurita)) {
			if(!album.add(figurita)) {
				throw new FiguritaRepetida();	
			} else sacarFiguritaDelStcok(figurita);
		}
	}

	public Boolean buscarFiguritaEnElStock(Figurita figuritaBuscada) throws FiguritaNoDisponible {
		for (Figurita figurita : stockDisponible) {
			if(figurita.equals(figuritaBuscada)) {
				return true;
			}
		} throw new FiguritaNoDisponible();
	}

	public Integer getCantidadDeFiguritasPegadas() {
		return album.size();
	}

	public void sacarFiguritaDelStcok(Figurita figurita) {
		stockDisponible.remove(figurita);
	}

	public Figurita getFigurita(Figurita figuritaBuscada) {
		for (Figurita figurita : stockDisponible) {
			if(figurita.equals(figuritaBuscada)) {
				return figurita;
			}
		} return null;
 
	}
}
