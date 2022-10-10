package PagsObjets;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapsObjetHomeMercadolibre;


public class PageObjecInicio extends MapsObjetHomeMercadolibre {
	
	public PageObjecInicio(WebDriver driver) {
		super(driver);
	}

	//METODO INICIAL
	public void urlAcceso(String url) throws IOException {
	driver.get(url);
		
	}
	//METODO PRIMERA PRUEBA
	public void busquedaInicial(String producto, File rutaCarpeta,String generarEvidencia) throws InterruptedException, IOException{
	
	
		try {
			// LIMPIAR LA CAJA DE TEXTO DE BUSQUEDA
			borrar(txtbusqueda,rutaCarpeta,generarEvidencia);
			
			// ENVIAR UN VALOR A BUSCAR 
			sendkey(producto, txtbusqueda,rutaCarpeta,generarEvidencia);
			submit(txtbusqueda,rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
			
			//CERRAR UBICACION
			click(cerrarubicacion,rutaCarpeta,generarEvidencia);
							
			//CERRAR COOKIES
			click(cerrarCookies,rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
			
			//SELECCIONA UN PRODUCTO
			click(linkproducto,rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
			
			//PRESIONA EL BOTON A�ADIR A CARRITO
			tiempoEspera(2000);
			click(linkcarrito,rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
			
			//BOTON CREAR CUENTA
			click(btncrearCuenta,rutaCarpeta,generarEvidencia);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//METODO LINK CREAR CUENTA
	public void linkCrearCuenta(File rutaCarpeta,String generarEvidencia) throws Exception {
		
		
		click(linkCrearCuenta,rutaCarpeta,generarEvidencia);
	}
	
}

