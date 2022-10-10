package PagesObjects;

import java.io.File;
import MapsObjects.MapobjecthHomeMercadolibre;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagObjetHomeMercadolibre extends MapobjecthHomeMercadolibre {

	public PagObjetHomeMercadolibre(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver= driver;
	}
	
	public void homeMercadolibre(File rutaCarpeta,String generarEvidencia,String producto) throws Exception {
	//METODO INGRESAR A CUENTA
	click(txtBuscadorMercadolibre,rutaCarpeta,generarEvidencia,"Ingresa al buscador de mercado libre");
	tiempoEspera(2000);
	
	sendkey(producto,txtBuscadorMercadolibre,rutaCarpeta,generarEvidencia,"ingresar el producto a buscar");
	tiempoEspera(2000);
	enter(rutaCarpeta);
	tiempoEspera(2000);
	
	click(linkprimerObjeto,rutaCarpeta,generarEvidencia,"Seleccionar el primer elemento");
	tiempoEspera(4000);
    scrollVertical( rutaCarpeta, 1014, 1739, 1300,3);
   
    click( btnComprar, rutaCarpeta,generarEvidencia,"click en comprar");
    tiempoEspera(2000);
    click(btnCrearcuenta, rutaCarpeta,generarEvidencia,"Crear cuenta");
    tiempoEspera(2000);
	}
}
