package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestPanini {

	@Test
	public void queSePuedaCrearUnaFigurita() {
		Figurita figurita =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);
		assertNotNull(figurita);
	}
	
	@Test
	public void queSePuedaCrearUnAdministrador() {
		UsuarioRegistrado administrador= new Administrador(1,"nombre");
		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(administrador);
		
		Integer valorEsperado=1;
		Integer valorObtenido=actual.cantidadDeUsuarios();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	
	@Test
	public void queSePuedaCrearUnUsuarioFinal() {
		UsuarioRegistrado usuarioFinal= new UsuarioFinal(1,"nombre");
		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(usuarioFinal);
		
		Integer valorEsperado=1;
		Integer valorObtenido=actual.cantidadDeUsuarios();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() {
		UsuarioRegistrado administrador= new Administrador(1,"nombre");
		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(administrador);
		
		Figurita figurita =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);

		try {
			((Administrador)administrador).agregarFigurita(figurita, actual);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		
		Integer valorEsperado=1;
		Integer valorObtenido=actual.getCantidadDeFiguritas();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() {
		UsuarioRegistrado usuarioFinal= new UsuarioFinal(1,"nombre");
		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(usuarioFinal);

		Figurita figurita =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);

		try {
			((UsuarioFinal)usuarioFinal).agregarFigurita(figurita, actual);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		
		Integer valorEsperado=1;
		Integer valorObtenido=((UsuarioFinal)usuarioFinal).getCantidadDeFiguritas();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() {		
		UsuarioRegistrado usuarioFinal= new UsuarioFinal(1,"nombre");
		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(usuarioFinal);

		Figurita figurita1 =new Figurita(3, "D", Seleccion.ARGENTINA, "Messi",100.0);
		Figurita figurita2 =new Figurita(2, "A", Seleccion.QATAR, "Messi",100.0);
		Figurita figurita3 =new Figurita(1, "B", Seleccion.ECUADOR, "Messi",100.0);
		
		try {
			((UsuarioFinal)usuarioFinal).agregarFigurita(figurita1, actual);
			((UsuarioFinal)usuarioFinal).agregarFigurita(figurita2, actual);
			((UsuarioFinal)usuarioFinal).agregarFigurita(figurita3, actual);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		
		List <Figurita>listaOrdenada=new ArrayList<>();
		
		listaOrdenada.add(figurita2);
		listaOrdenada.add(figurita3);
		listaOrdenada.add(figurita1);
		
		List <Figurita>listaObtenida=((UsuarioFinal)usuarioFinal).getStock();
		
		assertEquals(listaOrdenada, listaObtenida);
	}
	
	@Test
	public void queLasFiguritasAgregadasPorElAdministradorQuedenOrdenadas() {		
		UsuarioRegistrado administrador= new Administrador(1,"nombre");
		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(administrador);

		Figurita figurita1 =new Figurita(3, "D", Seleccion.ARGENTINA, "Messi",100.0);
		Figurita figurita2 =new Figurita(2, "A", Seleccion.QATAR, "Messi",100.0);
		Figurita figurita3 =new Figurita(1, "B", Seleccion.ECUADOR, "Messi",100.0);
		
		try {
			((Administrador)administrador).agregarFigurita(figurita1, actual);
			((Administrador)administrador).agregarFigurita(figurita2, actual);
			((Administrador)administrador).agregarFigurita(figurita3, actual);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		
		List <Figurita>listaOrdenada=new ArrayList<>();
		listaOrdenada.add(figurita2);
		listaOrdenada.add(figurita3);
		listaOrdenada.add(figurita1);
		
		List <Figurita>listaObtenida=new ArrayList<>();
		listaObtenida.addAll(actual.getFiguritas());
		
		assertEquals(listaOrdenada, listaObtenida);
	}
	
	@Test (expected=CodigoExistente.class)
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() throws CodigoExistente {
		UsuarioRegistrado administrador= new Administrador(1,"nombre");
		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(administrador);

		Figurita figurita1 =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);
		Figurita figurita2 =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);

		((Administrador)administrador).agregarFigurita(figurita1, actual);
		((Administrador)administrador).agregarFigurita(figurita2, actual);

	}
	
	@Test
	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() {
		UsuarioRegistrado usuarioFinal= new UsuarioFinal(1,"nombre");
		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(usuarioFinal);
		
		Figurita figurita1 =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);
		Figurita figurita2 =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);

		try {
			((UsuarioFinal)usuarioFinal).agregarFigurita(figurita1, actual);
			((UsuarioFinal)usuarioFinal).agregarFigurita(figurita2, actual);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		Integer valorEsperado=2;
		Integer valorObtenido=((UsuarioFinal)usuarioFinal).getCantidadDeFiguritas();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() {
		UsuarioRegistrado usuarioFinal= new UsuarioFinal(1,"nombre");
		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(usuarioFinal);

		Figurita figurita1 =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);

		try {
			((UsuarioFinal)usuarioFinal).agregarFigurita(figurita1, actual);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		
		try {
			((UsuarioFinal)usuarioFinal).pegarFigurita(figurita1);
		} catch (FiguritaRepetida e) {
			e.printStackTrace();
		} catch (FiguritaNoDisponible e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Integer valorEsperado=1;
		Integer valorObtenido=((UsuarioFinal)usuarioFinal).getCantidadDeFiguritasPegadas();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected=FiguritaRepetida.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaRepetida, FiguritaNoDisponible {
		UsuarioRegistrado usuarioFinal= new UsuarioFinal(1,"nombre");
		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(usuarioFinal);

		Figurita figurita1 =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);
		Figurita figurita2 =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);

		try {
			((UsuarioFinal)usuarioFinal).agregarFigurita(figurita1, actual);
			((UsuarioFinal)usuarioFinal).agregarFigurita(figurita2, actual);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		((UsuarioFinal)usuarioFinal).pegarFigurita(figurita1);
		((UsuarioFinal)usuarioFinal).pegarFigurita(figurita2);
		
	}
	
	@Test
	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() {
		UsuarioRegistrado remitente= new UsuarioFinal(1,"nombre");
		UsuarioRegistrado destinatario= new UsuarioFinal(1,"nombre");

		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(remitente);
		actual.agregarUsuario(destinatario);
		
		Figurita figurita1 =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);
		Figurita figurita2 =new Figurita(2, "A", Seleccion.ARGENTINA, "Messi",100.0);

		try {
			((UsuarioFinal)remitente).agregarFigurita(figurita1, actual);
			((UsuarioFinal)destinatario).agregarFigurita(figurita2, actual);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		
		try {
			actual.intercambiarFiguritas(remitente, figurita1, destinatario, figurita2);
		} catch (CodigoExistente | FiguritaNoDisponible e) {
			e.printStackTrace();
		}
		
		Integer valorEsperado1=2;
		Integer valorObtenido1=((UsuarioFinal)remitente).getFigurita(figurita2).getNroFigurita();
		
		Integer valorEsperad2=1;
		Integer valorObtenido2=((UsuarioFinal)destinatario).getFigurita(figurita1).getNroFigurita();

		assertEquals(valorEsperado1, valorObtenido1);
		
		assertEquals(valorEsperad2, valorObtenido2);
	}
	
	@Test (expected=FiguritaNoDisponible.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga() throws CodigoExistente, FiguritaNoDisponible {
		UsuarioRegistrado remitente= new UsuarioFinal(1,"nombre");
		UsuarioRegistrado destinatario= new UsuarioFinal(1,"nombre");

		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(remitente);
		actual.agregarUsuario(destinatario);
		
		Figurita figurita1 =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);
		Figurita figurita2 =new Figurita(2, "A", Seleccion.ARGENTINA, "Messi",100.0);
		Figurita figurita3 =new Figurita(3, "A", Seleccion.ARGENTINA, "Messi",100.0);

		((UsuarioFinal)remitente).agregarFigurita(figurita1, actual);
		((UsuarioFinal)destinatario).agregarFigurita(figurita2, actual);
		
		actual.intercambiarFiguritas(remitente, figurita3, destinatario, figurita2);
		
		Integer valorEsperado1=2;
		Integer valorObtenido1=((UsuarioFinal)remitente).getFigurita(figurita2).getNroFigurita();
		
		Integer valorEsperad2=1;
		Integer valorObtenido2=((UsuarioFinal)remitente).getFigurita(figurita1).getNroFigurita();

		assertEquals(valorEsperado1, valorObtenido1);
		
		assertEquals(valorEsperad2, valorObtenido2);

	}
	
	@Test (expected=FiguritaNoDisponible.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() throws CodigoExistente, FiguritaRepetida, FiguritaNoDisponible {
		UsuarioRegistrado remitente= new UsuarioFinal(1,"nombre");
		UsuarioRegistrado destinatario= new UsuarioFinal(1,"nombre");

		Sistema actual= new Sistema("nombre");
		actual.agregarUsuario(remitente);
		actual.agregarUsuario(destinatario);
		
		Figurita figurita1 =new Figurita(1, "A", Seleccion.ARGENTINA, "Messi",100.0);
		Figurita figurita2 =new Figurita(2, "A", Seleccion.ARGENTINA, "Messi",100.0);

	
		((UsuarioFinal)remitente).agregarFigurita(figurita1, actual);
		((UsuarioFinal)destinatario).agregarFigurita(figurita2, actual);
		((UsuarioFinal)remitente).pegarFigurita(figurita1);
		
		actual.intercambiarFiguritas(remitente, figurita1, destinatario, figurita2);
		
		Integer valorEsperado1=2;
		Integer valorObtenido1=((UsuarioFinal)remitente).getFigurita(figurita2).getNroFigurita();
		
		Integer valorEsperad2=1;
		Integer valorObtenido2=((UsuarioFinal)remitente).getFigurita(figurita1).getNroFigurita();

		assertEquals(valorEsperado1, valorObtenido1);
		
		assertEquals(valorEsperad2, valorObtenido2);

	}

}
