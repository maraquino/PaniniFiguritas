package ar.edu.unlam.pb2;

public class Administrador extends UsuarioRegistrado {
	public Administrador(Integer id, String nombre) {
		super(id, nombre);
	}

	@Override
	public void agregarFigurita(Figurita figurita, Sistema sistema) throws CodigoExistente {
		sistema.agregarFiguritaAlSistema(figurita);	
	}

}
