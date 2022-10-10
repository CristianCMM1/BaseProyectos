package PagsObjets;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjetCrearCuenta;


public class PagObjetCrearCuenta extends MapObjetCrearCuenta {

	public PagObjetCrearCuenta(WebDriver driver) {
		super(driver);
	}

//METODO CREAR CUENTA LINK
	public void crearCuenta(String correo, File rutaCarpeta, String generarEvidencia) throws InterruptedException, IOException {

		try {
			// ACEPTAR TERMINOS Y CONDICIONES
			click(checkAceptarTerminos, rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
			click(btnaceptarTerminos, rutaCarpeta,generarEvidencia);

			// SELECCIONAR EMAIL
			tiempoEspera(2000);
			click(btnvalidarEmail, rutaCarpeta,generarEvidencia);

			// INGRESAR MAIL
			click(txtingresarCorreo, rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);

			// LIMPIAR LA CAJA DE TEXTO DE BUSQUEDA
			borrar(txtingresarCorreo, rutaCarpeta,generarEvidencia);
			sendkey(correo,txtingresarCorreo, rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
			submit(txtingresarCorreo, rutaCarpeta,generarEvidencia);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
